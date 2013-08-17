// Hyper-Rectangle class supporting KDTree class

package com.liang.spatial;

class KDLeaf< Coord extends Comparable<? super Coord>> extends KDNode {

    public GenericPoint point;
    private final Class nameDouble = Double.class;
    private final Class nameInt = Integer.class;
    public int dim;

    public KDLeaf(Class T, int ndims) {
        super();
        point = new GenericPoint(T, ndims);
        dim = ndims;
        if(  (T!= nameDouble) &&  (T!=nameInt) )
            System.out.println("The type can not be supported");
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



    public boolean equal(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof GenericPoint)) {
            System.out.println("The comparison objects are confused");
            return false;
        }
        GenericPoint a_point = (GenericPoint) obj;
        int ret = 0;

        for(int i=0; i<dim; i++){


            point.setCurrDimComp(i);
            int local = point.compareTo(a_point);
            ret += local;
            if(ret != 0) return false;

        }
        return true;
    }


    public static void main(String args[]){

    KDLeaf a = new KDLeaf(Double.class, 5);

    }
}

