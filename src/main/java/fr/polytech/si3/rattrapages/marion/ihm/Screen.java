package fr.polytech.si3.rattrapages.marion.ihm;

import fr.polytech.si3.rattrapages.marion.graph.Edge;

/**
 * @author Marion
 */
public class Screen {

   private Edge edge = new Edge();

    public void display (){
        edge.createAllThePowerSource();
        edge.createAllTheHouses();
        edge.createAllTheLinks();
        edge.algorithmChoice(edge);

    }


}
