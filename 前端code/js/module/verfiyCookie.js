$(function() {
    //cookie验证部分
    (function() {
        var userID = window.proCookie.getCookie('userID');
        var password = window.proCookie.getCookie('password');
        const logInStatus = function() {
            $('#up-nav .beforeLogin').css('display', 'none');
            $('#up-nav .afterLogin').css('display', 'inline-block');
            $('#up-nav .person-center>a').attr('href', './personalCenter.html');
        };
        const beforeLogInStatus = function() {
            $('#up-nav .beforeLogin').css('display', 'inline-block');
            $('#up-nav .afterLogin').css('display', 'none');
            $('#up-nav .new-store').css('display', 'inline');
            $('#up-nav .person-center>a').attr('href', './logIn.html');
            $('#up-nav .new-store>a').attr('href', './logIn.html');
            $('#up-nav .backstore>a').attr('href', './logIn.html');
        };
        // 如果有cookie发送验证请求
        if (userID != undefined && password != undefined) {
            var data = {
                userID: userID,
                password: password
            };
            var success = function(aaa) {
                if (aaa.code = 200) {
                    //如果用户在此主机上最近登录过
                    if (aaa.data.confirm == 1) {
                        // 首页改为已登录状态
                        logInStatus();
                        $('#up-nav .afterLogin .userName').text(userID);
                        // 若用户点击退出按钮
                        $('#up-nav .exit').on('click', function() {
                            console.log('delete');
                            window.proCookie.delCookie('userID', '/');
                            window.proCookie.delCookie('password', '/');
                            beforeLogInStatus();
                        });
                        // 如果该用户有开店铺的话
                        if (aaa.data.haveBusiness == 1) {
                            $('#up-nav .new-store').css('display', 'none');
                            $('#up-nav .backstore>a').attr('href', './supplierBackground.html');
                        } else {
                            $('#up-nav .new-store').css('display', 'inline');
                            $('#up-nav .new-store>a').attr('href', './signInBusiness.html');
                            $('#up-nav .backstore>a').attr('href', './signInBusiness.html');
                        }
                    } else {
                        // 把首页改为未登录状态
                        beforeLogInStatus();
                    }
                } else {
                    alert('服务器出错，请稍后重试');
                }
            }
            let url = window.serverIP + "/farm1/userServlet/verify";
            window.sendAjax('post', url, data, success);
            // $.ajax({
            //     type: 'post',
            //     url: url,
            //     dataType: 'json',
            //     data: data,
            //     success: success,
            //     timeout: 2000,
            //     error: function() {
            //         alert('请求超时或网络未连接');
            //     }
            // });
        } else {
            beforeLogInStatus();
        }
    })();
});