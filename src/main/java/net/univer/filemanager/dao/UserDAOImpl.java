package net.univer.filemanager.dao;

import java.util.List;

import net.univer.filemanager.domain.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		user.setEnabled(true);
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {

		return sessionFactory.getCurrentSession().createQuery("from User")
			.list();
	}
	
	public User getUser(String username) {
		return (User) sessionFactory.getCurrentSession().
				createQuery("from User u where u.username = :username").setString("username", username).uniqueResult();
	}
	
	public User getUser(Integer userid) {
		return (User) sessionFactory.getCurrentSession().
				createQuery("from User u where u.id = :userid").setInteger("userid", userid).uniqueResult();
	}
}
