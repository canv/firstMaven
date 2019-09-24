package lesson14.annotations.reflectionlib;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;


public class Lesson14 {
    public static void main(String[] args) throws Throwable {
        // runAllTests("lesson14.annotations.reflectionlib.tests");

        Reflections reflections = new Reflections(
                "lesson14.annotations.reflectionlib.tests");

        Set<Class<?>> setClasses = reflections.getTypesAnnotatedWith(TestClass.class);

        for (Class<?> setClass : setClasses) {

            List<Method> setMethods = new ArrayList<>();
            Constructor<?> constructor = setClass.getConstructor(null);
            Object possibleTestMethods = constructor.newInstance();

            for (Method method : setClass.getMethods()) {

                if (method.isAnnotationPresent(TestMethod.class)) {

                    setMethods.add(method);
                    // method.invoke(possibleTestMethods);
                }
            }

//            setMethods.sort((m1, m2) ->
//                    m1.getAnnotation(TestMethod.class).order()
//                    .compareTo(
//                    m2.getAnnotation(TestMethod.class).order()));

            for (Method setMethod : setMethods) {
                setMethod.invoke(possibleTestMethods);
            }
        }
    }
}