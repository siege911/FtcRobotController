package org.firstinspires.ftc.teamcode.CommandSystem.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private DriveSubsystem driveSubsystem;
    private DoubleSupplier forward, strafe, turn;

    public DriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier forward, DoubleSupplier strafe, DoubleSupplier turn) {
        this.driveSubsystem = driveSubsystem;
        this.forward = forward;
        this.strafe = strafe;
        this.turn = turn;

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(forward.getAsDouble(), strafe.getAsDouble(), turn.getAsDouble());
    }
}
