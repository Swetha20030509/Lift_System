package LiftManagement.datalayer;

import LiftManagement.model.Lift;

import java.util.ArrayList;

public class Database {
    ArrayList<Lift> allLift = new ArrayList<>();

    public ArrayList<Lift> getLiftDetail() {
        return allLift;
    }

    public void updateLiftStaus(int id) {
        allLift.get(id).setFloorNumber(-1);
        allLift.get(id).setAvailable(false);
    }
}
