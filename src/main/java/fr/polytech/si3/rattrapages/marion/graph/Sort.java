package fr.polytech.si3.rattrapages.marion.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marion
 */
public class Sort {

    public List<List<Integer>> sortLinkedList (List<List<Integer>> list){
        List<List<Integer>> sortList = new ArrayList<>();
        if (list.size() <= 1){
            return list;
        }
        while(list.size()!=0) {
            Integer first = list.get(0).get(2);
            int index = 0;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).get(2) < first) {
                    first = list.get(i).get(2);
                    index = i;
                }
            }
            sortList.add(list.remove(index));
            size--;
        }
        return sortList;
    }
}
