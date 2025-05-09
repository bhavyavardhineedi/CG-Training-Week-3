public class ExceptionPropagation {

    // method1() throws ArithmeticException (division by zero)
    public static void method1() {
        int result = 10 / 0; // This will throw ArithmeticException
    }

    // method2() calls method1()
    public static void method2() {
        method1(); // Calls method1, which throws the exception
    }

    public static void main(String[] args) {
        try {
            method2(); // Calls method2, which in turn calls method1
        } catch (ArithmeticException e) {
            // Handle the exception here
            System.out.println("Handled exception in main");
        }
    }
}
