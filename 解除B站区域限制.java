(function() {
    'use strict';

    // 获取当前页面的URL
    let url = window.location.href;

    // 获取网页标题
    let title = document.title;

    // 繁体字的正则表达式
    let regexTraditional = /[\u4E00\u4E09\u4E8C\u4E10\u4E3F\u4E38\u4E43\u4E58\u4E60\u4E65\u4E72\u4E7E\u4E8B\u4E9A\u5A5A\u5BC6\u5C0F\u5D4A\u5E03\u5E7A\u5F9C\u9B31\u9E1A]/;

    // 检查是否是哔哩哔哩的网站
    if (url.includes("bilibili.com/bangumi/play")) {
        // 检查标题中是否包含“僅限”或包含繁体字
        if (title.includes("僅限") || regexTraditional.test(title)) {
            // 如果URL没有查询标识
            if (!url.includes("?") && !url.includes("spm_id_from")) {
                // 在URL后添加查询参数
                let newUrl = url + "?spm_id_from=333.1387.0.0";

                // 跳转到新URL
                window.location.href = newUrl;
                return; // 跳转后结束插件运行
            }

            // 检查URL中是否包含“from”字符段
            if (url.includes("from")) {
                // 检查URL中是否包含“？”符号
                if (url.includes("?")) {
                    // 去掉“？”符号
                    let newUrl = url.replace("?", "");

                    // 重新加载页面
                    window.location.href = newUrl;
                }
            }
        }
    }

    // 在页面加载完成后重新执行本插件
    window.addEventListener('load', function() {
        let url = window.location.href;
        let title = document.title;

        if (url.includes("bilibili.com")) {
            if (title.includes("僅限") || regexTraditional.test(title)) {
                if (url.includes("from_spmid")) {
                    if (url.includes("?")) {
                        let newUrl = url.replace("?", "");
                        window.location.href = newUrl;
                    }
                }
            }
        }
    });

})();


