package tuenti.challenge.seven.edition;

import java.io.File;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio8 {

    public static String NA = "N/A";

    public static void main(String[] args) {

	Scanner input;
	PrintStream ps;
	try {
	    ps = new java.io.PrintStream("sample.output");
	    input = new Scanner(new File("src/main/resources/sample.input"));
	    int i = 1;
	    while (input.hasNext()) {
		for (int cases = new Integer(input.nextLine()); cases > 0; cases--) {
		    String numero = input.nextLine().trim();
		    String resul = calcular(numero);
		    System.out.println("Case #" + i + ": " + resul);
		    ps.println("Case #" + i + ": " + resul);
		    i++;
		}
		break;
	    }
	    input.close();
	    ps.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private static String calcular(String numero) {
	try {
	    if (numero.contains(" ")) {
		return NA;
	    }
	    numero.chars().mapToObj(s -> comprueba(s)).toArray(Collectors.toList());

	    BigInteger numeroCod = new BigInteger(numero, 10);
	    return numeroCod.toString();
	} catch (Exception e) {
	    return NA;
	}

    }

    private static String comprueba(int s) {
	return Character.toString((char) s);

    }

}