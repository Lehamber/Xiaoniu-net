<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>智农慧通-用户注册</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


    <!-- <link rel="stylesheet" href="css/signIn.css">
    <script src="./js/signIn.js"></script> -->
</head>

<body>
    <div id="up-nav">
        <div class="container over-clear">
            <div class="fleft left-div">
                <span class="tag">欢迎来到智农慧通</span>
                <div class="beforeLogin">
                    <span class="iconfont icon">&#xe651;</span>
                    <span class="login"><a href="./logIn.html">注册登录</a></span>
                </div>
                <div class="afterLogin">
                    <span class="iconfont icon">&#xe651;</span>
                    <span class="userName">简小橘</span>
                    <span class="exit">退出</span>
                </div>

            </div>
            <div class="fright right-div">
                <span class="new-store"><a href="#">我要入驻开店</a></span>
                <span class="iconfont tag">&#xe63b;</span>
                <span class="person-Center"><a href="#">个人中心</a></span>
                <span class="iconfont tag">&#xe63b;</span>
                <span class="backstore"><a href="#">供应商后台</a></span>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="banner"></div>
        <div class="title-line">
            <span class="tit">注册</span>
        </div>
        <div class="register-container">
            <form target="the-iframe">
                <div class="form-group">
                    <label for="userName" class="sr-only">username</label>
                    <input type="text" id="userName" class="form-control" placeholder="用户名">
                    <p class="formatInfo">用户名格式不合法。用户名由字母、数字、汉字、-和_组成。不能少于2个字符 且 必须包含字母或汉字</p>
                    <p class="repeatInfo">该用户名以被使用</p>
                    <p class="inviteInfo">请输入用户名</p>
                </div>
                <div class="form-group">
                    <label for="email" class="sr-only">email</label>
                    <input type="text" id="email" class="form-control" placeholder="邮箱">
                    <p class="formatInfo">邮箱格式不合法</p>
                    <p class="repeatInfo">该邮箱已被注册</p>
                    <p class="inviteInfo">请输入邮箱地址</p>
                </div>
                <div class="form-group">
                    <label for="userPhone" class="sr-only">userPhone</label>
                    <input type="text" id="userPhone" class="form-control" placeholder="手机号">
                    <p class="formatInfo">手机号格式不合法</p>
                    <p class="repeatInfo">该手机号已被注册</p>
                    <p class="inviteInfo">请输入邮箱地址</p>
                </div>
                <div id="safe_window">
                    <p>安全系数</p>
                    <div class="a_pw">
                        <div class="safe_line"></div>
                        <div class="safe_line"></div>
                        <div class="safe_line"></div>
                        <div class="safe_line"></div>
                        <div class="safe_line"></div>
                        <span style="display: none;">弱</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">password</label>
                    <input type="password" id="password" class="form-control" placeholder="密码（6-16个字符组成，区分大小写）">
                    <p class="formatInfo">密码由6-20个字符组成，且不能包含除!@#$%^&*_+-=?之外的其它特殊字符</p>
                    <p class="inviteInfo">请输入密码</p>
                </div>
                <div class="checkbox">
                    <label class="checkLabel">
                        <input type="checkbox" value="123" id="checkbox">
                        <span>我已同意</span>
                        <a href="#">《智农慧通用户使用协议》</a>
                        <span>和</span>
                        <a href="#">《智农慧通隐私政策》</a>
                    </label>
                </div>
                <input type="button" class="btn btn-success" id="btnInput" value="注册" disabled>
                <div></div>
            </form>
            <iframe id="is_iframe" name="the-iframe" style="display: none;"></iframe>
        </div>
    </div>
    <div id="footer">
        <div><span>豫ICP备13007354号-1 | 服务热线：400-009-8699</span></div>
        <div><span>互联网药品信息服务资格证书:(湘)-经营性-2020-0005 河南智农慧通科技有限公司
            营业执照号</span></div>
        <div><span>增值电信业务经营许可证：经营许可证编号：豫B2-20130072</span></div>
        <div><span>©-2020 Cnhnb B2B SYSTEM All Rights Reserved</span></div>
        <div><img src="./images/footer.png" alt="行业认证"></div>
    </div>
    <script>
        $(function() {

            // 用来判断各输入框的状态，0表示空，1表示有输入但格式不对，2代表有输入格式也对了
            let status = {
                userName: 0,
                email: 0,
                userPhone: 0,
                password: 0
            };
            // 限制输入空格
            $('#userName').on('input', function() {
                // var value = $(this).val();
                $(this).val($(this).val().replace(' ', ''));
            });
            $('#email').on('input', function() {
                $(this).val($(this).val().replace(' ', ''));
            });
            $('#userPhone').on('input', function() {
                $(this).val($(this).val().replace(' ', ''));
            });
            // 
            $('#userName').on('change', function() {
                var value = $(this).val();
                var reg = new RegExp(/^(?=.*([a-zA-z]|[\u4E00-\u9FA5\uf900-\ufa2d]))[\w-\u4E00-\u9FA5\uf900-\ufa2d]{2,15}$/);
                var aNextAll = $(this).nextAll();
                aNextAll.css('display', 'none');
                if (reg.test(value)) {
                    aNextAll.eq(0).css('display', 'none');
                    status.userName = 2;
                } else {
                    aNextAll.eq(0).css('display', 'block');
                    status.userName = 1;
                    if ($(this).val() == '') {
                        aNextAll.eq(0).css('display', 'none');
                        status.userName = 0;
                    }
                }
            });
            $('#email').on('change', function() {
                var value = $(this).val();
                var reg = new RegExp(/^[\w-\.]+@[\w-\.]+(\.[a-zA-Z0-9]+)+$/);
                var aNextAll = $(this).nextAll();
                aNextAll.css('display', 'none');
                if (reg.test(value)) {
                    aNextAll.eq(0).css('display', 'none');
                    status.email = 2;
                } else {
                    aNextAll.eq(0).css('display', 'block');
                    status.email = 1;
                    if ($(this).val() == '') {
                        aNextAll.eq(0).css('display', 'none');
                        status.email = 0;
                    }
                }
            });

            //为每个四个input框设置 change事件，检查格式，给出提示信息
            $('#userPhone').on('change', function() {
                var value = $(this).val();
                var reg = new RegExp(/^[0-9]{11}$/);
                var aNextAll = $(this).nextAll();
                aNextAll.css('display', 'none');
                if (reg.test(value)) {
                    aNextAll.eq(0).css('display', 'none');
                    status.userPhone = 2;
                } else {
                    aNextAll.eq(0).css('display', 'block');
                    status.userPhone = 1;
                    if ($(this).val() == '') {
                        aNextAll.eq(0).css('display', 'none');
                        status.userPhone = 0;
                    }
                }
            });

            $('#password').on('input', function() {
                var value = $(this).val();
                $(this).val(value.replace(/\s/g, ''));
                value = $(this).val();

                var reg = new RegExp(/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+-=?])[\S]{6,20}$/);
                var aNextAll = $(this).nextAll();
                var security = 0; //安全系数
                aNextAll.css('display', 'none');
                if (/^[0-9a-zA-Z!@#$%^&*_+-=?]{6,20}$/.test(value)) {
                    aNextAll.eq(0).css('display', 'none');
                    status.password = 2;
                    if (value.match(/[0-9]/) != null) {
                        security++;
                    }
                    if (value.match(/[a-z]/) != null) {
                        security++;
                    }
                    if (value.match(/[A-Z]/) != null) {
                        security++;
                    }
                    if (value.match(/[@$!%*#?&]/) != null) {
                        security++;
                    }
                } else {
                    aNextAll.eq(0).css('display', 'block');
                    status.password = 1;
                    if (value == '') {
                        aNextAll.eq(0).css('display', 'none');
                        status.password = 0;
                    }
                }

                // 实时显示安全系数
                var aSafe_line = $('#safe_window .safe_line');
                var oSafe_word = $('#safe_window>div>span').eq(0);

                if (security == 0) {
                    aSafe_line.css('background-color', 'transparent');
                    oSafe_word.css('display', 'none');
                }
                if (security == 1) {
                    aSafe_line.css('background-color', 'transparent');
                    aSafe_line.eq(0).css('background-color', 'red');
                    oSafe_word.css('display', 'block');
                    oSafe_word.css('color', 'red');
                    oSafe_word.text('弱');
                }
                if (security == 2) {
                    aSafe_line.css('background-color', 'transparent');
                    aSafe_line.eq(0).css('background-color', 'red');
                    aSafe_line.eq(1).css('background-color', '#ff7f00');

                    oSafe_word.css('display', 'block');
                    oSafe_word.css('color', '#ff7f00');
                    oSafe_word.text('中');
                }
                if (security == 3) {
                    aSafe_line.css('background-color', 'transparent');
                    aSafe_line.eq(0).css('background-color', 'red');
                    aSafe_line.eq(1).css('background-color', '#ff7f00');
                    aSafe_line.eq(2).css('background-color', '#f0f028');

                    oSafe_word.css('display', 'block');
                    oSafe_word.css('color', '#f0f028');
                    oSafe_word.text('中');
                }
                if (security == 4) {
                    aSafe_line.css('background-color', 'transparent');
                    aSafe_line.eq(0).css('background-color', 'red');
                    aSafe_line.eq(1).css('background-color', '#ff7f00');
                    aSafe_line.eq(2).css('background-color', '#f0f028');
                    aSafe_line.eq(3).css('background-color', '#39bf3e');

                    oSafe_word.css('display', 'block');
                    oSafe_word.css('color', '#39bf3e');
                    oSafe_word.text('强');
                }
            });

            //将checkedbox 的状态 和 按钮的状态进行绑定
            var oCheckbox = document.getElementById('checkbox');
            $('#checkbox').on('click', function() {
                if ($(this).prop('checked')) {
                    $('#btnInput').attr('disabled', false);
                } else {
                    $('#btnInput').attr('disabled', true);
                }
            });
            // 如果填了数据，且格式正确 走你
            // 如果为空 就让其他的 p都隐藏，把请输入p给调出来
            $('#btnInput').on('click', function() {

                // 判断status是否都为2（是否都填写了数据且格式都正确）
                let isGo = false;
                for (var x in status) {
                    if (status[x] == 2) {
                        isGo = true;
                    } else {
                        isGo = false;
                    }
                }
                if (isGo == true) {
                    // console.log('send ajax');
                    // 发送请求
                    sendRequest();
                }

                // 给没有写入数据的输入表单 显示 请输入信息
                for (var x in status) {
                    if (status[x] == 0) {
                        let aNextSlibling = $('#' + x).nextAll();
                        aNextSlibling.css('display', 'none');
                        if (x == 'password') {
                            aNextSlibling.eq(1).css('display', 'block');
                        } else {
                            aNextSlibling.eq(2).css('display', 'block');
                        }
                    }
                }

            });

            //发送请求
            let sendRequest = function() {

                let data1 = {
                    "userName": $('#userName').val(),
                    "email": $('#email').val(),
                    "userPhone": $('#userPhone').val(),
                    "password": $('#password').val()
                };
                let data = {
                    "key":"花生"
                };
                function success(aaa) {
                    if (aaa.code == 200) { // 如果处理成功
                        let count = 0;
                        for (var x in aaa.data) {
                            if (aaa.data[x] == 1) {
                                count++;
                            } else {
                                looklook(x);
                            }
                        }
                        if (count == 3) {
                            //将账号密码 计入cookies
                            // window.location.href = './index.html';
                            alert("注册成功");
                        }

                        function looklook(x) {
                            if (x == 'userNameSta') {
                                let aNextSlibLing = $('#userName').nextAll();
                                aNextSlibLing.css('display', 'none');
                                aNextSlibLing.eq(1).css('display', 'block');
                            }
                            if (x == 'emailSta') {
                                let aNextSlibLing = $('#email').nextAll();
                                aNextSlibLing.css('display', 'none');
                                aNextSlibLing.eq(1).css('display', 'block');
                            }
                            if (x == 'userPhoneSta') {
                                let aNextSlibLing = $('#userPhone').nextAll();
                                aNextSlibLing.css('display', 'none');
                                aNextSlibLing.eq(1).css('display', 'block');
                            }
                        }

                    }
                    if (aaa.code == 500) { // 如果处理失败
                        alert(aaa.message);
                    }
                    console.log(aaa);
                }

                $.ajax({
                    type: 'post',
                    url: 'http://172.32.100.201:8080/farm1/categoryServlet/returnKey',
                    dataType: 'json',
                    //data: JSON.stringify(data),
                    data: data,
                    success: success,
                    timeout: 20000,
                    error: function() {
                        alert("请求超时或服务器故障，请稍后重试");
                    }
                });
            }
        });

        // 1、限制用户输入空格  --- ok
        // 2、每个input框 change，检查格式，给出formatInfo
        // 3、在格式不对、checked没有被选中、或 没有输入内容的情况下 保持 submit disabled
        // 4、在没有输入内容时 点击 submit，给出提示 请输入
        // 5、当submit可以点击时，发送所有的信息，根据后端的返回信息，给出重复的提示
    </script>
</body>

</html>