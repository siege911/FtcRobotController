package org.firstinspires.ftc.teamcode.CommandSystem.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class GripperSubsystem extends SubsystemBase {
    Telemetry telemetry;
    private Servo wrist1;
    private Servo wrist2;
    private Servo claw;
    private double clawCurrentPosition;
    private double wrist1CurrentPosition;
    private double wrist2CurrentPosition;
    private boolean clawOpen = true;

    public GripperSubsystem(Servo wrist1Servo, Servo wrist2Servo, Servo clawServo){

        wrist1 = wrist1Servo;
        wrist2 = wrist2Servo;
        claw = clawServo;
        telemetry.addData("Claw Status", "Initialized");
        telemetry.addData("Wrist1 Status", "Initialized");
        telemetry.addData("Wrist2 Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void periodic() {

        clawCurrentPosition = getClawPosition();
        wrist1CurrentPosition = getWrist1Position();
        wrist2CurrentPosition = getWrist2Position();
        telemetry.addData("Claw Position", clawCurrentPosition);
        telemetry.addData("Wrist1 Position", wrist1CurrentPosition);
        telemetry.addData("Wrist2 Position", wrist2CurrentPosition);
        telemetry.update();
    }

    public double getClawPosition() {
        return claw.getPosition();
    }

    public double getWrist1Position() {
        return wrist1.getPosition();
    }

    public double getWrist2Position() {
        return wrist2.getPosition();
    }

    public void setClawPosition(double clawTargetPosition) {
        claw.setPosition(clawTargetPosition);
    }

    public void setWrist1Position(double wrist1TargetPosition) {
        wrist1.setPosition(wrist1TargetPosition);
    }

    public void setWrist2Position(double wrist2TargetPosition) {
        wrist2.setPosition(wrist2TargetPosition);
    }

    public void clawGrab() {
        if (!clawOpen) {
            claw.setPosition(-0.1);
        }

    }
    public void clawRelease() {
        if (clawOpen) {
            claw.setPosition(0.8);
        }
    }

}
