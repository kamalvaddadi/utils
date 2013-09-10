package com.mycompany.myutils;

import com.mycompany.myutils.NumberToWordsService;
import junit.framework.TestCase;

public class UtilsServiceTests extends TestCase {

	private NumberToWordsService service = new NumberToWordsService();
	
	public void testEnglishNumbers() throws Exception {
		assertEquals("one", service.convert(1));
		assertEquals("two", service.convert(2));
		assertEquals("three", service.convert(3));
		assertEquals("four", service.convert(4));
		assertEquals("five", service.convert(5));
		assertEquals("six", service.convert(6));
		assertEquals("seven", service.convert(7));
		assertEquals("eight", service.convert(8));
		assertEquals("nine", service.convert(9));
		assertEquals("ten", service.convert(10));
		assertEquals("eleven", service.convert(11));
		assertEquals("twelve", service.convert(12));
		assertEquals("thirteen", service.convert(13));
		assertEquals("fourteen", service.convert(14));
		assertEquals("fifteen", service.convert(15));
		assertEquals("sixteen", service.convert(16));
		assertEquals("seventeen", service.convert(17));
		assertEquals("eighteen", service.convert(18));
		assertEquals("nineteen", service.convert(19));
		assertEquals("twenty", service.convert(20));
		assertEquals("thirty", service.convert(30));
		assertEquals("forty", service.convert(40));
		assertEquals("fifty", service.convert(50));
		assertEquals("sixty", service.convert(60));
		assertEquals("seventy", service.convert(70));
		assertEquals("eighty", service.convert(80));
		assertEquals("ninety", service.convert(90));
		assertEquals("one hundred one", service.convert(101));
		assertEquals("one thousand one", service.convert(1001));
		assertEquals("ten thousand one", service.convert(10001));
		assertEquals("one hundred thousand one", service.convert(100001));
		assertEquals("one million one", service.convert(1000001));
		assertEquals("ten million one", service.convert(10000001));
		assertEquals("one hundred million one", service.convert(100000001));
		assertEquals("one billion one", service.convert(1000000001));


	}

}
