package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name="TeleOp")
public class Teleop extends LinearOpMode {
    // http://192.168.43.1:8080
    // the robot is to be moved facing the right not facing toward the basket
    @Override
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap);
        GamePadA gamePadA = new GamePadA(robot);
        GamePadB gamePadB = new GamePadB(robot);

        waitForStart();
        while(opModeIsActive()) {

            // This is all for controlling the robot with the gamepads

            //Use gamePadActions class to actually run code
            gamePadA.buttonA(gamepad1.a);
            gamePadA.buttonB(gamepad1.b);
            gamePadA.buttonX(gamepad1.x);
            gamePadA.buttonY(gamepad1.y);
            gamePadA.dpadUp(gamepad1.dpad_up);
            gamePadA.dpadDown(gamepad1.dpad_down);
            gamePadA.dpadLeft(gamepad1.dpad_left);
            gamePadA.dpadRight(gamepad1.dpad_right);
            gamePadA.leftBumper(gamepad1.left_bumper);
            gamePadA.rightBumper(gamepad1.right_bumper);
            gamePadA.leftTrigger(gamepad1.left_trigger);
            gamePadA.rightTrigger(gamepad1.right_trigger);
            gamePadA.joystickDrive(-gamepad1.right_stick_y, gamepad1.right_stick_x,-gamepad1.left_stick_x);

            gamePadB.buttonA(gamepad2.a);
            gamePadB.buttonB(gamepad2.b);
            gamePadB.buttonX(gamepad2.x);
            gamePadB.buttonY(gamepad2.y);
            gamePadB.dpadUp(gamepad2.dpad_up);
            gamePadB.dpadDown(gamepad2.dpad_down);
            gamePadB.dpadLeft(gamepad2.dpad_left);
            gamePadB.dpadRight(gamepad2.dpad_right);
            gamePadB.leftBumper(gamepad2.left_bumper);
            gamePadB.rightBumper(gamepad2.right_bumper);
            gamePadB.leftTrigger(gamepad2.left_trigger);
            gamePadB.rightTrigger(gamepad2.right_trigger);

            gamePadB.leftJoystickY(-gamepad2.left_stick_y);
            gamePadB.rightJoystickY(-gamepad2.right_stick_y);

            robot.robotTelemetry();
        }
    }
}
