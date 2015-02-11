/**
 * This class works as stopwatch for measuring the execution time of blocks of code 
 * 
 * @author Dr. Christopher Starr , adapted by Andy Gajadhar
 * @since September 14, 2014
 * 
 * NOTE: Downloaded from: OAKS, just changed the name of the method end() to stop() and created durationInMilliseconds
 * method for using it to accomplish the Program 3 requirements 
 */
public class ExecutionTimer {
	  private long start;
	  private long end;

	  public ExecutionTimer() {
	    reset();
	  }

	  public void start() {
	    start = System.currentTimeMillis();
	  }

	  public void stop() {
	    end = System.currentTimeMillis();
	  }

	  public double durationInSeconds(){
	    return ((end-start)/1000.0);
	  }
	  
	  public double durationInMilliseconds(){
	    return end-start;
	  }

	  public void reset() {
	    start = 0;  
	    end   = 0;
	  }
	}