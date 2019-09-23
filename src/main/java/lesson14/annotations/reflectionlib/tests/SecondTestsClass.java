package lesson14.annotations.reflectionlib.tests;

import lesson14.annotations.reflectionlib.TestClass;
import lesson14.annotations.reflectionlib.TestMethod;

@TestClass
public class SecondTestsClass {

    public void thirdTest(){
        System.out.println("Second class - third test");
    }

    @TestMethod(order = 2)
    public void secondTest(){
        System.out.println("Second class - second test");
    }

    @TestMethod(order = 1)
    public void firstTest(){
        System.out.println("Second class - first test");
    }
}
