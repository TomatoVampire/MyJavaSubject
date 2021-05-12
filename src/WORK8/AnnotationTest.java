package WORK8;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

//注解数组参数
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExceptionTest{
    Class<? extends Exception>[] value();
}

public class AnnotationTest {
    public static void main(String[] args) throws Exception{
        for(Method m : Sample.class.getDeclaredMethods()) {
            try {
                //执行函数
                m.invoke(null);
            } catch (Throwable wrappedExc) {
                Throwable exc = wrappedExc.getCause();
                //注解数组参数
                Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
                for(Class<? extends Throwable> excType : excTypes){
                    if(excType.isInstance(exc)){
                        System.out.println(m +"failed: " + exc);
                        //break;
                    }
                }//for
            }//catch
        }
    }
}

class Sample{
    @ExceptionTest({IndexOutOfBoundsException.class,
            NullPointerException.class,
            ArithmeticException.class})
    public static void m1(){
        int[] a = new int[1];
        a[1] = 2;//1

    }

    @ExceptionTest({IndexOutOfBoundsException.class,
            NullPointerException.class,
            ArithmeticException.class})
    public static void m2(){
        List<String> l = new ArrayList<>();
        l.add(null);//2
        l.get(0).hashCode();
    }

    @ExceptionTest({IndexOutOfBoundsException.class,
            NullPointerException.class,
            ArithmeticException.class})
    public static void m3(){
        int z = 0;
        int k = 1 / z;//3
    }
}