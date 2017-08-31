package fr.polytech.si3.rattrapages.marion.building;

import java.util.List;

/**
 * @author Marion
 */
public class Building {
    protected int id;
    private List<Building> buildingList;
    private List<Integer> idList;

    public Building(int id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void addBuilding (Building building){
        idList.add(building.getId());
        buildingList.add(building);
    }

    public List<Integer> getIdList() {
        return idList;
    }
}
