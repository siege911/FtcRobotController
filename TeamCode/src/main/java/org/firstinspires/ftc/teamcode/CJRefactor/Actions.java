package org.firstinspires.ftc.teamcode.CJRefactor;

public class Actions {

    public final int ARM_SAMPLE_GRAB = 200;
    public final int ARM_SAMPLE_INTAKE = 300;
    public final int ARM_ASCEND_END = 200;

    private Robot robot;

    public Actions(Robot robot) {
        this.robot = robot;
    }

    public void grabSample() {
        robot.armAttachment.arm.setPosition(ARM_SAMPLE_GRAB);
        robot.armAttachment.gripper.close();
        robot.armAttachment.arm.setPosition(ARM_SAMPLE_INTAKE);
    }

    public void ascend() {
        robot.armAttachment.arm.setPosition(ARM_ASCEND_END);
    }
}
