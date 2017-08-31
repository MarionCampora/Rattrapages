package fr.polytech.si3.rattrapages.marion.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Marion
 */
public class SortTest {
    Sort sort;
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();
    List<Integer> list4 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list5 = new ArrayList<>();

    @Before
    public void setUp(){
        sort = new Sort();
        list1.add(1);
        list1.add(2);
        list1.add(2);

        list2.add(2);
        list2.add(3);
        list2.add(3);

        list3.add(1);
        list3.add(3);
        list3.add(4);

        list4.add(1);
        list4.add(4);
        list4.add(42);

        list5.add(4);
        list5.add(5);
        list5.add(4);

    }

    @Test
    public void testSortASingleBuilding(){
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        assertEquals(sort.sortLinkedList(list), list);
    }

    @Test
    public void testSortEmptyList(){
        List<List<Integer>> list = new ArrayList<>();
        assertEquals(sort.sortLinkedList(list), list);
    }

    @Test
    public void testASortList(){
        List<List<Integer>> list = new ArrayList<>();
        List list9 = new ArrayList();
        list9.add(list1);
        list9.add(list2);
        list9.add(list3);
        list9.add(list4);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        assertEquals(list9, sort.sortLinkedList(list));
    }

    @Test
    public void testSortAnUnsortedList(){
        List<List<Integer>> list = new ArrayList<>();
        List list6 = new ArrayList();
        list6.add(list1);
        list6.add(list2);
        list6.add(list3);
        list6.add(list4);
        list.add(list3);
        list.add(list2);
        list.add(list4);
        list.add(list1);
        assertEquals(list6, sort.sortLinkedList(list));
    }

    @Test
    public void testSortedListWithSameWeight(){
        List<List<Integer>> list = new ArrayList<>();
        List list6 = new ArrayList();
        list6.add(list1);
        list6.add(list2);
        list6.add(list3);
        list6.add(list5);
        list6.add(list4);
        List list7 = new ArrayList();
        list7.add(list1);
        list7.add(list2);
        list7.add(list5);
        list7.add(list3);
        list7.add(list4);
        list.add(list5);
        list.add(list3);
        list.add(list2);
        list.add(list4);
        list.add(list1);
        List list8 = sort.sortLinkedList(list);
        assertEquals(list8, list7);
    }
}
