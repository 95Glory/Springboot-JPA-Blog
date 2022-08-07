# 스프링 블로그 만들기 (Spring boot + Ajax)  

### 프로젝트 설명
Rest API + 비동기통신  
Rest API 통신에 초점을 맞추고 진행.  
Thymeleaf 템플릿 엔진을 활용하여 화면구축을 통해  
본인이 게시한 글은 수정 / 삭제를 할 수 있으며  
다른 사용자의 게시글을 볼 수 있는 웹페이지 구축

### 디펜던시
* Spring boot  
* Thymeleaf  
* MySql  
* Lombok  
* Spring Security  
* Spring web  
* JPA    

### 기능 설명
* 썸머노트를 사용한 글쓰기 폼 제공
* 스프링 시큐리티를 통한 권한별 렌더링 및 로그인 기능 제공
* 스프링 시큐리티 UserDetail객체를 활용하여 게시글 수정 / 삭제 권한
* 게시글 CRUD  
* 타임리프를 통한 layout 분리
