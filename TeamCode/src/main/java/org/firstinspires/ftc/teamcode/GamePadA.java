package org.firstinspires.ftc.teamcode;
public class GamepadA{
    
    private MyRobot robot;
    
    public GamepadA(MyRobot robot) {
        this.robot=robot;
    }
    
    public double surge = 0;
    public double sway = 0;
    public double yaw = 0;
    private double SPEED = 0.65;
    
    public void buttonA (boolean pressed) {}
    public void buttonB (boolean pressed) {}
    public void buttonY (boolean pressed) {}
    public void buttonX (boolean pressed) {}
    public void buttonUp (boolean pressed) {}
    public void buttonDown (boolean pressed) {}
    public void buttonLeft (boolean pressed) {}
    public void buttonRight (boolean pressed) {}
    public void buttonLTrigger(double power) {}
    public void buttonRTrigger (double power) {}
    public void buttonLBumper (boolean pressed) {}
    public void buttonRBumper (boolean pressed) {}
    public void motion(double surge, double sway, double yaw) {
        robot.drive.drive(surge, sway, yaw, SPEED);
    }
}