package lesson14.annotations.reflectionlib;

import org.reflections.Reflections;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

public class Lesson14 {
    public static void main(String[] args) throws Throwable {
// 1) Реализовать поочередный вызов аннотируемых классов
// 2) Реализовать поочередный вызов аннотируемых методов
//      в каждом вызванном классе
// 3) Сделать мозможность объявления атрибута аннотации
//      @TestMethod(2) вместо @TestMethod(order = 2)

        Reflections reflections = new Reflections(
                "lesson14.annotations.reflectionlib.tests");

        Set<Class<?>> setClasses = reflections.getTypesAnnotatedWith(TestClass.class);

        List<Class<?>> sortedClasses = new ArrayList<>(setClasses);
        sortedClasses.sort(Comparator.comparingInt(m -> m.getAnnotation(TestClass.class).value()));

        for (Class<?> sortedClass : sortedClasses) {
            List<Method> sortedMethods = new ArrayList<>();

            for (Method method : sortedClass.getMethods()) {
                if (method.isAnnotationPresent(TestMethod.class)) {
                    sortedMethods.add(method);
                }
            }

            Constructor<?> constructor = sortedClass.getConstructor(null);
            Object possibleTestMethods = constructor.newInstance();
            sortedMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(TestMethod.class).value()));
            for (Method setMethod : sortedMethods) {
                setMethod.invoke(possibleTestMethods);
            }
        }
    }
}