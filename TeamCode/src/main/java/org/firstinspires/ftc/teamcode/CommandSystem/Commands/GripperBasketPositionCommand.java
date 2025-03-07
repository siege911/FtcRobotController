package org.firstinspires.ftc.teamcode.CommandSystem.Commands;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.GripperSubsystem;

public class GripperBasketPositionCommand extends CommandBase {
    private static int BASKET_POSITION = 1000;
    private final GripperSubsystem gripperSubsystem;

    public GripperBasketPositionCommand(GripperSubsystem gripperSubsystem) {
        this.gripperSubsystem = gripperSubsystem;
        addRequirements(gripperSubsystem);
    }

    @Override
    public void execute() {
        gripperSubsystem.setWrist1Position(BASKET_POSITION);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
