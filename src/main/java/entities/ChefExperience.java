package entities;

public enum ChefExperience {
    MASTER(3),
    SENIOR(2),
    JUNIOR(1);

    private int value;

    ChefExperience(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
