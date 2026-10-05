package day8;

public class GraphMatrix {
	
	static class Graph {
		int[][] graph;
		
		public Graph(int vertices) {
			graph = new int[vertices][vertices];
		}
		
		public void addEdge(int source, int destination, int weight) {
			graph[source][destination] = weight;
//			graph[destination][source] = weight; // For directed graph
		}
		
		public void display() {
			for(int i = 0; i < graph.length; i++) {
				for(int j = 0; j < graph[i].length; j++) {
					System.out.print(graph[i][j] + "  ");
				}
				System.out.println();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Graph graph = new Graph(5);
		
		graph.addEdge(0, 4, -1);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 2, 4);
		graph.addEdge(3, 1, -5);
		graph.addEdge(4, 0, 3);
		
		
		graph.display();
		
	}
	
}
