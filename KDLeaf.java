// Hyper-Rectangle class supporting KDTree class

package com.liang.spatial;

class KDLeaf< Coord extends Comparable<? super Coord>> extends KDNode {

    public GenericPoint point;

    public int dim;

    public KDLeaf(Class T, int ndims) {
        super();
    }


    public void setValue(Coord[] value) {

        for (int i=0; i<value.length; ++i) {
            point.setCoord(i, value[i]);
        }
    }

    public void setPoint(GenericPoint a_point) {

        point = a_point;
    }

    public String toString() {
        return "A leaf: " + point.toString() + "\n";
    }

    public static void main(String args[]){

    KDLeaf a = new KDLeaf(Double.class, 5);

    }
}

