package org.firstinspires.ftc.teamcode;

public class GamePadA {
    private final Robot robot;

    public GamePadA(Robot robot) {
        this.robot = robot;
    }

    public void buttonA(boolean pressed) {

    }
    public void buttonB(boolean pressed) {

;    }
    public void buttonX(boolean pressed) {
        robot.actions.ascend();
    }
    public void buttonY(boolean pressed) {
        robot.poses.ascend();
    }
    public void dpadUp(boolean pressed) {

    }
    public void dpadDown(boolean pressed) {

    }

    public void dpadLeft(boolean pressed) {

    }
    public void dpadRight(boolean pressed) {

    }

    public void leftBumper(boolean pressed) {

    }

    public void rightBumper(boolean pressed) {

    }

    public void leftTrigger(double buttonPressure) {
    }
    public void rightTrigger(double buttonPressure) {
    }

    public void joystickDrive(double forwardBack, double strafe, double turn) {
        robot.driveBase.drive(forwardBack, strafe,turn, 0.9);
    }
}
