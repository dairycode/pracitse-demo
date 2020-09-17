import com.github.dairycode.spring.config.MyConfig1;
import com.github.dairycode.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test() {
        // 如果使用了配置类方式去做,我们就只能通过AnnotationConfig上下文来获取容器,通过配置类的class对象加载!
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig1.class);
        User getUser = context.getBean("user", User.class);
        System.out.println(getUser.getName());
    }
}
