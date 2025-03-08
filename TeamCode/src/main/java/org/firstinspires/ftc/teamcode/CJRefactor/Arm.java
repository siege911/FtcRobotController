package org.firstinspires.ftc.teamcode.CJRefactor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private DcMotor motor;

    private Telemetry telemetry;

    private int MIN_POSITION = 0;
    private int MAX_POSITION = 2930;

    public Arm(HardwareMap hardwareMap){
        this.motor = hardwareMap.get(DcMotor.class, "rotaryArm");
        this.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("Arm Status", "Initialized");
        telemetry.update();
    }

    public int getPosition() {
        return this.motor.getCurrentPosition();
    }

    public void moveByInput(double power){
        this.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if(getPosition() > MIN_POSITION && getPosition() < MAX_POSITION){
            motor.setPower(power);
        }
    }

    public void setPosition(int position) {
        if (position < MIN_POSITION) {
            motor.setTargetPosition(MIN_POSITION);
        } else if (position > MAX_POSITION) {
            motor.setTargetPosition(MAX_POSITION);
        } else {
            motor.setTargetPosition(position);
        }
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);
        while (motor.isBusy()) {
            telemetry.addData("Arm Current Position", getPosition());
            telemetry.addData("Arm Target Position", position);
            telemetry.update();
        }
    }
}
