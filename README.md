# SimpleRecipe
재료 기반 레시피 검색 사이트

작업중인 브랜치 : ghp01

프론트 부분 css 작업 완료했으나
스프링 시큐리티 작업 중 js, css 및 image 등의 정적 파일이 제대로 동작하지 않는 오류 발생


- 시큐리티 기능을 적용하기 위해 작업했던 파일 목록
1) SimpleRecipe/SimpleRecipe/src/main/java/com/simplerecipe/login/ 디렉터리 내 
vo, dao, service, controller

2) SimpleRecipe/SimpleRecipe/src/main/webapp/WEB-INF/spring 내 3가지 context xml 파일
      appServlet/servlet-context.xml
      root-context.xml
      security-context.xml
      
3) SimpleRecipe/SimpleRecipe/src/main/webapp/WEB-INF/views/login/login.jsp

4) SimpleRecipe/SimpleRecipe/src/main/webapp/WEB-INF/web.xml 
   (security-context.xml 등록 및 springSecurityFilterChain filter 등록)

5) 등록되지 못한 동적 파일들의 디렉터리는
   SimpleRecipe/SimpleRecipe/src/main/webapp/resources/에 있습니다.
   css, img/recipe, js, smarteditor2(네이버 스마트 에디터)
