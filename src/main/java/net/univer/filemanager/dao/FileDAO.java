package net.univer.filemanager.dao;

import java.util.List;

import net.univer.filemanager.domain.File;

public interface FileDAO {

	public void addFile(File file);

	public List<File> listFile(Integer userId);
	
	public List<File> shareFileList();
	
	public List<File> listFile();
	
	public void removeFile(Integer id);
	
	public File getFile(Integer id);
}