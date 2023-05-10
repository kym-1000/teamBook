<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
   crossorigin="anonymous">
<link href="/resources/css/memberLogin.css" type="text/css" rel="stylesheet">
<title>회원 아이디 찾기</title>
</head>
<body>
   <div class="login-box">
      <div class="Mem-search loginTopBtn loginTopBtn2">
         <a href="/mem/MemIdSearch"><button>
               아이디 찾기
            </button></a> <a href="/mem/MemPwSearch"><button>
               비밀번호 찾기
            </button></a>
      </div>
      <div class="login-container">
         <div class="logo">
            <a href="/"><img src="/resources/img/logo.jpg" alt="로고"></a><br>
         </div>
         <div class="login">
            <form action="/mem/MemIdSearch" method="post">
               <input type="text" placeholder="이름" name="mem_name"><Br>
               <input type="number" placeholder="휴대폰 번호" name="mem_cell_num">
               <br>
               <br> <a><button type="submit"
                     class="btn btn-outline-secondary">확인</button></a> <br>
                     
               <br>
            </form>
         </div>
      </div>
   </div>


   <script type="text/javascript">
      const msg = '<c:out value="${msg}"/>';
         if (msg!="0") {
            alert(`아이디는 ${msg} 입니다.`);
         } else {
            alert("찾을 수 없습니다. 다시 입력해주세요!");
         }
   </script>

</body>
</html>