package entities;

public class Employee {
    private long id;
    private String name;
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(String name, EmployeeStatus status) {
        this.name = name;
        this.status = status;
    }

    public Employee(long id, String name, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
}
