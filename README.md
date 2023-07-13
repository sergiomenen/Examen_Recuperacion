# Examen_Recuperacion

Este proyecto contiene las clases `Matrix` y `MatrixTest` para calcular el determinante de una matriz 3x3 utilizando el método de Laplace en Java.

## Clase Matrix

La clase `Matrix` representa una matriz de dimensiones 3x3 y proporciona el método `calculateDeterminant()` para calcular el determinante de la matriz.


- `Matrix(double[][] data)`: Crea una instancia de la matriz con los datos proporcionados. Los datos deben ser una matriz 3x3 de tipo `double`.

- `calculateDeterminant()`: Calcula y devuelve el determinante de la matriz utilizando el método de Laplace. Devuelve un valor de tipo `double`.

## Clase MatrixTest

La clase `MatrixTest` contiene las pruebas unitarias para verificar el correcto funcionamiento de la clase `Matrix`.

### Métodos de prueba

- `testDeterminantCalculation()`: Realiza pruebas para verificar el cálculo correcto del determinante de la matriz en diferentes casos.
- `testInvalidMatrixDimensions()`: Verifica que se lance una excepción `IllegalArgumentException` cuando se intenta construir una matriz con dimensiones incorrectas.
- `testInvalidMatrixFormat()`: Verifica que se lance una excepción `NumberFormatException` cuando se intenta construir una matriz con un formato incorrecto (texto en lugar de números).

### Ejecución de las pruebas

Para ejecutar las pruebas, sigue los siguientes pasos:

1. Abre el archivo `MatrixTest.java`.
2. Ejecuta el método `main()` en la clase `MatrixTest`.
3. Verifica los resultados de las pruebas que se muestran en la consola.
