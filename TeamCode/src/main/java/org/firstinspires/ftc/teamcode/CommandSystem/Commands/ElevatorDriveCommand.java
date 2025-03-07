package org.firstinspires.ftc.teamcode.CommandSystem.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.ElevatorSubsystem;

import java.util.function.DoubleSupplier;

public class ElevatorDriveCommand extends CommandBase {
    private ElevatorSubsystem elevatorSubsystem;
    private DoubleSupplier extend;

    public ElevatorDriveCommand(ElevatorSubsystem elevatorSubsystem, DoubleSupplier extend) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.extend = extend;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        elevatorSubsystem.extendByPower(extend.getAsDouble());
    }
}
