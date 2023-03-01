package telran.structure;

import java.util.*;


public class WordsImpl implements Words {
HashMap<String, String> map = new HashMap<>();
	
	@Override
	public boolean addWord(String word) {
	boolean res = false;
	String key = word.toUpperCase();
	if (map.get(key) == null) {
		map.put(key, word);
		res = true;
	}
	return res;
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
	String prefix1 = prefix.toUpperCase();
	List<String> list = map.keySet().stream().filter(n -> n.startsWith(prefix1)).map(n -> map.get(n)).toList();
	return list;
	}

	@Override
	public void displayAllWords() {
		map.values().stream().forEach(n -> System.out.println(n));
	}

}
