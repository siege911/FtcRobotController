package org.firstinspires.ftc.teamcode;

public class GamePadB {
    private boolean isRunning = true;
    private final Robot robot;

    public GamePadB(Robot robot) {

        this.robot = robot;
        this.isRunning = false;
    }

    public void buttonA(boolean pressed) {
        if(isRunning == false) {
            isRunning = true;
            robot.actions.grabSample();
            isRunning = false;
        }

    }
    public void buttonB(boolean pressed) {
        robot.armAttachment.gripper.toggle();
;    }
    public void buttonX(boolean pressed) {
        //Implement here
    }
    public void buttonY(boolean pressed) {

    }
    public void dpadUp(boolean pressed) {
        robot.poses.specimenDelivery();
    }
    public void dpadDown(boolean pressed) {
        robot.poses.sampleIntake();
    }

    public void dpadLeft(boolean pressed) {
        robot.poses.topBasketDelivery();
    }
    public void dpadRight(boolean pressed) {
        robot.poses.specimenIntake();
    }

    public void leftBumper(boolean pressed) {
        robot.armAttachment.wristRotate.positionUp();
    }

    public void rightBumper(boolean pressed) {
        robot.armAttachment.wristRotate.positionDown();
    }

    public void leftTrigger(double buttonPressure) {
        if (buttonPressure > 0.1){
            robot.armAttachment.elevator.moveByInput(-buttonPressure);
        }
    }
    public void rightTrigger(double buttonPressure) {
        if (buttonPressure > 0.1) {
            robot.armAttachment.elevator.moveByInput(buttonPressure);
        }
    }

    public void leftJoystickY(double input) {
        robot.armAttachment.arm.moveByInput((int)(input*100));
    }

    public void rightJoystickY(double input) {

    }

    public void leftJoystickX(double input) {
    }

    public void rightJoystickX(double input) {
    }
}
