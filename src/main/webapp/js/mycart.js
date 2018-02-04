$(function () {
    'use strict';

    ////////////////////////////////////////////////////
    // 页面初始化时执行的操作
    $(document).ready(function () {
        // 1.登录验证处理
        validUserSession();
        // 2.获取并显示购物车信息
        getCartInfo();
    });



    //////////////////////////////////////////////////////
    // 用户注销超链接点击事件
    $('#logout').click(function () {
        // 注销处理
        logout();
    });

    //////////////////////////////////////////////////////
    // 禁止用户名超链接点击事件
    // TODO:用户信息页面
    $('#user-label').click(function (e) {
        e.preventDefault();
    })

});

////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////
//         用户登录验证        //
////////////////////////////////
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
            var reg = new RegExp('"', 'g'),
                data = msg.replace(reg, '').split(':');
            // 判断返回值
            if (data[0] === 'loginOut'){
                // 验证失败，提示并跳转至错误页面
                window.location.href = 'error.html';
            }
            else if (data[0] === 'session'){
                // 验证通过，将用户名展示在页面
                $('#user-label').text(data[1]);
            }
        }
    })
}

////////////////////////////////
//         获取购物车信息       //
////////////////////////////////
function getCartInfo() {
    $.ajax({
        async: false,
        url: 'selectAllCart.do',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json;charset=utf8',
        error : function () {
            window.location = "error.html";
        },
        success: function (data) {
            var obj = $.parseJSON(data);
            var htmlStr = showCartList(obj);
            // 清空当前数据
            $('#cart-table-body').empty();
            // 显示购物车信息
            $('#cart-table-body').append(htmlStr);
        }
    })
}

////////////////////////////////
//         显示购物车信息       //
////////////////////////////////
function showCartList(cartList) {
    var htmlStr = '',
        stockNum = 0,
        dishSum = 0,
        priceArray = [];

    // 生成html代码
    for (var i in cartList) {
        // 计算总金额
        var dishPrice = cartList[i].tdPrice * cartList[i].tcNum;
        priceArray[i] = parseFloat(dishPrice).toFixed(2);
        // 计算总数量
        dishSum += parseInt(cartList[i].tcNum);
        // 判断是否有可购买的订单
        if (cartList[i].tdStock === '有货'){
            stockNum++;
        }
        // 生成html代码
        htmlStr += '             <tr id="' + cartList[i].tcId + '">\n' +
            '                        <td class="text-left">\n' +
            '                            <div class="checkbox-list">\n' +
            '                                <input type="checkbox" class="checklist-item"/>\n' +
            '                            </div>\n' +
            '                        </td>\n' +
            '                        <td class="text-left">\n' +
            '                            <img src="' + cartList[i].tdImg + '"/>\n' +
            '                            ' + cartList[i].tdName + '\n' +
            '                        </td>\n' +
            '                        <td class="text-center">¥' + cartList[i].tdPrice + '</td>\n' +
            '                        <td class="text-center">' + cartList[i].tdStock + '</td>\n' +
            '                        <td class="text-center">\n' +
            '                            <button type="button" class="btn btn-xs">&minus;</button>\n' +
            '                            <input type="text" class="text-center" id="num-input"' +
            '                               disabled="true" value="' + cartList[i].tcNum + '">\n' +
            '                            <button type="button" class="btn btn-xs">&plus;</button>\n' +
            '                        </td>\n' +
            '                        <td class="text-center">\n' +
            '                            <button type="button" class="btn btn-xs" id="item-delete">删除</button>\n' +
            '                        </td>\n' +
            '                    </tr>';
    }
    // 显示总数量和金额
    showNumAndMoney(dishSum, priceArray);
    // 根据在库状态修改提示和按钮状态
    if (stockNum > 0) {
        $('#cart-alert-null').hide();
        $('#buy-btn').attr('disable', false);
    }else {
        $('#cart-alert-null').show();
        $('#buy-btn').attr('disable', true);
    }
    return htmlStr;
}

////////////////////////////////
//       显示金额及数量信息     //
////////////////////////////////
function showNumAndMoney(dishSum, priceArray) {
    var totalPrice = '0';

    for (var i = 0; i < priceArray.length; i++) {
        totalPrice = parseFloat(totalPrice) + parseFloat(priceArray[i]);
    }

    $('#sum-price, #sum-pay').append('¥' + parseFloat(totalPrice).toFixed(2));
    $('#sum-num').append(dishSum);
}

////////////////////////////////
//          用户注销处理       //
////////////////////////////////
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
                window.location = 'error.html';
            }
        }).error(function () {
            window.location = 'error.html';
        });
    }
}