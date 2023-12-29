/* The MIT License (MIT)
 *
 * Copyright (c) 2015 Emir Bucalovic (embuc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package se.emirbuc.randomsentence;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.emirbuc.randomsentence.RandomSentences;
import se.emirbuc.randomsentence.RandomSentences.Length;

/**
 * RandomSentencesTest class.
 *
 * @author Emir Bucalovic (embuc)
 * @since 2015-okt-01
 */
public class RandomSentencesTest {

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
