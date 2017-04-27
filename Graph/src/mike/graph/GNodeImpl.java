package mike.graph;

import java.util.ArrayList;

public class GNodeImpl implements GNode {

	protected String name;
	protected ArrayList<GNode> children = new ArrayList<GNode>();
	private ArrayList<GNode> allNodes = new ArrayList<GNode>();
	private ArrayList<ArrayList<GNode>> allPaths = new ArrayList<ArrayList<GNode>>();
	private ArrayList<GNode> path = new ArrayList<GNode>();


	public GNodeImpl(String name) {
		this.name = name;
	}

	public void addChild(GNode node) {
		children.add(node);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public GNode[] getChildren() {
		// returns empty array if no children
		return children.toArray(new GNode[children.size()]);
	}

	public boolean hasChildren() {
		return children.size() > 0;
	}

	public String toString() {
		return name;
	}

	/**
	 * Return all nodes in the graph.
	 * Recursively visit every child node in the graph.
	 * @param nd
	 * @return
	 */
	public ArrayList<GNode> walkGraph(GNode nd) {

		if (nd.hasChildren()) {
			for (GNode n : nd.getChildren()) {
				allNodes.add(n);
				walkGraph(n);
			}
		}
		return allNodes;
	}

	/**
	 * Return all paths in the graph.
	 * Depth first search approach. Recursively visit every child.
	 * When reached child who's a leaf, record the path.
	 */
	public ArrayList<ArrayList<GNode>> paths(GNode node) {
		path.add(node);
		for (GNode kid : node.getChildren()) {
			paths(kid);
		}
		// add path only when on a leaf node
		if (!node.hasChildren()) {
			allPaths.add(new ArrayList<GNode>(path));
		}
		path.remove(path.size() - 1);
		return allPaths;
	}
}
