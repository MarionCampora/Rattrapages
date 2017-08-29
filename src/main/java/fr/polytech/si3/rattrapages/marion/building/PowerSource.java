package fr.polytech.si3.rattrapages.marion.building;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marion
 */
public class PowerSource extends Building {

    private List<PowerSource> powerSourceList = new ArrayList<>();

    public PowerSource(int id) {
        super(id);
    }

    public void addPowerSource(PowerSource powerSource){
        powerSourceList.add(powerSource);
        addBuilding(powerSource);
    }
}
