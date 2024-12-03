import java.util.TreeMap;

public class TestComparatorForMap {

  public static void main (String[] args) {
    /*
In the case of Map, if we want default natural sorting order of keys then we should go for
TreeMap.
1. TreeMap m = new TreeMap();
 This TreeMap object meant for default natural sorting order of keys
2. TreeMap t = new TreeMap(Comparator c);
 This TreeMap object meant for Customized Sorting Order of keys
    */

    // Apprach 1: Understanding basic flow of TreeMap
    TreeMap<Integer, String> tm = new TreeMap<>();
    tm.put(10,"Saurabh");
    tm.put(20,"Chhaya");
    tm.put(0,"Durga");
    tm.put(30,"Ayansh");
    System.out.println(tm); // {0=Durga, 10=Saurabh, 20=Chhaya, 30=Ayansh}

    // Apprach 2: Custom sorting
    TreeMap<Integer, String> tmCustom = new TreeMap<>((i1, i2)->(i1>i2)?-1:(i1<i2)?1:0);
    tmCustom.put(10,"Saurabh");
    tmCustom.put(20,"Chhaya");
    tmCustom.put(0,"Durga");
    tmCustom.put(30,"Ayansh");
    System.out.println(tmCustom); // {30=Ayansh, 20=Chhaya, 10=Saurabh, 0=Durga}

  }
}
