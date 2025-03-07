package org.firstinspires.ftc.teamcode.CommandSystem.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.ElevatorSubsystem;

public class ElevatorRetractCommand extends CommandBase {
    private static int RETRACT_HEIGHT = 0;
    private final ElevatorSubsystem elevatorSubsystem;
    public ElevatorRetractCommand(ElevatorSubsystem elevatorSubsystem){
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        elevatorSubsystem.setPosition(RETRACT_HEIGHT);

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
