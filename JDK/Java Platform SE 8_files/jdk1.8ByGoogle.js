/**
 * Created by admin on 2017/4/2.
 */


try {

    juede_init();

} catch (e) {
    console.error(e)
}


(function () {
    var href = window.location.href;
    var startIndex = href.indexOf("::");

    if (startIndex < 0) {
        return;
    }

    var url = "https://gitee.com/xiagao/jdk9-api-translate/blob/public/apidoc" + href.substr(startIndex + 2);

    /*   if (confirm("是否")) {
     window.open(url);
     }
     */

})();


function getGitUrl() {
    var href = window.location.href;
    var startIndex = href.indexOf("::");
    var url = "https://gitee.com/xiagao/jdk9-api-translate/blob/public/apidoc";
    if (startIndex < 0) {
        return url;
    }

    url = url + href.substr(startIndex + 2);
    return url

}


(function () {
    var html = "<div style='position: fixed;bottom: 50px;right: 50px;z-index: 999'><a style='color: red; ' target='_blank' href='{a_href}'>{a_text}</a></div>"
    html = html.replace("{a_href}", "http://blog.fondme.cn/posts/21018/")
        .replace("{a_text}", "jdk<br/>中<br/>英<br/>对<br/>照<br/>版<br/>");
    // 创建div节点
    var div = document.createElement("div");
    var body = document.getElementsByTagName("body");
    // 装载html字符串
    div.innerHTML = html;
    body[0].appendChild(div)


})();


function juede_init() {

    // 广告内容
    var adDatas = [
        [{text: "我要纠错----修正翻译内容。<br/>", url: getGitUrl(), style: ""},
            {
                text: "QQ群：864725196 <br/>",
                url: "http://shang.qq.com/wpa/qunwpa?idkey=61b7562205ad978904da9c728e973c4a08be6185de697cad831aef608cf4a9fe",
                style: ""
            },
            {text: "安卓帮助文档。<br/>", url: "http://blog.466dd.com/posts/21025/", style: "color:red;font-weight: bold;"}
        ]];

    // 官网地址
    var hosts = ["http://blog.fondme.cn", "http://blog.466dd.com"];
    var adUrl = "/posts/21024/";
    var siteDatas = [];
    for (var i = 0; i < hosts.length; i++) {
        var host = hosts[i];
        var siteinfo = {text: "网站地址" + (i + 1) + " ", url: host + adUrl};
        siteDatas.push(siteinfo)
    }
    adDatas.unshift(siteDatas);


    // 处理数据为html
    var adHtml = "";
    for (var i = 0; i < adDatas.length; i++) {
        var datas = adDatas[i];
        for (var j = 0; j < datas.length; j++) {
            var row = datas[j];
            var url = row.url;
            var style = row.style;
            //没有url时
            if (!url) {
                url = "javascript:void(0)";
            }

            if (!style) {
                style = "";
            }
            adHtml +=
                '<a target="_blank"  style="font-size: 14px; color:black; text-decoration: none; ' + style + '" href="' + url + '">' + row.text + '</a>';
        }
        adHtml += "<br/>"
    }


    // 广告html
    var html =
        '<div  style=" text-align: right; position: absolute;right: 0px;z-index:9999;top: 95px; color: black">' +
        adHtml +
        '</div>';

    // 创建div节点
    var div = document.createElement("div");
    var body = document.getElementsByTagName("body");
    // 装载html字符串
    div.innerHTML = html;
    body[0].appendChild(div)
}

