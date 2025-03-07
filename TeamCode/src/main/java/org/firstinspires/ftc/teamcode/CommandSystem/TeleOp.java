package org.firstinspires.ftc.teamcode.CommandSystem;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.CommandSystem.Commands.DriveCommand;
import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.DriveSubsystem;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class TeleOp extends CommandOpMode {
    private Motor frontLeft, frontRight, backLeft, backRight;
    private DriveSubsystem driveSubsystem;
    private DriveCommand driveCommand;
    private GamepadEx gamepadEx;
    @Override
    public void initialize(){
        frontLeft = new Motor(hardwareMap, "frontLeft");
        frontRight = new Motor(hardwareMap, "frontRight");
        backLeft = new Motor(hardwareMap, "backLeft");
        backRight = new Motor(hardwareMap, "backRight");

        gamepadEx = new GamepadEx(gamepad1);

        driveSubsystem = new DriveSubsystem(frontLeft, frontRight, backLeft, backRight);
        driveCommand = new DriveCommand(driveSubsystem, gamepadEx::getLeftX, gamepadEx::getLeftY, gamepadEx::getRightX);

        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);



        //POSSIBLE IMPLEMENTATION OF ROBOT CLASS...
        //TELEOP SHOULD WORK WITHOUT IT
        MyRobot myRobot = new MyRobot(MyRobot.OpModeType.TELEOP);
        myRobot.register(driveSubsystem);
        // run the command scheduler tied to that robot instance
        while (opModeIsActive() && !isStopRequested()) {
            myRobot.run();
        }
        myRobot.reset();    // resets the scheduler instance

    }


}
