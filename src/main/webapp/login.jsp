<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>校园订餐系统</title>

	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/login.css" />

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.md5.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div class="page">
	<div class="loginWrapper">
		<div class="logo">用户登录</div>
        <div class="login_form">
			<div id="Login" name="Login">
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" id="username" name="tuName" class="login_input" >
                    <span id="count-msg" class="error"></span>
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" id="password" name="tuPwd" class="login_input" >
					<span id="password-msg" class="error"></span>
				</li>
				<div class="clearfix"></div>
				<li class="login-sub">
					<input type="button" id="submit" name="submit" value="登录" />
                    <input type="button" id="register" name="register" value="注册" />
				</li>
           </div>
		</div>
	</div>
</div>
</body>
</html>