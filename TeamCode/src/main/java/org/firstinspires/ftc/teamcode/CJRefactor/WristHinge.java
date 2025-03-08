package org.firstinspires.ftc.teamcode.CJRefactor;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class WristHinge {
    private final double MIN_POSITION = 0.1;
    private final double MAX_POSITION = 0.8;

    private double[] positions = {0.1, 0.3, 0.5, 0.7, 0.8};
    private int currentPosition = 2;

    private Servo servo;

    public WristHinge(HardwareMap hardwareMap){
        this.servo = hardwareMap.get(Servo.class, "wrist1");
        //servo.scaleRange(MIN_POSITION, MAX_POSITION);
    }

    public void setPosition(double position){

        if (position < MIN_POSITION) {
            servo.setPosition(MIN_POSITION);
        } else if (position > MAX_POSITION) {
            servo.setPosition(MAX_POSITION);
        } else {
            servo.setPosition(position);
        }
    }

    public void setPositionByIndex(int index) {
        if(index >= 0 && index <= 4) {
            currentPosition = index;
        }
        setPosition(positions[currentPosition]);
    }

    public void positionUp() {
        if (currentPosition < 4) {
            currentPosition++;
        }
        setPosition(positions[currentPosition]);
    }

    public void positionDown() {
        if (currentPosition > 0) {
            currentPosition--;
        }
        setPosition(positions[currentPosition]);
    }

    public void positionMin() {
        currentPosition = 0;
        setPosition(positions[currentPosition]);
    }

    public void positionMax() {
        currentPosition = 4;
        setPosition(positions[currentPosition]);
    }

    public double getPosition() {
        return this.servo.getPosition();
    }
}
