// Hyper-Rectangle class supporting KDTree class

package com.liang.spatial;

class KDRect< Coord extends Comparable<? super Coord>> extends KDNode {

    public GenericPoint min;
    public GenericPoint max;

    public int dim;
    private final Class nameDouble = Double.class;
    private final Class nameInt = Integer.class;

    public KDRect(Class T, int ndims) {
        super();
        min = new GenericPoint(T, ndims);
        max = new GenericPoint(T, ndims);
        dim = ndims;
        if(  (T!= nameDouble) &&  (T!=nameInt) )
            System.out.println("The type can not be supported");
    }

    public void infiniteHRectDouble() {

        for (int i=0; i<dim; ++i) {
            min.setCoord(i, Double.NEGATIVE_INFINITY);
            max.setCoord(i, Double.POSITIVE_INFINITY);
        }
    }

    public void infiniteHRectInteger() {

        for (int i=0; i<dim; ++i) {
            min.setCoord(i, -99999);
            max.setCoord(i, 99999);
        }
    }

    // used in initial conditions of KDTree.nearest()
    public void infiniteHRect(Class T) {

        if( T==nameDouble)  infiniteHRectDouble();
        else if ( T==nameInt) infiniteHRectInteger();
        else System.out.println("The type can not be supported");
    }

    public void setValue(Coord[] min_value, Coord[] max_value) {
        for (int i=0; i<min_value.length; ++i) {
            min.setCoord(i, min_value[i]);
            max.setCoord(i, max_value[i]);
        }
    }

    public void setLeftValue(KDRect Parent, int a_dim, Coord a_value) {

        for (int i=0; i<min.getDimensions(); ++i) {
            min.__coordinates[i] = Parent.min.__coordinates[i];
            max.__coordinates[i] = Parent.max.__coordinates[i];
        }
        max.__coordinates[a_dim] = a_value;
    }

    public void setRightValue(KDRect Parent, int a_dim, Coord a_value) {

        for (int i=0; i<min.getDimensions(); ++i) {
            min.__coordinates[i] = Parent.min.__coordinates[i];
            max.__coordinates[i] = Parent.max.__coordinates[i];
        }
        min.__coordinates[a_dim] = a_value;
    }

    public String toString() {
        return "A rectangle: " + min.toString() + "   " + max.toString() + "\n";
    }

    public static void main(String args[]){

        KDRect a = new KDRect(Double.class, 5);
        a.infiniteHRect(Double.class);

    }
}

