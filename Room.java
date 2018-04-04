import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
/**
 * Cette classe est une classe du jeu: The legend of Zuulda
 * C'est un jeu d'aventure dans le style d'un rpg
 * 
 * Room est la classe qui gère la description et les sorties de toutes salles
 */
public class Room{
    private String aDescription;
    private HashMap<String, Room> exits;
    private String aImageName;
    private HashMap<String, Item> aItems;
    
    /**
     * Constructeur naturel de la classe Room
     */
    public Room(final String pDescription, final String pImage){
        this.aDescription = pDescription;
        exits = new HashMap<String,Room>();
        aItems = new HashMap<String, Item>();
        aImageName = pImage;
    }
    
    public void addItem(final String pItem, final double pPrix, final double pPoids){
        aItems.put(pItem, new Item(pItem,pPrix,pPoids));
    }
    
    /**
     * Accesseur de l'argument aDescription
     */
    public String getDescription(){
        return this.aDescription;
    }
    
    /**
     * Methode qui ajoute une sortie a la HashMap
     */
    public void setExits(String pDirection, Room pSortie){
        exits.put(pDirection,pSortie);        
    }
    
    /**
     * Accesseur de l'argument exits qui retourne la sortie associé a la direction de la HashMap
     */
    public Room getExits(String pDirection){
        return exits.get(pDirection);
    }
    
    /**
     * Accesseur de l'argument exits qui retourne dans une chaîne de charactères le nombre de sorties disponnibles
     */
    public String getExitsString(){
        String vExits = "";
        for (Map.Entry<String,Room> e : exits.entrySet()){
            vExits += " " + e.getKey();
        }
        return vExits;
    }
    
    
    public String getItemString(){
        String vItems = "";
        for (Map.Entry<String,Item> e : aItems.entrySet()){
            vItems += " " + e.getValue().getDescription();
        }
        return vItems;
    }
    
    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription(){
        return aDescription;
    }
    
    /**
     * Methode qui affiche la description de la salle avec le nombre de sorties
     */
    public String getLongDescription(){
        return "\nVotre position : " + this.aDescription + "\n" + "Sorties :" + getExitsString() + 
        "\nVoici l'objet présent dans cette piece : " + getItemString();
    }
    
    /**
     * Return a string describing the room's image name
     */
    public String getImageName(){
        return aImageName;
    }
} // Room