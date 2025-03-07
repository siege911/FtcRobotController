package org.firstinspires.ftc.teamcode.CommandSystem;

import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.DriveSubsystem;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.IMU;

public class Auto extends CommandOpMode {
    private Motor frontLeft, frontRight, backLeft, backRight;
    private Motor.Encoder frontLeftEncoder, frontRightEncoder, backLeftEncoder, backRightEncoder;
    private DriveSubsystem driveSubsystem;
    private IMU imu;


    @Override
    public void initialize(){
        //Initialize the
        frontLeft = new Motor(hardwareMap, "frontLeft");
        frontRight = new Motor(hardwareMap, "frontRight");
        backLeft = new Motor(hardwareMap, "backLeft");
        backRight = new Motor(hardwareMap, "backRight");


        driveSubsystem = new DriveSubsystem(frontLeft, frontRight, backLeft, backRight);

        register(driveSubsystem);




        //POSSIBLE IMPLEMENTATION OF ROBOT CLASS...
        //AUTO SHOULD WORK WITHOUT IT
        MyRobot myRobot = new MyRobot(MyRobot.OpModeType.AUTO);
        myRobot.register(driveSubsystem);
        // run the command scheduler tied to that robot instance
        while (opModeIsActive() && !isStopRequested()) {
            myRobot.run();
        }
        myRobot.reset();    // resets the scheduler instance

    }


}