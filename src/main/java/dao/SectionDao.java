package dao;

import java.util.List;

import entities.Section;

public class SectionDao extends GenericDao<Long,  Section>{

	public SectionDao() {
		super(Section.class);
	}

	public List<Section> listSections() {
		List<Section> resultList = entityManager.createQuery("Select a From Section a", Section.class).getResultList();
		return resultList;
	}
	
	public void printSections() {
		List<Section> resultList = entityManager.createQuery("Select a From Section a", Section.class).getResultList();
		System.out.println("\nnum of Sections:" + resultList.size());
		for (Section next : resultList) {
			System.out.println("next Section: " + next);
		}
		System.out.println("\n");
	}
	
}
