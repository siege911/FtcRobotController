package org.firstinspires.ftc.teamcode.CommandSystem.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmSubsystem extends SubsystemBase {
    private static int MAX_POSITION = 2090;
    private static int MIN_POSITION = 0;
    private Motor arm;
    private double currentPosition;
    private double startingPosition;
    private double maxPosition;
    Telemetry telemetry;
    public ArmSubsystem(Motor armMotor) {
        this.arm = armMotor;
        arm.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        telemetry.addData("Arm Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void periodic() {

        currentPosition = getPosition();
        telemetry.addData("Arm Position", currentPosition);
        telemetry.update();
    }

    public double getPosition() {
        return arm.getCurrentPosition();
    }

    public void setRotation(int targetRotation) {
        int targetPositionChecked = targetRotation;

        if (targetRotation > MAX_POSITION) {
            targetPositionChecked = MAX_POSITION;
            telemetry.addData("Arm", "MAX POSITION EXCEEDED");
            telemetry.update();
        }

        if (targetRotation < MIN_POSITION) {
            targetPositionChecked = MIN_POSITION;
            telemetry.addData("Arm", "MIN POSITION EXCEEDED");
            telemetry.update();
        }

        arm.setTargetPosition(targetPositionChecked);
    }
}
