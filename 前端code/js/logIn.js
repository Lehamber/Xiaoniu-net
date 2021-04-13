 $(function() {

     $('#account').on('change', function() {

         let account = $(this).val();
         if (account.trim() == '') { // 如果输入位空串 则 让提示消失
             //  $('.logInBox .error2').css('display', 'none');
             return false;
         }
         let reg1 = new RegExp(/^[0-9]{11}$/); // 电话号
         let reg2 = new RegExp(/^[\w-\.]+@[\w-\.]+(\.[\w-\.]+)+$/); // 邮箱
         let reg3 = new RegExp(/^(?=.*([a-zA-Z]|[\u4E00-\u9FA5\uf900-\ufa2d]))[\w\-\u4E00-\u9FA5\uf900-\ufa2d]{2,20}$/); //用户名
         if (!reg1.test(account) && !reg2.test(account) && !reg3.test(account)) {
             $('.logInBox .error2').css('display', 'block');
         } else {
             $('.logInBox .error2').css('display', 'none');
         }
     });
     $('#account').on('input propertychange', function() {
         let account = $(this).val();
         if (account.trim() == '') {
             $(this).val(''); // 如果有空格则置为空
             $('.logInBox .error2').css('display', 'none');
         }
     });

     $('.logInBox form>button').eq(0).on('click', function() {

         let userID = $('#account').val();
         let password = $('#password').val();

         let success = function(aaa) {
             if (aaa.code == 200) {
                 if (aaa.data.confirm == 1) {
                     window.proCookie.addCookie('userID', aaa.data.userName, '/', 5);
                     window.proCookie.addCookie('password', $('#password').val(), '/', 5);
                     window.location.href = './index.html';
                 } else {
                     $('.logInBox>form .error1').css('display', 'block');
                 }
             } else {
                 alert("服务器出错请稍后再试");
             }
         }
         let data = {
             userID: userID,
             password: password
         };
         //  用户登录
         let url = window.serverIP + window.realUrl.logIn;
         window.sendAjax('post', url, data, success);
         //  $.ajax({
         //      type: 'post',
         //      //  url: "http://172.32.100.201:8080/farm1/userServlet/login",
         //      url: url,
         //      dataType: 'json',
         //      data: data,
         //      success: success,
         //      // 设置超时时间
         //      timeout: 2000,
         //      error: function() {
         //          alert("访问超时或异常，请稍后重试");
         //      }
         //  });
     });

     //这个好像是没有必要的，因为form表单自带提交功能；
     $('body').keydown(function() {
         if (event.keyCode == 13) {
             $('.logInBox form>button').eq(0).click();
             //  alert(123);
         }
     });
 });