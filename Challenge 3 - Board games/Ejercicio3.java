package tuenti;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class Ejercicio3 {

	private static BigInteger DOS = BigInteger.valueOf(2);

	public static void main(String[] args) {

		try (Scanner input = new Scanner(new File("rsc/input.txt"))) {

			Integer numberOfCases = new Integer(input.nextLine());
			for (Integer caseX = 1; caseX <= numberOfCases; caseX++) {
				BigInteger maxPoints = new BigInteger(input.nextLine());
				String resul = calcular(maxPoints);
				System.out.println("Case #" + caseX + ": " + resul);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String calcular(BigInteger maxPoints) {
		BigInteger uniques = BigInteger.ONE;
		BigInteger aux = maxPoints;
		while (!aux.equals(BigInteger.ONE)) {
			aux = aux.divide(DOS);
			uniques = uniques.add(BigInteger.ONE);
		}
		return uniques.toString();
	}

}