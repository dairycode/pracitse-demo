package com.github.dairycode.hutool.http.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class HttpTest {
    public void HttpUtil() {

        // GET请求
        // 最简单的HTTP请求，可以自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result1 = HttpUtil.get("https://www.baidu.com");

        // 当无法识别页面编码的时候，可以自定义请求页面的编码
        String result2 = HttpUtil.get("https://www.baidu.com", CharsetUtil.CHARSET_UTF_8);

        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String result3 = HttpUtil.get("https://www.baidu.com", paramMap);

        // POST请求
        HashMap<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("city", "北京");

        String result4 = HttpUtil.post("https://www.baidu.com", paramMap2);

        // 文件上传
        HashMap<String, Object> paramMap3 = new HashMap<>();
        //文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
        paramMap.put("file", FileUtil.file("D:\\face.jpg"));

        String result5 = HttpUtil.post("https://www.baidu.com", paramMap);

        // 下载文件
        String fileUrl = "http://mirrors.sohu.com/centos/7.3.1611/isos/x86_64/CentOS-7-x86_64-DVD-1611.iso";

        //将文件下载后保存在E盘，返回结果为下载文件大小
        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file("e:/"));
        System.out.println("Download size: " + size);

        //带进度显示的文件下载
        HttpUtil.downloadFile(fileUrl, FileUtil.file("e:/"), new StreamProgress(){

            @Override
            public void start() {
                Console.log("开始下载。。。。");
            }

            @Override
            public void progress(long progressSize) {
                Console.log("已下载：{}", FileUtil.readableFileSize(progressSize));
            }

            @Override
            public void finish() {
                Console.log("下载完成！");
            }
        });
    }

    public static void main(String[] args) {
        String result = HttpUtil.get("https://www.baidu.com");
        System.out.println(result);
    }
}
