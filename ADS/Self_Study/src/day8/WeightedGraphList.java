package day8;

import java.util.ArrayList;

public class WeightedGraphList {

	static class Edge {
		int source;
		int destination;
		int weight;
		
		public Edge(int src, int dest, int weight) {
			this.source = src;
			this.destination = dest;
			this.weight = weight;
		}
	}
	
	static class Graph {
		ArrayList<ArrayList<Edge>> graph;
		
		public Graph(int vertices) {
			graph = new ArrayList<>();
			
			for(int i = 0; i < vertices; i++) {
				graph.add(new ArrayList<>());
			}
		}
		
		public void addEdge(int src, int dest, int weight) {
			graph.get(src).add(new Edge(src, dest, weight));
			graph.get(dest).add(new Edge(dest, src, weight));
		}
		
		public void display() {
			for(int i = 0; i < graph.size(); i++) {
				System.out.print(i + " -> ");
				for(Edge edge : graph.get(i)) {
					System.out.print("(" + edge.source + ", " + edge.destination + ", " + edge.weight + ")");
				}
				System.out.println();
			}
		}
		
	}
	
	public static void main(String[] args) {

		Graph graph = new Graph(5);
		
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 10);
		graph.addEdge(0, 3, 7);
		graph.addEdge(1, 3, 3);
		graph.addEdge(1, 4, 5);

		graph.display();
	}

}
