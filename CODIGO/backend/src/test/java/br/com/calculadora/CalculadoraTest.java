package br.com.calculadora;

public class CalculadoraTest {

    public static void main(String[] args) {
        int failures = 0;

        failures += run("somar", CalculadoraTest::testarSomar);
        failures += run("subtrair", CalculadoraTest::testarSubtrair);
        failures += run("multiplicar", CalculadoraTest::testarMultiplicar);
        failures += run("dividir", CalculadoraTest::testarDividir);
        failures += run("dividirPorZero_lancaExcecao", CalculadoraTest::testarDividirPorZero);

        if (failures == 0) {
            System.out.println("OK - Todos os testes passaram.");
            return;
        }

        System.err.println("FALHA - " + failures + " teste(s) falharam.");
        System.exit(1);
    }

    private static int run(String name, Runnable test) {
        try {
            test.run();
            System.out.println("PASS - " + name);
            return 0;
        } catch (AssertionError e) {
            System.err.println("FAIL - " + name + ": " + e.getMessage());
            return 1;
        } catch (RuntimeException e) {
            System.err.println("ERROR - " + name + ": " + e);
            return 1;
        }
    }

    private static void testarSomar() {
        Calculadora calc = new Calculadora(2, 3);
        assertEquals(5, calc.somar(), "somar");
    }

    private static void testarSubtrair() {
        Calculadora calc = new Calculadora(10, 4);
        assertEquals(6, calc.subtrair(), "subtrair");
    }

    private static void testarMultiplicar() {
        Calculadora calc = new Calculadora(6, 7);
        assertEquals(42, calc.multiplicar(), "multiplicar");
    }

    private static void testarDividir() {
        Calculadora calc = new Calculadora(9, 2);
        assertEquals(4.5, calc.dividir(), 0.000001, "dividir");
    }

    private static void testarDividirPorZero() {
        Calculadora calc = new Calculadora(9, 0);
        try {
            calc.dividir();
            throw new AssertionError("dividirPorZero: era esperado lançar ArithmeticException");
        } catch (ArithmeticException ex) {
            assertEquals("Divisão por zero", ex.getMessage(), "mensagem dividirPorZero");
        }
    }

    private static void assertEquals(int expected, int actual, String testName) {
        if (expected != actual) {
            throw new AssertionError(testName + ": esperado " + expected + " mas veio " + actual);
        }
    }

    private static void assertEquals(String expected, String actual, String testName) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(testName + ": esperado '" + expected + "' mas veio '" + actual + "'");
        }
    }

    private static void assertEquals(double expected, double actual, double delta, String testName) {
        if (Math.abs(expected - actual) > delta) {
            throw new AssertionError(testName + ": esperado " + expected + " mas veio " + actual);
        }
    }
}
