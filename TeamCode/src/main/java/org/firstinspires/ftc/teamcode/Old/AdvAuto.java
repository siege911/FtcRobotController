package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous (name = "Advanced_Auto")

public class AdvAuto extends LinearOpMode{
    
   private boolean dDownPrev;
   private boolean dUpPrev;
   private int poseIndex;
   private int adjust;
   
   
    // http://192.168.43.1:8080
    // the robot is to be moved facing the right not facing toward the basket
    @Override
    public void runOpMode() {
        
        AdvArm arm = new AdvArm(hardwareMap);
        AdvDrive drivebase = new AdvDrive(hardwareMap);
        AdvClaw claw = new AdvClaw(hardwareMap);
        ElapsedTime runtime = new ElapsedTime();
        
        waitForStart();
        // Execute one-time code here
        
        // //move the robot forward 12 inches
        // drivebase.moveRelativeByDistance(19, 0, 0.3);
        // drivebase.moveRelativeByDistance(0, 20, 0.3);
        // drivebase.moveRelativeByDistance(21, 0, 0.3);
        // drivebase.moveRelativeByDistance(0, 20, 0.3);
        // drivebase.moveRelativeByDistance(-52, 0, 0.3);
        // //Grabbing 1st sample here^.
        // drivebase.moveRelativeByDistance(52, 0, 0.3);
        // drivebase.moveRelativeByDistance(0, -20, 0.3);
        // drivebase.moveRelativeByDistance(19, 0, 0.3);
        // drivebase.moveRelativeByDistance(0, 20, 0.3);
        // drivebase.moveRelativeByDistance(52, 0, 0.3);
        // //Grabbing 2nd sample here^.
        // drivebase.moveRelativeByDistance(52, 0, 0.3);
        // drivebase.moveRelativeByDistance(0, -19, 0.3);
        // drivebase.moveRelativeByDistance(20, 0, 0.3);
        // drivebase.moveRelativeByDistance(0, 19, 0.3);
        // drivebase.moveRelativeByDistance(-52, 0, 0.3);
        // //Grabbing 3rd sample here^
        //Grabbing specimen here:
        arm.setPoseIndex(2);
        arm.rotateArm(0);
         claw.wrist1(true, false);
         claw.openClaw();
        
        while(opModeIsActive()) {
            
            
        //     // This is all for controlling the robot with the gamepads
        //     claw.wrist2(gamepad2.right_trigger, gamepad2.left_trigger);
        //     claw.claw(gamepad2.b,gamepad2.a,gamepad2.y);
        //     drivebase.drive(-gamepad1.right_stick_y, gamepad1.right_stick_x,-gamepad1.left_stick_x);
        //   arm.rotateArm((int)(-gamepad2.right_stick_y*100));
        //   // arm.goToPosition((int)(-gamepad2.right_stick_y*100));
        //   arm.nextPresetPose(gamepad2.dpad_up);
        //  arm.prevPresetPose(gamepad2.dpad_down);
        //     arm.extendArm(-gamepad2.left_stick_y);
            
            // This is all for printing debugging info to the hub console
            telemetry.update();
            telemetry.addData("time", "%.1f seconds", 120 - runtime.seconds());
            telemetry.addData("arm:", arm.getArmPosition());
            telemetry.addData("claw:", claw.getClawPosition());
            telemetry.addData("wrist 1=%1f", claw.getWrist1Position());
            telemetry.addData("wrist 2=%1f", claw.getWrist2Position());
            telemetry.addData("1 R:", "Y=%.1f, X=%.1f", gamepad1.right_stick_y, gamepad1.right_stick_x);
            telemetry.addData("1 L:", "Y=%.1f, X=%.1f", gamepad1.left_stick_y, gamepad1.left_stick_x);
            telemetry.addData("2 R:", "Y=%.1f, X=%.1f", gamepad2.right_stick_y, gamepad2.right_stick_x);
            telemetry.addData("2 L:", "Y=%.1f, X=%.1f", gamepad2.left_stick_y, gamepad2.left_stick_x);
        }
    }
}
