package lesson14.annotations.reflectionlib.tests;

import lesson14.annotations.reflectionlib.TestClass;
import lesson14.annotations.reflectionlib.TestMethod;

@TestClass
public class FirstTestsClass {

    public void thirdTest(){
        System.out.println("First class - third test");
    }

    public void secondTest(){
        System.out.println("First class - second test");
    }

    @TestMethod(order = 1)
    public void firstTest(){
        System.out.println("First class - first test");
    }
}
