package fr.polytech.si3.rattrapages.marion.graph;

import fr.polytech.si3.rattrapages.marion.building.Building;
import fr.polytech.si3.rattrapages.marion.building.House;
import fr.polytech.si3.rattrapages.marion.building.PowerSource;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Marion
 */
public class EdgeTest {

    Edge edge;

    @Before
    public void setUp(){
        edge = new Edge();
    }

    @Test
    public void testNbVertices(){
        assertEquals(edge.nbVertices(), 0);
        Building p = new PowerSource(1);
        edge.addBuilding(p);
        assertEquals(edge.nbVertices(), 1);
        Building a = new House(2);
        Building b = new House(3);
        edge.addBuilding(a);
        edge.addBuilding(b);
        assertEquals(edge.nbVertices(), 3);
    }

    @Test
    public void testNbEdges(){
        int nbr = edge.nbEdges();
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(65);
        edge.isLinked(list);
        assertEquals(edge.nbEdges(), nbr+1);
        List list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(75);
        edge.isLinked(list1);
        assertEquals(edge.nbEdges(),nbr+2);
        List list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(42);
        edge.isLinked(list2);
        assertEquals(edge.nbEdges(),nbr+3);
    }

    @Test
    public void testIfIdBuildingAlreadyExistWithSameBuilding(){
        Building v = new PowerSource(7);
        Building j = new PowerSource(7);
        edge.addBuilding(v);
        assertEquals(edge.addBuilding(j), false);
        Building c = new House(8);
        Building d = new House(8);
        edge.addBuilding(c);
        assertEquals(edge.addBuilding(d), false);
    }

    @Test
    public void testIfIdBuildingAlreadyExistWithDifferentBuilding(){
        Building x = new PowerSource(9);
        Building y = new House(9);
        edge.addBuilding(x);
        assertEquals(edge.addBuilding(y), false);
        Building z = new PowerSource(10);
        Building w = new House(10);
        edge.addBuilding(w);
        assertEquals(edge.addBuilding(z), false);
    }

    @Test
    public void testCreationOfLink(){
        Building n = new PowerSource(11);
        Building m = new House(12);
        edge.addBuilding(n);
        edge.addBuilding(m);
        int size = edge.getLinkList().size();
        List list = new ArrayList();
        list.add(n.getId());
        list.add(m.getId());
        list.add(42);
        edge.isLinked(list);
        assertEquals(edge.getLinkList().size(), size+1);
    }

    @Test
    public void testIfLinkAlreadyExistInTheSameWay(){
        Building o = new PowerSource(11);
        Building p = new House(12);
        List list = new ArrayList();
        list.add(o.getId());
        list.add(p.getId());
        list.add(42);
        edge.addBuilding(o);
        edge.addBuilding(p);
        edge.isLinked(list);
        int size = edge.getLinkList().size();
        List list1 = new ArrayList();
        list1.add(o.getId());
        list1.add(p.getId());
        list.add(58);
        assertEquals(edge.isLinked(list1), false);
        assertEquals(edge.getLinkList().size(), size);
    }

    @Test
    public void testIfLinkAlreadyExistInTheOtherWay(){
        Building o = new PowerSource(13);
        Building p = new House(14);
        List list = new ArrayList();
        edge.addBuilding(o);
        edge.addBuilding(p);
        list.add(o.getId());
        list.add(p.getId());
        list.add(42);
        edge.isLinked(list);
        int size = edge.getLinkList().size();
        List list1 = new ArrayList();
        list1.add(p.getId());
        list1.add(o.getId());
        list.add(58);
        assertEquals(edge.isLinked(list1), false);
        assertEquals(edge.getLinkList().size(), size);
    }

    @Test
    public void testIfAPowerSourceIsCreated(){

    }

    @Test
    public void testIfTheChoiceOfAlgorithmIsGoodForKruskal(){
        //TO DO
    }

    @Test
    public void testIfTheChoiceOfAlgorithmIsGoodForPrim(){
        //TO DO
    }

    @Test
    public void testIfTheChoiceOfAlgorithmIsGoodForDijkstra(){
        //TO DO
    }
}
