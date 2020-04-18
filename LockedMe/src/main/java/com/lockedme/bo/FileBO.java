package com.lockedme.bo;
import java.util.Scanner;
import com.lockedme.model.FileObject;
import java.util.List;
import com.lockedme.exception.LockedmeException;

public interface FileBO {
	
	public FileObject addFile(FileObject fo,Scanner in) throws LockedmeException;
	public FileObject delFile(FileObject fo, Scanner in) throws LockedmeException;
	public List<FileObject> getListofFiles() throws LockedmeException;
	public FileObject searchFile(FileObject fo) throws LockedmeException;
	//public String createDir() throws LockedmeException;

	

}
