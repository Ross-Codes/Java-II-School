/**
 * MapExample is an example of the use of an HashMap
 * @author ddalsveen
 */
import java.util.*;
public class MapExample {

 /**
  * main method
  * @param String[] args (input arguments are  the keys)
  */

  public static void main(String args[]) {

    Map map = new HashMap();
    // store the frequency of occurance as an Integer object 
    Integer ONE = new Integer(1);

    for (int i=0, n=args.length; i<n; i++) {
      String key = args[i];
      Integer frequency = (Integer)map.get(key);
      // If the key/ value pair does not exist, set frequency to 1
      if (frequency == null) {
        frequency = ONE;
      } else {
        int value = frequency.intValue();
        frequency = new Integer(value + 1);
      }
      map.put(key, frequency);
    }
    System.out.println(map);

    // The map in sorted fashion
    Map sortedMap = new TreeMap(map);
    System.out.println(sortedMap);
    
  }
}