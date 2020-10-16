package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Section implements Serializable{

	private Long id;

	private String name;

//	private List<Fiche> fiches;
	
	public Section() {
		// TODO Auto-generated constructor stub
	}

	public Section(String name, List<Fiche> fiches) {
		this.name = name;
//		this.fiches = fiches;
	}

	public Section(String name) {
		this.name = name;
//		this.fiches = new ArrayList<Fiche>();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@OneToMany
//	public List<Fiche> getFiches() {
//		return fiches;
//	}
//
//	public void setFiches(List<Fiche> fiches) {
//		this.fiches = fiches;
//	}
//	
//	public void addFiche(Fiche f) {
//		this.fiches.add(f);
//	}

	@Override
	public String toString() {
		return "name : " + name +";\n";
	}

}
