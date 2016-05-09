package com.ibm.dragndrop.model;

import java.io.InputStream;

public class File {
    private String fileName;
    private InputStream stream;

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public InputStream getStream() {
        return stream;
    }
    public void setStream(InputStream stream) {
        this.stream = stream;
    }    
    
    
}
