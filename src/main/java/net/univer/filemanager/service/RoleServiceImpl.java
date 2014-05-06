package net.univer.filemanager.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import net.univer.filemanager.dao.RoleDAO;
import net.univer.filemanager.domain.Role;
 
@Service
public class RoleServiceImpl implements RoleService {
 
    @Autowired
    private RoleDAO roleDAO;
 
    @Transactional
    public void addRole(Role role, Integer userId) {
    	roleDAO.addRole(role, userId);
    }
 
}
