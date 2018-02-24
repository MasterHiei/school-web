$(function () {
    'use strict';

    ////////////////////////////////////////////////////
    // 页面初始化时执行的操作
    $(document).ready(function () {
        // 获取并显示购物车信息
        getCartInfo();
    });

    ////////////////////////////////////////////////////
    // 选中全选框后选中所有复选框
    $('#checklist').click(function () {
        var isCheck = $(this).prop('checked');
        checkAll(isCheck);
    });

    ////////////////////////////////////////////////////
    // 根据复选框状态选择全选框
    $('#cart-table-body').on('click', '.checklist-item', function () {
        changeAllCheck();
    });

    ////////////////////////////////////////////////////
    // 减少订购数量
    $('#cart-table-body').on('click', '.btn-minus', function () {
        var tcId = $(this).parents('tr').attr('id');
        var totalNum = parseInt($(this).next('.number-input').val()) - 1;
        updateCartNum(tcId, totalNum, this);
    });

    ////////////////////////////////////////////////////
    // 增加订购数量
    $('#cart-table-body').on('click', '.btn-plus', function () {
        var tcId = $(this).parents('tr').attr('id');
        var totalNum = parseInt($(this).prev('.number-input').val()) + 1;
        updateCartNum(tcId, totalNum, this);
    });

    ////////////////////////////////////////////////////
    // 输入框直接更改订购数量
    $('#cart-table-body').on('change', '.number-input', function () {
        var tcId = $(this).parents('tr').attr('id');
        var totalNum = parseInt($(this).val());
        updateCartNum(tcId, totalNum, this);
    });

    ////////////////////////////////////////////////////
    // 点击删除该商品
    $('#cart-table-body').on('click', '.btn-delete', function () {
        var tcId = $(this).parents('tr').attr('id'),
            objArray = [this];
        // 删除处理
        deleteCart(tcId, objArray);
    });

    ////////////////////////////////////////////////////
    // 删除所有被选中的商品
    $('#all-delete').click(function () {
        var tcIdStr = '',
            objArray = [];
        // 获取被选中的购物车的ID
        $('.checklist-item').each(function () {
            if ($(this).prop('checked')) {
                tcIdStr += $(this).parents('tr').attr('id') + ',';
                objArray.push(this);
            }
        });
        if (objArray.length > 0) {
            // 删除处理
            deleteCart(tcIdStr, objArray);
        }
    });

    ////////////////////////////////////////////////////
    // 订单确认点击事件
    $('#buy-btn').click(function () {
        // 检查是否存在显示为无货的商品
        var isStock = 0;
        $('.stock-input').each(function () {
            if ($(this).text() === '无货') {
                isStock = -1;
            }
            else {
                isStock = 1;
            }
        });
        if (isStock === 1) {
            if (confirm('确认购买吗？')) {
                // 订单处理
                buyCart();
            }
        }
        else if (isStock === -1) {
            alert('对不起，您的订单中存在已售完的商品。\r\n请删除该商品后再进行购买。');
        }
        else if (isStock === 0) {
            alert('当前购物车中无任何可购买的商品。请确认后再购买。');
        }
    });

    ////////////////////////////////////////////////////
    // 继续购买按钮点击事件
    $('#go-index').click(function () {
        window.location.href = 'index.html';
    });
});

////////////////////////////////////////////////////////////////////////////////////////////////////////

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
            // 显示总数量和总金额
            changeNumAndMoney();
        }
    })
}

////////////////////////////////
//         显示购物车信息       //
////////////////////////////////
function showCartList(cartList) {
    var htmlStr = '',
        stockNum = 0;

    // 生成html代码
    for (var i in cartList) {
        // 判断是否有可购买的订单
        stockNum++;
        // 生成html代码
        htmlStr += '             <tr class="cartList-item" id="' + cartList[i].tcId + '">\n' +
            '                        <td class="text-left">\n' +
            '                            <div>\n' +
            '                                <input type="checkbox" class="checklist-item"/>\n' +
            '                            </div>\n' +
            '                        </td>\n' +
            '                        <td class="text-left">\n' +
            '                            <img src="' + cartList[i].tdImg + '"/>\n' +
            '                            ' + cartList[i].tdName + '\n' +
            '                        </td>\n' +
            '                        <td class="text-center price-input">¥' + cartList[i].tdPrice + '</td>\n' +
            '                        <td class="text-center stock-input">' + cartList[i].tdStock + '</td>\n' +
            '                        <td class="text-center">\n' +
            '                            <button type="button" class="btn btn-xs btn-minus">&minus;</button>\n' +
            '                            <input onkeyup="if(this.value.length===1){this.value=this.value.replace(/[^1-9]/g,\'\')}' +
            '                                   else{this.value=this.value.replace(/\\D/g,\'\')}" ' +
            '                               onafterpaste="if(this.value.length===1){this.value=this.value.replace(/[^1-9]/g,\'\')}' +
            '                                   else{this.value=this.value.replace(/\\D/g,\'\')}" ' +
            '                               type="text" class="text-center number-input" ' +
            '                               value="' + cartList[i].tcNum + '">\n' +
            '                            <button type="button" class="btn btn-xs btn-plus">&plus;</button>\n' +
            '                        </td>\n' +
            '                        <td class="text-center">\n' +
            '                            <button type="button" class="btn btn-xs btn-delete" >删除</button>\n' +
            '                        </td>\n' +
            '                    </tr>';
    }
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
//         选中所有复选框       //
////////////////////////////////
function checkAll(isCheck) {
    var checklist = $('#cart-table-body').find('.checklist-item');
    checklist.prop('checked', isCheck);
}

////////////////////////////////
//     根据复选框改变全选框     //
////////////////////////////////
function changeAllCheck() {
    var checkedNum = 0,
        checkListNum = 0;
    $('.checklist-item').each(function () {
        if ($(this).prop('checked')) {
            checkedNum++;
        }
        checkListNum++;
    });
    if (checkListNum === checkedNum) {
        $('#checklist').prop('checked', true);
    }else {
        $('#checklist').prop('checked', false);
    }
}

////////////////////////////////
//         更新商品数量         //
////////////////////////////////
function updateCartNum(tcId, totalNum, obj) {
    var params = JSON.stringify({
        tcId: tcId,
        tcNum: totalNum
    });

    $.ajax({
        async: false,
        url: 'updateCart.do',
        data: params,
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json;charset=utf8',
        error : function () {
            window.location.href = "error.html";
        },
        success: function (msg) {
            var reg = new RegExp('"', 'g'),
                data = msg.replace(reg, '');
            if (data === 'true') {
                if (totalNum > 0) {
                    // 变更购物车数量
                    $(obj).parent().find('.number-input').val(totalNum);
                    // 变更总数量和总金额
                    changeNumAndMoney();
                }
                else {
                    // 删除该购物车信息
                    $(obj).parents('tr').remove();
                    // 变更总数量和总金额
                    changeNumAndMoney();
                }
            }
            else if (data === 'false') {
                window.location.href = 'error.html';
            }
        }
    })
}

////////////////////////////////
//       变更金额及数量信息     //
////////////////////////////////
function changeNumAndMoney() {
    var priceArray = [],
        numberArray = [],
        totalPrice = '0',
        totalNum = 0;

    // 获取所有价格
    $('.price-input').each(function () {
        priceArray.push(parseFloat($(this).text().substring(1)));
    });

    // 获取所有数量
    $('.number-input').each(function () {
        numberArray.push(parseInt($(this).val()));
    });

    // 计算总价格
    for (var i in priceArray) {
        totalPrice = parseFloat(totalPrice) + (parseFloat(priceArray[i]) * parseFloat(numberArray[i]));
    }

    // 计算总数量
    for (var j in numberArray) {
        totalNum = totalNum + parseInt(numberArray[j]);
    }

    $('#sum-price, #sum-pay').empty();
    $('#sum-price, #sum-pay').append('¥' + parseFloat(totalPrice).toFixed(2));
    $('#sum-num').empty();
    $('#sum-num').append(totalNum);
}

////////////////////////////////
//          商品删除处理       //
////////////////////////////////
function deleteCart(tcIdStr, objArray) {
    var params = JSON.stringify({
        tcIdStr : tcIdStr
    });

    $.ajax({
        async: false,
        url: 'deleteCart.do',
        data: params,
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json;charset=utf8',
        error : function () {
            window.location.href = "error.html";
        },
        success:function (msg) {
            var reg = new RegExp('"', 'g'),
                data = msg.replace(reg, '');
            if (data === 'true') {
                // 删除该购物车信息
                for (var i in objArray) {
                    $(objArray[i]).parents('tr').remove();
                }
            }
            else if (data === 'false') {
                window.location.href = 'error.html';
            }
        }
    })
}

////////////////////////////////
//          商品购买处理       //
////////////////////////////////
function buyCart() {
    $.ajax({
        async: false,
        url: 'insertOrder.do',
        type: 'POST',
        contentType: 'application/json;charset=utf8',
        error : function () {
            window.location.href = "error.html";
        },
        success:function (msg) {
            var reg = new RegExp('"', 'g'),
                data = msg.replace(reg, '');
            if (data === 'true') {
                alert('订单提交成功，订单详情可前往个人信息页面查看。');
                window.location.href = 'index.html'
            }
            else if (data === 'alert') {
                alert('当前购物车中无任何可购买的商品。请确认后再购买。');
            }
            else if (data === 'false') {
                window.location.href = 'error.html';
            }
        }
    })
}