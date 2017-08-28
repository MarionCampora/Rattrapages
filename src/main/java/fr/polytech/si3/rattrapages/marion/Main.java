package fr.polytech.si3.rattrapages.marion;

import fr.polytech.si3.rattrapages.marion.graph.WeightedEdge;
import fr.polytech.si3.rattrapages.marion.graph.WeightedUnDiGraph;
import fr.polytech.si3.rattrapages.marion.graph.algorithm.KruskalAvecSources;
import fr.polytech.si3.rattrapages.marion.heap.EmptyHeapException;
import fr.polytech.si3.rattrapages.marion.heap.FullHeapException;

import java.util.Set;

/**
 * @author Marion
 */
public class Main {
    public static void main(String args[]) throws FullHeapException, EmptyHeapException {
        KruskalAvecSources k = new KruskalAvecSources();
        WeightedUnDiGraph G = new WeightedUnDiGraph(9);
        G.addEdge(0,2,4);
        G.addEdge(0,5,8);
        G.addEdge(1,4,2);
        G.addEdge(1,5,7);
        G.addEdge(1,7,6);
        G.addEdge(2,4,8);
        G.addEdge(2,5,11);
        G.addEdge(3,4,4);
        G.addEdge(3,6,10);
        G.addEdge(3,7,2);
        G.addEdge(3,8,14);
        G.addEdge(4,8,7);
        G.addEdge(5,7,1);
        G.addEdge(6,8,9);

        Set<WeightedEdge> mst = k.mst(G);

        for ( WeightedEdge e : mst )
            System.out.print(e + " ");
        System.out.println();
    }
}
