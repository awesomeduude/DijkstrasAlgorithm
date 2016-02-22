import java.util.ArrayList;
/**
 * An interface specified by the project requirements
 * @author Calvin Grewal
 */
public interface Shorty {
	/**
	 * Returns the path from the start node to a destination node
	 * @param node is the final, destination node
	 * @param d is a Dijkstra object that contains the final node
	 * @return returns an ArrayList containing the path to the final node
	 */
	static ArrayList<String> next(String destination, Dijkstra d){
		ArrayList<String> path = new ArrayList<String>();
	
		//the last node in the path is the destination node
		path.add(destination);
		
		//keeps on backtracking and adding nodes to the path until the start node is reached
		while(!d.getNodes().get(d.getNodes().indexOf(path.get(0))).equals(d.getStartNode())){//While the previous node isn't the start node
			//Adds the previous node of the first node in the path
			path.add(0,d.getPv().get(d.getNodes().indexOf(path.get(0))));
		}
		
		return path;
	}
}
