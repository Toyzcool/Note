function show(type) {
    count = 0;
    for (var key in methods) {
        var row = document.getElementById(key);
        if ((methods[key] & type) != 0) {
            row.style.display = '';
            row.className = (count++ % 2) ? rowColor : altColor;
        } else row.style.display = 'none';
    }
    updateTabs(type);
}

function updateTabs(type) {
    for (var value in tabs) {
        var sNode = document.getElementById(tabs[value][0]);
        var spanNode = sNode.firstChild;
        if (value == type) {
            sNode.className = activeTableTab;
        } else {
            sNode.className = tableTab;
        }
    }
}

/* 统计和推送 */
(function () {
    var hm = document.createElement("script");
    hm.src = "//hm.baidu.com/hm.js?d3414741ec158443f41d7ca685623a4f";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();
(function () {
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
    } else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();

/* 延时加载广告 */
window.onload = pagedispose;

/* 页面处理*/
function pagedispose() {
    /* 处理所有方法点击不生效 */
    var t0 = document.getElementById("t0");
    if (t0) {
        t0.innerHTML = "<span><a href='javascript:show(65535);'>所有方法</a></span>";

    }
    /* 如果存在版权则加载广告 */
    var legalCopy = document.getElementsByClassName("legalCopy");
    if (legalCopy.length) {
        var body = document.getElementsByTagName("body");
        var html = ('' + '<div style=" position: fixed;right: 0px;top: 0px; background-color: #EEEEEF;color: white">' + '      <a target="_blank"  style="font-size: 16px; color:white:;; text-decoration: none" href="https://blog.fondme.cn/posts/21004/"><div style="">其他翻译版,去围观</div></a>' + '</div>');
        // 创建div节点
        var div = document.createElement("div");
        // 装载html字符串
        div.innerHTML = html;
        body[0].appendChild(div);
    }
}