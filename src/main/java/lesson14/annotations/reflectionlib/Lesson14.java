package lesson14.annotations.reflectionlib;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;



public class Lesson14 {
    public static void main(String[] args) throws Throwable {
        runAllTests("lesson14.annotations.reflectionlib.tests");
    }

    public static void runAllTests(String packageAddress) throws Throwable {
        Reflections reflections = new Reflections(packageAddress);
        Set<Class<?>> setClasses = reflections.getTypesAnnotatedWith(TestClass.class);

        for (Class<?> setClass : setClasses) {
            Constructor<?> constructor = setClass.getConstructor(null);

            Object possibleTestMethods = constructor.newInstance();

            for (Method method : setClass.getMethods()) {
                if(method.isAnnotationPresent(TestMethod.class)){

                    TestMethod testMethod = method.getAnnotation(TestMethod.class);
//                    if(testMethod.order()>)

                    method.invoke(possibleTestMethods);
                }
            }
        }
    }
}
