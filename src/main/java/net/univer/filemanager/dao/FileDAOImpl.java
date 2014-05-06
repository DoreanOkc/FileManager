package net.univer.filemanager.dao;

import java.util.List;

import net.univer.filemanager.domain.File;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAOImpl implements FileDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addFile(File file) {
		sessionFactory.getCurrentSession().save(file);
	}

	@SuppressWarnings("unchecked")
	public List<File> listFile(Integer userId) {
		return sessionFactory.getCurrentSession().
				createQuery("from File f where f.userid = :userid").setInteger("userid", userId).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<File> shareFileList() {
		return sessionFactory.getCurrentSession().
				createQuery("from File f where f.shared = :shared").setBoolean("shared", true).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<File> listFile() {
		return sessionFactory.getCurrentSession().
				createQuery("from File").list();
	}
	
	public void removeFile(Integer id) {
		File file = (File) sessionFactory.getCurrentSession().load(File.class, id);
        if (null != file) {
            sessionFactory.getCurrentSession().delete(file);
        }
    }
	
	public File getFile(Integer id) {
		return (File) sessionFactory.getCurrentSession().
				createQuery("from File f where f.id = :fileid").setInteger("fileid", id).uniqueResult();
	}

}
