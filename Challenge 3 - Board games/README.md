## **Challenge 3** - [Board games](./Enunciado.md)

Este reto tiene la dificultad de entender bien lo que piden, necesitan un sistema para llevar los puntos de un juego de mesa. Para ello necesitamos calcular el mínimo número de cartas a imprimir dada una puntuación máxima, las cartas no se pueden repetir. 

Por ejemplo, si tenemos una puntuación máxima de 4 puntos, necesitamos encontrar el mínimo número de cartas necesarias sin que se repitan para contar desde 1 hasta 4:
	1 -> Necesitaremos la carta 1
	2 -> Necesitaremos la carta 2
	3 -> Con la del 1 y el 2 es suficiente, 1+2=3
	4 -> Necesitameremos una carta más, por ejemplo el 3, 3+1=4
Así que finalmente tendremos 3 cartas (1,2 y 3) para contar hasta 4.

Si analizamos bien el problema, nos damos cuenta de que lo que realmente nos están pidiendo es cuantos bits necesitamos para representar la puntuación máxima del juego. Para 20 por ejemplo necesitaríamos 5 bits (10100), que en el problema serían las cartas 1, 2, 4, 8, 16. Esto lo podemos conseguir de manera iterativa dividiendo la puntuación por 2 hasta llegar a 1, o bien de manera directa aplicando logaritmo en base dos con redondeo hacia arriba.

