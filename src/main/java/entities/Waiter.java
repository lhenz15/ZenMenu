package entities;

public class Waiter extends Employee {

    public Waiter() {
    }

    public Waiter(String name, EmployeeStatus status) {
        super(name, status);
    }

    public Waiter(long id, String name, EmployeeStatus status) {
        super(id, name, status);
    }
}
