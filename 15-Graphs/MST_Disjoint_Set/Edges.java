package MST_Disjoint_Set;

class Edges implements Comparable<Edges> {
    int u;
    int v;
    int weight;

    public Edges(int u,int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edges other) {
        // Compare based on the weight (ascending order by default)
        return Integer.compare(this.weight, other.weight);
    }
}


