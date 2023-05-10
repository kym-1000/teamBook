<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/memberJoin.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- CSS only -->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
   crossorigin="anonymous">
<script src="https://kit.fontawesome.com/92e616dfba.js" crossorigin="anonymous"></script>   
<title>Insert title here</title>
<style type="text/css">
body {
   text-align: center;
   margin: 0 auto;
   width: 100%;
   padding-top: 150px;
}

.logo>a>img {
   width: 150px;
   height: 150px;
}

.login-container {
   border: 1px solid gray;
   width: 500px;
   height: 100%;
   margin: 30px auto;
}

.Mem-search>a>button {
   text-decoration: none;
   background-color: white;
   font-size: 15px;
   width: 100px;
   height: 43.5px;
   color: gray;
}
.pw_ok {
   color: #008000;
   display: none;
}

.pw_rewrite {
   color: #ff0000;
   display: none;
}

.pw_null {
   color: #ff0000;
   display: none;
}

.pwRe_ok {
   color: #008000;
   display: none;
}

.pwRe_rewrite {
   color: #ff0000;
   display: none;
}

.pwRe_null {
   color: #ff0000;
   display: none;
}
#mem_pw::placeholder, #mem_pwRe::placeholder {
	font-size: 8px;
}
input{
	width: 250px;
}
</style>
</head>
<body>
   <h1>새로운 비밀번호 입력</h1>
   <div class="login-container">
      <div class="logo">
         <a href="/"><img src="/resources/img/logo.jpg" alt="로고"></a><br>
      </div>
      <div class="login">
         <form action="/mem/newPwUpdate" method="post">
         <lable for="mem_id">ID</lable>
         <br> <input type="text" class="join-input" name="mem_id" id="mem_id" value=${mvo.mem_id} required readonly="readonly">          
         <br><lable for="mem_pw">PW</lable>
         <br> <input type="password" class="join-input" name="mem_pw" id="mem_pw" placeholder="영문(대소문자 구분X), 숫자, 특수문자 조합, 9~12자리" onchange="checkPw()" required> 
            <span class="pw_ok"><i class="fa-solid fa-check"></i></span> 
            <span class="pw_rewrite"><i class="fa-solid fa-x"></i></span> 
            <span class="pw_null"><i class="fa-solid fa-x"></i></span><br>

         <lable for="mem_pwRe">PW Re</lable><br>
          <input type="password" class="join-input" name="mem_pwRe" id="mem_pwRe" placeholder="비밀번호 확인을 위해 한번 더 입력해주세요" onchange="checkPwRe()" required> 
            <span class="pwRe_ok"><i class="fa-solid fa-check"></i></span> 
            <span class="pwRe_rewrite"><i class="fa-solid fa-x"></i></span> 
            <span class="pwRe_null"><i class="fa-solid fa-x"></i></span> 
            <br><br><br> 
            <a><button type="submit" class="btn btn-outline-secondary" >확인</button></a>
            <br> <br>
         </form>
      </div>
   </div>

</body>
</html>