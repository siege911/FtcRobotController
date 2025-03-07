package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;


public class Arm {
    private DcMotor motor;

    //private Telemetry telemetry;

    private int MIN_POSITION = 0;
    private int MAX_POSITION = 2930;
    public final int START = 0; //Do NOT set this under 0!!!
    public final int SAMPLE_INTAKE_ANGLE_FIELD = 325;
    public final int HIGH_BASKET_ANGLE = 2650; 
    public final int SPECIMEN_INTAKE_ANGLE = 450;
    public final int SPECIMEN_DELIVER_ANGLE = 1125;
    public final int ASCENT_ANGLE = 0; //Ascent not possible yet
    public final int SAMPLE_SUBMERSIBLE_INTAKE = 600;
    public final int SAMPLE_SUBMERSIBLE_GRAB_INTAKE = 480;
    public final int SAMPLE_INTAKE_HOVER = 275;

    public Arm(HardwareMap hardwareMap){
        this.motor = hardwareMap.get(DcMotor.class, "rotaryArm");
        this.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
        setPosition(SAMPLE_INTAKE_ANGLE_FIELD);
    }
    public void setToHighBasketPosition() {
        setPosition(HIGH_BASKET_ANGLE);
    }
    public void setToSpecimenIntakePosition() {
        setPosition(SPECIMEN_INTAKE_ANGLE);
    }
    public void setToSpecimenDeliverPosition() {
        setPosition(SPECIMEN_DELIVER_ANGLE);
    }
    public void setToSampleSubmersibleIntakePostion() {
        setPosition(SAMPLE_SUBMERSIBLE_INTAKE);
    }
    public void setToSampleSubmersibleIntakeGrabPostion() {
        setPosition(SAMPLE_SUBMERSIBLE_GRAB_INTAKE);
    }
    public void setToSampleIntakeHoverPosition() {
        setPosition(SAMPLE_INTAKE_HOVER);
    }
}