package telran.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class StackInt {
	//Write the following methods
	//All methods should have complexity O[1]
 public LinkedList<Integer> stackInt = new LinkedList<Integer>();
 public LinkedList<Integer> stackMaxInt = new LinkedList<Integer>();


 public void push(int num) {
		stackInt.add(num);
		if (stackMaxInt.size() == 0 || num > stackMaxInt.getLast()) {
			stackMaxInt.add(num);
		}
	}
 public	int pop() {
		//returns a number from top of stack or throws NoSuchElementException
		//if the stack is empty
		if (stackInt.size() == 0) {
			throw new NoSuchElementException();
		}
		int res = stackInt.getLast();
		if (res == stackMaxInt.getLast()) {
			stackMaxInt.removeLast();
		}
		stackInt.removeLast();
		return res;
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
		return stackMaxInt.getLast();
			
		}
 }