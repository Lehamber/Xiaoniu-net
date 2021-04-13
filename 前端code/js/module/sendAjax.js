(function(window, $) {
    function sendAjax(type, url, data, success) {
        $.ajax({
            type: type,
            url: url,
            dataType: 'json',
            data: data,
            success: success,
            timeout: 30000 * 50,
            error: function() {
                alert("请求超时,或网络错误请稍后重试");
            }
        });
    }
    window.sendAjax = sendAjax;
})(window, jQuery);