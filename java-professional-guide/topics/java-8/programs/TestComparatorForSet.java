import java.util.TreeSet;

public class TestComparatorForSet {

  public static void main (String[] args) {
    /*
    In the case of Set, if we want Sorting order then we should go for TreeSet
    1. TreeSet t = new TreeSet();
    This TreeSet object meant for default natural sorting order
    2. TreeSet t = new TreeSet(Comparator c);
    This TreeSet object meant for Customized Sorting Order
    */

    // Apprach 1: Understanding basic flow of TreeSet
/*
    TreeSet<Integer> ts = new TreeSet<>();
    ts.add(10);
    ts.add(20);
    ts.add(0);
    ts.add(30);
    System.out.println(ts); // [0, 10, 20, 30]
*/

    // Apprach 2: Custom sorting
    TreeSet<Integer> ts = new TreeSet<>((i1, i2)->(i1>i2)?-1:(i1<i2)?1:0);
    ts.add(10);
    ts.add(20);
    ts.add(0);
    ts.add(30);
    System.out.println(ts); // [30, 20, 10, 0]

  }
}
