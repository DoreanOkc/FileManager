package net.univer.filemanager.dao;

import net.univer.filemanager.domain.Role;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addRole(Role role, Integer userid) {
		role.setUserid(userid);
    	role.setRole("ROLE_USER");
		sessionFactory.getCurrentSession().save(role);
	}
}
