package topics.StreamsAPI.EmployeeQuesttions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(new Employee("123", "Souvik", 500000, "IT"),
                new Employee("345", "Tanuka", 1200000, "Customer Rep"),
                new Employee("344", "Sharmistha", 1200000, "Designing"),
                new Employee("321", "Adrika", 10000, "Designing"),
                new Employee("245", "Jayanta", 1200000, "IT"),
                new Employee("3145", "Sagar", 100000, "Customer Rep"),
                new Employee("3045", "Tania", 12000000, "Customer Rep"));

        // List of employees names starting with 'S'
        System.out.println("List of employees names starting with 'S'");
        employeeList.stream()
                .filter(e -> e.geteName().startsWith("S"))
                .forEach(e -> System.out.println(e.geteName()));

        System.out.println();

        // List of employee ids who are in "Customer Rep"
        System.out.println("List of employee ids who are in Customer Rep");
        employeeList.stream()
                .filter(e -> e.geteDepartment().equalsIgnoreCase("Customer Rep"))
                .forEach(e -> System.out.println(e.geteId()));

        System.out.println();

        //List of employee names whose salary is greater than 1000000 And names start with S
        System.out.println("List of employee names whose salary is greater than 1000000");
        employeeList.stream()
                .filter(e -> e.geteSalary() > 1000000 && e.geteName().startsWith("S"))
                .forEach(e -> System.out.println(e.geteName()));

        System.out.println();


        //Change all the names to uppercase
        System.out.println("Change all the names to uppercase");
        System.out.println(employeeList.stream()
                .map(e -> e.geteName().toUpperCase()).collect(Collectors.toList()));


        System.out.println();

        //Map all the departments with employees names
        System.out.println("Map all the departments with employees names");
        System.out.println(employeeList.stream()
                .collect(Collectors.toMap(e -> e.geteName(), e -> e.geteDepartment())));

        System.out.println();


        countEmployees(employeeList);
        groupByDepartments(employeeList);
        highestSalary(employeeList);
        employeesSortedBySalary(employeeList);
        averageSalaryInDepartment(employeeList);

    }

    //Count number of employees with salary > 1000000
    public static void countEmployees(List<Employee> employeeList) {
        System.out.println("Count number of employees with salary > 1000000");
        System.out.println(employeeList.stream()
                .filter(e -> e.geteSalary() > 1000000)
                .count());
    }

    // Grouping employees on the basis of departments
    public static void groupByDepartments(List<Employee> employeeList) {
        System.out.println("Grouping employees on the basis of departments");
        Map<String, List<Employee>> departments = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.geteDepartment()));
        System.out.println(departments);
    }

    //Highest paid employee
    public static void highestSalary(List<Employee> employeeList) {
        System.out.println("Highest paid employee");
        employeeList.stream()
                .max(Comparator.comparingDouble(e -> e.geteSalary()))
                .ifPresent(e -> System.out.println(e.geteName()));
    }

    public static void employeesSortedBySalary(List<Employee> employeeList) {
        System.out.println("Employees sorted by Salary");
        List<Employee> employeeListSorted = employeeList.stream()
                .sorted(Comparator.comparingDouble(e -> e.geteSalary()))
                .collect(Collectors.toList());
        employeeListSorted.stream()
                .forEach(e -> System.out.println(e.geteName()));
    }

    public static void averageSalaryInDepartment(List<Employee> employeeList) {
        System.out.println("Average Salary from each department");
        System.out.println(employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.geteDepartment(), Collectors.averagingDouble(e -> e.geteSalary()))));
    }
}
