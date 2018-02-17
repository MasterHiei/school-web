$(function () {

    'use strict';

    $(document).ready(function () {
        // 查询用户信息
        selectUserInfo();
    })
});


// 查询用户信息
function selectUserInfo() {
    $.ajax({
        async: false,
        url: 'selectOneUser.do',
        type: 'POST',
        contentType: 'application/json;charset=utf8',
        error : function () {
            window.location = "error.html";
        },
        success: function (data) {
            if (data.length > 0) {
                // 转换成JSON对象
                var jsonStr = $.parseJSON(data);
                var userData =JSON.parse(jsonStr);
                // 显示用户信息
                showUserInfo(userData);
            }
        }
    })
}

// 显示用户信息
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