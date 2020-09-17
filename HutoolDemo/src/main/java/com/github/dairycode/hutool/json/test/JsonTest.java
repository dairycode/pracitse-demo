package com.github.dairycode.hutool.json.test;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class JsonTest {
    // JSONObject
    public void toJSONObject() {
        // 创建
        JSONObject json1 = JSONUtil.createObj();
        json1.put("a", "value1");
        json1.put("b", "value2");
        json1.put("c", "value3");

        // JSONUtil.createObj()是快捷新建JSONObject的工具方法，同样我们可以直接new:
        JSONObject json2 = new JSONObject();

        // 转换
        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        // 方法一:实用工具类转换
        JSONObject jsonObject1 = JSONUtil.parseObj(jsonStr);
        // 方法二:new的方式转换
        JSONObject jsonObject2 = new JSONObject(jsonStr);

        // JSON对象转字符串
        jsonObject1.toString();
    }

    // JSONArray
    public void toJSONArray() {
        // 创建
        // 方法一
        JSONArray array1 = JSONUtil.createArray();
        // 方法二
        JSONArray array2 = new JSONArray();

        array1.add("value1");
        array1.add("value2");
        array1.add("value3");

        // 转为JSONArray字符串
        array1.toString();

        // 转换
        String jsonStr = "[\"value1\", \"value2\", \"value3\"]";
        JSONArray array = JSONUtil.parseArray(jsonStr);
    }
}
