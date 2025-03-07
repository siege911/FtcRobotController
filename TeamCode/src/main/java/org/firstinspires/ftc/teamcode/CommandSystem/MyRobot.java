package org.firstinspires.ftc.teamcode.CommandSystem;

import com.arcrobotics.ftclib.command.Robot;


//STILL NEED TO IMPLEMENT THIS CONCEPT MORE
//THIS IS JUST SAMPLE CODE

public class MyRobot extends Robot {

    // enum to specify opmode type
    public enum OpModeType {
        TELEOP, AUTO
    }

    // the constructor with a specified opmode type
    public MyRobot(OpModeType type) {

        if (type == OpModeType.TELEOP) {
            initTele();
        } else {
            initAuto();
        }
    }

    /*
     * Initialize teleop or autonomous, depending on which is used
     */
    public void initTele() {

    }

    public void initAuto() {
        // initialize auto-specific scheduler
    }
}
