import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解
/*
四个元注解:
    @Target: 用于描述注解的使用范围(即:被描述的注解可以用在什么地方)
    @Retention: 表示需要在什么级别保存该注释信息,用于描述注解的生命周期(SOURCE<CLASS<RUNTIME)
    @Document: 说明该注解将被包含在javadoc中
    @Inherited: 说明子类可以继承父类中该注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    // 注解的参数: 参数类型 + 参数名()
    // 只有一个参数,建议参数名为value,且value在输入时可以省略
    String name() default "";
    int age() default 0;
    int id() default -1;    // 如果默认值为-1,代表不存在,indexof,如果找不到就返回-1

    String[] schools() default {"河海大学", "211大学"};
}
