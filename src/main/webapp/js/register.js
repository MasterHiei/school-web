$(function(){
    'use strict';

    var isNameValid = false,
        isNameUsed = false,
        isPwdValid = false,
        isRePwdValid = false,
        isAddressValid = false;

    // 输入检查
    $('#username').on('blur', function () {
        // 优先执行格式检查
        isNameValid = checkName();

        if (isNameValid){
            isNameUsed = checkNameUsed();
        }
    });
    $('#password').on('blur', function () {
        isPwdValid = checkPassword();
    });
    $('#re-password').on('blur', function () {
        isRePwdValid = reCheckPassword();
    });
    $('#address').on('blur', function () {
        isAddressValid = checkAddress();
    });

    // 提交用户信息时的处理
    $('#submit').click(function () {

        // 触发输入检查
        $('.input').trigger('blur');

        // 正常情况下的处理
        if (isNameValid && isNameUsed && isPwdValid && isRePwdValid && isAddressValid){
            register();
        }
    });

    // 登录跳转
    $('#login').click(function () {
        window.location.href = 'login.html';
    })
});

// 提交用户信息
function register() {
    var userData = JSON.stringify({
        tuName: $('#username').val(),
        tuPwd: $.md5($('#password').val()),
        tuAddress: $('#address').val()
    });

    $.ajax({
        url: 'register.do',
        type: 'POST',
        dataType: 'json',
        data: userData,
        contentType: 'application/json;charset=utf8',
        error: function () {
            alert('非常抱歉，由于系统发生未知错误，请您稍后重试。');
        },
        success: function (msg) {
            // 注册成功，跳转至登录页面
            if (msg === 'success'){
                alert('注册成功。');
                window.location.href = 'login.html';
            }
            else {
                alert(msg);
            }
        }
    })
}

// 检查用户名
function checkName(){
    var name = $('#username').val();
    if (name == null || name === ''){
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

// 检查用户名是否存在
function checkNameUsed(){
    var name = JSON.stringify({
            tuName: $('#username').val()
        });

    $.ajax({
        url: 'userName.do',
        type: 'POST',
        dataType: 'json',
        data: name,
        contentType: 'application/json;charset=utf8',
        error: function (msg) {
            alert('非常抱歉，由于系统发生未知错误，请您稍后重试。');
        },
        success: function (msg) {
            if (msg === 'unused') {
                $('#hiddenFlg').val('1');
            }else {
                $('#hiddenFlg').val('0');
            }
        }
    });

    if ($('#hiddenFlg').val() === '1') {
        return true;
    } else if ($('#hiddenFlg').val() === '0')
    {
        $('#count-msg').html('用户名已存在');
        return false;
    } else {
        // 第一次blur事件不会检测到AJAX赋给hiddenFlg的值
        // 但不影响注册（点击注册按钮时会强制触发第1+α次blur事件）
        return 'first';
    }
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

// 重复检查密码
function reCheckPassword() {
    var password = $('#password').val(),
        rePassword = $('#re-password').val();
    if (rePassword !== password){
        $('#re-password-msg').html('输入的密码不一致');
        return false;
    }
    $('#re-password-msg').empty();
    return true;
}

// 检查住址
function checkAddress() {
    var address = $('#address').val();
    if (address == null || address === ''){
        $('#address-msg').html('住址不能为空');
        return false;
    }
    $('#address-msg').empty();
    return true;
}