package fr.polytech.si3.rattrapages.marion.graph;

import fr.polytech.si3.rattrapages.marion.building.Building;
import fr.polytech.si3.rattrapages.marion.building.House;
import fr.polytech.si3.rattrapages.marion.building.PowerSource;
import fr.polytech.si3.rattrapages.marion.graph.algorithm.Algorithm;
import fr.polytech.si3.rattrapages.marion.graph.algorithm.KruskalAvecSources;
import fr.polytech.si3.rattrapages.marion.graph.algorithm.PrimAvecSources;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Marion
 */
public class Edge {

    private List<Building> buildingList = new ArrayList<>();
    private List<PowerSource> powerSourceList = new ArrayList<>();
    private List<List<Integer>> linkList = new ArrayList<>();


    public void createPowerSource (){
        System.out.println("Write the ID of a PowerSource: ");
        Building building = new PowerSource(readAnInteger());
        if (addBuilding(building)){
            addPowerSource((PowerSource) building);
        }
    }

    public int readAnInteger(){
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        return str;
    }

    public void createAllThePowerSource(){
        createPowerSource();
        System.out.println("Do you want to create another PowerSource ? (y/n)");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals("y") || str.equals("Y")){
            createAllThePowerSource();
        }
    }

    public void createHouse(){
        System.out.println("Write the ID of an House: ");
        Building building = new House(readAnInteger());
        addBuilding(building);
    }

    public void createAllTheHouses(){
        createHouse();
        System.out.println("Do you want to create another House ? (y/n)");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals("y") || str.equals("Y")){
            createAllTheHouses();
        }
    }

    public boolean isCreated (int u){
        for (int i = 0; i < buildingList.size(); i++) {
            if (u == buildingList.get(i).getId()){
                return true;
            }
        }
        return false;
    }

    public void createLink(List list){
        int str = readAnInteger();
        if (isCreated(str)){
            list.add(str);
        }
        else{
            System.out.println("Please enter a building which is already create");
            createLink(list);
        }
    }

    public void createAllTheLinks(){
        List list = new ArrayList();
        System.out.println("Write a link between to point : \nFirst point :");
        createLink(list);
        System.out.println("Second point: ");
        createLink(list);
        System.out.println("Weight: ");
        list.add(readAnInteger());
        isLinked(list);
        System.out.println("Do you want to create another Link ? (y/n)");
        Scanner sc3 = new Scanner(System.in);
        String str3 = sc3.nextLine();
        if(str3.equals("y") || str3.equals("Y")){
            createAllTheLinks();
        }
    }

    public boolean isLinked(List list){
        for (int i = 0; i < linkList.size(); i++) {
            List list1 = linkList.get(i);
            if ((list.get(0) == list1.get(0) && list.get(1) == list1.get(1)) || (list.get(0) == list1.get(1) && list.get(1) == list1.get(0))){
                System.out.println("Link already created.");
                return false;
            }
        }
        linkList.add(list);
        return true;
    }

    public void algorithmChoice(){
        System.out.println("Choose an algorithm : \n- Kruskal (1)\n- Prim (2)\n- Dijkstra (3)");
        int str = readAnInteger();
        Algorithm algorithm;
        if (str == 1){
            System.out.println("K");
            algorithm = new KruskalAvecSources();
            algorithm.mst();
            algorithmChoice();
        }
        else if (str == 2){
            System.out.println("P");
            algorithm = new PrimAvecSources();
            algorithm.mst();
            algorithmChoice();
        }
        else if (str == 3){
            System.out.println("D");
            algorithmChoice();
        }
        else {
            System.out.println("ok");
        }
    }

    public int nbVertices(){
        return buildingList.size();
    }

    public int nbEdges(){
        return linkList.size();
    }

    public boolean addBuilding(Building building){
        for (int i = 0; i < buildingList.size(); i++) {
            if(building.getId() == buildingList.get(i).getId()){
                System.out.println("Building is already create.");
                return false;
            }
        }
        buildingList.add(building);
        return true;
    }

    public void addPowerSource(PowerSource source){
        powerSourceList.add(source);
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public List<PowerSource> getPowerSourceList() {
        return powerSourceList;
    }

    public List<List<Integer>> getLinkList() {
        return linkList;
    }
}
