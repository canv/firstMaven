package lesson14.annotations.reflectionlib.tests;

import lesson14.annotations.reflectionlib.TestClass;
import lesson14.annotations.reflectionlib.TestMethod;

@TestClass
public class ThirdTestsClass {

    @TestMethod(order = 3)
    public void thirdTest(){
        System.out.println("Third class - third test");
    }

    @TestMethod(order = 2)
    public void secondTest(){
        System.out.println("Third class - second test");
    }

    @TestMethod(order = 1)
    public void firstTest(){
        System.out.println("Third class - first test");
    }
}
