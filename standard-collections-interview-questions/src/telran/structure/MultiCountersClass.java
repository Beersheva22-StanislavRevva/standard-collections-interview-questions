package telran.structure;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class MultiCountersClass implements MultiCounters {
	HashMap<Integer, Integer> hashMap = new HashMap<>();
	TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	
	@Override
	public Integer addItem(Object item) {
		return null;
	}

	@Override
	public Integer getValue(Object item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Object> getMaxItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
