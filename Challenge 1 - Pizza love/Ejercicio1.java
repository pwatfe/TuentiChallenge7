package tuenti;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio1 {

	public static final BigDecimal PIZZA_SLICES = new BigDecimal("8");

	public static void main(String[] args) {

		try (Scanner input = new Scanner(new File("rsc/input.txt"))) {
			
			Integer numberOfcases = new Integer(input.nextLine());
			for (int caseX = 1; caseX <= numberOfcases; caseX++) {
				Integer people = new Integer(input.nextLine());
				String maxNumberPiecesOfPizza = input.nextLine();
				String resul = minimunNumberOfPizzas(people, maxNumberPiecesOfPizza);
				System.out.println("Case #" + caseX + ": " + resul);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static String minimunNumberOfPizzas(int people, String maxNumberPiecesOfPizza) {

		BigDecimal reduce = Stream.of(maxNumberPiecesOfPizza.split(" ")).map(BigDecimal::new)
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b)).divide(PIZZA_SLICES, BigDecimal.ROUND_CEILING);

		return reduce.toString();
	}
	
	// Si se quiere usar BigInteger en lugar de BigDecimal, para simular el ROUND_CEILING
	// hay que restar uno antes de dividir y sumarle uno después (también podemos hacerlo 
	// comprobando el resto). Se hace esto porque la división entera de BigInteger te 
	// redondea hacia abajo.
	//
	//	 BigInteger reduce = Stream.of(maxNumberPiecesOfPizza.split(" ")).map(s -> new BigInteger(s))
	//	 .reduce(BigInteger.ZERO, (a, b) -> a.add(b)).subtract(BigInteger.ONE)
	//	 .divide(PIZZA_SLICES).add(BigInteger.ONE);

}