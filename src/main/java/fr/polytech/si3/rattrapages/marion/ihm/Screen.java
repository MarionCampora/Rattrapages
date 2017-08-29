package fr.polytech.si3.rattrapages.marion.ihm;

import fr.polytech.si3.rattrapages.marion.building.Building;
import fr.polytech.si3.rattrapages.marion.building.House;
import fr.polytech.si3.rattrapages.marion.building.PowerSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Marion
 */
public class Screen {

    private List<Building> buildingList;
    private List<House> houseList;
    private List<PowerSource> powerSourceList;
    private List<List<Integer>> linkList;


    public boolean createPowerSource (){
        System.out.println("Write the ID of a PowerSource: ");
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        for (int i = 0; i < buildingList.size(); i++) {
            if(str == buildingList.get(i).getId()){
                System.out.println("Building is already create.");
                return false;
            }
        }
        Building building = new PowerSource(str);
        buildingList.add(building);
        powerSourceList.add((PowerSource) building);
        return true;
    }

    public void createdPowerSource (){
        createPowerSource();
        System.out.println("Do you want to create another PowerSource ? (y/n)");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals("y") || str.equals("Y")){
            createdPowerSource();
        }
    }

    public boolean createHouse(){
        System.out.println("Write the ID of an House: ");
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        for (int i = 0; i < buildingList.size(); i++) {
            if (str == buildingList.get(i).getId()){
                System.out.println("Building is already create.");
                return false;
            }
        }
        Building building = new House(str);
        buildingList.add(building);
        houseList.add((House) building);
        return true;
    }

    public void createdHouse(){
        createHouse();
        System.out.println("Do you want to create another House ? (y/n)");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals("y") || str.equals("Y")){
            createdHouse();
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
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        if (isCreated(str)){
            list.add(str);
        }
        else{
            System.out.println("Please enter a building which is already create");
            createLink(list);
        }
    }

    public void createdLink(){
        List list = new ArrayList();
        System.out.println("Write a link between to point : \nFirst point :");
        createLink(list);
        System.out.println("Second point: ");
        createLink(list);
        System.out.println("Weight: ");
        Scanner sc2 = new Scanner(System.in);
        int str2 = sc2.nextInt();
        list.add(str2);
        isLinked(list);
        System.out.println("Do you want to create another Link ? (y/n)");
        Scanner sc3 = new Scanner(System.in);
        String str3 = sc3.nextLine();
        if(str3.equals("y") || str3.equals("Y")){
            createdLink();
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
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        if (str == 1){
            System.out.println("K");
            algorithmChoice();
        }
        else if (str == 2){
            System.out.println("P");
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

    public void display (){
        buildingList = new ArrayList<>();
        powerSourceList = new ArrayList<>();
        houseList = new ArrayList<>();
        linkList = new ArrayList<>();
        createdPowerSource();
        createdHouse();
        createdLink();
        algorithmChoice();
    }


}
