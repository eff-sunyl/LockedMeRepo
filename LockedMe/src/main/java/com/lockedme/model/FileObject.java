package com.lockedme.model;

public class FileObject {
	
	private String fname;
	//private String flocale;
	//private int fsize;

	/**public String getFlocale() {
		return flocale;
	}

	public void setFlocale(String flocale) {
		this.flocale = flocale;
	}

	public int getFsize() {
		return fsize;
	}

	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
**/
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public FileObject(String fname) {
		super();
		this.fname = fname;
	}
	


	@Override
	public String toString() {
		return "FileObject [fname=" + fname + "]";
	}
	

}
