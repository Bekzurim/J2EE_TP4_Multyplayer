/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 *
 * @author pedago
 */
public class MultiPlayersGame implements MultiPlayerGame {
    
        String[] joueurs;
        SinglePlayerGame[] partie;
        int joueur;
    
	/**
	 * Démarre une nouvelle partie pour un groupe de joueurs
	 * @param playerName un tableau des noms de joueurs (il faut au moins un joueur)
	 * @return une chaîne de caractères indiquant le prochain joueur,
	 * de la forme "Prochain tir : joueur Bastide, tour n° 1, boule n° 1"
	 * @throws java.lang.Exception si le tableau est vide ou null
	 */
	public String startNewGame(String[] playerName){
            String[] joueur=playerName;
            for(int i=0;i<joueur.length;i++){
                partie[i]=new SinglePlayerGame();
        }
            
            return "Prochain tir : joueur "+joueurs[0]+", tour n° 1, boule n° 1";
        }
	
	/**
	 * Enregistre le nombre de quilles abattues pour le joueur courant, dans le frame courant, pour la boule courante
	 * @param nombreDeQuillesAbattues : nombre de quilles abattue à ce lancer
	 * @return une chaîne de caractères indiquant le prochain joueur,
	 * de la forme "Prochain tir : joueur Bastide, tour n° 5, boule n° 2",
	 * ou bien "Partie terminée" si la partie est terminée.
	 * @throws java.lang.Exception si la partie n'est pas démarrée.
	 */
	public String lancer(int nombreDeQuillesAbattues){
            partie[joueur].lancer(nombreDeQuillesAbattues);
            if(partie[joueur].hasCompletedFrame()){
                if(joueur<joueurs.length-1){
                    joueur+=1;
                }
                else{
                    joueur=0;
                }
                return "Prochain tir : joueur "+joueurs[joueur]+", tour n°"+partie[joueur].getFrameNumber()+", boule n° 1";
            }
            else{
                return "Prochain tir : joueur "+joueurs[joueur]+", tour n°"+partie[joueur].getFrameNumber()+", boule n° "+partie[joueur].getNextBallNumber();
                }
        }
	
	/**
	 * Donne le score pour le joueur playerName
	 * @param playerName le nom du joueur recherché
	 * @return le score pour ce joueur
	 * @throws Exception si le playerName ne joue pas dans cette partie
	 */
	public int scoreFor(String playerName){
            int name = 0;
            for(int i=0;i<joueurs.length;i++){
                if(joueurs[i]==playerName){
                    name=i;
                }
            }
            return partie[name].score();
        }
}
