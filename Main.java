import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();
		//makes a sample graph 
		g.makeGraph();
		
		//To make a custom graph,  use the HashMap below
		HashMap<String, HashMap<String,Integer>> customMap = new HashMap<String, HashMap<String, Integer>>();
		
		Dijkstra d = new Dijkstra(g.getNodeDistances(),"G");
		//prints out the data from the Dijkstra object
		d.betterPrint();
		
		//Destination can be changed to any node in the graph
		String destination = "E";
		ArrayList<String> next =  Shorty.next(destination, d);
		System.out.println("Path to "+ destination + ": "+ next);
	}
}
