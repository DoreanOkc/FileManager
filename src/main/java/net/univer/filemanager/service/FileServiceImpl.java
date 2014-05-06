package net.univer.filemanager.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.univer.filemanager.dao.FileDAO;
import net.univer.filemanager.domain.File;
 
@Service
public class FileServiceImpl implements FileService {
 
    @Autowired
    private FileDAO fileDAO;
 
    @Transactional
    public void addFile(File file) {
        fileDAO.addFile(file);
    }
 
    @Transactional
    public List<File> listFile(Integer userId) {
    	return fileDAO.listFile(userId);
    }
    
    @Transactional
    public List<File> shareFileList() {
    	return fileDAO.shareFileList();
    }
    
    @Transactional
    public List<File> listFile() {
    	return fileDAO.listFile();
    }
    
    @Transactional
    public void removeFile(Integer id) {
        fileDAO.removeFile(id);
    }
 
    @Transactional
    public File getFile(Integer id) {
        return fileDAO.getFile(id);
    }
}
