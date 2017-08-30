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

    public KruskalAvecSources (Edge edge){
        this.edge = edge;
    }

    @Override
    public List<List<Integer>> mst() {Sort sort = new Sort();
        List<List<Integer>> sortLinkedList = sort.sortLinkedList(edge.getLinkList());
        List<List<Integer>> kruskalList = new ArrayList<>();
        List<Integer> first = sortLinkedList.remove(0);
        List building = new ArrayList();
        kruskalList.add(first);
        building.add(first.get(0));
        building.add(first.get(1));
        while (building.size() < edge.getBuildingList().size() && sortLinkedList.size() > 0) {
            createTheGraph(sortLinkedList, building, kruskalList);
        }
        return kruskalList;
    }

    private void createTheGraph (List<List<Integer>> sortLinkedList, List building, List<List<Integer>> kruskalList){
            int cycle = 0;
            for (int j = 0; j < building.size(); j++) {
                if (sortLinkedList.get(0).get(0) == building.get(j)){
                    for (int k = j; k < building.size(); k++) {
                        if (sortLinkedList.get(0).get(1) == building.get(k)){
                            cycle = 3;
                        }
                        else {
                            cycle = 1;
                        }
                    }
                }
                if (sortLinkedList.get(0).get(1) == building.get(j)){
                    for (int k = j; k < building.size(); k++) {
                        if (sortLinkedList.get(0).get(0) == building.get(k)){
                            cycle = 3;
                        }
                        else {
                            cycle = 2;
                        }
                    }
                }
            }
            if (cycle == 0){
                building.add(sortLinkedList.get(0).get(0));
                building.add(sortLinkedList.get(0).get(1));
                kruskalList.add(sortLinkedList.remove(0));
                System.out.println("0");
            }
            else if (cycle == 1){
                building.add(sortLinkedList.get(0).get(1));
                kruskalList.add(sortLinkedList.remove(0));
                System.out.println("1");
            }
            else if (cycle == 2){
                building.add(sortLinkedList.get(0).get(0));
                kruskalList.add(sortLinkedList.remove(0));
                System.out.println("2");
            }
            else {
                sortLinkedList.remove(0);
                System.out.println("3");
            }
        }


}
