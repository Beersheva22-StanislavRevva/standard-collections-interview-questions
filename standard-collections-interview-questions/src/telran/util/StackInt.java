package telran.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class StackInt {
	//Write the following methods
	//All methods should have complexity O[1]
 public LinkedList<Integer> stackInt = new LinkedList<Integer>();


 public void push(int num) {
		stackInt.add(num);
	}
 public	int pop() {
		//returns a number from top of stack or throws NoSuchElementException
		//if the stack is empty
		if (stackInt.size() == 0) {
			throw new NoSuchElementException();
		}
		return stackInt.getLast();
	}
 public boolean isEmpty () {
		//returns true if the stack is empty, otherwise false
		return stackInt.size() == 0;
	}
	
 public int getMax() {
		//returns maximal value of the stack or throws NoSuchElementException
		//if the stack is empty
		if (stackInt.size() == 0) {
			throw new NoSuchElementException();
		}
		int res = stackInt.getFirst();
		Integer e;
		Iterator<Integer> it = stackInt.listIterator();
		while (it.hasNext()) {
		e = (Integer) it.next();
			if (e.intValue() > res) {
				res = e;
			}
		}
		
		return res;
	}
 
 public int getMaxV2() {
	//returns maximal value of the stack or throws NoSuchElementException
	//if the stack is empty
	if (stackInt.size() == 0) {
			throw new NoSuchElementException();
		}
	Integer res = stackInt.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
	return res;
 }
}