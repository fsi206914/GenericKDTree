// Hyper-Rectangle class supporting KDTree class

package com.liang.spatial;

class KDRect< Coord extends Comparable<? super Coord>> extends KDNode {

    public GenericPoint min;
    public GenericPoint max;

    public int dim;
    private final Class nameDouble = Double.class;
    private final Class nameInt = Integer.class;
    public hyperplane currHP;

    public final class hyperplane{

        int planeDim;
        Coord value;

        public hyperplane(int a_planeDim, Coord a_value)
        {
            planeDim = a_planeDim;
            value = a_value;
        }

    }


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

    public void setHyperPlane( int a_planeDim, Coord a_value ) {
        currHP = new hyperplane(a_planeDim, a_value);
    }

    public void infiniteHRectInteger() {

        for (int i=0; i<dim; ++i) {
            min.setCoord(i, Integer.MIN_VALUE);
            max.setCoord(i, Integer.MAX_VALUE);
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

    public int  FindNextDirect( GenericPoint a_point  ) {

        Coord Midvalue = this.currHP.value;
        int DimComp = this.currHP.planeDim;
        int cmp = Midvalue.compareTo( (Coord) a_point.getCoord(DimComp));

        if(cmp <0) return -1;
        else return 1;

    }


    public String toString() {
        return "A rectangle: " + min.toString() + "   " + max.toString() + "\n";
    }

    public int compareTo(KDNode o) {
        return 1;
    }


    public static void main(String args[]){

        KDRect a = new KDRect(Double.class, 5);
        a.infiniteHRect(Double.class);

    }
}

