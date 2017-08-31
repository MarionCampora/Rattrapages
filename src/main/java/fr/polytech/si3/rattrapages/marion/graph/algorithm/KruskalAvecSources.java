package fr.polytech.si3.rattrapages.marion.graph.algorithm;

import fr.polytech.si3.rattrapages.marion.graph.Edge;
import fr.polytech.si3.rattrapages.marion.graph.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marion
 */
public class KruskalAvecSources extends Algorithm{

    private Edge edge;
    private int fathers[] = new int[1000];
    private int mstEdges = 0;

    public KruskalAvecSources (Edge edge){
        this.edge = edge;
    }

    @Override
    public List<List<Integer>> mst() {Sort sort = new Sort();
        List<List<Integer>> sortLinkedList = sort.sortLinkedList(edge.getLinkList());
        List<List<Integer>> kruskalList = new ArrayList<>();
        int cpt = 0;
        for (int i = 0; i < 1000; i++) {
            fathers[i] = i;
        }
        while (mstEdges <= edge.nbEdges()|| sortLinkedList.size() > cpt) {
            createdTheGraph(sortLinkedList, kruskalList, cpt, fathers);
            cpt ++;
        }
        return kruskalList;
    }

    private int find(int x){
        if (fathers[x] == x){
            return x;
        }
        return find(fathers[x]);
    }

    private void union(int root1, int root2){
        if (fathers[root1] >= fathers[root2]){
            fathers[root2] = root1;
            if (fathers[root1] == -1){
                fathers[root1] = root1;
            }
        }
        else {
            fathers[root1] = root2;
            if (fathers[root2] == -1){
                fathers[root2] = root2;
            }
        }
    }
    
    private void createdTheGraph (List<List<Integer>> sortLinkedList, List<List<Integer>> kruskalList, int j, int[] fathers){
        if (find(fathers[sortLinkedList.get(j).get(0)]) != find(fathers[sortLinkedList.get(j).get(1)]) || find(fathers[sortLinkedList.get(j).get(0)]) == -1 || find(fathers[sortLinkedList.get(j).get(1)]) == -1){
            union(fathers[sortLinkedList.get(j).get(0)], fathers[sortLinkedList.get(j).get(1)]);
            kruskalList.add(sortLinkedList.get(j));
            mstEdges++;
        }
    }

}
