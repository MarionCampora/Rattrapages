package fr.polytech.si3.rattrapages.marion.building;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marion
 */
public class House extends Building {

    private List<House> houseList = new ArrayList<>();

    public House(int id) {
        super(id);
    }

    public void addHouse(House house){
        houseList.add(house);
        addBuilding(house);
    }
}
