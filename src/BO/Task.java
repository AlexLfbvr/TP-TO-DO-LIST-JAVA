package BO;

public class Task {

	private int id;
	private String titre;
	private String desc;
	private String date;
	private String etat;

	public Task(int id, String titre, String desc, String date, String etat) {
		super();
		this.id = id;
		this.titre = titre;
		this.desc = desc;
		this.date = date;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Task: " + id + ", titre= " + titre + ", description= " + desc + ", date= " + date + ", état= " + etat;
	}

}
