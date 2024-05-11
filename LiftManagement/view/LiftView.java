package LiftManagement.view;

import LiftManagement.LiftManagement;
import LiftManagement.model.Lift;
import LiftManagement.model.Liftsetupmodel;

import java.util.ArrayList;
import java.util.Scanner;

public class LiftView {
    LiftManagement liftManagement = null;
    Liftsetupmodel liftsetupmodel = null;

    public LiftView(LiftManagement liftManagement) {
        this.liftManagement = liftManagement;
        liftsetupmodel = new Liftsetupmodel(this);
    }

    Scanner sc = new Scanner(System.in);

    private void displayLeftPosition() {
        ArrayList<Lift> allLift = liftsetupmodel.getLifts();
        System.out.println("Display the left detail");
        System.out.println("LeftNumber    " + "FloorNUmber");
        for (int i = 0; i < allLift.size(); i++) {
            System.out.println("L" + allLift.get(i).getLeftId() + "        " + allLift.get(i).getFloorNumber());
        }
    }

    public void init() {
        while (true) {
            System.out.println("1.leftDetail");
            System.out.println("2.user acces left");
            System.out.println("3.Under maintain lift");
            System.out.println("4.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayLeftPosition();
                    break;
                case 2:
                    System.out.println("Enter the current floor");
                    int currentFloor = sc.nextInt();
                    System.out.println("Enter the desination floor");
                    int desinationFloor = sc.nextInt();
                    System.out.println("Enter the number of peopple in lift");
                    int peopleCount = sc.nextInt();

                    liftsetupmodel.nearestPostionFind(currentFloor, desinationFloor, peopleCount);
                    break;
                case 3:
                    System.out.println("Enter id");
                    int id = sc.nextInt();
                    liftsetupmodel.assignStatus(id);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public void displayMessage(String s) {
        System.out.println(s);
    }

    public void leftAllocated() {
        liftsetupmodel.Allocated();

    }
}
