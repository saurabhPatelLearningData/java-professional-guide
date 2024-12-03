import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparatorForList implements Comparator<Integer> {

  /*
  public int compare(obj1,obj2)
  returns -ve iff obj1 has to come before obj2
  returns +ve iff obj1 has to come after obj2
  returns 0 iff obj1 and obj2 are equal
  */

  /*
  ip: [10, 20, 0, 30]
  Here Integer i1 is always next element and Integer i2 is always previous element.
  Example: At first iteration i1 = al[1] and i2 = al[0] :
  i1= 20 and i2 = 10
  Second Iteration: i1 = 0, and i2 = 20
  Third Iteration: i1 = 0, and i2 = 10
  Forth Iteration: i1 = 30 and i2 =10
  Fivth Iteration: i1 = 30 and i2 =20

  */

  @Override
  public int compare(Integer i1, Integer i2) {
    // Approach 1
 /*   if(i1>i2) {
      return -1;
    }
    else if (i1<i2) {
      return 1;
    }
    else {
      return 0;
    }
*/
    // Approach 2
    return (i1>i2)?-1:(i1<i2)?1:0;

  }

}
 class Test {

  public static void main (String[] args) {
    List<Integer> al = new ArrayList<>();
    al.add(10);
    al.add(20);
    al.add(0);
    al.add(30);
    System.out.println("Before Sorting"+ al);

    //For Approach 1 and 2
    //Collections.sort(al, new TestComparatorForListWithoutLambda());

    //For Approach 3 with Lambda expression
    Collections.sort(al, (i1, i2)->(i1>i2)?-1:(i1<i2)?1:0);
    System.out.println("After Sorting" + al);

  }


}