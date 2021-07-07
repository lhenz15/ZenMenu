package entities;

public class Chef extends Employee {
    private ChefExperience experience;
    private ChefStatus status;

    public Chef(ChefExperience experience, ChefStatus status) {
        this.experience = experience;
        this.status = status;
    }

    public Chef(String name, ChefExperience experience, ChefStatus status) {
        super(name);
        this.experience = experience;
        this.status = status;
    }

    public Chef(long id, String name, ChefExperience experience, ChefStatus status) {
        super(id, name);
        this.experience = experience;
        this.status = status;
    }

    public ChefExperience getExperience() {
        return experience;
    }

    public void setExperience(ChefExperience experience) {
        this.experience = experience;
    }

    public ChefStatus getStatus() {
        return status;
    }

    public void setStatus(ChefStatus status) {
        this.status = status;
    }
}
