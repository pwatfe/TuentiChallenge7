package tuenti.challenge.seven.edition;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You have probably heard about bowling before, but you may not know how to score a bowling game correctly.
 * 
 * A game of bowling consists of ten frames, in which the player has the chance to knock down ten pins. The player has
 * two rolls in each frame, which means he can throw the ball twice. If the player knocks down all ten pins on the first
 * roll, they don't need a second roll for the frame. This kind of frame is called a "strike". If the player knocks down
 * some pins on the first roll and all remaining pins on the second roll (i.e.: 6 and 4), we call the frame a "spare".
 * For each frame, the player is awarded as many points as pins knocked down. For instance, if the player knocks down 3
 * and 5 pins the score awarded for the frame is 8. If the frame is a spare, the pins knocked down on the next roll are
 * awarded as a bonus. If the frame is a strike, the pins knocked down on the next two rolls are awarded as a bonus. The
 * 10th frame is a bit special: if it ends up being spare or a strike, the player gets one or two extra rolls. These
 * extra rolls are solely used to add extra points to the strike/spare and don't provide any points by themselves. Take
 * a look here for more information.
 * 
 * You have been asked to program a simple firmware for your local bowling alley. You need to calculate the score of
 * each frame based on the number of pins knocked down on each roll of a game.
 * 
 * Input
 * 
 * The first line will contain an integer C, the number of cases for our problem. Each case starts with a line with an
 * integer R, the number of rolls. A line with R integers follows, each indicating the pins knocked down in the roll Ri.
 * 
 * Output
 * 
 * For each case, a line starting with "Case #x: " followed by 10 integers separated by spaces, indicating the score of
 * each frame. Every line is followed by a new line character.
 * 
 * 
 * @author filope
 *
 */
public class Ejercicio2 {

    public static void main(String[] args) {

	Scanner input;
	PrintStream ps;
	try {
	    ps = new java.io.PrintStream("sample.output");
	    input = new Scanner(new File("src/main/resources/sample.input"));
	    int i = 1;
	    while (input.hasNext()) {
		for (int cases = new Integer(input.nextLine()); cases > 0; cases--) {
		    int numRolls = new Integer(input.nextLine());
		    String[] rolls = input.nextLine().split(" ");
		    String resul = calcular(numRolls, rolls);
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

    private static String calcular(int numRolls, String[] rolls) {

	int[] puntuacion = new int[10];
	int[] tiradas = Arrays.asList(rolls).stream().mapToInt(s -> Integer.valueOf(s)).toArray();
	int roll = 0;
	for (int frame = 0; frame < 10; frame++) {
	    roll = setearPuntos(frame, roll, tiradas, puntuacion);
	}

	StringBuffer result = new StringBuffer();
	int acumulado = 0;
	for (int i : puntuacion) {
	    acumulado += i;
	    result.append(acumulado + " ");
	}
	return result.toString().trim();
    }

    private static int setearPuntos(int frame, int roll, int[] rolls, int[] points) {
	int puntero = roll;
	int pleno = rolls[roll];
	int semipleno = roll + 1 >= rolls.length ? 0 : rolls[roll + 1];
	int extra = roll + 2 >= rolls.length ? 0 : rolls[roll + 2];
	
	if (pleno == 10) {
	    points[frame] = pleno + semipleno + extra;
	    puntero++;
	} else if (semipleno + pleno == 10) {
	    points[frame] = pleno + semipleno + extra;
	    puntero = puntero + 2;
	} else{
	    points[frame] = pleno + semipleno;
	    puntero = puntero + 2;
	}


	return puntero;
    }

}