package WORK8;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

//元数组参数
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionContainer.class)
@interface ExceptionSingle{
    Class<? extends Exception> value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExceptionContainer{
    ExceptionSingle[] value();
}

public class AnnotationTest2 {
    public static void main(String[] args) throws Exception{
        for(Method m : Sample2.class.getDeclaredMethods()) {
            try {
                //执行函数
                m.invoke(null);
            } catch (Throwable wrappedExc) {
                Throwable exc = wrappedExc.getCause();
                //注解数组参数
                ExceptionSingle[] excTypes = m.getAnnotation(ExceptionContainer.class).value();
                for(ExceptionSingle excType : excTypes){
                    if(excType.value().isInstance(exc)){
                        System.out.println(m +"failed: " + exc);
                        //break;
                    }
                }//for
            }//catch
        }
    }
}

class Sample2{
    @ExceptionSingle(IndexOutOfBoundsException.class)
    @ExceptionSingle(NullPointerException.class)
    @ExceptionSingle(ArithmeticException.class)
    public static void m1(){
        int[] a = new int[1];
        a[1] = 2;//1

    }

    @ExceptionSingle(IndexOutOfBoundsException.class)
    @ExceptionSingle(NullPointerException.class)
    @ExceptionSingle(ArithmeticException.class)
    public static void m2(){
        List<String> l = new ArrayList<>();
        l.add(null);//2
        l.get(0).hashCode();
    }

    @ExceptionSingle(IndexOutOfBoundsException.class)
    @ExceptionSingle(NullPointerException.class)
    @ExceptionSingle(ArithmeticException.class)
    public static void m3(){
        int z = 0;
        int k = 1 / z;//3
    }
}