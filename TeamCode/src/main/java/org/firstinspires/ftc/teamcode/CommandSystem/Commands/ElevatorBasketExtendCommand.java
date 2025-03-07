package org.firstinspires.ftc.teamcode.CommandSystem.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.ElevatorSubsystem;

public class ElevatorBasketExtendCommand extends CommandBase {
    private static int BASKET_HEIGHT = 2090;
    private final ElevatorSubsystem elevatorSubsystem;
    public ElevatorBasketExtendCommand(ElevatorSubsystem elevatorSubsystem){
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        elevatorSubsystem.setPosition(BASKET_HEIGHT);

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
