$(function () {

    'use strict';

    var pwdChecked = false,
        rePwdChecked = false;

    $(document).ready(function () {
        // 1.显示购物车数量
        getCartNum();
        // 2.查询用户信息
        selectUserInfo();
    });

    // 点击修改个人信息按钮
    $('#user-modify').click(function () {
        showUserInput();
    });

    // 点击保存个人信息按钮
    $('#user-confirm').click(function () {
        // 触发密码检查
        $('input[type="password"]').trigger('blur');

        // 创建参数
        var tuPwd = $('#tuPwd').val();
        if (tuPwd !== '' && tuPwd.length > 0) {
            tuPwd = $.md5(tuPwd);
        }
        if (pwdChecked && rePwdChecked) {
            var params = JSON.stringify({
                tuId: $('#user-label').attr('tuId'),
                tuPwd: tuPwd,
                tuAddress: $('#tuAddress').val()
            });
            updateUserInfo(params);
        }
    });

    // 取消按钮
    $('#user-cancel').click(function () {
        hideUserInput();
    });

    // 密码检查
    $('#tuPwd').on('blur', function () {
        pwdChecked = checkPassword();
    });

    // 密码检查
    $('#tuPwd').on('blur', function () {
        rePwdChecked = reCheckPassword();
    });
});

////////////////////////////////////////////////////

////////////////////////////////
//          查询用户信息       //
////////////////////////////////
function selectUserInfo() {
    $.ajax({
        async: false,
        url: 'selectOneUser.do',
        type: 'POST',
        error : function () {
            window.location = "error.html";
        },
        success: function (data) {
            if (data.length > 0) {
                // 转换成JSON对象
                var userData = JSON.parse($.parseJSON(data));
                // 显示用户信息
                showUserInfo(userData);
            }
        }
    })
}

////////////////////////////////
//          修改用户信息       //
////////////////////////////////
function updateUserInfo(params) {
    $.ajax({
        async: false,
        url: 'updateUser.do',
        data: params,
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json;charset=utf8',
        error : function () {
            window.location = "error.html";
        },
        success: function (data) {
            if (data === 'true') {
                // 显示提示
                $('#save-alert-success').fadeIn(300);
                setTimeout("$('#save-alert-success').fadeOut(800)", 1000);
                // 隐藏输入框
                hideUserInput();
            } else {
                // 显示提示
                $('#save-alert-error').fadeIn(300);
                setTimeout("$('#save-alert-error').fadeOut(800)", 1000);
            }
        }
    })
}

////////////////////////////////
//          显示用户信息       //
////////////////////////////////
function showUserInfo(userData) {
    var tuName = userData.tuName,
        tuAddress = userData.tuAddress,
        tiName = userData.tiName,
        tuDate = new Date(userData.tuDate);

    $('#tuName').val(tuName);
    $('#tuAddress').val(tuAddress);
    $('#tuDate').val(tuDate.getFullYear() + '年' + tuDate.getMonth() + '月' + tuDate.getDay() + '日');
    $('#tiName').val(tiName);
}

////////////////////////////////
//         购物车数量获取       //
////////////////////////////////
function getCartNum() {
    $.ajax({
        async: false,
        url: 'selectCartNum.do',
        type: 'POST',
        success: function (data) {
            addCartNum(data);
        }
    })
}

////////////////////////////////
//         购物车数量更新       //
////////////////////////////////
function addCartNum(plusNum) {
    var num = $('.badge').text().toString();
    $('.badge').text(parseInt(num) + parseInt(plusNum));
}

////////////////////////////////
//          显示输入框         //
////////////////////////////////
function showUserInput() {
    $('.input-password').show();
    $('.modify-item').removeAttr('readonly').css('border', '1px solid #e7e7e7');
    $('#user-confirm').show();
    $('#user-cancel').show();
    $('#user-modify').hide();
}

////////////////////////////////
//          隐藏输入框         //
////////////////////////////////
function hideUserInput() {
    $('input[type="password"]').val('');
    $('.input-password').hide();
    $('.modify-item').attr('readonly', 'readonly').css('border', '0 none');
    $('#user-modify').show();
    $('#user-confirm').hide();
    $('#user-cancel').hide();
}

////////////////////////////////
//         检查用户密码        //
////////////////////////////////
function checkPassword(){
    var password = $('#tuPwd').val();
    if (password !== '' && password.length > 0) {
        var reg = /^\w{6,12}$/;
        if (!reg.test(password)){
            $('#password-msg').html('密码格式不正确');
            return false;
        }
        $('#password-msg').empty();
    }
    return true;
}

////////////////////////////////
//         检查确认密码        //
////////////////////////////////
function reCheckPassword() {
    var password = $('#tuPwd').val(),
        rePassword = $('#re-tuPwd').val();
    if (rePassword !== password){
        $('#re-password-msg').html('两次输入的密码不一致');
        return false;
    }
    $('#re-password-msg').empty();
    return true;
}