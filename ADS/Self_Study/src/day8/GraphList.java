package day8;

import java.util.ArrayList;

public class GraphList {
	static class Graph {
		ArrayList<Integer>[] graph;
		
		public Graph(int vertices) {
			graph = new ArrayList[vertices];
			
			for(int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
		}
		
		public void addEdge(int source, int destination) {
			graph[source].add(destination);
			graph[destination].add(source);
		}
		
		public void display() {
			for(int i = 0; i < graph.length; i++) {
				
				System.out.print(i + " -> ");
				
				for(int vertex : graph[i]) {
					System.out.print(vertex + " ");
				}
				
				System.out.println();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Graph graph = new Graph(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		
		
		graph.display();
		
	}
}
