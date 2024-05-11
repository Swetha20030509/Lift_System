package LiftManagement.model;

import LiftManagement.datalayer.Database;
import LiftManagement.view.LiftView;

import java.util.ArrayList;

public class Liftsetupmodel {
    LiftView liftView = null;
    Database database = null;

    public Liftsetupmodel(LiftView liftView) {
        this.liftView = liftView;
        this.database = new Database();
    }

    public ArrayList<Lift> getLifts() {
        return database.getLiftDetail();
    }

    public void assignStatus(int id) {
        database.updateLiftStaus(id);
    }

    public int restrickLeft(int id, int currentFloor, int desinationFloor) {
        if (id == 0 || id == 1) {
            if (currentFloor >= 0 && currentFloor <= 5 && desinationFloor >= 0 && desinationFloor <= 5)
                return id;
            else
                return -1;
        } else if (id == 2 || id == 3) {
            if ((currentFloor == 0 || (currentFloor >= 6 && currentFloor <= 10)) && (desinationFloor == 0 || (desinationFloor >= 6 && desinationFloor <= 10)))
                return id;
            else
                return -1;
        }

        return id;

    }

    public int leaseNumberOfStep(int i, int currentFloor, int destintioFloor) {
        ArrayList<Lift> allLift = database.getLiftDetail();
        if (i == 0 || i == 1) {
            return Math.abs(allLift.get(i).getFloorNumber() - currentFloor) + ((Math.abs(currentFloor - destintioFloor)));
        } else if (i == 3 || i == 2) {
            return Math.abs(allLift.get(i).getFloorNumber() - currentFloor) + ((Math.abs(currentFloor - destintioFloor)) - 5);


        }
        return Math.abs(allLift.get(i).getFloorNumber() - currentFloor) + ((Math.abs(currentFloor - destintioFloor)));
    }

    public void nearestPostionFind(int currentFloor, int desinationFloor, int capacity) {
        ArrayList<Lift> allLift = database.getLiftDetail();
        while (capacity > 0) {
            int minmum = Integer.MAX_VALUE;
            ;
            int id = -1;


            for (int i = 0; i < allLift.size(); i++) {

                if (allLift.get(i).isAvailable() && restrickLeft(i, currentFloor, desinationFloor) != -1) {
                    if (minmum > leaseNumberOfStep(i, currentFloor, desinationFloor)) {
                        minmum = leaseNumberOfStep(i, currentFloor, desinationFloor);
                        id = i;
                        if (capacity >= allLift.get(i).getCapacity())
                            capacity = capacity - allLift.get(i).getCapacity();
                        else
                            capacity = 0;
                    }
                }
            }
            if (id != -1) {

                allLift.get(id).setFloorNumber(desinationFloor);
                liftView.displayMessage("L" + (id + 1) + "Allocated");
            } else {
                liftView.displayMessage("No left available");
            }
        }

              /* int distance=-1;
                int id=-1;
                for (int i=0;i<allLift.size();i++)
                {
                    if(i==0)
                    {
                        distance=Math.abs(currentFloor-allLift.get(i).getFloorNumber());
                        id=i;
                        if(restrickLeft(id,currentFloor,desinationFloor)==-1) {
                            distance = Integer.MAX_VALUE;
                            id=-1;
                        }
                    }
                    else if(distance==Math.abs(currentFloor-allLift.get(i).getFloorNumber()))
                    {

                       if(allLift.get(id).getFloorNumber()<allLift.get(i).getFloorNumber()) {
                           id = i;
                       }
                        if(restrickLeft(id,currentFloor,desinationFloor)==-1) {
                            distance = Integer.MAX_VALUE;
                            id=-1;
                        }

                    }
                    else if(distance>Math.abs(currentFloor-allLift.get(i).getFloorNumber())) {
                        distance = Math.abs(currentFloor - allLift.get(i).getFloorNumber());
                        id=i;
                        if(restrickLeft(id,currentFloor,desinationFloor)==-1) {
                            distance = Integer.MAX_VALUE;
                            id=-1;
                        }
                    }

                }
                if(distance!=-1)
                {
                    allLift.get(id).setFloorNumber(desinationFloor);
                    System.out.println("L"+(id+1)+"Allocated");
                }*/

    }

    public void Allocated() {

        ArrayList<Lift> allLift = database.getLiftDetail();
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0)
                allLift.add(new Lift(i + 1, 0, 4));
            else
                allLift.add(new Lift(i + 1, 0, 5));
        }
    }
}

