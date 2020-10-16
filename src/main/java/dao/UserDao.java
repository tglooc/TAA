package dao;

import java.util.List;

import entities.User;

public class UserDao extends GenericDao<Long,  User>{

	public UserDao() {
		super(User.class);
	}
	
	public List<User> ListUsers(){
		List<User> resultList = entityManager.createQuery("Select a From User a", User.class).getResultList();
		return resultList;
	}
	
	public void printUsers() {
		List<User> resultList = entityManager.createQuery("Select a From User a", User.class).getResultList();
		System.out.println("\nnum of users:" + resultList.size());
		for (User next : resultList) {
			System.out.println("next user: " + next);
		}
		System.out.println("\n");
	}

}
