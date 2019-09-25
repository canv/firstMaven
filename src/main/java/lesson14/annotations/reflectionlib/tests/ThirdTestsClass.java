package lesson14.annotations.reflectionlib.tests;

import lesson14.annotations.reflectionlib.TestClass;
import lesson14.annotations.reflectionlib.TestMethod;

@TestClass(3)
public class ThirdTestsClass {

    @TestMethod(3)
    public void thirdTest(){
        System.out.println("(3.3)Third class - third test");
    }

    @TestMethod(1)
    public void firstTest(){
        System.out.println("(3.1)Third class - first test");
    }

    @TestMethod(2)
    public void secondTest(){
        System.out.println("(3.2)Third class - second test");
    }
}
