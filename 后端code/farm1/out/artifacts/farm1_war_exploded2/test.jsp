<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- <link rel="stylesheet" href="css/test.css"> -->

</head>

<body>
    <div>
        <h1>这里测试首页登录接口测试页面</h1>
    </div>
    <script>
        $(document).ready(function(){
            let data1 = {
                "data": [{
                    "CategoryName": '禽畜肉蛋'
                }, {
                    "CategoryName": '水果'
                }, {
                    "CategoryName": '蔬菜'
                }, {
                    "CategoryName": '粮油米面'
                }, {
                    "CategoryName": '农副加工'
                }, {
                    "CategoryName": '农资农机'
                }]
            };
            let data = {
                /*"key":"花生"*/
                /*"type":1,
                "key":"蔬菜",
                "page":"1"*/
                //"key":"辣椒"
                "ProductID":"17"
            };
            console.log(data);
            let type = 'post';
            let url = 'http://172.32.100.201:8080/farm1/productServlet/productMes';
            let success = function(aaa) {
                console.log(aaa.code);
                console.log(aaa.message);
                console.log(aaa.data);
            };
            $.ajax({
                type: type,
                url: url,
                dataType: 'json',
                //data: JSON.stringify(data),
                data: data,
                success: success,
                timeout: 70000,
                error: function() {
                    alert("1122请求超时，或网络错误请稍后重试");
                }
            });
        });

    </script>
</body>

</html>