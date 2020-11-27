package package1;

import java.util.LinkedList;
import java.util.List;

public class Cities {
	int size;
	List<City> cities;
	public Cities() {
		cities = new LinkedList<City>();
		System.out.println("Initializing cities");
	}
	
	public void addCity(City c) {
		cities.add(c);
		size = cities.size();
	}
	
	public City findNN(City c) {
		int nnIndex = 0;
		int index = 0;
		City nn = new City(0, 0 ,0);
		double maxDistanceSquare = Double.MAX_VALUE;
		for(City currentCity : cities) {
			double currentDistanceSquare = Math.pow((c.x - currentCity.x), 2.) + Math.pow((c.y - currentCity.y), 2.);
			if(currentDistanceSquare < maxDistanceSquare) {
				nnIndex = index;
				nn = currentCity;
				maxDistanceSquare = currentDistanceSquare;
			}
			index++;
		}
		cities.remove(nnIndex);
		size = cities.size();
		return nn;
	}
	
}
