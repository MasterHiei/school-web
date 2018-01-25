$(function () {
    'use strict';

    ////////////////////////////////////////////////////
    // 页面初始化时执行的操作
    $(document).ready(
        function () {
            // 1.登录验证处理
            validUserSession();
            // 2.显示餐厅列表
            getProviderList();
            // 3.显示菜单列表（分页处理）
            var params = '{type:"all"}';
            showPagination(params);
        }
    );

    ////////////////////////////////////////////////////
    // 食堂选择按钮触发事件
    $('#providerList').on('click', 'button', function () {
        // 获取查询条件
        var params = JSON.stringify({
           tuId : $(this).attr('id'),
           type : 'all'
        });
        // 执行查询
        showPagination(params);
    });

    ////////////////////////////////////////////////////
    // 菜单查询按钮触发事件
    $('#searchDishBtn').click(function () {
        var val = $.trim($('#searchDishInput').val()),
            params = $('#searchDishInput').val();
        if (val.length > 0 || val !== ''){
            // 获取查询条件
            var params = JSON.stringify({
                tdName : params,
                tdDetail : params
            });
            $('#hidden-searchParams').val(params);
            // 执行查询
            showPagination(params);
        }else {
            // 无条件时查询全部数据
            var params = '{type:"all"}';
            showPagination(params);
        }
    });

    // 输入时按Enter健同样会触发按钮点击事件
    $('#searchDishInput').on('change', function () {
        $('#searchDishBtn').trigger('click');
    });

    ////////////////////////////////////////////////////
    // 点X关闭提示框并恢复初始状态（查询全部数据）
    $('.close').click(function () {
        $(this).parent().hide();
        var params = '{type:"all"}';
        showPagination(params);
    });

    //////////////////////////////////////////////////////
    // 用户注销超链接点击事件
    $('#logout').click(function () {
        // 注销处理
        logout();
    });

    //////////////////////////////////////////////////////
    // 禁止用户名超链接点击事件
    $('#user-label').click(function (e) {
        e.preventDefault();
    })
});

////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////
//         session验证         //
////////////////////////////////
function validUserSession() {
    // 向后台提交请求以触发过滤器
    $.ajax({
        async: false,
        url: 'validSession.do',
        type: 'POST',
        error: function () {
            $('#search-alert-error').show();
        },
        success: function (msg) {
            // 返回值处理
            var reg = new RegExp('"', 'g'),
                data = msg.replace(reg, '').split(':');
            // 判断返回值
            if (data[0] === 'loginOut'){
                // 验证失败，提示并跳转至登录页面
                alert('由于您尚未登录或登录信息已过期，请重新登录。');
                window.location.href = 'login.html';
            }
            else if (data[0] === 'session'){
                // 验证通过，将用户名展示在页面
                $('#user-label').text(data[1]);
            }
        }
    })
}

////////////////////////////////
// 请求后台获取数据库中的餐厅信息 //
////////////////////////////////
function getProviderList() {
    $.ajax({
        async: false,
        url: 'selectExhibitor.do',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json;charset=utf8',
        error: function () {
            $('#search-alert-error').show();
        },
        success: function (data) {
            if (data.length > 0){
                var obj = $.parseJSON(data);
                // 将获取到的餐厅信息显示到页面
                showProviderName(obj);
            }
        }
    })
}

////////////////////////////////
//        动态显示餐厅列表      //
////////////////////////////////
function showProviderName(providerList) {
    var htmlStr = '',
        tuId,
        teName;
    for (var i in providerList){
        tuId = providerList[i].tuId;
        teName = providerList[i].teName;
        // 生成html
        htmlStr += '<button type="button" class="list-group-item" '
            + 'id="' + tuId + '"' + '>' + teName + '</button>';
    }
    // 将生成的html插入对应元素中
    $('#providerList').append(htmlStr);
}

////////////////////////////////
// 请求后台获取数据库中的菜单数量 //
////////////////////////////////
function getDishCount(params) {
    var dataRows = 0;

    $.ajax({
        async: false,
        url: 'selectDishCount.do',
        type: 'POST',
        data: params,
        dataType: 'json',
        contentType: 'application/json;charset=utf8',
        error: function () {
            $('#search-alert-error').show();
        },
        success: function (data) {
            dataRows = data;
        }
    });

    return dataRows;
}

////////////////////////////////
// 请求后台获取数据库中的菜单信息 //
////////////////////////////////
function getDishList(params) {
    var htmlStr = '';

    $.ajax({
        async: false,
        url: 'selectAllDish.do',
        type: 'POST',
        data: params,
        dataType: 'json',
        contentType: 'application/json;charset=utf8',
        error: function () {
            $('#search-alert-error').show();
        },
        success: function (data) {
            var obj = $.parseJSON(data);
            // 将获取到的菜单信息显示到页面
            htmlStr = showDishList(obj);
        }
    });

    return htmlStr;
}

////////////////////////////////
//        动态显示菜单列表      //
////////////////////////////////
function showDishList(dishList) {
    var htmlStr = '',
        isValuable;

    for (var i in dishList) {
        isValuable = true;
        // 生成html代码
        htmlStr += '<div class="menu-list-item clearfix" id="' + dishList[i].tdId + '">\n' +
            '           <div class="col-xs-5">\n' +
            '               <img src="' + dishList[i].tdImg + '" alt="辣子鸡丁">\n' +
            '           </div>\n' +
            '           <div class="col-xs-7">\n' +
            '               <div class="title">' + dishList[i].tdName + '</div>\n' +
            '               <div class="info">\n' +
            '                   <span class="info-summary">' + dishList[i].tdDetail + '</span>\n' +
            '                   <span class="info-summary">¥ ' + dishList[i].tdPrice + '</span>\n' +
            '                   <span class="info-summary">' + dishList[i].teName + '</span>\n' +
            '               </div>\n' +
            '               <button type="button" class="btn btn-info btn-xs btn-block cart-btn">\n' +
            '                   添加至购物车\n' +
            '               </button>\n' +
            '           </div>\n' +
            '       </div>' +
            '       <hr>' +
            '       <split>';
    }

    if (!isValuable){
        return '';
    }else {
        return htmlStr;
    }
}

////////////////////////////////
//        菜单列表分页处理      //
////////////////////////////////
function showPagination(searchParams) {
    // 数据库中的菜单总数
    var dataRows = getDishCount(searchParams);
    // 如果存在数据则显示
    if (dataRows > 0){
        // 总页数
        var pageCount = Math.ceil(dataRows / 4);
        // 分页处理
        $('#pagination').twbsPagination('destroy');
        $('#pagination').twbsPagination({
            totalPages: pageCount,
            startPage: 1,
            visiblePages: 6,
            first: '首页',
            prev: '上一页',
            next: '下一页',
            last: '末页',
            onPageClick: function (event, page) {
                // 查询参数（other参数由后台处理）
                var params = JSON.stringify({
                    start: (page - 1) * 4,
                    rows: 4,
                    other: searchParams
                });
                // 生成的html代码
                var htmlStr = getDishList(params);
                // 清理无用数据
                $('#hidden-searchParams').val('');
                $('.search-alert').hide();
                $('#menu-list').empty();
                // 展示查询到的数据
                $('#menu-list').append(htmlStr);
            }
        });
    }
    else {
        // 如果没有数据则提示
        $('#pagination').twbsPagination('destroy');
        $('#menu-list').empty();
        $('.search-alert').hide();
        $('#search-alert-null').show();
    }
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
                $('#search-alert-error').show();
            }
        }).error(function () {
            $('#search-alert-error').show();
        });
    }
}