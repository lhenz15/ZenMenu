package entities;

public class Chef extends Employee {
    private ChefExperience experience;

    public Chef() {
    }

    public Chef(String name, EmployeeStatus status, ChefExperience experience) {
        super(name, status);
        this.experience = experience;
    }

    public Chef(long id, String name, EmployeeStatus status, ChefExperience experience) {
        super(id, name, status);
        this.experience = experience;
    }

    public ChefExperience getExperience() {
        return experience;
    }

    public void setExperience(ChefExperience experience) {
        this.experience = experience;
    }
}
