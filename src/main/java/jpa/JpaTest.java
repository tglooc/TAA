package jpa;

import dao.FicheDao;
import dao.SectionDao;
import dao.UserDao;
import entities.Fiche;
import entities.Section;
import entities.User;

public class JpaTest {

	public JpaTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JpaTest test = new JpaTest();
//
//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
		try {
			test.createEntities();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		tx.commit();

//		manager.close();
//		factory.close();
		
		System.out.println("done");
	}

	private void createEntities() {
		
		UserDao ud = new UserDao();
		FicheDao fd = new FicheDao();
		SectionDao sd = new SectionDao();
		
		int num = ud.ListUsers().size();
		if (num == 0) {
			Section s1 = new Section("s1");
			Section s2 = new Section("s2");

			User u1 = new User("michel");
			User u2 = new User("beber");

			Fiche f1 = new Fiche("f1", u1, s1);
			f1.setTemps(36);
			Fiche f2 = new Fiche("f2", u2, s2);
			f2.setLieu("dans le bendo");

			
			ud.save(u1);
			ud.save(u2);
			sd.save(s1);
			sd.save(s2);
			fd.save(f1);
			fd.save(f2);
			
			ud.printUsers();
			sd.printSections();
			fd.printFiches();

		}
	}

}
