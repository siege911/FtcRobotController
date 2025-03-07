package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    public ArmAttachment armAttachment;
    public DriveBase driveBase;
    private ElapsedTime elapsedTime;
    public Poses poses;

    public Actions actions;

    Telemetry telemetry;

    public Robot(HardwareMap hardwareMap) {
        this.armAttachment = new ArmAttachment(hardwareMap);
        this.driveBase = new DriveBase(hardwareMap);
        this.elapsedTime = new ElapsedTime();
        this.poses = new Poses(this);
        this.actions = new Actions(this);
    }

    public void robotTelemetry() {
        telemetry.update();
        telemetry.addData("time", "%.1f seconds", 120 - elapsedTime.seconds());
        telemetry.addData("arm:", armAttachment.arm.getPosition());
        telemetry.addData("claw:", armAttachment.gripper.getPosition());
        telemetry.addData("wristHinge:", armAttachment.wristHinge.getPosition());
        telemetry.addData("wristRotate:", armAttachment.wristRotate.getPosition());
    }

}
