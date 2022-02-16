public class Pruebas {
    public static void m1(){}

    @Test
    public static void m2(){
        throw new RuntimeException();
    }

    @Test
    public static void m3(){}

    @Test
    public static void m4(){
        throw new RuntimeException();
    }

    public static void m5(){}
}

// Compilar:
// javac RunTests.java
// javac Pruebas.java
// java RunTests Pruebas