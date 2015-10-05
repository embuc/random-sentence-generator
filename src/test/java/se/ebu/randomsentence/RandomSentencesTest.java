package se.ebu.randomsentence;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.ebu.randomsentence.RandomSentences.Length;

/**
 * RandomSentencesTest class.
 *
 * @author Emir Bucalovic (embuc)
 * @since 2015-okt-01
 */
@SuppressWarnings("javadoc")
public class RandomSentencesTest {

	@Test
	public void type() {
		assertThat(RandomSentences.class, notNullValue());
	}

	@Test
	public void instantiation() {
		RandomSentences target = new RandomSentences();
		assertThat(target, notNullValue());
	}

	@Test
	public void generateRandomSentence_WithArgument_Null() {
		Length length = null;
		String actual = RandomSentences.generateRandomSentence(length);
		assertNotNull(actual);
	}

	@Test
	public void generateRandomSentence_WithArgument_ShortLength() {
		Length length = Length.SHORT;
		String actual = RandomSentences.generateRandomSentence(length);
		assertNotNull(actual);
		String[] words = actual.split(" ");
		assertTrue(words.length >= 3);
	}

	@Test
	public void generateRandomSentence_WithArgument_MediumLength() {
		Length length = Length.MEDIUM;
		String actual = RandomSentences.generateRandomSentence(length);
		assertNotNull(actual);
		String[] words = actual.split(" ");
		assertTrue(words.length >= 6);
	}

	@Test
	public void generateRandomSentence_WithArgument_LongLength() {
		Length length = Length.LONG;
		String actual = RandomSentences.generateRandomSentence(length);
		assertNotNull(actual);
		String[] words = actual.split(" ");
		assertTrue(words.length >= 12);
	}

	@Test
	@SuppressWarnings("boxing")
	public void testRandomLengthWithUpperLimit_0() {
		int length = 0;
		int actual = RandomSentences.rand(length);
		int expected = 0;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void testRandomLengthWithUpperLimit_10() {
		int length = 10;
		int actual = RandomSentences.rand(length);
		assertTrue(actual >= 0);
		assertTrue(actual <= 10);
	}

}
