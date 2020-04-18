package com.lockedme.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import com.lockedme.model.FileObject;

import org.junit.Test;

public class LockedmeExceptionTest {
	public static FileObject fo;
	@BeforeClass
	public static void createFO()
	{
		fo=new FileObject("Exception");
	}

	@Test
	public void testLockedmeException() {
		//fail("Not yet implemented");
		org.junit.Assert.assertTrue(fo!=null);
	}

	

}
