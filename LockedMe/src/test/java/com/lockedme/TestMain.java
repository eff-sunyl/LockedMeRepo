package com.lockedme;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import java.util.Scanner;

import org.junit.Test;

public class TestMain {

	private static Main in;
	@BeforeClass
	public static void createMain()
	{
		in=new Main();
	}
	@Test
	public void testMain() {
		assertFalse(in==null);
	}

}
