package com.simplerecipe.main.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.simplerecipe.common.paging.Criteria;
import com.simplerecipe.common.paging.PageMaker;
import com.simplerecipe.main.service.RecipeService;
import com.simplerecipe.main.vo.IngredientListVO;
import com.simplerecipe.main.vo.IngredientVO;
import com.simplerecipe.main.vo.RecipeVO;

@Controller
public class MainController {
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping("/main.do")
	public String mainPage(RecipeVO vo) {
		return "main";
	}
	
	@RequestMapping("/search.do")
	public String searchRecipe(RecipeVO vo) {
		return "result";
	}
	
	@RequestMapping("/result.do")
	public String resultRecipe(@RequestParam("keywords") String keywords, 
			Model model, Criteria cri) {
		List<String> ings = new ArrayList<>();
		String[] array = keywords.split(",");
		for(int i=0; i<array.length; i++) {
			ings.add(array[i].trim());
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(recipeService.getResultCount(ings));
		cri = pageMaker.getCri();
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("resultList", recipeService.searchRecipe(ings, cri));
		model.addAttribute("keywords", keywords);
		return "result";
	}
	
	@RequestMapping("/detail.do")
	public String detailRecipe(RecipeVO vo, Model model) {
		try {
			// src/main/resources 위치에서 파일을 쉽게 가져올 수 있도록 마련된 클래스.
			ClassPathResource resource_txt = 
					new ClassPathResource(recipeService.getDetail(vo).getRecipeTbContentLink());
			// java 7에 새롭게 추가된 nio 패키지의 Files, Path 클래스를 사용하면 파일을 쉽게 읽을 수 있다.
			Path path = Paths.get(resource_txt.getURI());
			List<String> content = Files.readAllLines(path);
			model.addAttribute("content", content);
			model.addAttribute("recipe", recipeService.getDetail(vo));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "detail";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.GET)
	public String insertRecipeForm() {
		return "insert";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertRecipe(
			MultipartFile imgFile,
			@RequestParam("recipeTbTitle") String recipeTbTitle,
			@RequestParam("ingredientTbName") List<String> ingredientTbNames,
			@RequestParam("addIngDetail") List<String> addIngDetails,
			@RequestParam("recipeDetail") String recipeDetail,
			HttpSession session) throws Exception {
		// 이 모든 일련의 과정에 트랜잭션을 걸어줘야함.
		try {
			// 이미지 업로드
			String savedImgName = uploadFile(imgFile.getOriginalFilename(), imgFile.getBytes());
			
			// txt 파일 만들기
			// 가장 최근의 번호를 가져와서 삽입해줘야한다
			int txtNo = Integer.parseInt(recipeService.getRecipeMaxCount()) + 1;
			String savedName = 
					"recipe_" + String.valueOf(txtNo) + ".txt";
			ClassPathResource resource = new ClassPathResource("txt/recipe/");
			try {
				Path path = Paths.get(resource.getURI()); // 레시피 txt파일들을 모아둔 디렉토리를 저장
				File file = new File(path + "/" + savedName); // 해당 디렉토리에 파일을 만들고
				file.createNewFile();
				resource = new ClassPathResource("txt/recipe/" + savedName); // 만든 파일을 참조하도록 함.
				path = Paths.get(resource.getURI()); 
				String txtContent = recipeTbTitle 
						+ "<br /><br />[재료]<br /><br />";
				for(int i = 0; i < ingredientTbNames.size(); i++) {
					txtContent += ingredientTbNames.get(i);
					txtContent += addIngDetails.get(i);
					if(i < ingredientTbNames.size() - 1)
						txtContent += ", ";
				}
				txtContent += "<br /><br />조리순서<br /><br />";
				txtContent += recipeDetail;
				byte[] bytes = txtContent.getBytes(); // 레시피 내용을 byte화한다.
				Files.write(path, bytes); // 대상 파일에 레시피 내용을 기록
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			// DB에 데이터 삽입
			// 아래의 정보를 바탕으로 userTbNo를 얻어낸다.
			RecipeVO rvo = new RecipeVO();
			List<IngredientVO> ivoList = new ArrayList<IngredientVO>();
			List<IngredientListVO> ilvoList = new ArrayList<IngredientListVO>();
			// recipe 테이블에 넣을 데이터 세팅
			rvo.setRecipeTbTitle(recipeTbTitle);
			rvo.setUserTbNo((int)session.getAttribute("userTbNo"));
			rvo.setRecipeTbContentLink("txt/recipe/" + savedName);
			rvo.setRecipeTbImageLink("/resources/img/recipe/" + savedImgName);
			// ingredient 테이블에 넣을 데이터 세팅
			for (int i = 0; i < ingredientTbNames.size(); i++) {
				IngredientVO ivo = new IngredientVO();
				ivo.setIngredientTbName(ingredientTbNames.get(i));
				ivoList.add(ivo);
				IngredientListVO ilvo = new IngredientListVO();
				ilvo.setIngredientListTbAmt(addIngDetails.get(i));
				ilvoList.add(ilvo);
			}
			recipeService.insertRecipe(rvo, ivoList, ilvoList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/mypage.do";
		
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID(); // 파일 업로드시 파일명 중복 방지를 위한 UUID
		String savedName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String updateRecipeForm(RecipeVO vo, Model model) {
		model.addAttribute("recipe", recipeService.getDetail(vo));
		// 레시피에 대한 재료 목록 및 재료 양을 가져온다.
		model.addAttribute("ingList", recipeService.getIngredientList(vo));
		// 각 재료의 이름을 가져온다.
		List<IngredientVO> ingredients = new ArrayList<IngredientVO>();
		for(int i = 0; i < recipeService.getIngredientList(vo).size(); i++) {
			IngredientVO ivo = new IngredientVO();
			ivo.setIngredientTbNo(recipeService.getIngredientList(vo).get(i).getIngredientTbNo());
			ingredients.add(recipeService.getIngredient(ivo.getIngredientTbNo()));
		}
		model.addAttribute("ings", ingredients);
		
		// txt 파일 내용 읽어서 내용란에 전달해줘야함
		try {
			// src/main/resources 위치에서 파일을 쉽게 가져올 수 있도록 마련된 클래스.
			ClassPathResource resource_txt = 
					new ClassPathResource(recipeService.getDetail(vo).getRecipeTbContentLink());
			// java 7에 새롭게 추가된 nio 패키지의 Files, Path 클래스를 사용하면 파일을 쉽게 읽을 수 있다.
			Path path = Paths.get(resource_txt.getURI());
			List<String> contents = Files.readAllLines(path);
			String content = ""; 
			boolean toggle = false;
			for(String str : contents) {
				// contents에 모든 내용이 한 줄 형태로 담겨있을 경우
				if(contents.size() == 1) {
					String[] str2 = str.split("조리순서<br /><br />", 2);
					content = str2[1];
					break;
				}
				// contents가 여러 줄일 경우
				if(toggle) {
					content += str;
					content += "<br />";
				}
				if(str.contains("조리순서")) {
					toggle = true;
				}
			}
			model.addAttribute("content", content);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "update";
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateRecipe(
			MultipartFile imgFile,
			@RequestParam("recipeTbNo") String recipeTbNo,
			@RequestParam("recipeTbTitle") String recipeTbTitle,
			@RequestParam("ingredientTbName") List<String> ingredientTbNames,
			@RequestParam("addIngDetail") List<String> addIngDetails,
			@RequestParam("recipeDetail") String recipeDetail,
			HttpSession session) throws Exception {
		// 이 모든 일련의 과정에 트랜잭션을 걸어줘야함.
		try {
			// 이미지 업로드
			String savedImgName = uploadFile(imgFile.getOriginalFilename(), imgFile.getBytes());
			
			// txt 파일 만들기
			String savedName = 
					"recipe_" + String.valueOf(recipeTbNo) + ".txt";
			ClassPathResource resource = new ClassPathResource("txt/recipe/");
			try {
				Path path = Paths.get(resource.getURI()); // 레시피 txt파일들을 모아둔 디렉토리를 저장
				File file = new File(path + "/" + savedName); // 해당 디렉토리에 파일을 만들고
				file.createNewFile();
				resource = new ClassPathResource("txt/recipe/" + savedName); // 만든 파일을 참조하도록 함.
				path = Paths.get(resource.getURI()); 
				String txtContent = recipeTbTitle 
						+ "<br /><br />[재료]<br /><br />";
				for(int i = 0; i < ingredientTbNames.size(); i++) {
					txtContent += ingredientTbNames.get(i);
					txtContent += addIngDetails.get(i);
					if(i < ingredientTbNames.size() - 1)
						txtContent += ", ";
				}
				txtContent += "<br /><br />조리순서<br /><br />";
				txtContent += recipeDetail;
				byte[] bytes = txtContent.getBytes(); // 레시피 내용을 byte화한다.
				Files.write(path, bytes); // 대상 파일에 레시피 내용을 기록
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			// DB에 데이터 삽입
			// 아래의 정보를 바탕으로 userTbNo를 얻어낸다.
			RecipeVO rvo = new RecipeVO();
			List<IngredientVO> ivoList = new ArrayList<IngredientVO>();
			List<IngredientListVO> ilvoList = new ArrayList<IngredientListVO>();
			// recipe 테이블에 넣을 데이터 세팅
			rvo.setRecipeTbTitle(recipeTbTitle);
			rvo.setUserTbNo((int)session.getAttribute("userTbNo"));
			rvo.setRecipeTbContentLink("txt/recipe/" + savedName);
			rvo.setRecipeTbImageLink("/resources/img/recipe/" + savedImgName);
			// ingredient 테이블에 넣을 데이터 세팅
			for (int i = 0; i < ingredientTbNames.size(); i++) {
				IngredientVO ivo = new IngredientVO();
				ivo.setIngredientTbName(ingredientTbNames.get(i));
				ivoList.add(ivo);
				IngredientListVO ilvo = new IngredientListVO();
				ilvo.setIngredientListTbAmt(addIngDetails.get(i));
				ilvoList.add(ilvo);
			}
			recipeService.updateRecipe(rvo, ivoList, ilvoList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/mypage.do";
		
	}
	
	@RequestMapping(value="/mypage.do")
	public String mypage(HttpSession session, Model model) {
		model.addAttribute("myRecipeList", 
			recipeService.getMyRecipeList((int)session.getAttribute("userTbNo")));
		model.addAttribute("userTbId", session.getAttribute("userTbId"));
		model.addAttribute("userTbNo", session.getAttribute("userTbNo"));
		return "mypage";
	}
	
	@RequestMapping("delete.do")
	public String deleteRecipe(RecipeVO vo) {
		recipeService.deleteRecipe(vo);
		return "redirect:/mypage.do";
	}
	
}
