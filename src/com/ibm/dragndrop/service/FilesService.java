package com.ibm.dragndrop.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * 
 * @author Michael Asmod
 * An interface for File Operations
 *
 */
public interface FilesService {
    
    public HashMap<String, java.io.File> getFilesFile(String realPath);
    public FileInputStream getfileInputStream(File file) throws FileNotFoundException;
}
