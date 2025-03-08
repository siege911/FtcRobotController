package org.firstinspires.ftc.teamcode.CJRefactor;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Gripper {

    private Servo servo;

    private boolean gripperOpen = true;

    private double MIN_POSITION = -0.2;
    private double MAX_POSITION = 1;

    private Telemetry telemetry;


    public Gripper(HardwareMap hardwareMap){
        this.servo = hardwareMap.get(Servo.class, "claw");
        telemetry.addData("Gripper Status", "Initialized");
        telemetry.update();
    }

    public void setPosition(double position) {
        if (position < MIN_POSITION) {
            servo.setPosition(MIN_POSITION);
        } else if (position > MAX_POSITION) {
            servo.setPosition(MAX_POSITION);
        } else {
            servo.setPosition(position);
        }
    }



    public void open() {
        gripperOpen = true;
        setPosition(0.8);
    }
    public void close() {
        gripperOpen = false;
        setPosition(-0.1);
    }

    public void toggle() {
        if (gripperOpen) {
            gripperOpen = false;
            setPosition(0.8);
        } else {
            gripperOpen = true;
            setPosition(-0.1);
        }
    }

    public double getPosition() {
        return this.servo.getPosition();
    }
}
