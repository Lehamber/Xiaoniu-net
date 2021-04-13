(function(window, $) {

    function addCookie(key, value, path, day, domain) {
        var index = window.location.pathname.indexOf('/');
        var defaultPath = window.location.pathname.slice(0, index);
        path = path || defaultPath;
        domain = domain || document.domain;
        if (!day) {
            document.cookie = `${key}=${value};path=${path};domain=${domain};`;
        } else {
            var date = new Date();
            date.setDate(date.getDate() + day);
            document.cookie = `${key}=${value};expires=${date.toUTCString()};path=${path};domain=${domain};`;
        }
    }
    // 获取cookie值
    function getCookie(key) {
        let cookieArray = document.cookie.split(';');
        for (var i = 0; i < cookieArray.length; i++) {
            let keyValueArray = cookieArray[i].split('=');
            if (key == keyValueArray[0].trim()) {
                return keyValueArray[1].trim();
            }
        }
    }
    // 删除cookies的值
    function delCookie(key, path) {
        var index = window.location.pathname.indexOf('/');
        var defaultPath = window.location.pathname.slice(0, index);
        path = path || defaultPath;
        addCookie(key, getCookie(key), path, -1);
    }

    // 把方法引入window对象
    window.proCookie = {
        addCookie: addCookie,
        getCookie: getCookie,
        delCookie: delCookie
    }

})(window, jQuery);