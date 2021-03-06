package stringBufferTest;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringBufferTest {
	
	private StringBuffer stringBuffer;

	@Before
	public void setUp() throws Exception {
		stringBuffer = new StringBuffer("abc");
	}

	@After
	public void tearDown() throws Exception {
		stringBuffer = null;
	}

	@Test
	public void testCharAtEquals() {
		assertEquals(stringBuffer.charAt(1),'b');
	}
	
	@Test
	public void testCharAtNotEquals() {
		assertNotEquals(stringBuffer.charAt(1), 'c');
	}

	@Test (expected = StringIndexOutOfBoundsException.class)
	public void testCharAtWithNegativeIndexes() {
		stringBuffer.charAt(-1);
	}
	
	@Test (expected = StringIndexOutOfBoundsException.class)
	public void testCharAtWithEqualIndexes() {
		stringBuffer.charAt(3);
	}
	
	@Test (expected = StringIndexOutOfBoundsException.class)
	public void testCharAtWithGreaterIndexes() {
		stringBuffer.charAt(4);
	}
	
	@Test
	public void testSetCharAtEquals() {
		assertEquals(stringBuffer.toString(), "abc");
		stringBuffer.setCharAt(0, 'z');
		assertEquals(stringBuffer.toString(), "zbc");
	}
	
	@Test
	public void testSetCharAtNotEquals() {
		assertEquals(stringBuffer.toString(), "abc");
		stringBuffer.setCharAt(0, 'z');
		assertNotEquals(stringBuffer.toString(), "cdc");
	}

	@Test
	public void testAppendEquals() {
		stringBuffer.append("abc");
		assertEquals(stringBuffer.toString(), "abcabc");
	}
	
	@Test
	public void testAppendNotEquals() {
		stringBuffer.append("abc");
		assertNotEquals(stringBuffer.toString(), "abc");
	}

	@Test
	public void testAppendWithNullString() {
		String str = null;
		stringBuffer.append(str);
		assertEquals(stringBuffer.toString(), "abcnull");
	}
}
