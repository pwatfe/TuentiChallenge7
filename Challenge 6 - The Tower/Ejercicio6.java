package tuenti.challenge.seven.edition;

import java.io.File;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author filope
 *
 */
public class Ejercicio6 {

    public static void main(String[] args) {

	Scanner input;
	PrintStream ps;
	try {
	    ps = new java.io.PrintStream("sample.output");
	    input = new Scanner(new File("src/main/resources/sample.input"));
	    int i = 1;
	    while (input.hasNext()) {
		for (int cases = new Integer(input.nextLine()); cases > 0; cases--) {
		    String[] floor = input.nextLine().split(" ");
		    String min = "0";
		    if (floor.length == 2) {
			Integer numberFloors = new Integer(floor[0]);
			Integer numberShortcuts = new Integer(floor[1]);
			Dijkstra dijkstraAlgorithm = inicializaMatriz(numberFloors);
			for (int j = 0; j < numberShortcuts; j++) {
			    String[] shortcut = input.nextLine().split(" ");
			    Integer origen = Integer.valueOf(shortcut[0]) - 1;
			    Integer destino = Integer.valueOf(shortcut[1]) - 1;
			    for (int k = 0; k <= origen; k++) {
				    dijkstraAlgorithm.addEdge(k, destino ,
					    new BigInteger(shortcut[2]));
			    }
	
			}
			dijkstraAlgorithm.dijkstra(0);
			min = dijkstraAlgorithm.getDestino(numberFloors-1);
		    }
		    System.out.println("Case #" + i + ": " + min);
		    ps.println("Case #" + i + ": " + min);
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

    private static Dijkstra inicializaMatriz(Integer numberFloors) {
	Dijkstra dijkstraAlgorithm = new Dijkstra(numberFloors);
	for (int i = 0; i < numberFloors - 1; i++) {
	    dijkstraAlgorithm.addEdge(i, i + 1, BigInteger.valueOf(i+1));
//	    dijkstraAlgorithm.addEdge(i + 1, i, BigInteger.ZERO);
	}
	return dijkstraAlgorithm;
    }

}

class Dijkstra {

    private List<List<Node>> adyacentes = new ArrayList<List<Node>>(); // lista de adyacencia
    private Map<Integer, BigInteger> distancia = new HashMap<>(); // distancia[ u ] distancia de vértice inicial a
								  // vértice con
    // ID = u
    private Map<Integer, Boolean> visitado = new HashMap<>(); // para vértices visitados
    private PriorityQueue<Node> cola = new PriorityQueue<Node>(); // priority queue propia de Java, usamos el
							       // comparador definido para que el de menor valor
							       // este en el tope
    private int V; // numero de vertices

    Dijkstra(int V) {
	this.V = V;
	for (int i = 0; i < V; ++i)
	    adyacentes.add(new ArrayList<Node>()); // inicializamos lista de adyacencia
    }

    // En el caso de java usamos una clase que representara el pair de C++
    class Node implements Comparable<Node> {
	int first;
	BigInteger second;

	Node(int d, BigInteger bigInteger) { // constructor
	    this.first = d;
	    this.second = bigInteger;
	}

	public int compareTo(Node other) { // es necesario definir un comparador para el correcto funcionamiento del
					   // PriorityQueue
	    if (second.compareTo(other.second) > 0)
		return 1;
	    if (second.equals(other.second))
		return 0;
	    return -1;
	}
    };

    // Paso de relajacion
    private void relajacion(int actual, int adyacente, BigInteger peso) {
	// Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al
	// vertice adyacente
	if (distancia.get(adyacente) == null) {
	    distancia.put(adyacente, distancia.get(actual).add(peso)); // relajamos el vertice actualizando la distancia
	    cola.add(new Node(adyacente, distancia.get(adyacente))); // agregamos adyacente a la cola de prioridad
	} else if (distancia.get(actual) != null && distancia.get(actual).add(peso).compareTo(distancia.get(adyacente)) < 0) {
	    //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
	    distancia.put(adyacente, distancia.get(actual).add(peso)); // relajamos el vertice actualizando la distancia
	    cola.add(new Node(adyacente, distancia.get(adyacente))); // agregamos adyacente a la cola de prioridad
	}
    }

    void dijkstra(int inicial) {
	cola.add(new Node(inicial, BigInteger.ZERO)); // Insertamos el vértice inicial en la Cola de Prioridad
	distancia.put(inicial, BigInteger.ZERO); // Este paso es importante, inicializamos la distancia del inicial como
						 // 0
	int actual, adyacente;
	BigInteger peso;
	while (!cola.isEmpty()) { // Mientras cola no este vacia
	    actual = cola.element().first; // Obtengo de la cola el nodo con menor peso, en un comienzo será el inicial
	    cola.remove(); // Sacamos el elemento de la cola
	    if (visitado.get(actual) != null && visitado.get(actual)) {
		continue; // Si el vértice actual ya fue visitado entonces sigo sacando elementos de la cola
	    }
	    visitado.put(actual, true); // Marco como visitado el vértice actual

	    for (int i = 0; i < adyacentes.get(actual).size(); ++i) { // reviso sus adyacentes del vertice actual
		adyacente = adyacentes.get(actual).get(i).first; // id del vertice adyacente
		peso = adyacentes.get(actual).get(i).second; // peso de la arista que une actual con adyacente ( actual , adyacente )
						      
		if (visitado.get(adyacente) == null || !visitado.get(adyacente)) { // si el vertice adyacente no fue
										   // visitado
		    relajacion(actual, adyacente, peso); // realizamos el paso de relajacion
		}
	    }
	}

//	System.out.printf("Distancias mas cortas iniciando en vertice %d\n", inicial);
//	for (int i = 0; i < V; ++i) {
//	    System.out.printf("Vertice %d , distancia mas corta = %d\n", i, distancia.get(i));
//	}
    }

    void addEdge(int origen, int destino, BigInteger bigInteger) {
	adyacentes.get(origen).add(new Node(destino, bigInteger)); // grafo diridigo
    }

    // Impresion del camino mas corto desde el vertice inicial y final ingresados
    String getDestino(int destino) {
	return distancia.get(destino).toString();

    }

    public int getNumberOfVertices() {
	return V;
    }

    public void setNumberOfVertices(int numeroDeVertices) {
	V = numeroDeVertices;
    }
}
