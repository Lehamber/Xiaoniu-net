$(function() {

    //搜索框响应
    ;
    (function() {

        let oReplaceholder = $("#replaceholder");
        let oInput = $("#searchBox");
        if (oInput.val() != '') {
            oReplaceholder.css('display', 'none');
        }
        oInput.on('input', function() {
            var value = $(this).val();
            $(this).val($(this).val().replace(' ', ''));
            value = $(this).val();

            if (value != '') {
                oReplaceholder.css('display', 'none');
                realTimeSearch();
            } else {
                oReplaceholder.css('display', 'block');
            }
        });

        oInput.focus();
        oReplaceholder.on('click', function() {
            oInput.focus();
        });

        //  搜索框input实时响应查询
        var realTimeSearch = function() {
            var key = $('#searchBox').val();
            let data = {
                key: key
            };

            function success(aaa) {
                if (aaa.code == 200) {
                    $('#searResult').html('');
                    $('#searResult').css('display', 'block');
                    for (var i = 0; i < aaa.data.length; i++) {
                        var oDiv = $('<div></div>').text(aaa.data[i].productName);
                        $('#searResult').append(oDiv);
                    }
                    setClick(); // 给结果设置点击事件，并跳转到供应大厅页面
                } else {
                    alert(aaa.message);
                }
            }
            let url = window.serverIP + window.realUrl.real_time_search;
            window.sendAjax('get', url, data, success);
        };

        //记录实时搜索结果的关键字 和 搜索类型，并跳转到供应大厅页面
        let setClick = function() {
            $('#searResult').children().on('click', function() {
                // 查询二级分类对应的一级分类名
                let firstClassify;
                let key = $(this).text();
                let data = {
                    "key": key
                };
                let success = function(aaa) {
                    if (aaa.code == 200) {
                        //我在这里搜索的直接是 数据库里面的 数据，所以查询结果不可能为空
                        if (aaa.data != '') {
                            firstClassify = aaa.data.key;
                            // 增加cookie项
                            window.proCookie.addCookie('type', String(2), '/');
                            window.proCookie.addCookie('key', key, '/');
                            window.proCookie.addCookie('page', String(1), '/');
                            window.proCookie.addCookie('firstClassify', firstClassify, '/');
                            window.location.href = '/supplyHall.html';

                        } // 为了方便测试，我把不等于'' 的情况也写上吧
                        else {
                            window.proCookie.addCookie('type', String(0), '/');
                            window.location.href = '/supplyHall.html';
                        }
                    } else {
                        alert(aaa.message);
                    }
                };
                let url = window.serverIP + window.realUrl.sear_firstClassify;
                window.sendAjax('get', url, data, success);
            });
        }

        // 给搜索按钮设置事件  搜索关键的字的类型
        let btn = $('.mid-search .searchButton');
        btn.on('click', function() {
            if ($('#searchBox').val() != '') {
                let key = $('#searchBox').val();
                let type = 'get';
                let url = window.serverIP + window.realUrl.sear_key_type;
                let data = {
                    key: key
                };
                let success = function(aaa) {
                    if (aaa.code == 200) {
                        if (aaa.data.type == 0) {
                            // type=0 说明没有查到，直接跳转显示 未查到相关商品
                            window.proCookie.addCookie('type', String(0), '/');
                            window.location.href = '/supplyHall.html';
                            return; // 这里必须使用一个 return 来结束success函数，
                            // 不然即使执行跳转页面的操作后面的代码也会执行完的
                        }
                        if (aaa.data.type == 2) {
                            let url = window.serverIP + window.realUrl.sear_firstClassify;
                            let data = {
                                key: key
                            };
                            window.sendAjax('get', url, data, function(aaa) {
                                if (aaa.code == 200) {
                                    window.proCookie.addCookie('firstClassify', aaa.data.key, '/');

                                } else {
                                    alert(aaa.message);
                                }
                            });
                        }
                        if (aaa.data.type == 1) {
                            window.proCookie.addCookie('firstClassify', key, '/');
                        }
                        window.proCookie.addCookie('key', key, '/');
                        window.proCookie.addCookie("type", String(aaa.data.type), '/');
                        window.proCookie.addCookie('page', String(1), '/');
                        window.location.href = '/supplyHall.html';
                    } else {
                        alert(aaa.message);
                    }
                };
                window.sendAjax(type, url, data, success);
            }
        });

        // 这是enter 键触发 按钮提交事件
        $('body').keydown(function() {
            if (document.activeElement.id == 'searchBox' && event.keyCode == 13) {
                btn.click();
            }
        });

        // input失去焦点的时候 让 searResult 隐藏,
        $('#searchBox').on('blur', function() {
            var timeout = null;
            clearTimeout(timeout);
            timeout = setTimeout(function() {
                $('#searResult').css('display', 'none');
            }, 150);
        });
        // // 获取焦点让 searResult 显示
        $('#searchBox').on('focus', function() {
            $('#searResult').css('display', 'block');
            setClick();
        });

        // 点击供应大厅nav  addcookie
        $('.header .down-nav .right-div a').eq(1).on('click', function() {
            window.proCookie.addCookie('type', String(3), '/');
            window.proCookie.addCookie('page', String(1), '/');
            window.location.href = '/supplyHall.html';
        });
    })();

    //首页产品展示
    ;
    (function() {
        var type = 'post';
        var url = window.serverIP + window.realUrl.home_page_pro_show;
        var data = {
            "data": [{
                    "categoryName": '禽畜肉蛋'
                },
                {
                    "categoryName": '水果'
                },
                {
                    "categoryName": '蔬菜'
                },
                {
                    "categoryName": '粮油米面'
                },
                {
                    "categoryName": '农副加工'
                },
                {
                    "categoryName": '农资农机'
                }
            ]
        };
        var success = function(aaa) {
            if (aaa.code == 200) {
                var productID = 0;
                var productName = '';
                var imgSrc = '';
                var title = '';
                var unitPrice = 0;
                var stock = 0;
                for (var i = 0; i < aaa.data.length; i++) {
                    for (var j = 0; j < 10; j++) {
                        productID = aaa.data[i].productArray[j].productID;
                        productName = aaa.data[i].productArray[j].productName;
                        imgSrc = window.serverIP + "/farm1/" + aaa.data[i].productArray[j].image;
                        // imgSrc = "http://127.0.0.1:8001/js/tao.jpg";
                        // imgSrc = "http://127.0.0.1:8001/images/banner1.jpg";

                        title = aaa.data[i].productArray[j].title;
                        unitPrice = aaa.data[i].productArray[j].unitPrice;
                        stock = aaa.data[i].productArray[j].stock;

                        var x = i + 1;
                        var y = j + 1;
                        let oProductID = $('.mid .classification:nth-of-type(' + x + ') .rightDiv .wrap:nth-of-type(' + y + ') .product .productID');
                        let oProductName = $('.mid .classification:nth-of-type(' + x + ') .rightDiv .wrap:nth-of-type(' + y + ') .product .productName');
                        let oImg = $('.mid .classification:nth-of-type(' + x + ') .rightDiv .wrap:nth-of-type(' + y + ') .product .pro-img>img');
                        let oTitle = $('.mid .classification:nth-of-type(' + x + ') .rightDiv .wrap:nth-of-type(' + y + ') .product .shop-title>div:last-child');
                        let oUnitPrice = $('.mid .classification:nth-of-type(' + x + ') .rightDiv .wrap:nth-of-type(' + y + ') .product .shop-text .money span');
                        let oStock = $('.mid .classification:nth-of-type(' + x + ') .rightDiv .wrap:nth-of-type(' + y + ') .product .shop-text .quantity span');

                        oProductID.text(productID);
                        oProductName.text(productName);
                        oImg.attr('src', imgSrc);
                        oTitle.text(title);
                        oUnitPrice.text(unitPrice);
                        oStock.text(stock);
                    }
                }

                // 设置所有的商品图片，让图片尽可能大的自适应父级盒子的大小；
                let aImg = $('.mid .classification .pro-img img');
                for (var i = 0; i < aImg.length; i++) {

                    // 循环里面设置事件，i会变的无效，注意一下；
                    // 遇到问题不要慌，认真去想，打断点调试是最快的方法；
                    ;
                    (function(i) {
                        $('<img/>').attr('src', aImg.eq(i).attr('src')).on('load', function() {
                            console.log('img');
                            if (this.width >= this.height) {
                                aImg.eq(i).css('height', '100%');
                                aImg.eq(i).css('width', 'auto');
                            } else {
                                aImg.eq(i).css('width', '100%');
                                aImg.eq(i).css('height', 'auto');
                            }
                        });
                    })(i);
                }
            } else {
                alert('服务器端处理错误');
            }
        };
        window.sendAjax(type, url, JSON.stringify(data), success);


    })();
    //轮播bannertu
    ;
    (function() {
        let oP_imgs = $('.banner .p_imgs');
        let oLeftTab = $('.banner .leftTab');
        let oRightTab = $('.banner .rightTab');
        let oBottomTab = $('.banner .bottomTab');

        // 鼠标悬停  左右 tab 颜色加深, 停止定时器
        // 虽然当鼠标移上左右tab和bottom tab时，mouseout会触发。
        // 但是mouseover事件会进行冒泡传递，最终 下面的元素设置的mouseover又会被触发。
        // 不影响最终的效果；
        oP_imgs.parent().on('mouseover', function() {
            // 这两种方法都是可以的
            // $('.banner .l-rTab>div').toggleClass('change');
            $('.banner .l-rTab>div').addClass('change');
            clearInterval(timeInter);
        });
        oP_imgs.parent().on('mouseout', function() {
            // $('.banner .l-rTab>div').toggleClass('change');
            $('.banner .l-rTab>div').removeClass('change');
            timeInter = setInterval(timeTnterFun, 4000);
        });


        let imgLength = oP_imgs.children().length;
        let index = oP_imgs.parent().css('width').indexOf('p');
        let imgWidth = oP_imgs.parent().css('width').slice(0, index);

        // 初始化banner图起始位置
        let count = imgLength / 2;
        oP_imgs.css({
            "left": String(-count * imgWidth) + 'px'
        });
        // 初始化下面tab的位置
        oBottomTab.children().removeClass('color');
        oBottomTab.children().eq(0).addClass('color');

        // 给左右tab设置响应事件
        oRightTab.on('click', rigTabResponse);
        oLeftTab.on('click', lefTabResponse);

        function rigTabResponse() {
            oRightTab.off('click');
            oBottomTab.children().off('mouseenter');
            count++;
            // 更新下面的tab
            oBottomTab.children().removeClass('color');
            oBottomTab.children().eq(count % (imgLength / 2)).addClass('color');
            oP_imgs.animate({
                "left": String(-count * imgWidth) + 'px'
            }, 200, function() {
                if (count == 7) {
                    count = imgLength / 2 - 1;
                    $(this).css({
                        "left": String(-count * imgWidth) + 'px'
                    });
                }
                oRightTab.on('click', rigTabResponse);
                oBottomTab.children().on('mouseenter', bottomTabResponse);

            });
        };

        function lefTabResponse() {
            oLeftTab.off('click');
            oBottomTab.children().off('mouseenter');
            count--;
            // 更新下面的tab
            oBottomTab.children().removeClass('color');
            oBottomTab.children().eq(count % (imgLength / 2)).addClass('color');
            oP_imgs.animate({
                "left": String(-count * imgWidth) + 'px'
            }, 200, function() {
                if (count == 0) {
                    count = imgLength / 2;
                    $(this).css({
                        "left": String(-count * imgWidth) + 'px'
                    });
                }
                oLeftTab.on('click', lefTabResponse);
                oBottomTab.children().on('mouseenter', bottomTabResponse);
            });
        };

        // 给下面的tab设置响应事件
        oBottomTab.children().on('mouseenter', bottomTabResponse);

        function bottomTabResponse() {
            // 移除mouseenter事件
            oBottomTab.children().off('mouseenter');
            oBottomTab.children().removeClass('color');
            $(this).addClass('color');
            count = parseInt(count / (imgLength / 2)) * (imgLength / 2) + $(this).index();
            oP_imgs.animate({
                "left": String(-count * imgWidth) + 'px'
            }, 200, function() {
                if (count == 0) {
                    count = imgLength / 2;
                    $(this).css({
                        "left": String(-count * imgWidth) + 'px'
                    });
                }
                if (count == 7) {
                    count = imgLength / 2 - 1;
                    $(this).css({
                        "left": String(-count * imgWidth) + 'px'
                    });

                }
                oBottomTab.children().on('mouseenter', bottomTabResponse);
            });
        }

        // 设置定时器，自动播放banner图
        let timeInter = null;
        clearInterval(timeInter);
        timeInter = setInterval(timeTnterFun, 4000);

        function timeTnterFun() {
            // 触发 右tab事件，两种方法均可以
            // oRightTab.click();
            oRightTab.trigger('click');
        };
    })();

    // banner左边导航栏
    ;
    (function() {
        var aLi = $(".header .banner .left-nav>ul>li");
        let oProWin = $('.header .proSelectWin');
        var liIndex;

        aLi.on('mouseover', function() {
            oProWin.html(''); //清空所有元素内容
            liIndex = aLi.index(this);
            // oProWin.mouseenter();
            let aProducts = window.classify.data[aLi.index(this)].data;
            for (var i = 0; i < aProducts.length; i++) {
                var oProWrap = $('<div class="pro-wrap"></div>');
                oProWrap.append($(`<div class="sm-class">${aProducts[i].name}</div>`));
                var oProItem = $('<div class="pro-item"></div>');
                // 为oProItem填入内容
                for (var j = 0; j < aProducts[i].data.length; j++) {
                    oProItem.append($(`<div class="items">${aProducts[i].data[j]}</div>`));
                }
                oProWrap.append(oProItem);
                // 把proWrap 填入ProWin里面
                oProWin.append(oProWrap);
            }
        });
        //设置 li的hover 和非 hover的状态 
        aLi.hover(function() {
            oProWin.css('display', 'block');
            $(this).css({
                'background-color': '#39bf3e'
            });
            $(this).find('a').css({
                'color': '#fff',
                'font-weight': 'bold'
            });
            $(this).find('.up>i').css({
                'color': '#fff'
            });
            $(this).find(' span').css({
                'color': '#fff'
            });
        }, function() {
            oProWin.css('display', 'none');
            $(this).css({
                'background-color': '#fff'
            });
            $(this).find('a').css({
                'color': '#3c3c3c',
                'font-weight': ''
            });
            $(this).find('.up>i').css({
                'color': '#686868'
            });
            $(this).find(' span').css({
                'color': '#646464'
            });
        });
        oProWin.hover(function() {
            aLi.eq(liIndex).trigger('mouseenter');
        }, function() {
            aLi.eq(liIndex).trigger('mouseleave');
        });
    })();

    // 点击 添加cookies
    ;
    (function() {
        // banner左边的nav部分
        var aA = $('.header .banner .left-nav');
        aA.on('click', 'li a', function() {
            console.log('aaa');
            window.proCookie.addCookie('type', String(1), '/');
            window.proCookie.addCookie('key', $(this).text(), '/');
            window.proCookie.addCookie('page', String(1), '/');
            window.proCookie.addCookie('firstClassify', $(this).text(), '/');
            window.location.href = '/supplyHall.html';
        });


        var aItems = $('.header .proSelectWin');
        aItems.on('click', '.pro-wrap .items', function() { // 动态绑定事件
            console.log('bbb');
            let url = window.serverIP + window.realUrl.sear_firstClassify;
            let key = $(this).text();
            let data = {
                key: key
            }
            window.sendAjax('get', url, data, function(aaa) {
                if (aaa.code == 200) {
                    console.log(aaa.data);
                    if (aaa.data != '') {
                        window.proCookie.addCookie('firstClassify', aaa.data.key, '/');
                    } else { // 如果返回为空，那么直接 type = 0,跳转到到产品大厅
                        window.proCookie.addCookie('type', String(0), '/');
                        window.location.href = '/supplyHall.html';
                        return;
                    }
                    window.proCookie.addCookie('type', String(2), '/');
                    window.proCookie.addCookie('page', String(1), '/');
                    window.proCookie.addCookie('key', key, '/');
                    window.location.href = '/supplyHall.html';
                } else {
                    alert(aaa.message);
                }
            });
        });

        // banner图部分， 点击banner图 type = 3 跳转页面
        $('.header .banner .pic .p_imgs img').on('click', function() {
            window.proCookie.addCookie('type', String(3), '/');
            window.proCookie.addCookie('page', String(1), '/');
            window.location.href = '/supplyHall.html';
        });

        // 给banner图下面的 f4 添加cookie
        let aF4 = $('.header .banner .f4 img');
        aF4.on('click', function() {
            window.proCookie.addCookie('type', String(3), '/');
            window.proCookie.addCookie('page', String(1), '/');
            window.location.href = '/supplyHall.html';
        });

        // 给六个热门推荐添加 cookie
        let aLookMore = $('.mid .classification .look-more');
        aLookMore.on('click', function() {
            let key = $(this).prev().prev().text();
            window.proCookie.addCookie('firstClassify', key, '/');
            window.proCookie.addCookie('key', key, '/');
            window.proCookie.addCookie('type', String(1), '/');
            window.proCookie.addCookie('page', String(1), '/');
            window.location.href = '/supplyHall.html';
        });

        // 点击展示的商品
        $('.mid .classification').on('click', '.rightDiv .wrap .product', function() {
            window.proCookie.addCookie('productID', $(this).find('.productID').text());
            window.location.href = "./productDetail.html";
        });

    })();


});