package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class WristRotate {

    private final double MIN_POSITION = 0.45;
    private final double MAX_POSITION = 1;
    private final double START = 0.0;
    private final double CENTER_POSITION = 0.0;
    private final double MAX_CW_POSITION = 0.0;  //CW means "Clockwise"
    private final double MAX_CCW_POSITION = 0.0; //CCW means "Counter-Clockwise"
    private Servo servo;

    public WristRotate(HardwareMap hardwareMap){
        this.servo = hardwareMap.get(Servo.class, "wrist2");
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

    public void wristRotateLeft() {
        setPosition(0.45);
    }
    public void wristRotateRight() {
        setPosition(1);
    }

    public double getPosition() {
        return this.servo.getPosition();
    }
  
    public void setToMaxPosition() {
        setPosition(MAX_POSITION);
    }
    
    public void setToMinPosition() {
        setPosition(MIN_POSITION);
    }
    public void setToStartPosition() {
        setPosition(START);
    }
    public void setToCenterPosition() {
        setPosition(CENTER_POSITION);
    }
    public void setToCWPosition() {
        setPosition(MAX_CW_POSITION);
    }
    public void setToCCWPosition() {
        setPosition(MAX_CCW_POSITION);
    }
}

