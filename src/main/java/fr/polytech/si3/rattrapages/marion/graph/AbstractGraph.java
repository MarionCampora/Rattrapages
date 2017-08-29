/*
package fr.polytech.si3.rattrapages.marion.graph;

import fr.polytech.si3.rattrapages.marion.building.Building;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

*/
/**
 * @author Marion
 *//*

public abstract class AbstractGraph {
    protected int nbEdges;
    protected List<List<Building>> adjacencyList;

    public AbstractGraph(int n){
        nbEdges = 0;
        adjacencyList = new ArrayList<List<Building>>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new LinkedList<Building>());
        }
    }

    public int nbVertices(){
        return adjacencyList.size();
    }

    public int nbEdges(){
        return nbEdges;
    }

    public Iterable<Building> adjacents (Building u) {
        return adjacencyList.get(u.getId());
    }

    public void addEdge(WeightedEdge e){
        addEdge(e.origin(), e.destination(), e.getWeight());
    }

    public abstract void addEdge (Building u, Building v, int w);

    private class EdgeIterator implements Iterable<WeightedEdge>, Iterator<WeightedEdge> {

        Integer origin;
        Iterator<Building> adjacents;

        EdgeIterator(Integer u) {
            origin = u;
            adjacents = adjacencyList.get(u).iterator();
        }

        public Iterator<WeightedEdge> iterator() {
            return this;
        }

        public boolean hasNext() {
            return adjacents.hasNext();
        }

        public WeightedEdge next() {
            for (int i = 0; i < nbEdges; i++) {
                if (adjacents.next() == )
            }
            return new WeightedEdge(origin,adjacents.next());
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
*/
