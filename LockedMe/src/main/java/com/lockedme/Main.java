package com.lockedme;

import java.util.Scanner;
import com.lockedme.bo.impl.FileBOImpl;


import com.lockedme.exception.LockedmeException;

public class Main {
	public static int parseInput(Scanner sc)

	{   int pI=0;
	try {
	    String s=sc.nextLine();
		pI=Integer.parseInt(s);
		}
		catch(java.lang.NumberFormatException ime)
		{
			System.out.println("Only numbers can be used as input.");
			
		}
		return pI;
	}

	public static void devDetails()
	{
		System.out.println("*********************************************************");	
		System.out.println("*        Application Name: LockedMe.com prototype       *");
		System.out.println("*        Developer Name  : Ratna Kumar Boddu            *");
		System.out.println("*        Email           : ratboddu@gmail.com           *");
		System.out.println("*        Date            : April, 2020                  *");
		System.out.println("*        Description     : Add,delete,find files        *");
		System.out.println("*********************************************************");
	}
	
	public void displaySubMenu(Scanner input)
	{
	
		int i_p=0;
		do {
			
			devDetails();
		System.out.println("-------------------------File Operations Menu----------------------------");
		System.out.println("Option 1 : Add a file to the main directory, enter the number 1");	
		System.out.println("Option 2 : Delete a user specified file from the main directory, enter the number 2");		
		System.out.println("Option 3 : Search a user specified file from the main directory, enter the number 3");
		System.out.println("Option 4 : Navigate back to the main menu, enter the number 4");
		
		System.out.println("-------------------------------------------------------------------------");	
		System.out.println("Note: This program accepts numerical input from 1 to 4");
		System.out.println("-------------------------------------------------------------------------");
		
	    i_p=parseInput(input);

		//System.out.println(i_p);
		switch (i_p)
		{
		 case 1: //call fetch File names in main dir function
			 System.out.println("You have entered option 1 in File Operations Menu");
			 try {
			 FileBOImpl.displayAddFile(input);
			 }
			 catch(LockedmeException e)
			 {
				 System.out.println(e.getMessage());
			 }
			 break;
		 case 2: //call File operations sub menu
			 System.out.println("You have entered option 2 in File Operations Menu");
			 try {
				 FileBOImpl.displayDelFile(input);
				 }
				 catch(LockedmeException e)
				 {
					 System.out.println(e.getMessage());
				 }
			 break;
		 case 3: //call app exit function
			 System.out.println("You have entered option 3 in File Operations Menu");
			 try {
				 FileBOImpl.displaySearchFile(input);
				 }
				 catch(LockedmeException e)
				 {
					 System.out.println(e.getMessage());
				 }
			 break;
		 case 4: //call app exit function
			 System.out.println("You have entered option 4 in File Operations Menu");
			 break;
		 default: 
			 // System.out.println("You have entered option "+ i_p);
			 System.out.println("Invalid input. Enter Numbers 1,2,3,4");
		}
		}
		
		while(i_p!=4);
		//input.close();
		System.out.println("You are back to Main Menu.");
	}
	
	public void displayMainMenu()
	{
		int i_p=0;
		Scanner input=new Scanner(System.in);
		do {
	    
        devDetails();	
		System.out.println("--------------------------LockedMe main menu---------------------------");
		System.out.println("Option 1 : To display current file names in main directory, enter the number 1");	
		System.out.println("Option 2 : File operations in main directory, enter the number 2");		
		System.out.println("Option 3 : Close the application, enter the number 3");
		
		System.out.println("-----------------------------------------------------------------------");	
		System.out.println("Note: This program accepts numerical input from 1 to 3");
		System.out.println("-----------------------------------------------------------------------");
		
		i_p=parseInput(input);
		//input.close();
		//System.out.println(i_p);
		switch (i_p)
		{
		 case 1: //call fetch File names in main dir function
			 
			 System.out.println("You have entered option 1");
			 try {
				FileBOImpl.displayListFile();
			} catch (LockedmeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		 case 2: //call File operations sub menu
			 
			 System.out.println("You have entered option 2");
			 new Main().displaySubMenu(input);
			 break;
		 case 3: //call app exit function
			 System.out.println("You have entered option 3");
			 break;
		 default: 
			 // System.out.println("You have entered option "+ i_p);
			 System.out.println("Invalid input. Enter Numbers 1,2,3");
		}
		
		}
		
		while(i_p!=3);
		input.close();
		System.out.println("You have exited the application.");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
     new Main().displayMainMenu();
		/*
		 * File f = new File("1"); System.out.println(f.getAbsolutePath()); File ff =
		 * new File(f.getAbsoluteFile()+"rdt.wap"); boolean b=false; try {
		 * b=ff.createNewFile(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } System.out.println(b);
		 */
     //f.close();
     
     
	}

}
