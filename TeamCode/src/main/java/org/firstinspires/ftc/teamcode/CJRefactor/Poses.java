package org.firstinspires.ftc.teamcode.CJRefactor;

public class Poses {

    private Robot robot;

    public final int ARM_SAMPLE_INTAKE = 300;
    public final int ARM_SPECIMEN_GRAB = 990;
    public final int ARM_SPECIMEN_PLACE = 1270;

    public final int ARM_ASCEND_START = 2930;
    public final int ARM_HIGH_BASKET = 2930; //Do NOT set this over 2930!!!

    public Poses(Robot robot) {
        this.robot = robot;
    }

    public void sampleIntake() {
        robot.armAttachment.elevator.retractFull();
        robot.armAttachment.gripper.open();
        //Move arm to proper rotation
        robot.armAttachment.arm.setPosition(ARM_SAMPLE_INTAKE);
    }

    public void specimenIntake() {
        robot.armAttachment.elevator.retractFull();
        robot.armAttachment.gripper.open();
        //Move arm to proper rotation
        robot.armAttachment.arm.setPosition(ARM_SPECIMEN_GRAB);
    }

    public void specimenDelivery() {
        //Resets if needed
        robot.armAttachment.elevator.retractFull();
        robot.armAttachment.gripper.close();
        //Move arm to proper rotation
        robot.armAttachment.arm.setPosition(ARM_SPECIMEN_PLACE);
    }

    public void topBasketDelivery() {
        robot.armAttachment.arm.setPosition(ARM_HIGH_BASKET);
        robot.armAttachment.elevator.extendFull();
        robot.armAttachment.wristHinge.setPositionByIndex(4);
        robot.armAttachment.wristRotate.setPositionByIndex(2);
        robot.armAttachment.gripper.open();
    }

    public void ascend() {
        robot.armAttachment.arm.setPosition(ARM_ASCEND_START);
    }
}
