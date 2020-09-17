// 测试自定义注解
public class TestAnnotation {

    // 注解可以显式赋值,如果没有默认值,一定要给注解赋值
    @MyAnnotation(age = 18)
    public void test() {}
}
