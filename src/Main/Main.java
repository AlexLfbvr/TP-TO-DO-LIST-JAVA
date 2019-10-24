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
			System.out.println("[2] Ajouter une t�che");
			System.out.println("[3] Supprimer une t�che");
			System.out.println("[4] Modifier une t�che");
			System.out.println("[5] Historique d'une t�che");
			System.out.println("[6] Afficher la Collection Historique");

			// r�cup�ration du choix
			int choix = sc.nextInt();

			switch (choix) {
			// Afficher les t�ches
			case 1:
				System.out.println("Voici la liste des t�ches");
				maList.listTask();
				break;
			// Ajouter une t�che
			case 2:
				maList.addVersionUser();
				System.out.println("La t�che est bien ajout�e\n");
				maList.listTask();
				break;
			// Supprimer une t�che
			case 3:
				Scanner sc5 = new Scanner(System.in);
				System.out.println("Entrez l'id de la t�che a supprimer: ");
				maList.listTask();
				int x = sc5.nextInt();
				maList.delTask(x);
				maList.listTask();
				break;
			// Modifier une tache
			case 4:
				maList.changeTask();
				break;
				// Historique d'une t�che
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
