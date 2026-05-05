package service;

import model.Customer;
import model.PriorityCustomer;

import java.util.*;

public class QueueManager {
    private static QueueManager instance;

    private Queue<Customer> normalQueue = new LinkedList<>();
    private PriorityQueue<PriorityCustomer> priorityQueue =
            new PriorityQueue<>(Comparator.comparingInt(PriorityCustomer::getPriorityLevel).reversed());

    private int tokenCounter = 1;

    private QueueManager() {}

    public static QueueManager getInstance() {
        if (instance == null) {
            instance = new QueueManager();
        }
        return instance;
    }

    public Customer generateToken(String name, int age) {
        int token = tokenCounter++;

        if (age > 60) {
            PriorityCustomer pc = new PriorityCustomer(name, age, token, 1);
            priorityQueue.add(pc);
            return pc;
        } else {
            Customer c = new Customer(name, age, token);
            normalQueue.add(c);
            return c;
        }
    }

    public Customer getNextCustomer() {
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.poll();
        }
        return normalQueue.poll();
    }

    public int getQueueSize() {
        return normalQueue.size() + priorityQueue.size();
    }

    public int estimateWaitingTime(int avgServiceTime) {
        return getQueueSize() * avgServiceTime;
    }
}