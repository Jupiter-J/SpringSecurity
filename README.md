# SpringSecurity
스프링 부트를 사용하여 로그인, 회원가입, 로그아웃 구현

## 제작 기간
* 2022-03-20 ~ 2022-03-26
* 2022-03-31 : Oauth 추가

## Tech Stack
* SpringBoot, Gradle(Security), BootStrap, Thymleaf

## 구현한 기능
* 타임리프와 부트스트랩을 사용하여 MVC 패턴 적용
* 유저의 회원가입, 로그인, 로그아웃 기능 구현
* user Dto, Controller, Enttiy를 생성하여 회원가입한 정보를 받아 검증을 통해 로그인이 가능  


<br/><br/>
### 회원가입
![회원가입](https://user-images.githubusercontent.com/73453283/160240121-0839536c-2065-454f-903e-5fe8d4334197.gif)  


<br/><br/>
### 회원가입으로 생성한 id, pw로 로그인
![로그인](https://user-images.githubusercontent.com/73453283/160240094-cad710f7-4458-48c0-bbfb-115406cdcc26.gif)  


<br/><br/>
### 로그아웃 
![로그아웃](https://user-images.githubusercontent.com/73453283/160240418-3255fd7c-f97d-4610-84e9-022b04e4767f.gif)  


<br/><br/>
### Authentication을 통해 로그인한 유저를 확인 
<img width="1404" alt="스크린샷 2022-03-26 오후 9 39 04" src="https://user-images.githubusercontent.com/73453283/160240434-4941c1e3-228e-4fc7-aa3f-f518f784a4c3.png">

<br/><br/>
## 에러 이슈
아이디와 패스워드를 입력 하였을때 PasswordEncoder mapped null에러가 났다. [상세내용](https://velog.io/@jupiter-j/%EC%97%90%EB%9F%AC-There-is-no-PasswordEncoder-mapped-for-the-id-null)

타임리프로 RestController를 사용했을때 html페이지가 연결되지 않아서 어려움을 겪었다. [상세내용](https://velog.io/@jupiter-j/%EC%97%90%EB%9F%AC-Thymeleaf-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84%EC%99%80-RestController-%EC%97%90%EB%9F%AC)

부트스트랩으로 적용한 페이지와 시큐리티로 인증한 페이지의 경로 지정오류로 페이지가 404에러를 냈다 [상세내용](https://velog.io/@jupiter-j/%EC%97%90%EB%9F%AC-Spring-Security-%EB%B6%80%ED%8A%B8%EC%8A%A4%ED%8A%B8%EB%9E%A9Bootstrap-404%EC%97%90%EB%9F%AC-CSS-%EC%A0%81%EC%9A%A9-%EC%97%90%EB%9F%AC)

git ignore 적용 [상세내용](https://velog.io/@jupiter-j/%EC%97%90%EB%9F%AC-%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4-gitignore-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0)
