package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.*;
import telran.structure.*;

class WordsTest {

	@Test
	void addWordTest() {
		Words words = new WordsImpl();
		assertTrue(words.addWord("Mother"));
		assertFalse(words.addWord("mother"));
		assertTrue(words.addWord("Father"));
		assertFalse(words.addWord("FATHER"));
		words.displayAllWords();
		}
	
	@Test
	void getWordsByPrefixTest() {
		Words words = new WordsImpl();
		words.addWord("Mother");
		words.addWord("Mommy");
		words.addWord("Mom");
		words.addWord("Father");
		List<String> list = words.getWordsByPrefix("mo");
		list.stream().forEach(n -> System.out.println(n));
	}

}
