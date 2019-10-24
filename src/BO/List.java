package BO;

import BO.Task;
import java.util.*;

public class List {

	protected Collection<Task> tdList;		//liste des tâches "actives"
	protected Collection<Task> histoList;	//Liste des tâches après modification

	public List() {
		super();
		this.tdList = new ArrayList();
		this.histoList = new ArrayList();
	}

	public Collection<Task> getList() {
		return tdList;
	}

	public void setList(Collection<Task> list) {
		this.tdList = list;
	}

	public Collection<Task> getHistoList() {
		return histoList;
	}

	public void setHistoList(Collection<Task> histoList) {
		this.histoList = histoList;
	}

	// ajouter une tache en auto
	public void addVersionAuto(Task t) {
		tdList.add(t);
	}

	//Insertion dans l'inventaire et suppression dans taches actives
	public void inventaire(Task t) {
		//ajout de la tache dans Historique
		histoList.add(t);
		//Suppression dans to do list de l'ancienne version
		tdList.remove(t);
	}

	//Ajout mano par user
	public void addVersionUser() {
		int id;
		String titre, desc, date, etat;
		//Scanner pour les saisies
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		Scanner sc5 = new Scanner(System.in);


		System.out.println("Entrez l'id (nombre entier): ");
		id = sc1.nextInt();
		System.out.println("Entrez le Titre :");
		titre = sc2.nextLine();
		System.out.println("Entrez une description: ");
		desc = sc3.nextLine();
		System.out.println("Entrez une date: ");
		date = sc4.nextLine();
		System.out.println("Entrez unn etat: ");
		etat = sc5.nextLine();
		//Nouvelle tâche
		Task t1 = new Task(id, titre, desc, date, etat);
		//Insertion
		this.addVersionAuto(t1);
	}

	//changement tâches par user avec ID
	public void changeFastTask(int id2) {
		int id = id2;
		String titre, desc, date, etat;
		//scanner pour les saisies
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		Scanner sc5 = new Scanner(System.in);

		System.out.println("Entrez le Titre :");
		titre = sc2.nextLine();
		System.out.println("Entrez une description: ");
		desc = sc3.nextLine();
		System.out.println("Entrez une date: ");
		date = sc4.nextLine();
		System.out.println("Entrez un etat: ");
		etat = sc5.nextLine();
		//Nouvelle tache avec le même id que la version precedente 
		Task t1 = new Task(id, titre, desc, date, etat);
		
		Iterator<Task> it = tdList.iterator();
		while (it.hasNext()) {
			Task myElement = it.next();
			if (myElement.getId() == t1.getId()) {
				this.inventaire(myElement);
				break;
			}
		}
		this.addVersionAuto(t1);
	}

	// lister les taches de la liste sauf si la liste2 est vide
	public void listTask() {
		Iterator<Task> it = tdList.iterator();

		if (tdList.size() == 0) {
			System.out.println("La liste est vide.\n");
		} else {
			while (it.hasNext()) {
				Task myElement = it.next();
				System.out.println(myElement + "\n");
			}
		}
	}

	//Supprime une tache avec son ID
	public void delTask(int id) {
		Iterator<Task> it = tdList.iterator();
		while (it.hasNext()) {
			Task myElement = it.next();
			if (myElement.getId() == id) {
				it.remove();
				System.out.println("La tâche n°" + id + " est supprimée");
			} else {
				System.out.println("Il n'existe pas de tâche avec l'id " + id);
			}
		}
	}
	
	//Launcher pour modifier une tache
	public void changeTask() {
		Iterator<Task> it = tdList.iterator();
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez l'id de la tâche a modifier:");
		this.listTask();
		int id = sc.nextInt();

		this.changeFastTask(id);

	}

	//Affiche l'hstorique d'une tache
	public void getHistoriqueTask() {
		Iterator<Task> it2 = histoList.iterator();
		Iterator<Task> it1 = tdList.iterator();

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez l'id de la tâche :");
		this.listTask();
		int id = sc.nextInt();

		while (it1.hasNext()) {
			Task myElement = it1.next();
			if (myElement.getId() == id) {
				System.out.println(myElement.toString());
			}
			while (it2.hasNext()) {
				Task myElement2 = it2.next();
				if (myElement2.getId() == id) {
					System.out.println(myElement2.toString());
				}
			}
		}
		
	}
}