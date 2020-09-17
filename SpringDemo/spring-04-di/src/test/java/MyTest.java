import com.github.dairycode.spring.pojo.Student;
import com.github.dairycode.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
//        User user = context.getBean("user1", User.class);
        User user = context.getBean("user2", User.class);
        System.out.println(user);
    }
}
