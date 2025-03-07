package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class WristHinge {
    private final double MIN_POSITION = 0.1;
    private final double MAX_POSITION = 0.8;
    private final double SPECIMEN_INTAKE_POSITION = 0.6;
    private final double START = 0.0;
    private final double MAX_FORWARD_POSITION = 0.0;
    private final double MAX_BACKWARD_POSITION = 0.0;
    private final double SPECIMEN_DELIVERY_POSITON = 0.7;
    private final double SAMPLE_INTAKE_FIELD_POSITION = 0.2;
    private final double SAMPLE_DELIVERY_POSITION = 0.7;
    private final double ASCENT_POSITION = 0.0;
    private final double SAMPLE_INTAKE_SUBMERSIBLE_POSITION = 0.0;
    private Servo servo;

    public WristHinge(HardwareMap hardwareMap){
        this.servo = hardwareMap.get(Servo.class, "wrist1");
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

    public double getPosition() {
        return this.servo.getPosition();
    }
    public void setToStartPosition() {
        setPosition(START);
    }
    
    public void setToMinPosition() {
        setPosition(MIN_POSITION);
    }
    public void setToMaxPosition() {
        setPosition(MAX_POSITION);
    }
    public void setToSampleIntakePosition() {
        setPosition(SAMPLE_INTAKE_FIELD_POSITION);
    }
    
    
    public void setToSpecimenIntakePosition() {
        setPosition(SPECIMEN_INTAKE_POSITION);
    }
    public void setToSpecimenDeliverPosition() {
        setPosition(SPECIMEN_DELIVERY_POSITON);
    }
    public void setToAscentPosition() {
        setPosition(ASCENT_POSITION);
    }
    public void setToSampleSubmersIntakePosition() {
        setPosition(SAMPLE_INTAKE_SUBMERSIBLE_POSITION);
    }
    public void setToSampleHighBasketDeliveryPosition() {
        setPosition(SAMPLE_DELIVERY_POSITION);
    }
}
