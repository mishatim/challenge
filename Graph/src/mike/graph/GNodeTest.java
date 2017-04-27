package mike.graph;

public class GNodeTest {

	public static void main(String[] args) {

		GNode A = new GNodeImpl("A");
		GNode B = new GNodeImpl("B");
		GNode C = new GNodeImpl("C");
		GNode D = new GNodeImpl("D");
		GNode E = new GNodeImpl("E");
		GNode F = new GNodeImpl("F");
		GNode G = new GNodeImpl("G");
		GNode H = new GNodeImpl("H");
		GNode I = new GNodeImpl("I");
		GNode J = new GNodeImpl("J");
		GNode K = new GNodeImpl("K");
		GNode L = new GNodeImpl("L");

		// create a graph
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);

		B.addChild(E);
		B.addChild(F);

		C.addChild(G);
		C.addChild(H);
		C.addChild(I);

		D.addChild(J);
		D.addChild(K);

		K.addChild(L);
		

		// exercise the graph
		System.out.println("Node list from node: A");
		System.out.println(A.walkGraph(A));

		System.out.println("\nNode list from node: B");
		System.out.println(B.walkGraph(B));

		System.out.println("\nPath list from node: A");
		System.out.println(A.paths(A));


	}
}