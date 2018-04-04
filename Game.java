/**
 * Cette classe est une classe du jeu: The legend of Zuulda
 * C'est un jeu d'aventure dans le style d'un rpg
 * 
 * Game est la classe principale du jeu, elle affiche les informations d'entré et de sortie du jeu
 * Elle initialise la carte du jeu
 * Elle associe les commandes entrées par l'utilisateur avec les fonctions associés
 */
public class Game
{
    private UserInterface gui;
    private GameEngine engine;

    /**
     * Constructeur par defaut de la classe Game
     * Il appelle la methode createRooms afin d'initialiser les maps
     */
    public Game(){
        engine = new GameEngine();
	gui = new UserInterface(engine);
	engine.setGUI(gui);
    }
} // Game
