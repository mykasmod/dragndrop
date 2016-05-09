package com.ibm.dragndrop.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * 
 *@author Michael Asmod
 *A FilesService implementation to get HashMap of fileName, file pair.
 *Locate a file and return a FileInputStream.
 *
 */
public class FilesServiceImpl implements FilesService {
     
    /**
     * getFilesFile returns a HashMap of fileName, File
     * @param path A path of certain directory
     * @return A HashMap of fileName, File pair
     */
    public HashMap<String, File> getFilesFile(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        
        HashMap<String, File> filesMap = new HashMap<String, File>();
        if(files != null){
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                filesMap.put(f.getName(), f);
            }
        }
        return filesMap;
    }
    /**
     * @param file @see {@link File}
     */
    public FileInputStream getfileInputStream(File file) throws FileNotFoundException{
        FileInputStream fileInputStream = new FileInputStream(file);  
        return fileInputStream;
    }



}
