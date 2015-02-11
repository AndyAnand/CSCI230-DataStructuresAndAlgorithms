
//Four ways to iterate through a list of items...

import java.util.ArrayList;
	import java.util.Iterator;
	 
	public class IteratorTest {
		
	    public static void main(String[] args) {

	        ArrayList<String> cityList = new ArrayList<String>();
	 
	        cityList.add("Charleston");
	        cityList.add("Tartu");
	        cityList.add("Amsterdam");
	        cityList.add("Paris");
	        	 
	        //Method #1 : use a for loop
	        System.out.println("\nFor loop");
	        for (int i = 0; i < cityList.size(); i++) {
	            System.out.println(cityList.get(i));
	        }
	 
	        //Method #2 : use a for each loop
	        System.out.println("\nFor each loop");
	        for (String city : cityList) {
	            System.out.println(city);
	        }
	 
	        //Method #3 : use an iterator object and a while loop
	        System.out.println("\nIterator to control while loop");
	        Iterator iterator = cityList.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	        }
	 
	        //Method #4 : use a while loop
	        System.out.println("\nWhile loop based on list size");
	        int index = 0 ;
	        while (cityList.size()> index) {
	            System.out.println(cityList.get(index));
	            index++ ;
	        }
	    }
	}
