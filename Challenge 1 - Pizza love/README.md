## **Challenge 1** - [Pizza love](./Enunciado.md)

Nos piden calcular el número mínimo de pizzas que necesitamos para que nadie se quede con hambre. Cada pizza se corta en 8 trozos, y en cada caso nos dan el número de personas y el número máximo de trozos que puede comer.

En este caso el reto es sencillo de resolver (suele ser fácil el primero problema), si sumamos lo que cada persona puede comer tendremos el total de trozos de pizzas que vamos a necesitar, luego dividimos por el número de trozos que compone una pizza y redondeamos hacia arriba.

<pre>
BigDecimal reduce = Stream.of(maxNumberPiecesOfPizza.split(" "))
	.map(BigDecimal::new)
	.reduce(BigDecimal.ZERO, (a, b) -> a.add(b))
	.divide(PIZZA_SLICES, BigDecimal.ROUND_CEILING);
</pre>

