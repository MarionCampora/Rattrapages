//package fr.polytech.si3.rattrapages.marion.graph;
//
//import fr.polytech.si3.rattrapages.marion.building.Building;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Marion
// */
//public class WeightedUnDiGraph extends AbstractGraph{
//
//    private Map<WeightedEdge,Integer> weights;
//
//    public WeightedUnDiGraph(int n) {
//        super(n);
//        weights = new HashMap<WeightedEdge,Integer>();
//    }
//
//    @Override
//    public void addEdge(Building u, Building v, int w) {
//        if ( ! adjacencyList.get(u.getId()).contains(v) ) {
//            adjacencyList.get(u.getId()).add(v.getId());
//            adjacencyList.get(v.getId()).add(u.getId());
//            nbEdges++;
//            if (u.getId() < v.getId()){
//                weights.put(new WeightedEdge(u,v),w);
//            }
//        }
//    }
//
//
//    public void addEdge (int u, int v, int w){
//        if ( ! adjacencyList.get(u).contains(v) ) {
//            adjacencyList.get(u).add(v);
//            adjacencyList.get(v).add(u);
//            nbEdges++;
//            if (u < v){
//                weights.put(new WeightedEdge(u,v),w);
//            }
//        }
//    }
//
//    public int weight(Building u, Building v){
//        Integer i = u.getId() < v.getId() ? weights.get(new WeightedEdge(u,v)) : weights.get(new WeightedEdge(v,u));
//        if (i == null) {
//            return 0;
//        }
//        return i;
//    }
//
//    public int weight (int u, int v){
//        Integer i = u < v ? weights.get(new WeightedEdge(u,v)) : weights.get(new WeightedEdge(v,u));
//        if (i == null) {
//            return 0;
//        }
//        return i;
//    }
//
//    public int weight (WeightedEdge e){
//        return weight(e.origin(), e.destination());
//    }
//}
