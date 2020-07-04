<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/customize.css">
<link rel="stylesheet" href="resources/css/template.css">
</head>
<body class="body">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>



<style type="text/css">


.jumbotron{
text-shadow:black 0.2em 0.2em 0.2em;
color:white;
height:300px;
background-image:url('resources/images/babyele.JPG');
background-size:70% 100%;
background-repeat : no-repeat;
background-position:center;

}


</style>
<%@include file="header.jsp"%>
<div class="container">
	<div class="jumbotron" >

	<c:if test="${empty Sid }">
	<center><div><h2>로그인 이후 화면이 보입니다.</h2></div><center>
	</c:if>
	
	<c:if test="${not empty Sid }">

	<c:if test="${empty bank }">
	<p class="text-center">조회 할 수 있는 계좌가 없습니다. 소속 과 학생회에 문의 하세요</p>
	</c:if>
	<c:if test="${not empty bank }">
	<h1 class="text-center">${bank.getBname() }</h1>
	<p class="text-center">${bank.getBrest() }</p>	
	<c:if test="${Siscouncil>='1' }">
	<center><button onclick="location='/web/purchase'">구매 내역 등록하기</button></center>
	
	</c:if>
	<center><button onclick="location='/web/blistall'">회비 입출 내역 보기</button></center>
	</c:if>

	
	</c:if>
	</div>
	


	
</div>
<div class="footer">
<%@include file="footer.jsp"%>
</div>
</body>
</html>