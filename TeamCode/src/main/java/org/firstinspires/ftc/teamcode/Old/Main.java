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

@TeleOp(name="Main")

public class Main extends LinearOpMode{
    
   private boolean dDownPrev;
   private boolean dUpPrev;
   private int poseIndex;
   private int adjust;
   
   
    // http://192.168.43.1:8080
    @Override
    public void runOpMode() {
        
        AdvArm arm = new AdvArm(hardwareMap);
        Drive move = new Drive(hardwareMap);
        AdvClaw grab = new AdvClaw(hardwareMap);
        ElapsedTime runtime = new ElapsedTime();
        
        waitForStart();
        while(opModeIsActive()) {
            
            
            //controlling the robot with the gamepads
            grab.wrist2(gamepad2.right_trigger, gamepad2.left_trigger);
            grab.claw(gamepad2.b,gamepad2.a,gamepad2.y);
            move.drive(-gamepad1.right_stick_y, gamepad1.right_stick_x,-gamepad1.left_stick_x);
            arm.rotateArm((int)(-gamepad2.right_stick_y*100));
            // arm.goToPosition((int)(-gamepad2.right_stick_y*100));
            //arm.nextPresetPose(gamepad2.dpad_up);
            //arm.prevPresetPose(gamepad2.dpad_down);
            arm.extendArm(-gamepad2.left_stick_y);
            
            //printing debugging info to the hub console
            telemetry.update();
            //telemetry.addData("extend",arm.getArmExtendPosition());
            telemetry.addData("time", "%.1f seconds", 120 - runtime.seconds());
            telemetry.addData("arm:", arm.getArmPosition());
            telemetry.addData("extension:", arm.getExtensionPosition());
            telemetry.addData("claw:", grab.getClawPosition());
            telemetry.addData("wrist 1=%1f", grab.getWrist1Position());
            telemetry.addData("wrist 2=%1f", grab.getWrist2Position());
            telemetry.addData("1 R:", "Y=%.1f, X=%.1f", gamepad1.right_stick_y, gamepad1.right_stick_x);
            telemetry.addData("1 L:", "Y=%.1f, X=%.1f", gamepad1.left_stick_y, gamepad1.left_stick_x);
            telemetry.addData("2 R:", "Y=%.1f, X=%.1f", gamepad2.right_stick_y, gamepad2.right_stick_x);
            telemetry.addData("2 L:", "Y=%.1f, X=%.1f", gamepad2.left_stick_y, gamepad2.left_stick_x);
        }
    }
}
