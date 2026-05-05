package model;

public class PriorityCustomer extends Customer {
    private int priorityLevel;

    public PriorityCustomer(String name, int age, int tokenNumber, int priorityLevel) {
        super(name, age, tokenNumber);
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }
}