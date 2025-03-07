package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MyRobot {
    public ArmAttachment armAttachment;
    public DriveBase drive;
    private ElapsedTime elapsedTime;
    
    //public final int ARM_START_ANGLE = 0; //Do NOT set this under 0!!!
    //public final int ARM_SAMPLE_INTAKE_ANGLE = 300;
    //public final int ARM_HIGH_BASKET_ANGLE = 2930; //Do NOT set this over 2930!!!
    //public final int ARM_SPECIMEN_INTAKE_ANGLE = 990;
    //public final int ARM_SPECIMEN_PLACE_ANGLE = 1270;
    
    //public final double CLAW_OPEN_POSITION = 0.5;
    //public final double CLAW_CLOSE_POSITION = 0.8;

    Telemetry telemetry;

    public MyRobot(HardwareMap hardwareMap) {
        this.armAttachment = new ArmAttachment(hardwareMap);
        this.drive = new DriveBase(hardwareMap);
        this.elapsedTime = new ElapsedTime();
    }

    /*public void robotTelemetry() {
        telemetry.update();
        telemetry.addData("time", "%.1f seconds", 120 - elapsedTime.seconds());
        telemetry.addData("arm:", armAttachment.arm.getPosition());
        telemetry.addData("claw:", armAttachment.claw.getPosition());
        telemetry.addData("wristHinge:", armAttachment.wristHinge.getPosition());
        telemetry.addData("wristRotate:", armAttachment.wristRotate.getPosition());
    }*/
    
    public void grabSpecimen() {
        armAttachment.arm.setPosition(2000);
    }

}
