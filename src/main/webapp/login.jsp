<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/login.css" />
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div class="page">
	<div class="loginWrapper">
		<div class="logo">用户登录</div>
        <div class="login_form">
			<form id="Login" name="Login" method="post" onsubmit="" action="/login.do">
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" id="username" name="tuId" class="login_input" >
                    <span id="count-msg" class="error"></span>
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" id="password" name="tuPwd" class="login_input" >
					<span id="password-msg" class="error"></span>
				</li>
				<div class="clearfix"></div>
				<li class="login-sub">
					<input type="submit" name="Submit" value="登录" />
                    <input type="reset" name="Reset" value="重置" />
				</li>
				<c:if test="${!empty errorMsg}">
					<script type="text/javascript">alert("${errorMsg}");</script>
				</c:if>
           </form>
		</div>
	</div>
</div>
</body>
</html>