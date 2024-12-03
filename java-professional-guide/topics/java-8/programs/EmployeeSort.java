import java.util.ArrayList;
import java.util.Collections;

public class EmployeeSort {
  int employeeNo;
  String name;

  EmployeeSort(int employeeNo, String name) {
    this.employeeNo = employeeNo;
    this.name = name;
  }

  public String toString() {
    return employeeNo +":"+ name;

  }

}

class EmployeeSortTest {
  public static void main(String[] args) {

    ArrayList<EmployeeSort> al = new ArrayList<>();
    al.add(new EmployeeSort(10, "Saurabh"));
    al.add(new EmployeeSort(20, "Chhaya"));
    al.add(new EmployeeSort(0, "Durga"));
    al.add(new EmployeeSort(30, "Ayansh"));
    System.out.println("Before Sorting" + al);
    Collections.sort(al, (e1, e2)->(e1.employeeNo>e2.employeeNo)?-1:(e1.employeeNo<e2.employeeNo)?1:0);
    System.out.println("After Sorting" + al);

  }
}
