package lesson14.annotations.reflectionlib.tests;

import lesson14.annotations.reflectionlib.TestClass;
import lesson14.annotations.reflectionlib.TestMethod;

@TestClass(2)
public class SecondTestsClass {

    @TestMethod(2)
    public void secondTest(){
        System.out.println("(2.2)Second class - second test");
    }

    public void thirdTest(){
        System.out.println("(2.3)Second class - third test");
    }

    @TestMethod(1)
    public void firstTest(){
        System.out.println("(2.1)Second class - first test");
    }
}
