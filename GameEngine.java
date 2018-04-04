import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * Write a description of class GameEngine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameEngine
{
    private Room aCurrentRoom;
    private Stack aStackRoom;
    private Parser aParser;
    private UserInterface gui;
    
    public GameEngine(){
        createRooms();
        aParser = new Parser();
        aStackRoom = new Stack();
    }
    
    public void setGUI(UserInterface userInterface){
        gui = userInterface;
        printWelcome();
    }
    
    /**
     * Cette methode affiche le message d'accueil
     */
    private void printWelcome(){
        gui.println("\n\nBienvenu dans la légende de Zuulda !");
        gui.println("La légende de Zuulda est la plus palpitante des aventures !");
        gui.println("Tape help pour obtenir de l'aide \n");
        printLocationInfo();
        gui.showImage(aCurrentRoom.getImageName());
    }
    
    /**
     * Initialisation de toutes les salles
     * Configuration des sorties pour chaque salles
     * Definition de la salle actuelle
     */
    private void createRooms(){
        Room vCarrefour, vChateau, vChateauInt, vForetSud, vForetOuest, vForetNord, vForetEst,
            vVillage1, vVillage2, vVillage3, vVillage4, vVillage5, vCroisement, vPlage1,
            vPlage2, vPonton, vMontagne1, vMontagne2, vMontagne3;
        HashMap<String, Room> vRoom = new HashMap<String, Room>();
        vCarrefour = new Room("Carrefour à quatre branches","Images/carrefour.jpg");
        vRoom.put("Carrefour à quatre branches",vCarrefour);
      
        vChateau = new Room("Chateau","Images/chateau.png");
        vRoom.put("Chateau",vChateau);
        vChateauInt = new Room("Hall","Images/hall.png");
        vRoom.put("Hall",vChateauInt);
        vForetSud = new Room("L'orée de la forêt","Images/foretsud.png");
        vRoom.put("L'orée de la forêt",vForetSud);
        vForetOuest = new Room("Clairie de la forêt","Images/foretouest.jpg");
        vRoom.put("Clairie de la forêt",vForetOuest);
        vForetNord = new Room("Forêt ténébreuse","Images/foretnord.jpg");
        vRoom.put("Forêt ténébreuse",vForetNord);
        vForetEst = new Room("Carrefour de la forêt","Images/foretest.jpg");
        vRoom.put("Carrefour de la forêt",vForetEst);
        vVillage1 = new Room("Fontaîne","Images/fontaine.png");
        vRoom.put("Fontaîne",vVillage1);
        vVillage2 = new Room("Quartier Nord-Est","Images/quartierne.jpg");
        vRoom.put("Quartier Nord-Est",vVillage2);
        vVillage3 = new Room("Quartier Nord-Ouest","Images/quartierno.jpg");
        vRoom.put("Quartier Nord-Ouest",vVillage3);
        vVillage4 = new Room("Quartier Sud-Ouest","Images/quartierso.jpg");
        vRoom.put("Quartier Sud-Ouest",vVillage4);
        vVillage5 = new Room("Quartier Sud-Est","Images/quartierse.jpg");
        vRoom.put("Quartier Sud-Est",vVillage5);
        vCroisement = new Room("Carrefour a trois branches","Images/carrefour3.jpg");
        vRoom.put("Carrefour a trois branches",vCroisement);
        vPlage1 = new Room("Entrée de la plage","Images/plage.jpg");
        vRoom.put("Entrée de la plage",vPlage1);
        vPlage2 = new Room("Plage","Images/plage2.jpg");
        vRoom.put("Plage",vPlage2);
        vPonton = new Room("Ponton","Images/ponton.jpg");
        vRoom.put("Ponton",vPonton);
        vMontagne1 = new Room("Pied de la montagne","Images/montagne.jpg");
        vRoom.put("Pied de la montagne",vMontagne1);
        vMontagne2 = new Room("Milieu de la montagne","Images/montagne2.jpg");
        vRoom.put("Milieu de la montagne",vMontagne2);
        vMontagne3 = new Room("Sommet de la montagne","Images/montagne3.jpg");
        vRoom.put("Sommet de la montagne",vMontagne3);
        
        vVillage1.setExits("nord-est",vVillage2);
        vVillage1.setExits("nord-ouest",vVillage3);
        vVillage1.setExits("sud-est",vVillage4);
        vVillage1.setExits("sud-ouest",vVillage5);
        vVillage2.setExits("sud-ouest",vVillage1);
        vVillage3.setExits("sud-est",vVillage1);
        vVillage4.setExits("nord-ouest",vVillage1);
        vVillage5.setExits("nord-est",vVillage1);
        vCarrefour.setExits("nord",vChateau);
        vCarrefour.setExits("sud",vVillage1);
        vCarrefour.setExits("est",vForetSud);
        vCarrefour.setExits("ouest",vCroisement);
        vChateau.setExits("sud",vCarrefour);
        vChateau.setExits("porte",vChateauInt);
        vChateauInt.setExits("porte",vChateau);
        vForetSud.setExits("ouest",vCarrefour);
        vForetSud.setExits("nord",vForetEst);
        vForetEst.setExits("nord",vForetNord);
        vForetEst.setExits("sud",vForetSud);
        vForetEst.setExits("ouest",vForetOuest);
        vForetOuest.setExits("est",vForetEst);
        vForetNord.setExits("sud",vForetEst);
        vVillage1.setExits("nord",vCarrefour);
        vCroisement.setExits("est",vCarrefour);
        vCroisement.setExits("nord",vMontagne1);
        vCroisement.setExits("sud",vPlage1);
        vPlage1.setExits("nord",vCroisement);
        vPlage1.setExits("ouest",vPlage2);
        vPlage2.setExits("est",vPlage1);
        vPlage2.setExits("sud",vPonton);
        vMontagne1.setExits("sud",vCroisement);
        vMontagne1.setExits("nord",vMontagne2);
        vMontagne2.setExits("sud",vMontagne1);
        vMontagne2.setExits("nord",vMontagne3);
        vMontagne3.setExits("sud",vMontagne2);
        vPonton.setExits("nord",vPlage2);
        
        vForetSud.addItem("baton",0,2);
        vForetSud.addItem("mousse",0,0);
        vCarrefour.addItem("cailloux",0,1);
        
        
        this.aCurrentRoom = vCarrefour;
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand(String commandLine) 
    {
        gui.println(commandLine);
        Command command = aParser.getCommand(commandLine);

        if(command.isUnknown()) {
            gui.println("Je n'ai pas compris ce que vous voulez dire ...\n");
            return;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("eat"))
            if(command.hasSecondWord()) gui.println("Cette commande n'accepte qu'un mot !\n");
            else eat();
        else if (commandWord.equals("look"))
            if(command.hasSecondWord()) gui.println("Cette commande n'accepte qu'un mot !\n");
            else look();
        else if (commandWord.equals("back"))
            if(command.hasSecondWord()) gui.println("Cette commande n'accepte qu'un mot !\n");
            else back();
        else if (commandWord.equals("quit")) {
            endGame();
        }
    }
    
    /**
     * Fonction appelé lorsque la premiere commande est "go"
     * Si il n'y a pas de seconde commande affiche un message qui attend la suite
     * Si la seconde commande ne correspond pas a une des sorties affiche une reponse
     * Si les commandes sont correctes change la salle actuelle et affiche ses informations
     */
    public void goRoom(Command pCmd){
        aStackRoom.push(aCurrentRoom);
        if (!pCmd.hasSecondWord()){
            gui.println("\nOu voulez vous aller ?\n");
            return;
        }
        else{
            String vDirection = pCmd.getSecondWord();
            Room nextRoom = aCurrentRoom.getExits(vDirection);
            if(nextRoom==null){
                gui.println("\nIl n'y pas de sorties par là !\n");
            }
            else{
                aCurrentRoom = nextRoom;
                if(aCurrentRoom.getImageName() != null)
                    gui.showImage(aCurrentRoom.getImageName());          
            }
        }
        printLocationInfo();
    }
    
    /**
     * Affiche la description de la salle
     */
    private void printLocationInfo(){
        gui.println(aCurrentRoom.getLongDescription());
    }
    
    /**
     * Commande "help", affiche un resume du jeu et la liste des commandes disponnibles
     */
    private void printHelp(){
        gui.println ("\nVous êtes en quêtes pour sauver le royaume !");
        gui.println("Vos commandes sont: ");
        gui.println(aParser.showCommands());
    }
    
    /**
     * Methode de la commande "look", affiche la description de la salle
     */
    private void look(){
        gui.println(aCurrentRoom.getLongDescription());
    }
    
    private void back(){
        if(aStackRoom.empty()) gui.println("Vous ne pouvez plus revenir en arriere ! \n");
        else{
        aCurrentRoom = (Room)aStackRoom.pop();
        if(aCurrentRoom.getImageName() != null)
                    gui.showImage(aCurrentRoom.getImageName()); 
        printLocationInfo();
        }
    }
    
    /**
     * Methode de la commande "eat", affiche un message lorsque le joueur mange
     */
    private void eat(){
        gui.println("Vous n'avez plus de faim\n");
    }
    
    private void endGame(){
        gui.println("Merci d'avoir joué ! Aurevoir.\n");
        gui.enable(false);
    }
}
