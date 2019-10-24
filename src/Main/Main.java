package Main;

import java.util.*;

import BO.*;
import BO.List;

public class Main {

	public static void main(String[] args) {

		List maList = new List();

		Scanner sc = new Scanner(System.in);
		System.out.println("# TO DO LIST: ENIGMA 4 # \n");
		for (int j = 0; j > -1; j++) {
			System.out.println("Que voulez-vous faire? \n");
			System.out.println("[1] Afficher la liste");
			System.out.println("[2] Ajouter une tâche");
			System.out.println("[3] Supprimer une tâche");
			System.out.println("[4] Modifier une tâche");
			System.out.println("[5] Historique d'une tâche");
			System.out.println("[6] Afficher la Collection Historique");

			// récupération du choix
			int choix = sc.nextInt();

			switch (choix) {
			// Afficher les tâches
			case 1:
				System.out.println("Voici la liste des tâches");
				maList.listTask();
				break;
			// Ajouter une tâche
			case 2:
				maList.addVersionUser();
				System.out.println("La tâche est bien ajoutée\n");
				maList.listTask();
				break;
			// Supprimer une tâche
			case 3:
				Scanner sc5 = new Scanner(System.in);
				System.out.println("Entrez l'id de la tâche a supprimer: ");
				maList.listTask();
				int x = sc5.nextInt();
				maList.delTask(x);
				maList.listTask();
				break;
			// Modifier une tache
			case 4:
				maList.changeTask();
				break;
				// Historique d'une tâche
			case 5:
				maList.getHistoriqueTask();
				break;
				//Affiche l'ensemble de l'historique
			case 6:
				System.out.println(maList.getHistoList());
				break;
				default:
					System.out.println("Recommencez, saisie non valide");
					break;
			}
		}
	}
}
