package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fiche implements Serializable{

	private Long id;

	private String libelle;

	private Date dateButoire;

	private int temps;

//	private Set<String> tags;

	private String lieu;

	private String url;

	private String note;

	private User user;

	private Section section;

	public Fiche() {
		// TODO Auto-generated constructor stub
	}
	
	public Fiche(String libelle, Date dateButoire, int temps, String lieu, String url, String note, User user,
			Section section) {
		this.libelle = libelle;
		this.dateButoire = dateButoire;
		this.temps = temps;
		this.lieu = lieu;
		this.url = url;
		this.note = note;
		this.user = user;
		this.section = section;
	}

	public Fiche(String libelle, User user, Section section) {
		this.libelle = libelle;
		this.user = user;
		this.section = section;
		
		this.dateButoire = new Date();
		this.temps = 0;
		this.lieu = "";
		this.url = "";
		this.note = "";
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateButoire() {
		return dateButoire;
	}

	public void setDateButoire(Date dateButoire) {
		this.dateButoire = dateButoire;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

//	public Set<String> getTags() {
//		return tags;
//	}

//	public void setTags(Set<String> tags) {
//		this.tags = tags;
//	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "libelle : " + libelle + ", user : " + user + ", section : " + section + "\n";
	}

}
