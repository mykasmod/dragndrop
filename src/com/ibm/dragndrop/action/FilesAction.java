package com.ibm.dragndrop.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.dragndrop.Constants;
import com.ibm.dragndrop.model.File;
import com.ibm.dragndrop.service.FilesService;
import com.ibm.dragndrop.service.FilesServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author Michael Asmod
 * The main action class for file operation i.e. listing files, downloading files.
 * 
 */
public class FilesAction extends ActionSupport implements ServletRequestAware{
    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private InputStream inputStream;
    private String fileName;
    private List<File> fileList = new ArrayList<File>();
    private FilesService filesService = new FilesServiceImpl();
    private Map<String, java.io.File> filesMap;
    
    //download
    private File fileModel;
    private String contentType;
    
    //upload
    private java.io.File file;
    private String fileContentType;
    private String fileFileName;
    
    
    
    /** 
     * The getFiles Action populates a fileList with file.
     * fileList is used by iterator in jsp to display fileName of file. 
     */
    public String getFiles() throws Exception {
        
        filesService = new FilesServiceImpl();
        filesMap = filesService.getFilesFile(request.getServletContext().getRealPath(Constants.FILES));
      
        if(filesMap.keySet().size() > 0){
            for (Entry<String, java.io.File> entry: filesMap.entrySet()) {
                File file = new File(); 
                file.setFileName(entry.getKey());
                file.setStream(filesService.getfileInputStream(entry.getValue()));
                fileList.add(file);
            }
        }
        return SUCCESS;
    }
    
    /**
     * downloadFile Action method Downloads a file by setting An InputStream. 
     * Requires getFiles method to execute first.
     * <p>
     * fileName is set by s:url...s:param tags in jsp.
     * 
     */
    public String downloadFile() throws Exception {
        filesMap =  filesService.getFilesFile(request.getServletContext().getRealPath(Constants.FILES));
        inputStream = filesService.getfileInputStream(filesMap.get(fileName)); 

        return SUCCESS;
    }
    
    public String uploadFile() throws Exception {
        String destPath = request.getServletContext().getRealPath(Constants.FILES);
        java.io.File destFile = new java.io.File(destPath, fileFileName);        
        FileUtils.copyFile(file, destFile);
 
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
       this.request = request;
        
    }

    
    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

 
    public String getFileName() {
        return fileName;
    }
    //Important for struts param auto mapping with member var
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
    public File getFileModel() {
        return fileModel;
    }

    public void setFileModel(File fileModel) {
        this.fileModel = fileModel;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    
    
    
    

    public java.io.File getFile() {
        return file;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
    
    
    

    
        
}
