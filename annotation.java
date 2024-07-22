import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}
class AnnotationProcessor {
 public static void logExecutionTime(Object obj) throws Exception {
 for (Method method : obj.getClass().getDeclaredMethods()) {
 if (method.isAnnotationPresent(LogExecutionTime.class)) {
 long start = System.currentTimeMillis();
 method.setAccessible(true);
 method.invoke(obj);
 long end = System.currentTimeMillis();
 System.out.println("Execution time of " + method.getName() + " : " + (end - start) + "ms");
 }
 }
 }
}
class TestClass {
 @LogExecutionTime
 public void methodToLog() {
 // Simulate method execution time
 try {
 Thread.sleep(200);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 public static void main(String[] args) throws Exception {
 TestClass test = new TestClass();
 AnnotationProcessor.logExecutionTime(test);
 }
}