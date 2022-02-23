import java.util.Scanner;
import java.util.ArrayList;

public class Jeu
{
	private String nomJoueur;
	private int ptsRestants;
	
	/**
	 * <b>Jeu</b>
	 * 
	 */
	public Jeu(int nbrJoueurs, Joueur[] tabJoueur, Case[] plateau)
	{
		System.out.println("============================================================");
		System.out.println("===================== LANCEMENT DU JEU =====================");
		System.out.println("============================================================");
		System.out.println("                             --                             ");
		System.out.println("");
		
		System.out.println("========================== PHASE1 ==========================");
		System.out.println("");

		for(int i = 0; i < nbrJoueurs; i++)
		{
			this.nomJoueur = tabJoueur[i].getNomJoueur();
			this.ptsRestants = tabJoueur[i].getPointsActionRestants();
			System.out.println("");
			System.out.println("** [RAPPEL], tu as  ??(A COMPLETER!!!!!!!!!)PA (points d'actions) ?chaque PHASE1.");
			System.out.println("** Ces points d'actions sont des points de placement.");
			System.out.println("");
			System.out.println("** Pour placer un Zerb il faut d?enser 1PA.");
			System.out.println("** Pour placer un Crapit il faut d?enser 3PA.");
			System.out.println("** Pour placer un Krogul il faut d?enser 5PA.");
			System.out.println("");

			int choix = 0;
			
			while(this.ptsRestants>0 && choix != 4)
			{
				System.out.println("                             --                             ");
				System.out.println("");
				System.out.println("** [JOUEUR]" + this.nomJoueur + ", il te reste " + this.ptsRestants + " points d'actions !");
				System.out.println("                             --                             ");
				System.out.println("");
				
				System.out.println("** [JOUEUR]" + this.nomJoueur + ", quelle unite voulez-vous ajouter ?");
				System.out.println("");
				if(ptsRestants>=1)
				{
					System.out.println("** Rentrez '1' pour placer un Zerb.");
				}
				if(ptsRestants>=3)
				{
					System.out.println("** Rentrez '2' pour placer un Crapit.");
				}
				if(ptsRestants>=5)
				{
					System.out.println("** Rentrez '3' pour placer un Krogul.");
				}

				System.out.println("** Rentrez '4' pour finir votre tour.");
				
				Scanner sc = new Scanner(System.in);
				System.out.print("** Choix : ");
				choix = sc.nextInt();

				if(sc.nextLine() == null)
				{
					sc.close();
				}

				if(choix == 1)
				{
					sc = new Scanner(System.in);

					System.out.print("** Combien de Zerb voulez-vous ? ");
					int nombreChoix = sc.nextInt();

					new DessinPlateau();
					System.out.println();

					System.out.print("** Case : ");
					sc.nextLine();

					String caseChoisie = sc.nextLine();

					System.out.println("** [JOUEUR]" + this.nomJoueur + " place" + nombreChoix + " Zerb || CASE = " + caseChoisie);
					tabJoueur[i].addZerb(nombreChoix);

					if(sc.nextLine() == null)
					{
						sc.close();
					}
				} 
				else if(choix == 2)
				{
					sc = new Scanner(System.in);

					System.out.print("** Combien de Crapit voulez-vous ? ");
					int nombreChoix = sc.nextInt();

					new DessinPlateau();
					System.out.println();

					System.out.print("** Case : ");
					sc.nextLine();

					String caseChoisie = sc.nextLine();

					System.out.println("** [JOUEUR]" + this.nomJoueur + " place" + nombreChoix + " Crapit || CASE = " + caseChoisie);				
					tabJoueur[i].addCrapit(nombreChoix);

					if(sc.nextLine() == null)
					{
						sc.close();
					}
				} 
				else if(choix == 3)
				{
					sc = new Scanner(System.in);

					System.out.print("** Combien de Krogul voulez-vous ? ");
					int nombreChoix = sc.nextInt();

					new DessinPlateau();
					System.out.println();

					System.out.print("** Case : ");

					int caseChoisie = sc.nextInt();

					while(caseChoisie < 1 || caseChoisie > 24)
					{
						System.out.println("Veuillez saisir un nom de case valide.");
						caseChoisie = sc.nextInt();
					}

					plateau[caseChoisie - 1].setKroguls(nombreChoix, tabJoueur[i].getIdJoueur());
					System.out.println("** [JOUEUR]" + this.nomJoueur + " place" + nombreChoix + " Krogul || CASE = " + caseChoisie);
					tabJoueur[i].addKrogul(nombreChoix);
					System.out.println(plateau[caseChoisie - 1].getKroguls(tabJoueur[i].getIdJoueur()));

					if(sc.nextLine() == null)
					{
						sc.close();
					}

				}

				else if(choix == 4)
				{
					System.out.println("** [JOUEUR]" + this.nomJoueur + " a mis fin a sa phase1 !");

				}

				System.out.println("");
				this.ptsRestants = tabJoueur[i].getPointsActionRestants();
			}

			if(this.ptsRestants <= 0  || choix == 4)
			{
				System.out.println("");
				System.out.println("============================================================");
				System.out.println("** " + this.nomJoueur + " a termine la PHASE1 !");
				System.out.println("============================================================");
				System.out.println("                             --                             ");
				System.out.println("");
			}
			
		}
		System.out.println("============================================================");
		System.out.println("======================= PHASE1 BILAN =======================");
		System.out.println("============================================================");
		System.out.println("");
		
		for(int i = 0; i < nbrJoueurs; i++)
		{

			this.nomJoueur = tabJoueur[i].getNomJoueur();
			this.ptsRestants = tabJoueur[i].getPointsActionRestants();
			
			System.out.println("** " + nomJoueur + ", il te restait " + ptsRestants + " !");
			System.out.println("                             --                             ");
			System.out.println("");
		}
		
		System.out.println("========================== PHASE2 ==========================");
		System.out.println("");
		
		int nbzerb;

		for(int i = 0; i < nbrJoueurs; i++)
		{
			for (int j = 0; j<4; j++) /* zone ou on a besoin de 3 zerbs pour reproduction */ 
			{
				
			}
			for (int j = 4; j<24; j++) /* zone ou on a besoin de 4 zerbs pour reproduction */ 
			{
				int reproductionZ = 0;

				if (plateau[j].getSymbioz()==false)
				{
					nbzerb = plateau[j].getZerbs(i);
					if (plateau[j].getZerbs(i)>=4)
					{
						reproductionZ = 1;
						if (plateau[j].getZerbs(i)>=8)
						{
							reproductionZ = 2;
							if (plateau[j].getZerbs(i)==12)
							{
								reproductionZ = 3;
							}
						}
						System.out.println(" Vous avez " + reproductionZ + " de Zerbs à placer" );
						System.out.println("                             --                             ");

						ArrayList<Case> casesAdjacentes = plateau[j].getCasesAdjacentes();

						for (int k = 0 ; k < reproductionZ ; k++ )
						{	
							for (Case c : casesAdjacentes)
							{
								System.out.print(c);
							}
							System.out.println(" Où voulez-vous placer votre " + k + "e zerb ?");
							Scanner sc = new Scanner(System.in);

						}
					}
				}
			}
		}

		System.out.println("========================== PHASE3 ==========================");
		System.out.println("");
		
		System.out.println("========================== PHASE4 ==========================");
		System.out.println("");
	}
}
