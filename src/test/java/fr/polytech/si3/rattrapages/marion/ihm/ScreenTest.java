package fr.polytech.si3.rattrapages.marion.ihm;

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
public class ScreenTest {

    Screen screen;

    @Before
    public void setUp(){
        screen = new Screen();
    }

    @Test
    public void testNbVertices(){
        assertEquals(screen.nbVertices(), 0);
        Building p = new PowerSource(1);
        screen.addBuilding(p);
        assertEquals(screen.nbVertices(), 1);
        Building a = new House(2);
        Building b = new House(3);
        screen.addBuilding(a);
        screen.addBuilding(b);
        assertEquals(screen.nbVertices(), 3);
    }

    @Test
    public void testNbEdges(){
        int nbr = screen.nbEdges();
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(65);
        screen.isLinked(list);
        assertEquals(screen.nbEdges(), nbr+1);
        List list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(75);
        screen.isLinked(list1);
        assertEquals(screen.nbEdges(),nbr+2);
        List list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(42);
        screen.isLinked(list2);
        assertEquals(screen.nbEdges(),nbr+3);
    }

    @Test
    public void testIfIdBuildingAlreadyExistWithSameBuilding(){
        Building v = new PowerSource(7);
        Building j = new PowerSource(7);
        screen.addBuilding(v);
        assertEquals(screen.addBuilding(j), false);
        Building c = new House(8);
        Building d = new House(8);
        screen.addBuilding(c);
        assertEquals(screen.addBuilding(d), false);
    }

    @Test
    public void testIfIdBuildingAlreadyExistWithDifferentBuilding(){
        Building x = new PowerSource(9);
        Building y = new House(9);
        screen.addBuilding(x);
        assertEquals(screen.addBuilding(y), false);
        Building z = new PowerSource(10);
        Building w = new House(10);
        screen.addBuilding(w);
        assertEquals(screen.addBuilding(z), false);
    }

    @Test
    public void testCreationOfLink(){
        Building n = new PowerSource(11);
        Building m = new House(12);
        screen.addBuilding(n);
        screen.addBuilding(m);
        int size = screen.getLinkList().size();
        List list = new ArrayList();
        list.add(n.getId());
        list.add(m.getId());
        list.add(42);
        screen.isLinked(list);
        assertEquals(screen.getLinkList().size(), size+1);
    }

    @Test
    public void testIfLinkAlreadyExistInTheSameWay(){
        Building o = new PowerSource(11);
        Building p = new House(12);
        List list = new ArrayList();
        list.add(o.getId());
        list.add(p.getId());
        list.add(42);
        screen.addBuilding(o);
        screen.addBuilding(p);
        screen.isLinked(list);
        int size = screen.getLinkList().size();
        List list1 = new ArrayList();
        list1.add(o.getId());
        list1.add(p.getId());
        list.add(58);
        assertEquals(screen.isLinked(list1), false);
        assertEquals(screen.getLinkList().size(), size);
    }

    @Test
    public void testIfLinkAlreadyExistInTheOtherWay(){
        Building o = new PowerSource(13);
        Building p = new House(14);
        List list = new ArrayList();
        screen.addBuilding(o);
        screen.addBuilding(p);
        list.add(o.getId());
        list.add(p.getId());
        list.add(42);
        screen.isLinked(list);
        int size = screen.getLinkList().size();
        List list1 = new ArrayList();
        list1.add(p.getId());
        list1.add(o.getId());
        list.add(58);
        assertEquals(screen.isLinked(list1), false);
        assertEquals(screen.getLinkList().size(), size);
    }

    @Test
    public void testIfAPowerSourceIsCreated(){
        //TO DO
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
