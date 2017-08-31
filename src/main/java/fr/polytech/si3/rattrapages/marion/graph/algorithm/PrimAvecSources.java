package fr.polytech.si3.rattrapages.marion.graph.algorithm;

import fr.polytech.si3.rattrapages.marion.graph.Edge;
import fr.polytech.si3.rattrapages.marion.graph.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marion
 */
public class PrimAvecSources extends Algorithm {
    private Edge edge;

    public PrimAvecSources(Edge edge) {
        this.edge = edge;
    }

    @Override
    public List<List<Integer>> mst() {
        Sort sort = new Sort();
        List<List<Integer>> sortLinkedList = sort.sortLinkedList(edge.getLinkList());
        List<List<Integer>> primList = new ArrayList<>();
        List building = new ArrayList();
        int cptEdges = 0;
        for (int j = 0; j < sortLinkedList.size(); j++) {
            for (int i = 0; i < edge.getPowerSourceList().size(); i++) {
                if (((edge.getPowerSourceList().get(i).getId() == sortLinkedList.get(j).get(0) || edge.getPowerSourceList().get(i).getId() == sortLinkedList.get(j).get(1))) && cptEdges == 0) {
                    List<Integer> first = sortLinkedList.remove(j);
                    building.add(first.get(0));
                    building.add(first.get(1));
                    cptEdges = 2;
                    primList.add(first);
                    edge.removeFromPowerSourceList(i);
                }
            }
        }
        if (cptEdges != 0) {
            while (building.size() < edge.getBuildingList().size() && sortLinkedList.size() > 0) {
                createTheGraph(sortLinkedList, building, primList);
            }
        }
        return primList;
    }

    public void createTheGraph(List<List<Integer>> sortLinkedList, List building, List<List<Integer>> primList) {
        for (int i = 0; i < sortLinkedList.size(); i++) {
            int cycle = 0;
            int newBuilding = 0;
            boolean isLinked = true;
            for (int j = 0; j < building.size(); j++) {
                //makeAForest(sortLinkedList, i, building, isLinked, primList);
                if (sortLinkedList.get(i).get(1) == building.get(j)) {
                    cycle++;
                    newBuilding = sortLinkedList.get(i).get(0);
                }
                if (sortLinkedList.get(i).get(0) == building.get(j)) {
                    cycle++;
                    newBuilding = sortLinkedList.get(i).get(1);
                }
            }
            if (cycle == 1) {
                List<Integer> first = sortLinkedList.remove(i);
                primList.add(first);
                building.add(newBuilding);
                createTheGraph(sortLinkedList, building, primList);
            }
            if (cycle == 0 && edge.getPowerSourceList().size() != 0) {
                isLinked = false;
                makeAForest(sortLinkedList, i, building, isLinked, primList);
            }
        }
    }

    public boolean makeAForest(List<List<Integer>> sortLinkedList, int i, List building, boolean isLinked, List<List<Integer>> primList) {
        for (int j = 0; j < edge.getPowerSourceList().size(); j++) {
            if (sortLinkedList.get(i).get(0) == edge.getPowerSourceList().get(j).getId()) {
                if (isLinked) {
                    List<Integer> first = sortLinkedList.remove(i);
                    building.add(first.get(0));
                } else {
                    List<Integer> first = sortLinkedList.remove(i);
                    building.add(first.get(0));
                    building.add(first.get(1));
                    primList.add(first);
                    createTheGraph(sortLinkedList, building, primList);
                }
                return false;
            } else if (sortLinkedList.get(i).get(1) == edge.getPowerSourceList().get(j).getId()) {
                if (isLinked) {
                    List<Integer> first = sortLinkedList.remove(i);
                    building.add(first.get(1));
                } else {
                    List<Integer> first = sortLinkedList.remove(i);
                    building.add(first.get(1));
                    building.add(first.get(0));
                    primList.add(first);
                    createTheGraph(sortLinkedList, building, primList);
                }
                return false;
            }
        }
        return true;
    }
}
