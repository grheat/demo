package demo;

import entity.User;
import org.junit.Test;
import sun.applet.AppletViewer;

import java.util.*;

public class Java8Demo {
    public static void main(String[] args) {
        //lamda表达式
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");
        sortUsingJava8(names1);
        System.out.println(names1);


        //线程
        new Thread(() -> System.out.println("lamda")).start();
    }

    private static void sortUsingJava8(List<String> list) {
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
    }

    @Test
    public void testOptional() {
        User user = new User();
        user.setId(123123123);
        user.setName("王伟");
        user.setSex(0);

    }


}
