package org.firstinspires.ftc.teamcode.CommandSystem.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ElevatorSubsystem extends SubsystemBase {
    private static int MAX_POSITION = 2090;
    private static int MIN_POSITION = 0;
    Telemetry telemetry;
    private double currentPosition;
    private double startingPosition;
    private double maxPosition;
    private Motor elevator;

    public ElevatorSubsystem(Motor elevator) {
        this.elevator = elevator;
        elevator.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        telemetry.addData("Elevator Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void periodic() {

        currentPosition = getPosition();
        telemetry.addData("Elevator Position", currentPosition);
        telemetry.update();
    }

    public double getPosition() {
        return elevator.getCurrentPosition();
    }

    public void setPosition(int targetPosition) {
        int targetPositionChecked = targetPosition;

        if (targetPosition > MAX_POSITION) {
            telemetry.addData("Elevator Limits", "MAX POSITION EXCEEDED");
            telemetry.update();
            targetPositionChecked = MAX_POSITION;
        }

        if (targetPosition < MIN_POSITION) {
            telemetry.addData("Elevator Limits", "MIN POSITION EXCEEDED");
            telemetry.update();
            targetPositionChecked = MIN_POSITION;
        }

        elevator.setTargetPosition(targetPositionChecked);
    }

    public void extendByPower(double power) {
        if (getPosition() >= MAX_POSITION || getPosition() <= MIN_POSITION) {
            elevator.set(power);
        } else {
            telemetry.addData("Elevator Limits", "EXCEEDING POSITION LIMITS");
            telemetry.update();
        }
    }
}
