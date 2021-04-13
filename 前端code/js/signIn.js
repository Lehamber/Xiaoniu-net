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
        var reg = new RegExp(/^(?=.*([a-zA-z]|[\u4E00-\u9FA5\uf900-\ufa2d]))[\w\-\u4E00-\u9FA5\uf900-\ufa2d]{2,20}$/);
        var aNextAll = $(this).nextAll();
        aNextAll.css('display', 'none');
        if (reg.test(value)) {
            console.log(13);
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
    $('#checkbox').on('click', function() {
        if ($(this).prop('checked')) {
            $('#btnInput').attr('disabled', false);
        } else {
            $('#btnInput').attr('disabled', true);
        }
    });

    // 如果填了数据，且格式正确 提交数据
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
    // 设置按 enter 键 触发按钮点击
    $('body').keydown(function() {
        if (event.keyCode == 13 && $('#checkbox').prop('checked')) {
            $('#btnInput').click();
        }
    });
    //发送请求
    let sendRequest = function() {

        let data = {
            "userName": $('#userName').val(),
            "email": $('#email').val(),
            "userPhone": $('#userPhone').val(),
            "password": $('#password').val()
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
                    //将账号密码 计入cookies, 生存时间为5天
                    window.proCookie.addCookie('userID', $('#userName').val(), '/', 5);
                    window.proCookie.addCookie('password', $('#password').val(), '/', 5);
                    window.location.href = './index.html';
                    // alert("注册成功");
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
        // 用户注册
        let url = window.serverIP + window.realUrl.signIn;
        window.sendAjax('post', url, data, success);
        // $.ajax({
        //     type: 'post',
        //     url: url,
        //     dataType: 'json',
        //     data: data,
        //     success: success,
        //     timeout: 2000,
        //     error: function() {
        //         alert("请求超时或服务器故障，请稍后重试");
        //     }
        // });
    }
});