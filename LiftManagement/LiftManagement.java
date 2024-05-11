package LiftManagement;

import LiftManagement.model.Lift;
import LiftManagement.view.LiftView;

import java.util.ArrayList;
import java.util.Scanner;


public class LiftManagement {
    ArrayList<Lift> allLift = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LiftManagement liftManagement = new LiftManagement();
        LiftView liftView = new LiftView(liftManagement);
        liftView.leftAllocated();
        liftView.init();

    }
}
