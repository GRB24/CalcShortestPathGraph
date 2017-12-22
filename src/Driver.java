//==============================================================
// Shortest Path Program
//==============================================================
// Garrett Bates
// COSC 336 
// 5/2/2016
//--------------------------------------------------------------



import java.util.PriorityQueue;
import java.util.LinkedList;

public class Driver {

	public static void main(String[] args) {
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
		LinkedList<Integer> s = new LinkedList<Integer>();
		//list of vertices set to 1000 (infinity equivalent)
		int[] d = new int[8];
		d[1] = 1000;
		d[2] = 1000;
		d[3] = 1000;
		d[4] = 1000;
		d[5] = 1000;
		d[6] = 1000;
		d[7] = 1000;
		
		//adjacency matrix
		int[][] adj = new int[8][8];
		
		adj[1][1] = 0;
		adj[1][2] = 5;
		adj[1][3] = 1000;
		adj[1][4] = 1000;
		adj[1][5] = 7;
		adj[1][6] = 10;
		adj[1][7] = 1000;
		
		adj[2][1] = 1000;
		adj[2][2] = 0;
		adj[2][3] = 1;
		adj[2][4] = 1000;
		adj[2][5] = 3;
		adj[2][6] = 1000;
		adj[2][7] = 1000;
		
		adj[3][1] = 1000;
		adj[3][2] = 1000;
		adj[3][3] = 0;
		adj[3][4] = 6;
		adj[3][5] = 1000;
		adj[3][6] = 1000;
		adj[3][7] = 1000;
		
		adj[4][1] = 1000;
		adj[4][2] = 1000;
		adj[4][3] = 1000;
		adj[4][4] = 0;
		adj[4][5] = 1000;
		adj[4][6] = 1000;
		adj[4][7] = 1000;
		
		adj[5][1] = 1000;
		adj[5][2] = 1000;
		adj[5][3] = 1000;
		adj[5][4] = 4;
		adj[5][5] = 0;
		adj[5][6] = 2;
		adj[5][7] = 7;
		
		adj[6][1] = 1000;
		adj[6][2] = 1000;
		adj[6][3] = 1000;
		adj[6][4] = 1000;
		adj[6][5] = 1000;
		adj[6][6] = 0;
		adj[6][7] = 3;
	
		adj[7][1] = 1000;
		adj[7][2] = 1000;
		adj[7][3] = 4;
		adj[7][4] = 5;
		adj[7][5] = 1000;
		adj[7][6] = 1000;
		adj[7][7] = 0;
		
		
		//dijkstra's algorithm 
		pQ.add(1);
		d[1] = 0;
		int min;
		while (!pQ.isEmpty()) {
			min = (Integer) pQ.remove();
			
			//relax neighbors
			for (int i = 1; i < 8; i++) {
				if(adj[min][i] != 1000 && adj[min][i] != 0 && !s.contains(i)) {
					if(d[i] > d[min] + adj[min][i]) {
						d[i] = d[min] + adj[min][i];
						pQ.add(i);
						s.add(min);
					}
				}
			}
		}
		//printing of dijkstra's
		System.out.println("Dijikstra's Algorithm:\n");
		for (int i = 1; i < 8; i++) {
			System.out.println("From 1 to " + i + ": " + d[i]);
			System.out.println();
		}
		
		
//-----------------------------------------------------------------------------------------------------------

		//changes in matrix
		
		
		//test if negative cycle causes no solution
		//adj[4][1] = -10;
		
		adj[2][3] = -2;
		adj[2][5] = -2;
		adj[6][7] = -2;
		
		
		//pQ = new PriorityQueue<Integer>();
		//resets vertices values to infinity
		d[1] = 1000;
		d[2] = 1000;
		d[3] = 1000;
		d[4] = 1000;
		d[5] = 1000;
		d[6] = 1000;
		d[7] = 1000;
		  
		//pQ.add(1);
		//bellman-ford function
		d[1] = 0;
		boolean flag = true;
		
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j < 8; j++) {
				for (int k = 1; k < 8; k++) {
					if (d[k] > d[j] + adj[j][k])
						d[k] = d[j] + adj[j][k];
				}
			}		
		}
		
		for (int j = 1; j < 8; j++) {
			for (int k = 1; k < 8; k++) {
				if (d[k] > d[j] + adj[j][k])
					flag = false;;
			}
		}	
		
		while (!pQ.isEmpty()) {
			min = (Integer) pQ.remove();
			
			//relax neighbors
			for (int i = 1; i < 8; i++) {
				if(adj[min][i] != 1000 && adj[min][i] != 0 && !s.contains(i)) {
					if(d[i] > d[min] + adj[min][i]) {
						d[i] = d[min] + adj[min][i];
						pQ.add(i);
						s.add(min);
					}
				}
			}
		}
		
		//printing of bellman-ford
		System.out.println("------------------\n\nBellman-Ford Algorithm:\n");
		if (flag) {
			for (int i = 1; i < 8; i++) {
				System.out.println("From 1 to " + i + ": " + d[i]);
				System.out.println();
			}
		} else {
			System.out.println("There is no solution.");
		}
		
		
		
	}

}
