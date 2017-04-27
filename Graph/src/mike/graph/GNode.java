package mike.graph;

import java.util.ArrayList;

public interface GNode {

	public String getName();
    public GNode[] getChildren();
    public boolean hasChildren();
    public void addChild(GNode node);
    public ArrayList<GNode> walkGraph(GNode nd);
    public ArrayList<ArrayList<GNode>> paths(GNode node);
}
