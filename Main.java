package package1;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String args[]) throws FileNotFoundException{
		//LoadText lt = new LoadText("data/input_simple_60_8000.txt");
		LoadText lt = new LoadText("data/nn.txt");
		Cities ct = lt.get();
		//print(ct);
		City first = ct.cities.get(0);
		City Origin = ct.cities.get(0);
		City temp = new City(0, 0, 0);
		ct.cities.remove(0);
		double maxDistance = 0;
		while(ct.size > 0) {
			temp = ct.findNN(first);
			maxDistance = maxDistance + distance(temp, first);
			first = temp;
		}
		maxDistance =maxDistance + distance(Origin, first);
		System.out.println("Route distance: " + maxDistance);
	}
	
	public static double distance(City a, City b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
	
	public static void print(Cities c) {
		for(City ct : c.cities) {
			System.out.print(ct.index + ", " + ct.x + ", " + ct.y);
			System.out.println("");
		}
		
	}

}
