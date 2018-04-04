/**
 * Cette classe est une classe du jeu: The legend of Zuulda
 * C'est un jeu d'aventure dans le style d'un rpg
 * 
 * Comand est la classe qui vérifie la validité de la commande entré pas l'utilisateur
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Constructeur naturel de la classe Command
     * Elle initialise les arguments
     */
    public Command(final String p1, final String p2){
        this.aCommandWord = p1;
        this.aSecondWord = p2;
    }
    
    /**
     * Accesseur de l'argument aCommandWord qui est la première commande
     */
    public String getCommandWord(){
        return this.aCommandWord;
    }
    
    /**
     * Accesseur de l'argument aSecondWord qui est la seconde commande
     */
    public String getSecondWord(){
        return this.aSecondWord;
    }
    
    /**
     * Fonction qui permet de savoir si l'utilsateur a entré une commande ou une double commande
     */
    public boolean hasSecondWord(){
        return (aSecondWord != null);
    }
    
    /**
     * Fonction qui permet de vérifier si la fonction est existante ou non
     */
    public boolean isUnknown(){
        return (aCommandWord == null);
    }
} // Command
