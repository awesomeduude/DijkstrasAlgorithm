Dijkstra’s Algorithm README	Calvin Grewal

Introduction
	Dijkstra’s algorithm is an algorithm that finds the shortest path between two nodes on a graph. This implementation also implements an interface that contains a method that can return the shortest path to a specified node. Dijkstra’s algorithm has many use cases, as there are many places in the world that can be traveled.

Specification 
	My project fully fulfills the specifications listed on the project assignment. First, my project implements a class called Dijkstra which has a constructor takes hash map that maps a string to a hash map which maps a string to an integer. This constructor also takes in a string that represents a start node. Second, my code produces a hash map called path which represents the shortest path. Third, my code implements a next() method, which produces an array list that corresponds to the shortest path to a node.

Errors
	Currently, there are no known errors or bugs in the code, it runs as intended.

Overview of Code
	My program contains four files. First is the Dijkstra class. This class represents an object that stores an adjacency list representation of a graph, a list of nodes in the graph, whether or not each node has been explored, the shortest distance to each node from the start node, and the previous node in the path to each node. All indexes on all four of the lists correspond to the same node, so index 3 on the nodes list corresponds to the same node as index 3 on the distances list. In order to store this data, this class also runs Dijkstra’s algorithm. It contains many helper methods to help with this task. The main method that runs the algorithm is called run().
	The second class is the Graph class. This class is an adjacency list representation of a graph. This is achieved using a hash map that maps a string to a hash map that maps a string to an int. The main use of this class is to generate a graph that is used to run Dijkstra’s algorithm. Because of the project specifications, only the adjacency list representation is passed into a Dijkstra, rather than a Graph object. The makeGraph() method creates the graph listed on the “stolen from the web” powerpoint presentation.
	The third file is the Shorty interface. This interface contains a static method called “next” which returns an array list of the path to a specified node. This interface is implemented in the Dijkstra class.
	Lastly, is the Main class. This class creates a new Dijkstra object and prints out the data in a readable, formatted way.

Major Challenges
	My major challenge with this project was wrapping my head around how Dijkstra’s algorithm works, as well as how to use a hash map inside of another hash map. It took me a while to figure our how to use this data structure, but after I figured it out, it wasn’t problematic. I had some minor issues and bugs that were caused by bad coding practices, but I fixed those pretty easily. Overall, this project was very fun and interesting, and I think I learned a lot from it. Not only did I learn about new data structures, but I also learned how to break a big project into smaller parts.

Acknowledgements
	I did almost all of the work myself, but I did receive some help. First, my classmate Antoine helped me with printing out the data in a formatted way. Second, Mr. Kuszmaul helped me understand Dijkstra’s algorithm, and provided the basic code for the project. Lastly, I used the Java Documentation on the oracle many times to search up useful methods and other small things.
