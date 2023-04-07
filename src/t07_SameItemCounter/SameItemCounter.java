package t07_SameItemCounter;
import java.util.ArrayList;
import java.util.List;

public class SameItemCounter {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(List.of("Pen", "Cat", "Dog", "Blue", "White", "Dog", "Pen", "Blue",
				"Yellow", "Pen", "Cat", "Dog", "Blue", "White", "Dog", "Pen", "Blue", "Yellow"));

		List<Integer> countList = new ArrayList<>();
	
		for (int i = 0; i < list.size(); i++) {
			int count = 1;

			for (int j = i + 1; j < list.size(); j++) {
				if(list.get(i).equals(list.get(j))) {
					count++;
					list.remove(j);
				}
			}
			countList.add(count);			
		}
		
		for(int i=0; i<list.size();i++) {
			System.out.println(String.format("%s\t: %d", list.get(i), countList.get(i)));
		}

	}
}
