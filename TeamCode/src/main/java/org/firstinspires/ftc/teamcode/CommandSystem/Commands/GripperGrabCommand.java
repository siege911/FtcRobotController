package org.firstinspires.ftc.teamcode.CommandSystem.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.GripperSubsystem;

public class GripperGrabCommand extends CommandBase {
    private final GripperSubsystem gripperSubsystem;

    public GripperGrabCommand(GripperSubsystem gripperSubsystem) {
        this.gripperSubsystem = gripperSubsystem;
        addRequirements(gripperSubsystem);
    }

    @Override
    public void execute() {
        gripperSubsystem.clawGrab();

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
