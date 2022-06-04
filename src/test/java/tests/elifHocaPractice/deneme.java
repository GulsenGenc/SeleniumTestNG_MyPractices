package tests.elifHocaPractice;

import org.testng.annotations.Test;

public class deneme {

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test(dependsOnMethods = "test03")
    public void test02() {
        System.out.println("test02");
    }

    @Test()
    public void test03() {
        System.out.println("test03");
    }

    @Test()
    public void test04() {
        System.out.println("test04");
    }

    @Test
    public void test05() {
        System.out.println("test05");
    }
}
