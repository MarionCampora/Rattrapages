package fr.polytech.si3.rattrapages.marion.graph;

import fr.polytech.si3.rattrapages.marion.building.Building;

/**
 * @author Marion
 */
public class WeightedEdge implements Comparable<WeightedEdge> {
    private int weight;
    private Building x;
    private Building y;

    public WeightedEdge (Building x, Building y, int weight){
        this.weight = weight;
        this.x = x;
        this.y = y;
    }

    public WeightedEdge (Building x, Building y){
        this.x = x;
        this.y = y;
    }

    public int getWeight() {
        return weight;
    }

    public int compareTo(WeightedEdge e){
        if (weight < e.weight){
            return -1;
        }
        if (weight > e.weight){
            return 1;
        }
        return 0;
    }

    public Building origin() {
        return x;
    }

    public Building destination() {
        return y;
    }

}
