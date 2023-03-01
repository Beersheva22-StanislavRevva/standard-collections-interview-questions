package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
class StandardCollectionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void SubListtest() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,70,-20));
		list.add(5);
		List<Integer> listSub = list.subList(6, 9);
		
		System.out.println(listSub);
		listSub.add(1, -2);
		listSub.sort(Integer::compare);
		listSub.clear();
		System.out.println(list);
		
	}
	@Test
	@Disabled
	void displayOccurrencesCount() {
		String [] strings = {"lmn", "abc", "abc", "lmn", "a", "lmn"};
		Arrays.stream(strings)
				.collect(Collectors.groupingBy(s -> s,Collectors.counting()))
				.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
		
		
	}
	@Test
	@Disabled
	void displayDigitStatistics() {
		//Generate 1000000 random numbers [1-Integer.MAX_VALUE)
		//Display digits and counts of their occurrences in descending order of the counts
		//consider using flatMap for getting many from one
		new Random().ints(1_000_000, 1, Integer.MAX_VALUE)
		.flatMap(n -> Integer.toString(n).chars()).boxed()
		.collect(Collectors.groupingBy(digit -> digit, Collectors.counting()))
		.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e -> System.out.printf("%d: %d\n",   e.getKey() - '0', e.getValue()));
		;
	}
	@Test
	void maxNumberWithNegativeImageTest() {
		int ar[] = {10000000, 3, -2, 200, -200, -3, 2};
		int ar1[] = {1000000, -1000000000, 3, -4};
		assertEquals(200, maxNumberWithNegativeImage(ar));
		assertEquals(-1, maxNumberWithNegativeImage(ar1));
		
		
	}
	int maxNumberWithNegativeImage(int array[]) {
		//return maximal positive number having it negative image or -1 if none such numbers
		ArrayList<Integer> positiveNumbers = new ArrayList<>();
		ArrayList<Integer> negativeNumbers = new ArrayList<>();
		int maxValue = -1;
		for(int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				positiveNumbers.add(array[i]);
				 if (negativeNumbers.contains(-array[i]) && array[i] > maxValue ) {
					 maxValue = array[i];
				 }
			}
			if (array[i] < 0) {
				negativeNumbers.add(array[i]);
				if (positiveNumbers.contains(-array[i]) && - array[i] > maxValue ) {
					 maxValue = -array[i];
				 }
			}
				
		}
		return maxValue;
	}
	@Test
	void treeIteratingTest() {
		Integer array[] = {1, 11, 111, 32, 9, 1234, 99, 992};
		Integer example[] = {992, 99, 1234, 9, 32, 111, 11, 1};
		assertArrayEquals(example,createAndIterateTreeInOrder(array));
	}

	private Integer[] createAndIterateTreeInOrder(Integer array[]) {
		//create tree, add in tree numbers from a given array
		//and iterate in the order of array defined in 69
		
		TreeSet<Integer> treeSet = new TreeSet<>((x,y) -> {
		Integer sumX = 0;
		Integer sumY = 0;
		while (x != 0) {
			sumX += x%10;
			x /= 10;
		}
		while (y != 0) {
			sumY += y%10;
			y /= 10;
		}
		return Integer.compare(sumX, sumY);
		});
		Integer resultArray [] = new Integer[array.length]; 
		for (int i = 0; i < array.length; i++) {
			treeSet.add(array[i]);
		}
		Iterator <Integer> it = treeSet.descendingIterator();
		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = it.next();
		}
		return resultArray;
		}
	
}
	