package model;
import java.time.LocalDateTime;

public class Customer extends Person {
    public int tokenNumber;
    protected LocalDateTime arrivalTime;

    public Customer(String name, int age, int tokenNumber) {
        super(name, age);
        this.tokenNumber = tokenNumber;
        this.arrivalTime = LocalDateTime.now();
    }
}
