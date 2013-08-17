package com.liang.spatial;


public class KDNode implements Comparable<KDNode> {

    public int k;
    public int depth;
    public KDNode parent = null;
    public KDNode lesser = null;
    public KDNode greater = null;
    public boolean RectOrLeaf;

    public KDNode() {
    }

    public KDNode(int k, int depth) {

        this.k = k;
        this.depth = depth;
    }

    /**
     * {@inheritDoc}
     */

    public void setDepth(int a_depth) {

        depth = a_depth;
    }

    public void setRL(boolean RectOrLeaf) {

        this.RectOrLeaf = RectOrLeaf;
    }

    public boolean getRL() {

        return RectOrLeaf;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("k=").append(k);
        builder.append(" depth=").append(depth);
        return builder.toString();
    }

    @Override
    public int compareTo(KDNode o) {
        return 1;
    }


}
