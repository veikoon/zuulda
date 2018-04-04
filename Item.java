
/**
 * Write a description of class Items here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Item{
    private String aDescription;
    private double aPrix;
    private double aPoids;
    
    public Item(final String pDes, final double pPrix, final double pPoids){
        this.aDescription = pDes;
        this.aPrix = pPrix;
        this.aPoids = pPoids;
    }
    
    public String getDescription(){
        return this.aDescription;
    }
}
