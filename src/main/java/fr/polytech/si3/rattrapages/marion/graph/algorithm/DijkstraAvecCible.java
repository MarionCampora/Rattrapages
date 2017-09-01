package fr.polytech.si3.rattrapages.marion.graph.algorithm;

import fr.polytech.si3.rattrapages.marion.graph.Edge;
import fr.polytech.si3.rattrapages.marion.graph.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marion
 */
public class DijkstraAvecCible extends Algorithm {
    private int building;
    private List<List<Integer>> dijkstraList;
    private int powerSource;
    private int distanceFromStart[] = new int[1000];
    private int isNew[] = new int[1000];
    private int isNewAdjacent[] = new int[1000];
    private int isNewWeight[] = new int[1000];
    private List<Integer> buildingList;
    private int totalWeight;
    private List<Integer> allTheWeight = new ArrayList<>();
    List<List<List<Integer>>> allTheDijkstraList = new ArrayList<>();

    public DijkstraAvecCible (Edge edge, int building){
        this.edge = edge;
        this.building = building;
    }

    public void createAllTheTable(){
        for (int i = 0; i < 1000; i++) {
            fathers[i] = i;
        }
        for (int i = 0; i < 1000; i++) {
            distanceFromStart[i] = -1;
        }
        for (int i = 0; i < 1000; i++) {
            isNew[i] = 0;
        }
        for (int i = 0; i < 1000; i++) {
            isNewAdjacent[i] = -1;
        }
        for (int i = 0; i < 1000; i++) {
            isNewWeight[i] = -1;
        }
    }
    @Override
    public List<List<Integer>> mst() {
        createAllTheTable();
        Sort sort = new Sort();
        List<List<Integer>> sortLinkedList = sort.sortLinkedList(edge.getLinkList());
        buildingList = new ArrayList<>();
        int cptEdges = 0;
        while (edge.getPowerSourceList().size() > 0) {
            totalWeight = 0;
            dijkstraList = new ArrayList<>();
            powerSource = findTheFirst(sortLinkedList, cptEdges, dijkstraList);
            if (edge.getBuildingList().size() == 2){
                allTheWeight.add(totalWeight);
                allTheDijkstraList.add(dijkstraList);
            }
            else {
                while (buildingList.size() < edge.getBuildingList().size() && sortLinkedList.size() > 0) {
                    createTheGraph(sortLinkedList, building, dijkstraList, powerSource);
                    allTheWeight.add(totalWeight);
                    allTheDijkstraList.add(dijkstraList);
                }
            }
        }
        return path(allTheDijkstraList.get(sort.sortWeight(allTheWeight)));

    }

    private List<List<Integer>> path(List<List<Integer>> dijList){
        List<List<Integer>> finalDijList = new ArrayList<>();
        int size = dijList.size();
        int powerSource = dijList.get(0).get(0);
        finalDijList.add(dijList.get(size-1));
        int current = building;
        for (int j = size-1; j >= 0 ; j--) {
            if (current == dijList.get(j).get(0)){
                current = dijList.get(j).get(1);
                finalDijList.add(dijList.get(j));
            }
            else if (current == dijList.get(j).get(1)){
                current = dijList.get(j).get(0);
                finalDijList.add(dijList.get(j));
            }
            if (current == powerSource){
                j = -1;
            }
        }
        Collections.reverse(finalDijList);
        finalDijList.remove(finalDijList.size()-1);
        return finalDijList;
    }

    private int findTheFirst(List<List<Integer>> sortLinkedList, int cptEdges, List<List<Integer>> dijkstraList){
        int powerSource = 0;
        for (int j = 0; j < sortLinkedList.size(); j++) {
            for (int i = 0; i < edge.getPowerSourceList().size(); i++) {
                if (((edge.getPowerSourceList().get(i).getId() == sortLinkedList.get(j).get(0) || edge.getPowerSourceList().get(i).getId() == sortLinkedList.get(j).get(1))) && cptEdges == 0) {
                    List<Integer> first = sortLinkedList.remove(j);
                    if (edge.getPowerSourceList().get(i).getId() == sortLinkedList.get(j).get(0)){
                        buildingList.add(first.get(0));
                        buildingList.add(first.get(1));
                    }
                    else {
                        buildingList.add(first.get(1));
                        buildingList.add(first.get(0));
                    }
                    cptEdges = 2;
                    dijkstraList.add(first);
                    powerSource = edge.removeFromPowerSourceList(i).getId();
                    isNew[first.get(0)] = 2;
                    isNew[first.get(1)] = 2;
                    totalWeight = first.get(2);
                    distanceFromStart[powerSource] = 0;
                    if (powerSource == first.get(0)) {
                        distanceFromStart[first.get(1)] = first.get(2);
                        fathers[first.get(1)] = first.get(0);
                        isNewWeight[powerSource] = 0;
                        isNewWeight[first.get(1)] = totalWeight;
                        isNewAdjacent[powerSource] = powerSource;
                        isNewAdjacent[first.get(1)] = powerSource;
                    }
                    else if (powerSource == first.get(1)){
                        distanceFromStart[first.get(0)] = first.get(2);
                        fathers[first.get(0)] = first.get(1);
                        isNewWeight[powerSource] = 0;
                        isNewWeight[first.get(0)] = totalWeight;
                        isNewAdjacent[powerSource] = powerSource;
                        isNewAdjacent[first.get(0)] = powerSource;
                    }
                }
            }
        }
        return powerSource;
    }
    private void createTheGraph (List<List<Integer>> sortLinkedList, int building, List<List<Integer>> dijkstraList, int powerSource){
        boolean isFinished = true;
        while (isFinished){
            int cpt = 0;
            for (int i = 0; i < sortLinkedList.size(); i++) {
                int a = sortLinkedList.get(i).get(0);
                int b = sortLinkedList.get(i).get(1);
                int w = sortLinkedList.get(i).get(2);
                int A = find(a);
                int B = find(b);
                if (A != B){
                    cpt++;
                    if (isNew[a] == 2){
                        if (distanceFromStart[b] == -1) {
                            distanceFromStart[b] = distanceFromStart[a] + w;
                            isNew[b] = 1;
                            isNewAdjacent[b] = a;
                            isNewWeight[b] = w;
                            fathers[b] = fathers[a];
                        }
                        else if (distanceFromStart[b] > distanceFromStart[a] + w){
                            distanceFromStart[b] = distanceFromStart[a] + w;
                            isNew[b] = 1;
                            isNewAdjacent[b] = a;
                            isNewWeight[b] = w;
                            fathers[b] = fathers[a];
                        }
                    }
                    else if (isNew[b] == 2){
                        if (distanceFromStart[a] == -1){
                            distanceFromStart[a] = distanceFromStart[b] + w;
                            isNew[a] = 1;
                            isNewAdjacent[a] = b;
                            isNewWeight[a] = w;
                            fathers[a] = fathers[b];
                        }
                        else if (distanceFromStart[a] > distanceFromStart[b] + w){
                            distanceFromStart[a] = distanceFromStart[b] + w;
                            isNew[a] = 1;
                            isNewAdjacent[a] = b;
                            isNewWeight[a] = w;
                            fathers[a] = fathers[b];
                        }
                    }
                }
            }
            if (findTheNextLink(powerSource, dijkstraList) == building){
                isFinished = false;
            }
            if (cpt == 0){
                isFinished = false;
            }
        }
    }

    public int findTheNextLink (int powerSource, List<List<Integer>> dijkstraList){
        int smallerPath = powerSource;
        int smallerWeight = -1;
        for (int i = 0; i < distanceFromStart.length; i++) {
            if (distanceFromStart[i] > 0 && isNew[i] == 1 && i != powerSource){
                if (smallerWeight == -1){
                    smallerWeight = distanceFromStart[i];
                    smallerPath = i;
                }
                else if (smallerWeight > distanceFromStart[i]){
                    smallerPath = i;
                    smallerWeight = distanceFromStart[i];
                }
            }
        }
        distanceFromStart[smallerPath] = smallerWeight;
        List<Integer> list = new ArrayList<>();
        list.add(smallerPath);
        list.add(isNewAdjacent[smallerPath]);
        list.add(isNewWeight[smallerPath]);
        isNew[smallerPath] = 2;
        totalWeight += isNewWeight[smallerPath];
        dijkstraList.add(list);
        buildingList.add(smallerPath);
        return smallerPath;
    }


}
