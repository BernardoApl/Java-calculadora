# Backend (Calculadora)

## Estrutura

- `src/main/java`: código principal (`br.com.calculadora`)
- `src/test/java`: testes unitários (sem depender de JUnit)

## Rodar (Windows / cmd)

Dentro de `CODIGO\\backend\\`:

1) Compilar:

`mkdir target\\classes 2>nul`

`javac -d target\\classes src\\main\\java\\br\\com\\calculadora\\*.java`

2) Executar:

`java -cp target\\classes br.com.calculadora.Main`

## Rodar testes (Windows / cmd)

1) Compilar testes:

`mkdir target\\test-classes 2>nul`

`javac -d target\\test-classes -cp target\\classes src\\test\\java\\br\\com\\calculadora\\CalculadoraTest.java`

2) Executar testes:

`java -cp target\\classes;target\\test-classes br.com.calculadora.CalculadoraTest`

Se algum teste falhar, ele lança `AssertionError` e o processo sai com código 1.

## Observação (JUnit/Maven)

Existe um `pom.xml` em `CODIGO/backend/pom.xml`, mas para usar `mvn test` você precisa ter o Maven instalado (ou um wrapper) e baixar dependências. Este projeto já roda os testes unitários sem isso, apenas com JDK.
