package org.firstinspires.ftc.teamcode.CommandSystem.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.GripperSubsystem;

public class GripperReleaseCommand extends CommandBase {
    private final GripperSubsystem gripperSubsystem;

    public GripperReleaseCommand(GripperSubsystem gripperSubsystem) {
        this.gripperSubsystem = gripperSubsystem;
        addRequirements(gripperSubsystem);
    }

    @Override
    public void execute() {
        gripperSubsystem.clawRelease();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
