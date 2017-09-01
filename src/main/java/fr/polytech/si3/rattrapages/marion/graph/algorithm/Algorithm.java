package fr.polytech.si3.rattrapages.marion.graph.algorithm;

import fr.polytech.si3.rattrapages.marion.graph.Edge;

import java.util.List;

/**
 * @author Marion
 */
public abstract class Algorithm {


    protected Edge edge;

    protected int fathers[] = new int[1000];

    public abstract List<List<Integer>> fcm();

    protected int find(int x){
        if (fathers[x] == x){
            return x;
        }
        return find(fathers[x]);
    }


    protected boolean union(int root1, int root2){
        int cpt = 0;
        boolean isRoot1PowerSource = false;
        boolean isRoot2PowerSource = false;
        for (int i = 0; i < edge.getPowerSourceList().size(); i++) {
            if (root1 == edge.getPowerSourceList().get(i).getId()){
                cpt = 1;
                isRoot1PowerSource = true;
            }
            if (root2 == edge.getPowerSourceList().get(i).getId()){
                cpt = 2;
                isRoot2PowerSource = true;
            }
        }
        if (cpt == 0) {
            if (fathers[root1] >= fathers[root2]) {
                fathers[root2] = root1;
                if (fathers[root1] == -1) {
                    fathers[root1] = root1;
                }
            } else {
                fathers[root1] = root2;
                if (fathers[root2] == -1) {
                    fathers[root2] = root2;
                }
            }
        }
        if (cpt == 1) {
            fathers[root2] = root1;
        }
        if (cpt == 2) {
            fathers[root1] = root2;

        }

        if (isRoot1PowerSource&& isRoot2PowerSource){
            return false;
        }
        else {
            return true;
        }
    }
}
