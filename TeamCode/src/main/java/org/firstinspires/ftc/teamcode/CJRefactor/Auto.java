package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "Auto")

public class Auto extends LinearOpMode{


    // http://192.168.43.1:8080
    // the robot is to be moved facing the right not facing toward the basket
    @Override
    public void runOpMode() {

        DriveBase drivebase = new DriveBase(hardwareMap);
        ArmAttachment armAttachment = new ArmAttachment(hardwareMap);
        ElapsedTime runtime = new ElapsedTime();

        waitForStart();
        // Execute one-time code here

        //move the robot forward 12 inches
        drivebase.moveRelativeByDistance(12, 0, 0.1);


        while(opModeIsActive()) {
            // This is all for printing debugging info to the hub console
            telemetry.update();
            telemetry.addData("time", "%.1f seconds", 120 - runtime.seconds());
            telemetry.addData("arm:", armAttachment.arm.getPosition());
            telemetry.addData("claw:", armAttachment.gripper.getPosition());
            telemetry.addData("1 R:", "Y=%.1f, X=%.1f", gamepad1.right_stick_y, gamepad1.right_stick_x);
            telemetry.addData("1 L:", "Y=%.1f, X=%.1f", gamepad1.left_stick_y, gamepad1.left_stick_x);
            telemetry.addData("2 R:", "Y=%.1f, X=%.1f", gamepad2.right_stick_y, gamepad2.right_stick_x);
            telemetry.addData("2 L:", "Y=%.1f, X=%.1f", gamepad2.left_stick_y, gamepad2.left_stick_x);
        }
    }
}
