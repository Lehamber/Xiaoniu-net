//1.引入express
const { json } = require('express');
const express = require('express');
const querystring = require('querystring');
//2.创建应用对象
const app = express();


// cookies登录验证

// 登录
app.post('/farm1/userServlet/login', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样
        "message": "处理成功",
        "data": {
            "confirm": 1,
            "userName": "张三123"
        }
    };
    response.send(JSON.stringify(data));
});
// 注册
app.post('/farm1/userServlet/register', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样
        "message": "处理成功",
        "data": {
            "userNameSta": 1,
            "emailSta": 1,
            "userPhoneSta": 1
        }
    };
    response.send(JSON.stringify(data));
});

// 搜索框实时搜索
app.get('/farm1/productServlet/fuzzyQuery', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样  500表示 服务器端 出错了
        "message": "访问成功",
        "data": [{
                "productName": "苹果"
            },
            {
                "productName": "圣女果"
            },
            {
                "productName": "罗汉果"
            },
            {
                "productName": "圣女果"
            },
            {
                "productName": "罗汉果"
            }
        ]
    };
    response.send(JSON.stringify(data));
});

// cookies登录验证
app.post('/farm1/userServlet/verify', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样
        "message": "处理成功",
        "data": {
            "confirm": 1,
            "haveBusiness": 0
        }
    };
    response.send(JSON.stringify(data));
});

// 首页商品展示
app.post('/farm1/categoryServlet/showCategory', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样
        "message": "处理成功",
        "data": [{
                "categoryName": "禽畜肉蛋",
                "productArray": [{
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    }
                ]
            },
            {
                "categoryName": "禽畜肉蛋",
                "productArray": [{
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    }
                ]
            },
            {
                "categoryName": "禽畜肉蛋",
                "productArray": [{
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    }
                ]
            },
            {
                "categoryName": "禽畜肉蛋",
                "productArray": [{
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    }
                ]
            },
            {
                "categoryName": "禽畜肉蛋",
                "productArray": [{
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    }
                ]
            },
            {
                "categoryName": "禽畜肉蛋",
                "productArray": [{
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    },
                    {
                        "productID": 1,
                        "productName": "火龙果",
                        "title": "新鲜海南火龙果",
                        "unitPrice": 21.1,
                        "stock": 101,
                        "image": "/tao.jpeg"
                    }
                ]
            }
        ]
    };
    response.send(JSON.stringify(data));
});

// 查询关键字接口
app.get('/farm1/productServlet/keyQuery', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样
        "message": "处理成功",
        "data": {
            "sum": "201",
            "product": [{
                    "productID": 1,
                    "productName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 100,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                }, {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                },
                {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                }, {
                    "productID": 1,
                    "ProductName": "火龙果",
                    "title": "新鲜海南火龙果",
                    "unitPrice": 21.1,
                    "stock": 101,
                    "image": "http://127.0.0.1:8001/js/tao.jpg"
                }
            ]
        }
    };
    response.send(JSON.stringify(data));
});

// 查询关键字类型
app.get('/farm1/categoryServlet/keyType', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样  500表示 服务器端 出错了
        "message": "访问成功",
        "data": {
            "type": 2
        }
    }
    response.send(JSON.stringify(data));
});

// 7-查询二级分类 对应的一级分类明
app.get('/farm1/categoryServlet/returnKey', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样  500表示 服务器端 出错了
        "message": "访问成功",
        // "data": ''
        "data": {
            "key": "粮油米面"
        }
    }
    response.send(JSON.stringify(data));
});

//6-具体商品查询接口
app.get('/farm1/productServlet/productMes', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样
        "message": "处理成功",
        "data": {
            "productID": 123,
            "title": "高原红富士",
            "updateDate": "2020.11.1.21:28",
            "businessAddress": "河南省郑州市中原区莲花街100号河南工业大学",
            "unitPrice": 99.9,
            "stock": 888,
            "evalutionCount": 234,
            "specification": "碗",
            "imageArray": [
                "http://127.0.0.1:8080/pro1.jpeg",
                "http://127.0.0.1:8080/pro2.jpeg",
                "http://127.0.0.1:8080/pro3.jpeg",
                "http://127.0.0.1:8080/pro4.jpeg",

            ],
            "evaluationArray": [{
                    "userPhoto": "/images/image12.jpg",
                    "userName": "简小橘",
                    "evaluationDate": "2020.6.1 20:11",
                    "content": "昨天刚刚到货，色泽明亮，顾客喜欢"
                },
                {
                    "userPhoto": "/images/image12.jpg",
                    "userName": "简小橘",
                    "evaluationDate": "2020.6.1 20:11",
                    "content": "昨天刚刚到货，色泽明亮，顾客喜欢"
                },
                {
                    "userPhoto": "/images/image12.jpg",
                    "userName": "简小橘",
                    "evaluationDate": "2020.6.1 20:11", // 时间改天再议
                    "content": "昨天刚刚到货，色泽明亮，顾客喜欢"
                }
            ],
            "attributeArray": [{
                    "Attributename": "颜色",
                    "value": "红色",
                },
                {
                    "Attributename": "是否套袋",
                    "value": "是",
                },
                {
                    "Attributename": "储存方式",
                    "value": "鲜果",
                }
            ],
            "businessName": "郑州红鸿果业有限公司",
            "orderAmount": 664,
            "businessPhone": "18394617854"
        }
    };
    response.send(JSON.stringify(data));
});

// 8-收藏产品接口
app.post('/collect_pro', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样  500表示 服务器端 出错了
        "message": "访问成功"
    }
    response.send(JSON.stringify(data));
});

// 9-提交订单
app.post('/commit_order', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样  500表示 服务器端 出错了
        "message": "访问成功",
        "data": {
            "orderID": "1234567"
        }
    };
    response.send(JSON.stringify(data));
});

// 9-提交订单
app.get('/make_sure_page_search', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样  500表示 服务器端 出错了
        "message": "访问成功",
        "data": {
            "defaultAddress": "河南省郑州市中原区莲花街100号河南工业大学",
            "userName": "张derder",
            "productImg": "图片url",
            "unitPrice": "99.9",
            "addressID": "13",
            "productID": "8"
        }
    };
    response.send(JSON.stringify(data));
});


app.all('/test', (request, response) => {
    // 设置响应头  目的：设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');
    let data = {
        "code": 200, // 含义跟http状态码的含义一样  500表示 服务器端 出错了
        "message": "访问成功",
        "data": [{
                "productName": "苹果"
            },
            {
                "productName": "圣女果"
            },
            {
                "productName": "罗汉果"
            }
        ]
    };
    response.send(JSON.stringify(data));
});


//4.监听端口启动服务
app.listen(8000, () => {
    console.log("服务已启动，8000 端口监听中......");
});