package Assignment7;

import java.util.ArrayList;
import java.util.List;

class Inventory {
    private double balance;
    private int itemsProcessed;
    private List<Item> processingQueue;

    public Inventory() {
        this.balance = 0;
        this.itemsProcessed = 0;
        this.processingQueue = new ArrayList<>();
    }

    public synchronized void addItem(Item item) {
        processingQueue.add(item);
    }

    public synchronized Item retrieveItem() {
        if (processingQueue.isEmpty()) {
            return null;
        }
        itemsProcessed++;
        return processingQueue.remove(0);
    }

    public synchronized void incrementBalance(double amount) {
        balance += amount;
    }

    public synchronized double retrieveBalance() {
        return balance;
    }

    public synchronized int getQueueSize() {
        return processingQueue.size();
    }

    public synchronized int getItemsProcessed() {
        return itemsProcessed;
    }
}