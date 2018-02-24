$(function () {
    'use strict';

    // 页面初始化时执行的操作
    $(document).ready(function () {
        // 登录验证处理
        validUserSession();
    });

    // 用户名超链接点击事件
    $('#user-label').click(function () {
        window.location.href = 'user.html';
    })

    // 用户注销超链接点击事件
    $('#logout').click(function () {
        // 注销处理
        logout();
    });
});

// 用户登录验证
function validUserSession() {
    // 向后台提交请求以触发过滤器
    $.ajax({
        async: false,
        url: 'validSession.do',
        type: 'POST',
        error: function () {
            window.location.href = 'error.html';
        },
        success: function (msg) {
            // 返回值处理
            var data = msg.replace(new RegExp('"', 'g'), '').split(',');
            // 判断返回值
            if (data[0] === 'logout') {
                // 验证失败，提示并跳转至错误页面
                window.location.href = 'login.html';
            }
            else if (data[0] === 'login') {
                // 验证通过，将用户名展示在页面
                $('#user-label').attr('tuId', data[1]);
                $('#user-label').text(data[2]);
            }
        }
    });
}

// 用户注销处理
function logout() {
    var isLogout = confirm('确认退出当前账户吗？');
    if (isLogout){
        // 确认注销
        $.post('logout.do', function (msg) {
            var reg = new RegExp('"', 'g'),
                data = msg.replace(reg, '');
            if (data === 'logout'){
                window.location.href = 'login.html';
            }else {
                window.location.href = 'error.html';
            }
        }).error(function () {
            window.location.href = 'error.html';
        });
    }
}