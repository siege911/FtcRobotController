package org.firstinspires.ftc.teamcode.CommandSystem.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

//THIS IS SOME SAMPLE CODE MOSTLY BASED OFF OF TANK DRIVE
//NEED TO RE-IMPLEMENT
public class DriveOdometry extends CommandBase {
    private DriveSubsystem driveSubsystem;
    private Motor.Encoder m_frontLeftEncoder;
    private Motor.Encoder m_frontRightEncoder;
    private Motor.Encoder m_backLeftEncoder;
    private Motor.Encoder m_backRightEncoder;

    private DoubleSupplier speed;
    public DriveOdometry(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
    }

    @Override
    public void initialize() {
        //UNDER CONSTRUCTION
    }

    @Override
    public void execute() {

        //UNDER CONSTRUCTION
    }

    @Override
    public void end(boolean interrupted) {
            //UNDER CONSTRUCTION
    }

    @Override
    public boolean isFinished() {
            //UNDER CONSTRUCTION
    }
}
