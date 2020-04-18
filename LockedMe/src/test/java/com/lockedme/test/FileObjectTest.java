package com.lockedme.test;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import com.lockedme.model.FileObject;


public class FileObjectTest {
	
	private static FileObject fo;
	@BeforeClass
	public static void createFileObject()
	{
		fo=new FileObject("test");
	}

	@Test
	public void testGetFname() {
		org.junit.Assert.assertTrue(fo.getFname() instanceof String);
	}

	@Test
	public void testObject() {
		org.junit.Assert.assertFalse(fo==null);
	}




}
