package telran.util;
import java.util.*;
public class StackInt {
	LinkedList<Integer> numbers = new LinkedList<>();
	LinkedList<Integer> maxNumbers = new LinkedList<>();
	//Write the following methods
	//All methods should have complexity O[1]
	void push(int num) {
		numbers.addLast(num);
		if (maxNumbers.isEmpty() || num >= maxNumbers.getLast()) {
			maxNumbers.addLast(num);
		}
	}
	int pop() {
		//returns a number from top of stack or throws NoSuchElementException
		//if the stack is empty
		int num = numbers.removeLast();
		if(num == maxNumbers.getLast()) {
			maxNumbers.removeLast();
		}
		return num;
	}
	boolean isEmpty () {
		//returns true if the stack is empty, otherwise false
		return numbers.isEmpty();
	}
	int getMax() {
		//returns maximal value of the stack or throws NoSuchElementException
		//if the stack is empty
		return maxNumbers.getLast();
	}
}