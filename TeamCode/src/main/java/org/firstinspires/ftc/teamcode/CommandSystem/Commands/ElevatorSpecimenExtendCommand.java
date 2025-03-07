package org.firstinspires.ftc.teamcode.CommandSystem.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.ElevatorSubsystem;

public class ElevatorSpecimenExtendCommand extends CommandBase {
    private static int SPECIMEN_HEIGHT = 1000;
    private final ElevatorSubsystem elevatorSubsystem;
    public ElevatorSpecimenExtendCommand(ElevatorSubsystem elevatorSubsystem){
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        elevatorSubsystem.setPosition(SPECIMEN_HEIGHT);

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
