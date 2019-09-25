package lesson14.annotations.reflectionlib.tests;

import lesson14.annotations.reflectionlib.TestClass;
import lesson14.annotations.reflectionlib.TestMethod;

@TestClass(1)
public class FirstTestsClass {

    public void thirdTest(){
        System.out.println("(1.3)First class - third test");
    }

    public void secondTest(){
        System.out.println("(1.2)First class - second test");
    }

    @TestMethod(1)
    public void firstTest(){
        System.out.println("(1.1)First class - first test");
    }
}
