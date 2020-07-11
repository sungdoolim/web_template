<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/customize.css">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
	<div class="container-fluid">
	
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1" aria-expanded="false"><!-- ũ�⸦ �ٿ����� ��Ÿ���� ��ư -->
				<span class="sr-only"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.do">Every dongguk</a>
			
			<c:if test="${Siscouncil==10}">
			<a class="navbar-brand" href="userall.do">���� ���� ����</a>
			<a class="navbar-brand" href="bankall.do">�ܰ��� �л�ȸ�� ���� ����</a>
			
			</c:if>
		</div>	
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"><!-- �׺� �߰� ��κ��� ������ -->
			
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false"><c:if test="${empty Sid }">login or register</c:if><c:if test="${not empty Sid }">${Sid } �� ȯ���մϴ�.</c:if><span class="caret"></span></a>
					<ul class="dropdown-menu">
					
					<c:choose>
					<c:when test="${empty Sid }">
						<li><a href="login_form.do">�α���</a></li>
						<li><a href="register_form.do">ȸ������</a></li>	
					</c:when>
					<c:otherwise>
						<li><a href="logout.do">�α׾ƿ�</a></li>
						<li><a href="mypage.do">����������(${Sid})</a></li>
						</c:otherwise>
						</c:choose>
					
					</ul>
			
				</li>
			</ul>
			
		</div>
	</div>
</nav>



</body>
</html>