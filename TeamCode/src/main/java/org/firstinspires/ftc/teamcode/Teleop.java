package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Gamepad;
 import com.qualcomm.robotcore.robot.Robot;
 import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
 import org.firstinspires.ftc.robotcore.external.Telemetry;
 
 @TeleOp(name="TeleOp")
 public class Teleop extends LinearOpMode {
 
 
     static final double     DRIVE_SPEED_FULL   = 0.9 ;     // For figuring circumference
 
 
     // http://192.168.43.1:8080
     //move facing the right not facing toward the basket
     @Override
     public void runOpMode() {
         MyRobot robot = new MyRobot(hardwareMap);
         GamepadA gamepadA = new GamepadA(robot);
         GamepadB gamepadB = new GamepadB(robot);
         ElapsedTime runtime = new ElapsedTime();
 
         waitForStart();
         while(opModeIsActive()) {
            
            gamepadA.buttonA(gamepad1.a);
            gamepadA.buttonB(gamepad1.b);
            gamepadA.buttonY(gamepad1.y);
            gamepadA.buttonX(gamepad1.x);
            gamepadA.buttonUp(gamepad1.dpad_up);
            gamepadA.buttonDown(gamepad1.dpad_down);
            gamepadA.buttonLeft(gamepad1.dpad_left);
            gamepadA.buttonRight(gamepad1.dpad_right);
            gamepadA.buttonRTrigger(gamepad1.right_trigger);
            gamepadA.buttonLTrigger(gamepad1.left_trigger);
            gamepadA.buttonRBumper(gamepad1.right_bumper);
            gamepadA.buttonLBumper(gamepad1.left_bumper);
            gamepadA.motion(-gamepad1.right_stick_y, gamepad1.right_stick_x, -gamepad1.left_stick_x);
            
            gamepadB.buttonA(gamepad2.a);
            gamepadB.buttonB(gamepad2.b);
            gamepadB.buttonY(gamepad2.y);
            gamepadB.buttonX(gamepad2.x);
            gamepadB.buttonUp(gamepad2.dpad_up);
            gamepadB.buttonDown(gamepad2.dpad_down);
            gamepadB.buttonLeft(gamepad2.dpad_left);
            gamepadB.buttonRight(gamepad2.dpad_right);
            gamepadB.buttonRTrigger(gamepad2.right_trigger);
            gamepadB.buttonLTrigger(gamepad2.left_trigger);
            gamepadB.buttonRBumper(gamepad2.right_bumper);
            gamepadB.buttonLBumper(gamepad2.left_bumper);
            
            telemetry.addData("time", runtime.seconds());
            telemetry.addData("arm:", robot.armAttachment.arm.getPosition());
            telemetry.addData("claw:", robot.armAttachment.claw.getPosition());
            telemetry.addData("extension:", robot.armAttachment.extension.getPosition());
            telemetry.addData("wristHinge:", robot.armAttachment.wristHinge.getPosition());
            telemetry.addData("wristRotate:", robot.armAttachment.wristRotate.getPosition());
            telemetry.update();
         }
     }
 }
 
