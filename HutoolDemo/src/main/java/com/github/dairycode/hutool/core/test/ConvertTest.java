package com.github.dairycode.hutool.core.test;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.CharsetUtil;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Convert类可以说是一个工具方法类，里面封装了针对Java常见类型的转换，用于简化类型转换。
 * Convert类中大部分方法为toXXX，参数为Object，可以实现将任意可能的类型转换为指定类型。
 * 同时支持第二个参数defaultValue用于在转换失败时返回一个默认值。
 */
public class ConvertTest {
    // 1.转换为字符串
    public void toStr() {
        int a = 1;
        // aStr为"1"
        String aStr = Convert.toStr(a);

        long[] b = {1, 2, 3, 4, 5};
        // bStr为:"[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
    }

    // 2.转换为指定类型数组
    public void toArray() {
        String[] b = {"1", "2", "3", "4", "5"};
        // 结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);

        long[] c = {1, 2, 3, 4, 5};
        // 结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
    }

    // 3.转换为日期对象
    public void toDate() {
        String a = "2020-2-12";
        Date value = Convert.toDate(a);
    }

    // 4.转换为集合
    public void toList() {
        Object[] a = {"a", "你", "好", "", 1};
        // List<?> list = Convert.convert(List.class, a);
        // 从4.1.11开始可以这么用
        List<?> list = Convert.toList(a);
    }

    // 其他类型的转化
    public void otherType() {
        // 1.标准类型
        // 通过Convert.convert(Class<T>, Object)方法可以将任意类型转换为指定类型，
        // Hutool中预定义了许多类型转换，例如转换为URI、URL、Calendar等等，
        // 这些类型的转换都依托于ConverterRegistry类。通过这个类和Converter接口，
        // 我们可以自定义一些类型转换。详细的使用请参阅“自定义类型转换”一节。

        // 2.泛型类型
        // 通过convert(TypeReference<T> reference, Object value)方法，
        // 自行new一个TypeReference对象可以对嵌套泛型进行类型转换。
        // 例如，我们想转换一个对象为List<String>类型，此时传入的标准Class就无法满足要求，
        // 此时我们可以这样：
        Object[] a = {"a", "你", "好", "", 1};
        List<String> list = Convert.convert(new TypeReference<List<String>>() {}, a);
    }

    // 半角和全角转换
    public void toBC() {
        // 半角转全角
        String a = "123456789";
        // 结果为"1 2 3 4 5 6 7 8 9"
        String sbc = Convert.toSBC(a);

        // 全角转半角
        String b = "1 2 3 4 5 6 7 8 9";
        // 结果为"123456789"
        String dbc = Convert.toDBC(b);
    }

    // 16进制(Hex)
    public void toHex() {
        // 转为16进制(Hex)字符串
        String a = "我是一个小小的可爱的字符串";
        // 结果:"e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
        String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);

        // 将16进制(Hex)字符串转为普通字符串
        //结果为:"我是一个小小的可爱的字符串"
        // String raw = Convert.hexStrToStr(hex, CharsetUtil.CHARSET_UTF_8);
        //注意:在4.1.11之后hexStrToStr将改名为hexToStr
        String raw = Convert.hexToStr(hex, CharsetUtil.CHARSET_UTF_8);
    }

    // Unicode和字符串转换
    public void toUnicode() {
        String a = "我是一个小小的可爱的字符串";
        // 结果为:"\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String unicode = Convert.strToUnicode(a);
        // 结果为:"我是一个小小的可爱的字符串"
        String raw = Convert.unicodeToStr(unicode);
    }

    // 编码转换
    public void convertCharset() {
        String a = "我不是乱码";
        //转换后result为乱码
        String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
        // Assert.assertEquals(raw, a);
    }

    // 时间单位转换
    public void convertTime() {
        long a = 4535345;
        //结果为:75
        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
    }

    // 金额大小写转换
    public void digitToChinese() {
        double a = 67556.32;
        //结果为:"陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);
    }

    // 原始类和包装类转换
    public void wrap() {
        //去包装
        Class<?> wrapClass = Integer.class;

        //结果为：int.class
        Class<?> unWraped = Convert.unWrap(wrapClass);

        //包装
        Class<?> primitiveClass = long.class;

        //结果为：Long.class
        Class<?> wraped = Convert.wrap(primitiveClass);
    }
}
