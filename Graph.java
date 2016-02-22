import java.util.*;
/**
 * Defines a Graph of nodes
 * @author Calvin Grewal
 */
public class Graph {
	//Stores the distances between the nodes
	private HashMap<String, HashMap<String, Integer>> nodeDistances;
	
	/**
	 * Constructor for a Graph object that initializes the adjacency list
	 */
	public Graph(){
		nodeDistances = new HashMap<String,HashMap<String,Integer>>();
	}
	
	/**
	 * Gets the distance between two nodes
	 * @param start is a node
	 * @param end is the other node
	 * @return returns the distance between the two nodes, or -1 if they do not connect
	 */
	public int getDistance(String start, String end){
		return nodeDistances.get(start).containsKey(end) ? nodeDistances.get(start).get(end):-1;
	}
	
	/**
	 * Sets the distance between two nodes
	 * @param start is a node
	 * @param end is the other node
	 */
	public void setDistance(String start, String end, int distance){
		nodeDistances.get(start).put(end, distance);
	}
	
	/**
	 * Makes the graph shown on the "presentation stolen from the web"
	 */
	public void makeGraph(){
		HashMap<String, Integer> nodeADistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeBDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeCDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeDDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeEDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeFDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeGDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeHDistances = new HashMap<String, Integer>();
		
		nodeADistances.put("F", 10);
		nodeADistances.put("B", 8);
		
		nodeBDistances.put("C", 4);
		nodeBDistances.put("E", 10);
		
		nodeCDistances.put("D", 3);
		
		nodeDDistances.put("E", 25);
		nodeDDistances.put("F", 18);
		
		nodeEDistances.put("D", 9);
		nodeEDistances.put("G", 7);
		
		nodeFDistances.put("B", 7);
		nodeFDistances.put("A", 5);
		nodeFDistances.put("C", 3);
		nodeFDistances.put("E", 2);
		
		nodeGDistances.put("H", 3);
		nodeGDistances.put("D", 2);
		
		nodeHDistances.put("A", 4);
		nodeHDistances.put("B", 9);
		
		nodeDistances.put("A", nodeADistances);
		nodeDistances.put("B", nodeBDistances);
		nodeDistances.put("C", nodeCDistances);
		nodeDistances.put("D", nodeDDistances);
		nodeDistances.put("E", nodeEDistances);
		nodeDistances.put("F", nodeFDistances);
		nodeDistances.put("G", nodeGDistances);
		nodeDistances.put("H", nodeHDistances);
	}
	
	/**
	 * Accessor method for nodeDistances
	 * @return returns nodeDistances
	 */
	public HashMap<String, HashMap<String, Integer>> getNodeDistances(){
		return nodeDistances;
	}

}
