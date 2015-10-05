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
package se.ebu.randomsentence;

import java.util.Random;

/**
 * <code>RandomSentences</code> is the simple tool that generates random 'almost english' sentences.
 * Purpose is the to generate somewhat funnier test data. Replaces 'Lorem ipsum' stuff.
 *
 * @author Emir Bucalovic (embuc)
 * @since 2015-sep-25
 */
public class RandomSentences {

	private final static String SPACE = " ";
	private final static String PERIOD = ".";

	private static final Random r = new Random();

	/**
	 * The <code>Enum Length</code>.
	 *
	 * @author Emir Bucalovic (embuc)
	 * @since 2015-okt-05
	 */
	public enum Length {
		/** Three word sentence, think 'title | name | short description'*/
		SHORT, 
		/** Six word sentences.*/
		MEDIUM, 
		/** Twelve word sentences, think 'description'.*/
		LONG
	}

	/**
	 * Produces one random sentence with supplied length.
	 * @param length
	 * @return sentence as a String
	 */
	public static String generateRandomSentence(Length length) {
		if (length == null) {
			length = Length.SHORT;
		}
		StringBuilder sb = new StringBuilder();
		String first = Grammar.ARTICLE[rand(Grammar.ARTICLE.length - 1)];
		char c = first.charAt(0);
		first = first.replace(c, Character.toUpperCase(c));
		sb.append(first);
		sb.append(SPACE);
		sb.append(Grammar.NOUN[rand(Grammar.NOUN.length - 1)]);
		sb.append(SPACE);
		sb.append((Grammar.VERB[rand(Grammar.VERB.length - 1)]));
		if (length == Length.SHORT) {
			sb.append(PERIOD);
			return sb.toString();
		}
		sb.append(SPACE);
		sb.append(Grammar.PREPOSITION[rand(Grammar.PREPOSITION.length - 1)]);
		sb.append(SPACE);
		sb.append(Grammar.ARTICLE[rand(Grammar.ARTICLE.length - 1)] + SPACE + Grammar.NOUN[rand(Grammar.NOUN.length - 1)]);
		if (length == Length.MEDIUM) {
			sb.append(PERIOD);
			return sb.toString();
		}
		sb.append(SPACE);
		sb.append(Grammar.PREPOSITION[rand(Grammar.PREPOSITION.length - 1)]);
		sb.append(SPACE);
		sb.append(Grammar.ARTICLE[rand(Grammar.ARTICLE.length - 1)]);
		sb.append(SPACE);
		sb.append(Grammar.NOUN[rand(Grammar.NOUN.length - 1)]);
		sb.append(SPACE);
		sb.append((Grammar.VERB[rand(Grammar.VERB.length - 1)]));
		sb.append(SPACE);
		sb.append(Grammar.ARTICLE[rand(Grammar.ARTICLE.length - 1)]);
		sb.append(SPACE);
		sb.append(Grammar.NOUN[rand(Grammar.NOUN.length - 1)]);

		sb.append(PERIOD);
		return sb.toString();
	}

	static int rand(int length) {
		if (length == 0) {
			return 0;
		}
		int ri = r.nextInt() % length;
		if (ri < 0)
			ri += length;
		return ri;
	}

}
