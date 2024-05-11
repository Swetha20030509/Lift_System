package LiftManagement.model;

public class Lift {
    int leftId;
    int floorNumber;
    int capacity;
    boolean available = true;

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Lift(int leftId, int floorNumber) {
        this.leftId = leftId;
        this.floorNumber = floorNumber;
    }

    public Lift(int leftId, int floorNumber, int capacity) {
        this.leftId = leftId;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
    }


    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setLeftId(int leftId) {
        this.leftId = leftId;
    }

    public int getLeftId() {
        return leftId;
    }

}
