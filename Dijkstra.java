import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/**
 * Contains all fields and methods to run Dijkstra's Algorithm
 * @author Calvin Grewal
 *
 */
public class Dijkstra implements Shorty{
	//Maps
	public HashMap<String, String> path;

	//the first node to explore
	private String startNode;
	
	
	//All lists are syncronized so each index corresponds to the same node
	//stores whether or not a node has been explored
	private ArrayList<Boolean> k;
	//stores the names of all the nodes
	private ArrayList<String> nodes;
	//stores the previous node in the path
	private ArrayList<String> pv;
	//stores the distance from the start node to each node
	private ArrayList<Double> dv;

	//the graph of nodes
	private HashMap<String, HashMap<String,Integer>> nodeDistances;
	
	/**
	 * Constructor for a Dijkstra object
	 * @param nodeDistances is the graph of nodes
	 * @param start is the start node
	 */
	public Dijkstra(HashMap<String, HashMap<String,Integer>> nodeDistances, String start){
		init(nodeDistances, start);
		run();
	}
	/**
	 * Encapsulates all of the inializing methods
	 * @param nodeDistances is the graph of nodes
	 * @param start is the start node
	 */
	private void init(HashMap<String, HashMap<String,Integer>> nodeDistances, String start){
		this.startNode = start;
		int size = nodeDistances.size();
		this.nodeDistances = nodeDistances;
		initK(size);
		initDv(size);
		initPv(size);
		initNode(nodeDistances.keySet());
	}
	/**
	 * Initializes the lists to their proper values
	 * @param size is the number of nodes in the graph
	 */
	private void initK(int size){
		k = new ArrayList<Boolean>();
		for (int i=0;i<size;i++){
			k.add(false);
		}
	}
	private void initDv(int size){
		dv = new ArrayList<Double>();
		for(int i=0;i<size;i++){
			dv.add(Double.POSITIVE_INFINITY);
		}

	}
	private void initPv(int size){
		pv = new ArrayList<String>();
		for (int i=0;i<size;i++){
			pv.add(null);
		}
	}
	private void initNode(Set<String> names){
		nodes = new ArrayList<String>();
		for (String name:names){
			nodes.add(name);
		}
	}
	/**
	 * Runs Dijkstra's algorithm
	 */
	public void run(){
		//Starts at the startNode
		int startIndex = nodes.indexOf(startNode);
		k.set(startIndex, true);
		dv.set(startIndex, 0.0);
		pv.set(startIndex, null);
		
		String next = startNode;
		
		//Loops through until all nodes have been explored
		while(next!=null){
			update(next);
			next = findMinDistance();
		}
		//makes the Path
		generatePath();
	}
	/**
	 * Updates the lists according to information from the selected node
	 * @param next is the selected node
	 */
	private void update(String next){
		//index of the node that has been selected
		int nextIndex = nodes.indexOf(next);
		//index of the node a node that is connected to the selected node
		int index;
		
		double newDistance,oldDistance;

		//Marks the selected node as explored
		k.set(nextIndex,true);

		//For each node that is connected to the selected node
		for (String node: nodeDistances.get(next).keySet()){
			//Gets the index of each node
			index = nodes.indexOf(node);
			
			//the current shortest distance from the start node to the current node
			oldDistance = dv.get(index);
			
			//calculates the new distance from the start node to the selected node + the distance from the selected node to the current node
			newDistance = dv.get(nextIndex) + nodeDistances.get(next).get(node);
			
			//only updates pv and dv if the new distance is less than the old distance
			if (newDistance<oldDistance){
				pv.set(index, next);
				dv.set(index, newDistance);
			}
		}
	}

	/**
	 * Selects the minimum distance from the graph
	 * @return returns the name of the node with the minimum distance
	 */
	private String findMinDistance(){
		//Sets the minimum index to the first node in the list which has not been explored
		int minIndex = k.indexOf(false); //the index of the minimum distance
		
		//if all all nodes have been explored it returns null
		if (minIndex == -1) return null;
		
		//Goes through the nodes and finds the smallest distance
		for (int i=1;i<dv.size();i++){
			
			if (dv.get(i)<dv.get(minIndex)&&k.get(i)!=true) minIndex = i;
		}

		return nodes.get(minIndex);

	}
	/**
	 * Creates the path
	 */
	private void generatePath(){
		path = new HashMap<String, String>();
		
		for (int i=0;i<nodes.size();i++){
			path.put(nodes.get(i),pv.get(i));
		}
	}
	/**
	 * Standard accessor and mutator methods for some fields of a Dijkstra object
	 */
	public String getStartNode(){
		return startNode;
	}
	
	public ArrayList<Boolean> getK() {
		return k;
	}
	public ArrayList<String> getNodes() {
		return nodes;
	}
	public ArrayList<String> getPv() {
		return pv;
	}
	public ArrayList<Double> getDv() {
		return dv;
	}
	public HashMap<String,String> getPath(){
		return path;
	}
	/**
	 * Prints out the important fields
	 */
	public void print(){
		System.out.println("Nodes: " + getNodes());
		System.out.println("K: " + getK());
		System.out.println("Dv: " + getDv());
		System.out.println("Pv: " + getPv());
		System.out.println("Path: " + getPath());
		System.out.println();
	}
	/**
	 * Prints out the data very nicely
	 */
	public void betterPrint(){
		//Not the greatest way to do this, but it works
		System.out.println("Node" + "   " + "K" + "      " + "Dv" + "    " + "Pv");
		
		for (int i=0;i<nodes.size();i++){
			String name = nodes.get(i);
			boolean k = this.k.get(i);
			double dv = this.dv.get(i);
			String pv = this.pv.get(i);
			System.out.print(" " + name + "    " + k + "  ");
			System.out.format("%5.1f", dv); 
			System.out.println("   "+pv);		
		}
		
		System.out.println();
		System.out.println("Path: " + getPath());
		System.out.println();
	}
	
}