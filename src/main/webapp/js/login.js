$(function(){
	'use strict'

    $('#submit').click(function () {
    	var isNameValid = false,
			isPwdValid = false;

        // 输入检查
        $('#username').on('blur', function () {
            isNameValid = checkName();
        });
        $('#password').on('blur', function () {
            isPwdValid = checkPassword();
        });

        // 触发输入检查
        $('.input').trigger('blur');

        // 正常情况下的处理
		if (isNameValid && isPwdValid){
            login();
		}
    })

	// 注册跳转
	$('#register').click(function () {
		window.location.href = '../register.html';
    })
});

// 提交用户信息
function login() {
	var userData = JSON.stringify({
        tuName: $('#username').val(),
        tuPwd: $.md5($('#password').val())
	})

	$.ajax({
        url: 'login.do',
		type: 'POST',
		dataType: 'json',
        data: userData,
		contentType: 'application/json;charset=utf8',
		error: function (msg) {
			alert('发生错误：' + msg);
        },
		success: function (msg) {
        	// 学生账户登录，跳转至点餐页面
			if (msg == '1')
				window.location.href = 'order.html';
            // 管理账户登录，跳转至后台管理页面
			else if (msg == '2')
				window.location.href = 'management.html';
			else
				alert(msg);
        }
	})
}

// 检查用户名
function checkName(){
	var name = $('#username').val();
	if(name == null || name == ''){
		$('#count-msg').html('用户名不能为空');
		return false;
	}
	var reg = /^\w{6,12}$/;
	if(!reg.test(name)){
		$('#count-msg').html('用户名格式不正确');
		return false;
	}
	$('#count-msg').empty();
	return true;
}

// 检查密码
function checkPassword(){
	var password = $('#password').val();
	if(password == null || password == ''){
		$('#password-msg').html('密码不能为空');
		return false;
	}
	var reg = /^\w{6,12}$/;
	if(!reg.test(password)){
		$('#password-msg').html('密码格式不正确');
		return false;
	}
	$('#password-msg').empty();
	return true;
}