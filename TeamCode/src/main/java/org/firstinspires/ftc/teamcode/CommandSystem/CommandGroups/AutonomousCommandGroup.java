package org.firstinspires.ftc.teamcode.CommandSystem.CommandGroups;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.CommandSystem.Commands.GripperGrabCommand;
import org.firstinspires.ftc.teamcode.CommandSystem.Commands.GripperReleaseCommand;
import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.CommandSystem.Subsystems.GripperSubsystem;

public class AutonomousCommandGroup extends SequentialCommandGroup {
    private static final double INCHES = 3.0;
    private static final double SPEED = 0.5;

    /**
     * Creates a new ReleaseAndBack command group.
     *
     * @param drive The drive subsystem this command will run on
     * @param grip The gripper subsystem this command will run on
     */
    public AutonomousCommandGroup(DriveSubsystem driveSubsystem, GripperSubsystem gripperSubsystem)
    {
        addCommands(
                new GripperGrabCommand(gripperSubsystem),
                new GripperReleaseCommand(gripperSubsystem)
        );
        addRequirements(driveSubsystem, gripperSubsystem);
    }
}
