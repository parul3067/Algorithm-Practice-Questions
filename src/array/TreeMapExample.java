package array;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

class MyComparator implements Comparator<Map.Entry<Integer,String>> {
	
	@Override
	public int compare(Map.Entry<Integer,String> first, Map.Entry<Integer,String> second) {
		return first.getValue().compareTo(second.getValue());
	}
}

public class TreeMapExample {

	
	private static Map<Integer,String> sortByValue(Map<Integer,String> map) {
		Map<Integer,String> sortedMap = new LinkedHashMap<Integer,String>();
		List<Map.Entry<Integer,String>> list = new ArrayList<Map.Entry<Integer,String>>(map.entrySet());
		Collections.sort(list, new MyComparator());
		
		for(Map.Entry<Integer, String> e : list) {
			sortedMap.put(e.getKey(), e.getValue());
		}
		
		return sortedMap;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> map = new TreeMap<Integer,String>();
		map.put(2,"two");
		map.put(4,"four");
		map.put(1,"one");
		map.put(5,"five");
		
		Map<Integer,String> sortmap = sortByValue(map);
		
		Iterator itr = sortmap.keySet().iterator();
		while(itr.hasNext()) {
			System.out.println("value : "+map.get(itr.next()));
		}
	}

}
