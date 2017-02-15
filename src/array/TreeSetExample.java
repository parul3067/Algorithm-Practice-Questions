package array;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashSet;
import java.util.LinkedHashSet;


public class TreeSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		set.add(19);
		set.add(3);
		set.add(1);
		set.add(4);
		set.add(2);
		
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println("1st element "+itr.next());
		}
		
	}

}
