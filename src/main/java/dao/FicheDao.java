package dao;

import java.util.List;

import entities.Fiche;

public class FicheDao extends GenericDao<Long, Fiche> {

	public FicheDao() {
		super(Fiche.class);
	}

	public List<Fiche> listFiches() {
		List<Fiche> resultList = entityManager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
		return resultList;
	}

	public void printFiches() {
		List<Fiche> resultList = entityManager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
		System.out.println("\nnum of Fiches:" + resultList.size());
		for (Fiche next : resultList) {
			System.out.println("next Fiche: " + next);
		}
		System.out.println("\n");
	}

}
