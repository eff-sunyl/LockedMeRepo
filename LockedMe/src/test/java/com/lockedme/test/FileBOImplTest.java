package com.lockedme.test;
import static org.junit.Assert.assertFalse;



import org.junit.BeforeClass;
import org.junit.Test;


import com.lockedme.model.FileObject;
import com.lockedme.bo.impl.FileBOImpl;

public class FileBOImplTest {
	
private static FileBOImplTest ft;
@BeforeClass
public static void createFileObject()
{
	ft=new FileBOImplTest();
}
@Test
public void testaddFile()
{   
	FileObject fo=new FileObject("Test");
	
	assertFalse(fo==null);
	}

public void testdelFile()
{   
	FileObject fo=new FileObject("Test");
	
	assertFalse(fo==null);
	}
}

