package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//Temporary main Function to check the console
public class Main {

    static List<Employee> empList = new ArrayList<Employee>();

    public static void show() {
        Iterator<Employee> iterate = empList.iterator();

        while (iterate.hasNext()) {
            Employee emp = iterate.next();

            System.out.println("Unique ID : " + emp.getEmpid() + "   Name : "
                    + emp.getName());
            System.out.println();

        }
    }

    public static void main(String args[]) {

        Employee emp1 = new Employee(66, "b");
        Employee emp2 = new Employee(7, "a");
        Employee emp3 = new Employee(99, "b");
        Employee emp4 = new Employee(67, "a");
        Employee emp5 = new Employee(8, "b");
        Employee emp6 = new Employee(9, "a");

        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);
        empList.add(emp6);

        System.out.println("Natural Order Sort : ");
        Collections.sort(empList);
        show();

        System.out.println("Sort by Name : ");
        Collections.sort(empList, new SortByDefinedOrder());
        show();
    }
}
