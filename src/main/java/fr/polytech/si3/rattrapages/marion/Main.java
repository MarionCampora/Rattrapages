package fr.polytech.si3.rattrapages.marion;

import fr.polytech.si3.rattrapages.marion.heap.EmptyHeapException;
import fr.polytech.si3.rattrapages.marion.heap.FullHeapException;
import fr.polytech.si3.rattrapages.marion.ihm.Screen;


/**
 * @author Marion
 */
public class Main {
    public static void main(String args[]) throws FullHeapException, EmptyHeapException {
        Screen screen = new Screen();
        screen.display();
    }
}
