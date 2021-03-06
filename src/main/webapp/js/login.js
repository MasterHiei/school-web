$(function(){
	'use strict';

    var isNameValid = false,
        isPwdValid = false;

    // 输入检查
    $('#username').on('blur', function () {
        isNameValid = checkName();
    });
    $('#password').on('blur', function () {
        isPwdValid = checkPassword();
    });

    // 提交用户信息时的处理
    $('#submit').click(function () {
        // 触发输入检查
        $('.input').trigger('blur');

        // 正常情况下的处理
		if (isNameValid && isPwdValid){
            login();
		}
    });

    // 在密码输入框按Enter健同样会触发登录事件
    $('#password').on('change', function () {
        $('#submit').trigger('click');
    });

	// 注册跳转
	$('#register').click(function () {
		window.location.href = 'register.html';
    });

	// 忘记密码
	$('#forgotPwd-btn').click(function (e) {
		alert('非常抱歉，请您直接联系管理员或重新注册新的账号。');
		return false;
    })
});

// 提交用户信息
function login() {
	var userData = JSON.stringify({
        tuName: $('#username').val(),
        tuPwd: $.md5($('#password').val())
	});

	$.ajax({
        url: 'login.do',
		type: 'POST',
		dataType: 'json',
        data: userData,
		contentType: 'application/json;charset=utf8',
		error: function () {
            alert('非常抱歉，由于系统发生未知错误，请您稍后重试。');
        },
		success: function (msg) {
        	// 学生账户登录，跳转至订餐页面
			if (msg === 'student') {
                window.location.href = 'index.html';
			}
            // 管理账户登录，跳转至后台管理页面
			else if (msg === 'admin') {
                window.location.href = 'management.html';
			}
			else if (msg === 'null') {
				alert('对不起，该账户不存在。');
			}
			else if (msg === 'invalid') {
				alert('对不起，您输入的密码不正确。');
			}
        }
	})
}

// 检查用户名
function checkName(){
	var name = $('#username').val();
	if(name == null || name === ''){
		$('#count-msg').html('用户名不能为空');
		return false;
	}
	var reg = /^\w{6,12}$/;
	if (!reg.test(name)){
		$('#count-msg').html('用户名格式不正确');
		return false;
	}
	$('#count-msg').empty();
	return true;
}

// 检查密码
function checkPassword(){
	var password = $('#password').val();
	if (password == null || password === ''){
		$('#password-msg').html('密码不能为空');
		return false;
	}
	var reg = /^\w{6,12}$/;
	if (!reg.test(password)){
		$('#password-msg').html('密码格式不正确');
		return false;
	}
	$('#password-msg').empty();
	return true;
}