$(function() {
    // 首页 供应大厅 响应
    ;
    (function() {
        $('.nav .n-wrap .item:first-child').on('click', function() {
            window.location.href = '/index.html';
        });
        $('.nav .n-wrap .item:last-child').on('click', function() {
            window.proCookie.addCookie("type", String(3), '/');
            window.proCookie.addCookie('page', String(1), '/');
            window.location.href = '/supplyHall.html';
        });
    })();

    //中间 信息部分内容响应
    ;
    (function() {
        // 切换图片
        $('.content .left-info .pic-select ').on('click', '.option img', function() {
            let src = $(this).attr('src');
            $('.content .left-info .up-pic img').attr('src', src);
            $('.content .left-info .pic-select .option').css({
                'border': '2px solid transparent'
            });
            $(this).parent().css({
                'border': '2px solid #ff442f'
            });
            // 将上面刚刚加载的这几张图片大小设置为尽可能大的适应div
            {
                let aImages = $('.content .left-info .up-pic img');
                $('<img/>').attr('src', aImages.attr('src')).on('load', function() {
                    if (this.width >= this.height) {
                        aImages.css('height', '100%');
                        aImages.css('width', 'auto');
                    } else {
                        aImages.css('width', '100%');
                        aImages.css('height', 'auto');
                    }
                });
            }
        });
        // 更改数量
        let abtns = $('.content .right-info .amount button');
        abtns.eq(0).on('click', function() {
            let oValue = parseInt($(this).next().val());
            if (oValue - 1 < 1) {
                $(this).next().val(1);
            } else {
                $(this).next().val(oValue - 1);
            }
        });
        abtns.eq(1).on('click', function() {
            let oValue = parseInt($(this).prev().val());
            let stock = parseInt($('.content .stock-and-eval .stock span').text());
            if (oValue + 1 > stock) {
                $(this).prev().val(stock);
            } else {
                $(this).prev().val(oValue + 1);
            }
        });
        // 限制产品数量输出框只能输入 纯数字
        $('.content .right-info .amount input').on('input', function() {
            let reg = new RegExp(/^\d+$/);
            if (!reg.test($(this).val())) {
                $(this).val('');
            }
            let stock = parseInt($('.content .stock-and-eval .stock span').text());
            if (parseInt($(this).val()) > stock) {
                $(this).val(stock);
            }
        });
        // 点击按钮弹出商家联系电话
        $('.content .right-info .btns .phone').on('click', function() {
            let phoneID = $(this).prev().text();
            alert("商家的联系电话是:" + phoneID);
        });
        // 收藏按钮
        $('.content .right-info .btns .collect').on('click', function() {
            if ($('#up-nav .afterLogin').css('display') == 'none') {
                window.location.href = '/logIn.html';
                return;
            }
            let userName = $('#up-nav .afterLogin .userName').text();
            let productID = $('#pro-id').text();
            let data = {
                userName: userName,
                productID: productID
            }
            let url = window.serverIP + window.realUrl.collect_pro;
            window.sendAjax('post', url, data, function(aaa) {
                if (aaa.code == 200) {
                    alert("收藏成功!");
                } else {
                    alert(aaa.message + "  收藏失败");
                }
            });
        });

        // 立即采购按钮
        $('.content .right-info .btns .now-buy').on('click', function() {
            if ($('#up-nav .afterLogin').css('display') == 'none') {
                window.location.href = '/logIn.html';
                return;
            }
            let quantity = $('.content .right-info .amount input').val();
            let orderMoney = $('.content .right-info .stock-and-eval .stock span').text();
            window.proCookie.addCookie('quantity', quantity, '/');
            window.proCookie.addCookie('orderMoney', orderMoney, '/');
            window.location.href = '/makeSureBuy.html';
        });
    })();

    // 页面加载时要更新的页面信息
    ;
    (function() {
        let productID = window.proCookie.getCookie('productID');
        let url = window.serverIP + window.realUrl.sear_specific_pro;
        let data = {
            productID: productID
        };
        window.sendAjax('get', url, data, success);

        function success(aaa) {
            if (aaa.code == 200) {
                // 添加店铺名
                $('.head-logo .businessName .name').text(aaa.data.businessName);
                $('.buss-banner .bu-wr-wrap .bu-w-w-name').text(aaa.data.businessName);
                // 添加订单总数
                $('.head-logo .info .order .num').text(aaa.data.orderAmount);
                // 添加地址
                $('.buss-banner .location span').text(aaa.data.businessAddress);
                //添加标题
                $('.content .title-and-time .t-wrap .t-title').text(aaa.data.title);
                //添加更改日期
                // $('.content .title-and-time .time span').text(aaa.data.updateDate);
                $('.content .title-and-time .time span').text(' 2020年12月27日 10:42:17');
                //添加单价
                $('.content .right-info .money .m-num').text(aaa.data.unitPrice);
                // 添加库存
                $('.content .stock-and-eval .stock span').text(aaa.data.stock);
                // 添加累计评价
                $('.content .stock-and-eval .eval span').text(aaa.data.evalutionCount);
                // 添加发货地址
                $('.content .right-info .loca span').text(aaa.data.businessAddress);
                // 添加规格
                $('.content .specification .s-unit span').text(aaa.data.specification);
                // 添加商家电话
                $('.content .right-info .btns .phoneID').text(aaa.data.businessPhone);
                //更改图片的src
                let aImgSrc = aaa.data.imageArray;
                let oPicSelect = $('.content .left-info .pic-select');
                oPicSelect.html('');
                // <img src="${window.serverIP + '/farm/' + aImgSrc[i]}" alt="pro">
                // <img src="${aImgSrc[i]}" alt="pro"></img>
                for (var i = 0; i < aImgSrc.length; i++) {
                    let oOption = $(`
                        <div class="option">
                        <img src="${window.serverIP + '/farm1/' + aImgSrc[i]}" alt="pro">
                        </div>
                    `);
                    oPicSelect.append(oOption);
                }

                {
                    let oSrc = $('.content .left-info .pic-select .option img').eq(0).attr('src');
                    $('.content .left-info .up-pic img').attr('src', oSrc);
                }

                // 将上面刚刚加载的这几张图片大小设置为尽可能大的适应div
                {
                    let aImages = $('.content .left-info .pic-select img');
                    for (var i = 0; i < aImages.length; i++) {;
                        (function(i) {
                            $('<img/>').attr('src', aImages.eq(i).attr('src')).on('load', function() {
                                if (this.width >= this.height) {
                                    aImages.eq(i).css('height', '100%');
                                    aImages.eq(i).css('width', 'auto');
                                } else {
                                    aImages.eq(i).css('width', '100%');
                                    aImages.eq(i).css('height', 'auto');
                                }
                            });
                        })(i);
                    }
                }
            } else {
                alert(aaa.message);
            }
        }
    })();
});