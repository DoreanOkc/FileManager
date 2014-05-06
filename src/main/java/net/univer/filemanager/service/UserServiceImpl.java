package net.univer.filemanager.service;
 
import java.util.List;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 


import net.univer.filemanager.dao.UserDAO;
import net.univer.filemanager.domain.User;
 
@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDAO userDAO;
 
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }
 
    @Transactional
    public List<User> listUser() {
        return userDAO.listUser();
    }
    
    @Transactional
    public User getUser(String username) {
        return userDAO.getUser(username);
    }
    
    @Transactional
    public User getUser(Integer userid) {
        return userDAO.getUser(userid);
    }
 
}
