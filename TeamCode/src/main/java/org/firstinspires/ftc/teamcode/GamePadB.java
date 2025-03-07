package org.firstinspires.ftc.teamcode;
public class GamepadB {

private MyRobot robot;
    
    public GamepadB(MyRobot robot) {
        this.robot=robot;
    }

    public void buttonB (boolean pressed) {
        if(pressed) {
            //robot.armAttachment.claw.toggle();
        }
    }
    public void buttonA (boolean pressed) {
        if(pressed){
            robot.armAttachment.claw.open();
            //robot.armAttachment.arm.setToSampleSubmersibleIntakeGrabPostion();
            //robot.armAttachment.claw.close();
            robot.armAttachment.arm.setToSampleSubmersibleIntakePostion();
        }
    }
    public void buttonY (boolean pressed) {
        if(pressed){
            //robot.armAttachment.wristRotate.setToCenterPosition();
            robot.armAttachment.wristHinge.setToSampleHighBasketDeliveryPosition();
        }
    }
    public void buttonX (boolean pressed) {
        if(pressed){}
    }
    public void buttonUp (boolean pressed) {
        if(pressed) {
            // robot.armAttachment.arm.setToSpecimenDeliverPosition();
            // robot.armAttachment.extension.setToSpecimenDeliverPosition();
            // robot.armAttachment.wristHinge.setToSpecimenDeliverPosition();
            // robot.armAttachment.claw.close();
        }
        
        
    }
    public void buttonDown (boolean pressed) {
        if(pressed){
            // robot.armAttachment.extension.setToSampleSubmersibleIntakePosition();
            // robot.armAttachment.wristHinge.setToSampleSubmersIntakePosition();
            // robot.armAttachment.claw.open();
            // robot.armAttachment.arm.setToSampleSubmersibleIntakePostion();
        }
    }
    public void buttonLeft (boolean pressed) {
        if(pressed){
            // robot.armAttachment.extension.setToHighBasketPosition();
            // robot.armAttachment.wristHinge.setToSampleHighBasketDeliveryPosition();
            // robot.armAttachment.claw.open();
            // robot.armAttachment.arm.setToHighBasketPosition();
        }
    }
    public void buttonRight (boolean pressed) {
        if(pressed){
            // robot.armAttachment.extension.setToSpecimenIntakePosition();
            // robot.armAttachment.wristHinge.setToSpecimenIntakePosition();
            // robot.armAttachment.claw.open();
            // robot.armAttachment.arm.setToSpecimenIntakePosition();
        }
    }
    public void buttonLTrigger(double speed) {
        if(speed > 0.1 || speed < -0.1) {}
    }
    public void buttonRTrigger (double speed) {
        if(speed > 0.1 || speed < -0.1) {}
    }
    public void buttonLBumper (boolean pressed) {
        if(pressed){
            robot.armAttachment.wristRotate.setToCCWPosition();
        }
    }
    public void buttonRBumper (boolean pressed) {
        if(pressed){
            .armAttachment.wristRotate.setToCWPosition();
        }
    }
    public void joystickLeftY (double speed) {
        if(speed > 0.1 || speed < -0.1) {
            robot.armAttachment.extension.moveByInput(speed);
        }
    }
    public void joystickRightY (double speed) {
        if(speed > 0.1 || speed < -0.1) {
            robot.armAttachment.arm.moveByInput(speed);
        }
    }
    public void joystickLeftX (double speed) {
        if(speed > 0.1 || speed < -0.1) {}
    }
    public void joystickRightX (double speed) {
        if(speed > 0.1 || speed < -0.1) {}
    }
    
}