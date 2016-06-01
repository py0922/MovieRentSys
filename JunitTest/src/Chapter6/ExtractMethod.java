package Chapter6;

import static org.junit.Assert.*;

import org.junit.Test;

import ExtractMethod.LocalVariable;

public class ExtractMethod {
	private LocalVariable _localVariable=new LocalVariable();
	
	
	@Test
	public void test() {
		String expectedResult="name:"+_localVariable.getName()+"\n"+"amount:"+String.valueOf(8.7)+"\n";
		assertEquals(expectedResult,_localVariable.printOwing(2));
	}

}
