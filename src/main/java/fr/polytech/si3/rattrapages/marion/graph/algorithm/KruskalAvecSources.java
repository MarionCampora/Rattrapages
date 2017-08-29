package fr.polytech.si3.rattrapages.marion.graph.algorithm;

//import fr.polytech.si3.rattrapages.marion.graph.WeightedUnDiGraph;

/**
 * @author Marion
 */
public class KruskalAvecSources extends Algorithm{

    /*private static void fillHeap(BinaryHeap<WeightedEdge> minHeap, WeightedUnDiGraph G) throws FullHeapException {
        for ( int u = 0; u < G.nbVertices(); u++ ) {
            for ( Integer a : G.adjacents(u) ) {
                if ( u < a)
                    minHeap.add(new WeightedEdge(u,a,G.weight(u, a)));
            }
        }
    }

    public static Set<WeightedEdge> mst(WeightedUnDiGraph G) throws FullHeapException, EmptyHeapException {

        Set<WeightedEdge> mst = new HashSet<WeightedEdge>();

        Comparator<WeightedEdge> c = new Comparator<WeightedEdge>() {
            public int compare(WeightedEdge e1, WeightedEdge e2) {
                return e2.compareTo(e1);
            }
        };

        BinaryHeap<WeightedEdge> minHeap = new BinaryHeap<WeightedEdge>(G.nbEdges(),c);
        fillHeap(minHeap,G);
        DisjointSets ds = new DisjointSets(G.nbVertices());

        while(ds.numSets() > 1) {
            WeightedEdge currentEdge = minHeap.deleteExtreme();
            Building x = currentEdge.origin();
            Building y = currentEdge.destination();
            if(ds.find(x.getId()) != ds.find(y.getId())) {
                ds.union(ds.find(x.getId()), ds.find(y.getId()));
                mst.add(currentEdge);
            }
        }
        return mst;
    }*/

    @Override
    public void mst() {


    }
}
