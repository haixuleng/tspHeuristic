package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadText {
	String fileToLoad;
	int length = 0;
	// First line of the file stores the number of vertexes from the test file
	public LoadText(String fileName) throws FileNotFoundException {
		fileToLoad = fileName;
		System.out.println(fileName);
		size();
	}

	public void size() throws FileNotFoundException {
		int size = 0;
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			size ++;
			myReader.nextLine();
			//System.out.println("Length of Input: " + size);
		}
		//myReader.close();
		length = size;
		System.out.println("Length of Input: " + size);
	}

	public Cities get() throws FileNotFoundException {
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		Cities initData = new Cities();
		int index = 0;
		while(myReader.hasNextLine()) {
			String data = myReader.nextLine().strip();
			if(index < 1) {
				index ++;
				continue; // starting line
			}
			String[] values = data.split("\\s");
			City c = new City(Integer.parseInt(values[0]), Double.parseDouble(values[1]), Double.parseDouble(values[2]));
			initData.addCity(c);
		}
		myReader.close();
		return initData;
	}
}