package topics.StreamsAPI.EmployeeQuesttions;

public class Employee {
    private String eId;
    private String eName;
    private double eSalary;
    private String eDepartment;

    public Employee(String eId, String eName, double eSalary, String eDepartment) {
        this.eId = eId;
        this.eName = eName;
        this.eSalary = eSalary;
        this.eDepartment = eDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId='" + eId + '\'' +
                ", eName='" + eName + '\'' +
                ", eSalary=" + eSalary +
                ", eDepartment='" + eDepartment + '\'' +
                '}';
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public double geteSalary() {
        return eSalary;
    }

    public void seteSalary(double eSalary) {
        this.eSalary = eSalary;
    }

    public String geteDepartment() {
        return eDepartment;
    }

    public void seteDepartment(String eDepartment) {
        this.eDepartment = eDepartment;
    }
}
