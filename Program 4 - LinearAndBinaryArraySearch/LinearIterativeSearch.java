/**
 * This class is an implementation of a iterative linear search algorithm.
 * 
 * @author Andy Gajadhar
 * @since September 23, 2014
 *
 */
public class LinearIterativeSearch extends SearchAlgorithm{

	@Override
	public int search(Integer[] a, Integer value) {
		// TODO Auto-generated method stub
		ExecutionTimer s = new ExecutionTimer();
		int answer;
		
		s.start();
		answer = letSearch(a, value);
		s.stop();
		
		System.out.println("Found it in "+s.durationInSeconds()+" using linear search with iteration.");
		
		return answer;
	}
	
	/**
	 * created just for encapsulating searching for measuring the time inside this class, not outside
	 * @param a
	 * @param value
	 * @return
	 */
	
	private int letSearch(Integer[] a, Integer value){
		for(int i = 0; i < a.length; i++){
			if(a[i].intValue() == value.intValue())
				return i;
		}
		
		return -1;
	}
}
