package tuenti.challenge.seven.edition;

import java.io.File;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 
 * Pythagoras Junior is not a great mathematician like his great great great grandfather. When he gets a list of
 * numbers, he finds it hard to match 3 numbers and create a triangle out of them.
 * 
 * You need to help Pythagoras Junior to identify which is the smallest possible triangle given a list of side lengths.
 * We define the smallest triangle as the one with the minimum perimeter.
 * 
 * Input
 * 
 * The first line will contain an integer C, the number of cases for our problem. Each case consists of a line starting
 * with an integer N, the number of sides, followed by N integers, each indicating the length of a side. All the
 * integers are separated by spaces.
 * 
 * Output
 * 
 * For each case, a line starting with "Case #x: " followed by the perimeter of the smallest triangle or, if it's not
 * possible to form a valid triangle, "IMPOSSIBLE". Every line is followed by a new line character.
 * 
 * @author filope
 *
 */
public class Ejercicio4 {

    public static void main(String[] args) {

	Scanner input;
	PrintStream ps;
	try {
	    ps = new java.io.PrintStream("sample.output");
	    input = new Scanner(new File("src/main/resources/sample.input"));
	    int i = 1;
	    while (input.hasNext()) {
		for (int cases = new Integer(input.nextLine()); cases > 0; cases--) {
		    String[] sides = input.nextLine().split(" ");
		    Integer numberSides = Integer.valueOf(sides[0]);
		    String resul = calcular(numberSides, sides);
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

    private static String calcular(Integer numberSides, String[] sides) {
	BigInteger[] ordered = Arrays.stream(sides).skip(1).map(BigInteger::new).sorted()
		.toArray(size -> new BigInteger[size]);

	for (int i = 2; i < ordered.length; i++) {
	    if (ordered[i - 2].add(ordered[i - 1]).compareTo(ordered[i]) > 0) {
		if (ordered[i - 1].equals(ordered[i])) {
		    return ordered[0].add(ordered[i - 1]).add(ordered[i]).toString();
		} else {
		    if (i + 1 < ordered.length) {
			if (ordered[i - 2].add(ordered[i - 1]).add(ordered[i])
				.compareTo(ordered[0].add(ordered[i]).add(ordered[i + 1])) > 0) {
			    return ordered[0].add(ordered[i]).add(ordered[i + 1]).toString();
			} else {
			    return ordered[i - 2].add(ordered[i - 1]).add(ordered[i]).toString();
			}
		    } else {
			return ordered[i - 2].add(ordered[i - 1]).add(ordered[i]).toString();
		    }
		}
	    }
	}

	return "IMPOSSIBLE";
    }

    boolean esTriangulo(BigInteger a, BigInteger b, BigInteger c) {
	return a.compareTo(b) > 0;
    }

}