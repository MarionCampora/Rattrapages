package fr.polytech.si3.rattrapages.marion.graph.algorithm;

import fr.polytech.si3.rattrapages.marion.building.Building;
import fr.polytech.si3.rattrapages.marion.building.PowerSource;
import fr.polytech.si3.rattrapages.marion.graph.Edge;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Marion
 */
public class TestPrimAvecSources {
    PrimAvecSources primAvecSources;
    Edge edge;
    List<Integer> list8 = new ArrayList<>();
    List<Integer> list7 = new ArrayList<>();
    List<Integer> list6 = new ArrayList<>();
    List<Integer> list5 = new ArrayList<>();
    List<Integer> list4 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    Building building2 = new Building(2);
    Building building3 = new Building(3);
    Building building4 = new Building(4);
    Building building5 = new Building(5);


    @Before
    public void setUp(){
        edge = new Edge();
        primAvecSources = new PrimAvecSources(edge);
        PowerSource powerSource = new PowerSource(1);
        PowerSource powerSource2 = new PowerSource(15);
        edge.addPowerSource(powerSource);
        edge.addPowerSource(powerSource2);
        edge.addBuilding(powerSource);
        edge.addBuilding(powerSource2);
        edge.addBuilding(building2);
        edge.addBuilding(building3);
        edge.addBuilding(building4);

        list2.add(1);
        list2.add(2);
        list2.add(3);

        list3.add(1);
        list3.add(5);
        list3.add(1);

        list1.add(5);
        list1.add(3);
        list1.add(4);

        list4.add(3);
        list4.add(2);
        list4.add(6);

        list5.add(3);
        list5.add(4);
        list5.add(1);

        list6.add(15);
        list6.add(2);
        list6.add(2);

        list7.add(1);
        list7.add(15);
        list7.add(1);

        list8.add(5);
        list8.add(2);
        list8.add(3);

    }

    @Test
    public void testPrimSimple(){
        edge.addLinkList(list1);
        edge.addLinkList(list2);
        edge.addLinkList(list3);
        edge.addLinkList(list4);
        edge.addLinkList(list5);
        edge.addLinkList(list8);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list3);
        list.add(list2);
        list.add(list1);
        list.add(list5);
        List<List<Integer>> primList = primAvecSources.mst();
        assertEquals(primList, list);
    }

    @Test
    public void testPrimForest(){
        edge.addLinkList(list1);
        edge.addLinkList(list2);
        edge.addLinkList(list3);
        edge.addLinkList(list4);
        edge.addLinkList(list5);
        edge.addLinkList(list6);
        edge.addLinkList(list8);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list3);
        list.add(list6);
        list.add(list1);
        list.add(list5);
        List<List<Integer>> primList = primAvecSources.mst();
        assertEquals(primList, list);
    }

}

