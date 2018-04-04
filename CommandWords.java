/**
 * Cette classe est une classe du jeu: The legend of Zuulda
 * C'est un jeu d'aventure dans le style d'un rpg
 * 
 * ComandWords est la classe qui liste les commandes existantes
 */
public class CommandWords
{
    // tableau constant qui contient tous les mots de commande valides
    private static final String[] sValidCommands = {"go","quit","help","look","eat","back"};   

    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        // rien a faire pour le moment...
    } // CommandWords()

    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand( final String pString )
    {
        // pour chacune des commandes valides (du tableau constant)
        for ( int i=0; i<sValidCommands.length; i++ ) {
            // si elle est egale a pString
            if ( sValidCommands[i].equals( pString ) )
                return true;
        } // for
        // si nous arrivons la, c'est que la commande
        // n'a pas ete trouvee dans le tableau
        return false;
    } // isCommand()
    
    /**
     * Methode qui affiche la liste des commandes disponnibles
     */
    public String getCommandList(){
        String vCommandList = "";
        for(String command: sValidCommands){
            vCommandList += command + "  ";
        }
        return vCommandList;
    }
} // CommandWords
