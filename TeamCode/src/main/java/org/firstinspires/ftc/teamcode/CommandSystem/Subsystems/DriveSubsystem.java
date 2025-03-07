package org.firstinspires.ftc.teamcode.CommandSystem.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveOdometry;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveWheelSpeeds;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class DriveSubsystem extends SubsystemBase {
    //Use MechanumDrive class to automate the math for Mechanum
    private MecanumDrive drive;
    //Declare Motors in the Drive Base
    private Motor frontLeft, frontRight, backLeft, backRight;
    private Motor.Encoder frontLeftEncoder, frontRightEncoder, backLeftEncoder, backRightEncoder;
    private IMU imu;
    public DriveSubsystem(
            Motor frontLeft,
            Motor frontRight,
            Motor backLeft,
            Motor backRight
    ) {
        //Set variables from constructor
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);



        //THIS NEXT SECTION IS FOR ODOMETRY... STILL UNDER TESTING

        // Locations of the wheels relative to the robot center.
        //Need to edit with actual values
        Translation2d m_frontLeftLocation =
                new Translation2d(0.381, 0.381);
        Translation2d m_frontRightLocation =
                new Translation2d(0.381, -0.381);
        Translation2d m_backLeftLocation =
                new Translation2d(-0.381, 0.381);
        Translation2d m_backRightLocation =
                new Translation2d(-0.381, -0.381);

        // Creating my kinematics object using the wheel locations.
        MecanumDriveKinematics m_kinematics = new MecanumDriveKinematics
                (
                        m_frontLeftLocation, m_frontRightLocation,
                        m_backLeftLocation, m_backRightLocation
                );
        imu.resetYaw();

        //Creating Odometry object
        MecanumDriveOdometry m_robotOdometry = new MecanumDriveOdometry (
                m_kinematics,
                new Rotation2d(imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS))
        );

        //END ODOMETRY
    }

    //Basic Drive method for use with gamepad
    public void drive(double forwardSpeed, double strafeSpeed, double turnSpeed) {
        //RobotCentric... Forward is the direction the robot is facing
        drive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);

        //Alternative is driveFieldCentric... forward is "away" from human player
        //Need to get "heading" as a gyro output from the IMU
        //drive.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, heading);

    }

    //THIS IS FOR DRIVING USING ODOMETRY (Autonomous type driving)
    public void driveOdomotry(Translation2d newlocation) {

    }


    //Setup mecanum Drive Base




    //Setup Motor Mapping


}
