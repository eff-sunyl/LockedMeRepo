package com.lockedme.bo.impl;
import java.util.Comparator;
import com.lockedme.model.FileObject;
public class FileBOComparator implements Comparator<FileObject>{

	@Override
	public int compare(FileObject fo, FileObject fo1) {
		
		
		return fo.getFname().compareTo(fo1.getFname());
	}

}
