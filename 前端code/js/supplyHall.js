 $(function() {

     // 每次页面刷新要处理的事情
     ;
     (function() {
         let type = window.proCookie.getCookie('type');
         let page = window.proCookie.getCookie('page');
         let key = window.proCookie.getCookie('key');
         let firstClassify = window.proCookie.getCookie('firstClassify');
         if (parseInt(type) == 0) {
             $('.content .pro-show').html('');
             $('.content .searchEmpty').css('display', 'block');
             $('.content .pro-select-win').html('');
             $('.content .selectPage').css('display', 'none');
         }
         if (parseInt(type) == 1) {
             makeFirstClassDivToGreen();

             // 显示下面所有的商品 和 协调下面的  换页功能
             showAllPro_and_matchPage();
         }
         if (parseInt(type) == 2) {
             makeFirstClassDivToGreen();
             let aItems = $('.content .pro-wrap .items');
             for (var i = 0; i < aItems.length; i++) {
                 if (aItems.eq(i).text() == key) {
                     aItems.eq(i).css('color', '#39bf3e');
                     aItems.eq(i).parent().prev().css('color', '#39bf3e');
                 }
             }

             // 显示下面所有的商品 和 协调下面的  换页功能
             showAllPro_and_matchPage();
         }
         if (parseInt(type) == 3) {
             $('.content .pro-classify .item').eq(0).css({
                 "background-color": "#39bf3e",
                 "color": "#fff"
             });

             // 显示下面所有的商品 和 协调下面的  换页功能
             showAllPro_and_matchPage();
         }

         // 让对应的一级分类块的 变为绿色
         function makeFirstClassDivToGreen() {
             let aItem = $('.content .pro-classify .item');
             let keyIndex;
             for (var i = 0; i < aItem.length; i++) {
                 if (aItem.eq(i).text() == firstClassify) {
                     keyIndex = aItem.index(aItem.eq(i));
                     aItem.eq(i).css({
                         "background-color": "#39bf3e",
                         "color": "#fff"
                     });
                 }
             }
             let proData = window.classify.data[keyIndex - 1];
             $('.content .pro-select-win').html('');
             for (var i = 0; i < proData.data.length; i++) {
                 let oProWrap = $('<div class="pro-wrap"></div>');
                 let oSmClass = $(`<div class="sm-class">${proData.data[i].name}</div>`);
                 oProWrap.append(oSmClass);
                 let oProItem = $('<div class="pro-item"></div>');
                 for (var j = 0; j < proData.data[i].data.length; j++) {
                     oProItem.append($(`<div class="items">${proData.data[i].data[j]}</div>`))
                 }
                 oProWrap.append(oProItem);
                 $('.content .pro-select-win').append(oProWrap);
             }
             // return keyIndex;
         };

         // 加载显示所有查询到的商品，设置页码
         function showAllPro_and_matchPage() {

             let url = window.serverIP + window.realUrl.sear_key;
             let data = {
                 type: type,
                 key: key || '',
                 page: page || 1
             };
             //  console.log(data);
             let success = function(aaa) {
                 if (aaa.code == 200) {
                     // 如果未查到此商品
                     if (aaa.data == '') {
                         $('.content .pro-show').html('');
                         $('.content .searchEmpty').css('display', 'block');
                         $('.content .pro-select-win').html('');
                         $('.content .selectPage').css('display', 'none');
                         return;
                     }
                     // 加载显示所有查询到的商品
                     $('.content .pro-show').html('');
                     for (var i = 0; i < aaa.data.product.length; i++) {
                         // <img src="${window.serverIP +"/farm1/"+ aaa.data.product[i].image}" alt="">
                         //  <img src="http://127.0.0.1:8001/js/tao.jpg" alt=""></img>
                         let oPro = $(`
                        <div class="product">
                            <div class="productID">${aaa.data.product[i].productID}</div>
                            <div class="productName">${aaa.data.product[i].productName}</div>
                            <div class="pic-wrap">        
                            <img src="${window.serverIP +"/farm1/"+ aaa.data.product[i].image}" alt="pro-pic">
                            </div>
                            <div class="shop-text">
                                <div class="money">
                                    ￥<span>${aaa.data.product[i].unitPrice}</span>
                                </div>
                                <div class="quantity">
                                    库存<span>${aaa.data.product[i].stock}</span>
                                </div>
                            </div>
                            <div class="shop-title">
                                <div>优选</div>
                                <div>${aaa.data.product[i].title}</div>
                            </div>
                        </div>`);
                         $('.content .pro-show').append(oPro);
                     };
                     (function() {
                         // 如果我只是加载20个商品的话 其实也没有必这么做，直接在css里面写 就可以了
                         var oProShow = $('.content .pro-show .product');
                         for (var i = 0; i < oProShow.length; i++) {
                             if (i % 5 == 0) {
                                 oProShow.eq(i).css('margin-left', '0px');
                             }
                         }
                     })();;
                     (function() {
                         // 设置图片尽可能大的居中填充 div，
                         var aImg = $('.content .pro-show .pic-wrap img');
                         //  console.log(aImg.eq(0));
                         for (var i = 0; i < aImg.length; i++) {;
                             (function(index) {
                                 $('<img/>').attr('src', aImg.eq(index).attr('src')).on('load', function() {
                                     // 这里设置的style 全部是 element.style 根据优先级，它会让classstyle失效；
                                     console.log('img');
                                     if (this.width >= this.height) {
                                         aImg.eq(index).css('height', '100%');
                                         aImg.eq(index).css('width', 'auto');
                                     } else {
                                         aImg.eq(index).css('width', '100%');
                                         aImg.eq(index).css('height', 'auto');
                                     }
                                 });
                             })(i);
                         }
                     })();
                     // 设置页码
                     let pageAmount = parseInt(parseInt(aaa.data.sum) / 20) + 1;
                     //  console.log(aaa.data.sum);
                     $('.content .selectPage .page-num span').text(aaa.data.sum);
                     $('.content .selectPage .to-which-page input').val(page);
                     if (pageAmount > 7) {
                         let condition1 = parseInt(page) - 1;
                         let condition2 = pageAmount - parseInt(page);
                         if (condition1 > 3 && condition2 <= 3) {
                             $('.content .selectPage .select-div').html('');
                             $('.content .selectPage .select-div').append($(`
                                <div class="left-next page-div">
                                    <span class="iconfont">&#xe644;</span>
                                </div>
                                <div class="page-div">1</div>
                                <div class="more-page left-page">
                                    <span class="iconfont">&#xe637;</span>
                                </div>
                                <div class="page-div">${pageAmount-5}</div>
                                <div class="page-div">${pageAmount-4}</div>
                                <div class="page-div">${pageAmount-3}</div>
                                <div class="page-div">${pageAmount-2}</div>
                                <div class="page-div">${pageAmount-1}</div>
                                <div class="page-div">${pageAmount}</div>
                                <div class="right-next page-div">
                                    <span class="iconfont">&#xe629;</span>
                                </div>
                            `));

                         } else if (condition1 <= 3 && condition2 > 3) {
                             $('.content .selectPage .select-div').html('');
                             $('.content .selectPage .select-div').append($(`
                                <div class="left-next page-div">
                                    <span class="iconfont">&#xe644;</span>
                                </div>
                                <div class="page-div">1</div>
                                <div class="page-div">2</div>
                                <div class="page-div">3</div>
                                <div class="page-div">4</div>
                                <div class="page-div">5</div>
                                <div class="page-div">6</div>
                                <div class="more-page right-page">
                                    <span class="iconfont">&#xe637;</span>
                                </div>
                                <div class="page-div">${pageAmount}</div>
                                <div class="right-next page-div">
                                    <span class="iconfont">&#xe629;</span>
                                </div>
                            `));
                         } else {
                             $('.content .selectPage .select-div').html('');
                             $('.content .selectPage .select-div').append($(`
                               <div class="left-next page-div">
                                   <span class="iconfont">&#xe644;</span>
                               </div>
                               <div class="page-div">1</div>
                               <div class="more-page left-page">
                                    <span class="iconfont">&#xe637;</span>
                               </div>
                               <div class="page-div">${parseInt(page)-2}</div>
                               <div class="page-div">${parseInt(page)-1}</div>
                               <div class="page-div">${parseInt(page)}</div>
                               <div class="page-div">${parseInt(page)+1}</div>
                               <div class="page-div">${parseInt(page)+2}</div>
                               <div class="more-page right-page">
                                   <span class="iconfont">&#xe637;</span>
                               </div>
                               <div class="page-div">${pageAmount}</div>
                               <div class="right-next page-div">
                                   <span class="iconfont">&#xe629;</span>
                               </div>
                           `));
                         }

                     } else {
                         let oSelectDiv = $('.content .selectPage .select-div');
                         oSelectDiv.html('');
                         oSelectDiv.append($(`
                            <div class="left-next page-div">
                                <span class="iconfont">&#xe644;</span>
                            </div>
                            `));
                         for (var i = 1; i <= pageAmount; i++) {
                             oSelectDiv.append(`<div class="page-div">${i}</div>`);
                         }
                         oSelectDiv.append($(`
                            <div class="right-next page-div">
                                <span class="iconfont">&#xe629;</span>
                            </div>
                        `));
                     }
                     // 让对应的色块被选中（变绿）
                     let aPageDiv = $('.content .selectPage .select-div .page-div');
                     for (var i = 0; i < aPageDiv.length; i++) {
                         if (aPageDiv.eq(i).text() == page) {
                             aPageDiv.eq(i).css({
                                 "color": "#fff",
                                 "background-color": "#39bf3e"
                             });
                         }
                     }

                 } else {
                     alert(aaa.message);
                 }
             }
             window.sendAjax('get', url, data, success);
         }
     })();

     // 给页面中所有所有 需要需要 使用cookie交互的元素 设置响应
     ;
     (function() {
         // 一级分类块部分 
         $('.content .pro-classify').on('click', '.item', function() {
             if ($('.content .pro-classify .item').index(this) != 0) {
                 window.proCookie.addCookie('type', String(1), '/');
                 window.proCookie.addCookie('key', $(this).text(), '/');
                 window.proCookie.addCookie('page', String(1), '/');
                 window.proCookie.addCookie('firstClassify', $(this).text(), '/');
                 window.location.href = '/supplyHall.html';
             } else {
                 window.proCookie.addCookie('type', String(3), '/');
                 window.proCookie.addCookie('page', String(1), '/');
                 window.location.href = '/supplyHall.html';
             }
         });
         // 二级分类部分
         $('.content .pro-select-win').on('click', '.items', function() {
             let key = $(this).text();
             let data = {
                 key: key
             }
             let url = window.serverIP + window.realUrl.sear_firstClassify;
             window.sendAjax('get', url, data, function(aaa) {
                 if (aaa.code == 200) {
                     if (aaa.data != '') {
                         window.proCookie.addCookie('type', String(2), '/');
                         window.proCookie.addCookie('key', key, '/');
                         window.proCookie.addCookie('page', String(1), '/');
                         window.proCookie.addCookie('firstClassify', aaa.data.key, '/');
                         window.location.href = '/supplyHall.html';
                     } else {
                         window.proCookie.addCookie('type', String(0), '/');
                         window.location.href = '/supplyHall.html';
                     }
                 } else {
                     alert(aaa.message);
                 }
             })
         });
         // 页面部分
         // 左一页
         $('.content .selectPage .select-div').on('click', '.left-next', function() {
             let page = parseInt(window.proCookie.getCookie('page'));
             if (page - 1 <= 1) {
                 page = 1;
             } else {
                 page = page - 1;
             }
             window.proCookie.addCookie('page', page, '/');
             window.location.href = '/supplyHall.html';
         });
         //  右一页
         $('.content .selectPage .select-div').on('click', '.right-next', function() {
             let page = parseInt(window.proCookie.getCookie('page'));
             let maxPage = parseInt($('.content .selectPage .page-num span').text() / 20) + 1;
             if (page + 1 >= maxPage) {
                 page = maxPage;
             } else {
                 page = page + 1;
             }
             window.proCookie.addCookie('page', page, '/');
             window.location.href = '/supplyHall.html';
         });
         // 左省略号
         $('.content .selectPage .select-div').on('click', '.left-page', function() {
             let page = parseInt(window.proCookie.getCookie('page'));
             if (page - 6 <= 1) {
                 page = 1;
             } else {
                 page = page - 6;
             }
             window.proCookie.addCookie('page', page, '/');
             window.location.href = '/supplyHall.html';
         });
         //  右省略号
         $('.content .selectPage .select-div').on('click', '.right-page', function() {
             let page = parseInt(window.proCookie.getCookie('page'));
             let maxPage = parseInt($('.content .selectPage .page-num span').text() / 20) + 1;
             if (page + 6 >= maxPage) {
                 page = maxPage;
             } else {
                 page = page + 6;
             }
             window.proCookie.addCookie('page', page, '/');
             window.location.href = '/supplyHall.html';
         });
         //  所有的页块
         $('.content .selectPage .select-div').on('click', '.page-div', function() {
             let reg = new RegExp(/^\d+$/);
             let page;
             if (reg.test($(this).text())) {
                 page = $(this).text();
                 window.proCookie.addCookie('page', page, '/');
                 window.location.href = '/supplyHall.html';
             }
         });
         // 指定跳转页
         let oBtn = $('.content .selectPage .to-which-page button');
         oBtn.on('click', function() {
             let page = $(this).prev().val();
             let maxPage = parseInt($('.content .selectPage .page-num span').text() / 20) + 1;
             if (parseInt(page) < 1) {
                 page = 1;
             }
             if (parseInt(page) > maxPage) {
                 page = maxPage;
             }
             window.proCookie.addCookie('page', page, '/');
             window.location.href = '/supplyHall.html';
         });
         //  限制input只能输入 数字
         let oInput = $('.content .selectPage .to-which-page input');
         oInput.on('input', function() {
             if (!/^\d+$/.test($(this).val())) {
                 $(this).val('');
             }
         });

         // 这是enter 键触发 按钮提交事件
         $('body').keydown(function() {
             //  console.log(13);
             //  如果目前触发的焦点的input 的id 是toPage 且 按下的 enter键
             if (document.activeElement.id == 'toPage' && event.keyCode == 13) {
                 oBtn.click();
             }
         });

         // 点击具体的商品 跳转到商品 详情页
         $('.content .pro-show').on('click', '.product', function() {
             window.proCookie.addCookie('productID', $(this).find('.productID').text());
             window.location.href = "./productDetail.html";
         });

     })();
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
                     "key": key
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
                             window.sendAjax('get', url, key, function(aaa) {
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
         $('.header .down-nav .wrap a').eq(1).on('click', function() {
             window.proCookie.addCookie('type', String(3), '/');
             window.proCookie.addCookie('page', String(1), '/');
             window.location.href = '/supplyHall.html';
         });
     })();

     // 设置所有的产品图片 尽可能大的填充 div
     ;
     (function() {

     })();

 });