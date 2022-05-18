import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Tutorial1 {
	public static void main(String args[]) {
		System.setProperty("org.graphstream.ui", "swing");
		
		Graph graph = new SingleGraph("Tutorial 1");

		Graph graph2 = new MultiGraph("");

		graph2.addNode("A");
		graph2.addNode("B");
		graph2.addNode("C");
		graph2.addNode("D");
		graph2.addEdge("AB", "A", "B");
		graph2.addEdge("BC", "B", "C");
		graph2.addEdge("CA", "C", "A");
		graph2.addEdge("DA", "D", "A");

		graph2.display();
	}
}