package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class AdvClaw {

    private CRServo intake;
    private Servo wrist1;
    private Servo wrist2;
    private Servo claw;
    private boolean current = false;
    private boolean toggle = false;
    private boolean previous = false;
    private double position = 0;
    private double position2 = 0;
    private boolean clawToggle = false;
    private boolean clawPrevious = false;
    
    private final double WRIST_2_POSITION_FRONT = 0;
    private final double WRIST_2_POSITION_BACK = 0;
    
    public AdvClaw(HardwareMap hardwareMap){
        this.wrist1 = hardwareMap.get(Servo.class, "wrist1");
        this.wrist2 = hardwareMap.get(Servo.class, "wrist2");
        this.claw = hardwareMap.get(Servo.class, "claw");
        // claw.setDirection(Servo.Direction.REVERSE);
        
    }

    // public void pickup(boolean in){
    //     current = in;
    //     if (current==true && current != previous){toggle = !toggle;
    //     }
    //     if (toggle==true){intake.setPower(5);
    //     }
    //     if (toggle==false){intake.setPower(-5);
    //     }
    //     previous = current;
    // }
    //arm controls intake for auto

    public void wrist1(boolean right, boolean left){
        
        if (right==true){
            wrist1.setPosition(0.7);
            position = 0.7;
        }
         //&& position == 0.18
        else if (left==true){
            wrist1.setPosition(0.2);
            position = 0.2;
       }
    }
    
    public void wrist2(double wrist2right, double wrist2left){
        
        if (wrist2right > 0.1){
            wrist2.setPosition(0.1);
        }
        else if (wrist2left > 0.1){
            wrist2.setPosition(.8);
        } 
        else{ 
            wrist2.setPosition(0.45);
        }
    }
    
    public void claw(boolean open, boolean grab, boolean drop){
        
        if(grab){
             wrist1.setPosition(.3);
        }
        if(drop){
            wrist1.setPosition(0.7);
            
        }
       
        if (open == true && clawPrevious == false){
            clawToggle = !clawToggle;
        }
        
        if(clawToggle == true){
            claw.setPosition(0.8);
        }
        else{
            claw.setPosition(-0.1);
        }
        clawPrevious = open;
    }
    
    public void openClaw() {
        claw.setPosition(0.8);
    }
    public void closeClaw() {
        claw.setPosition(0.5);
    }
    
    public double getClawPosition() {
        return this.claw.getPosition();
    }
    public double getWrist1Position() {
        return this.wrist1.getPosition();
    }
    public double getWrist2Position() {
        return this.wrist2.getPosition();
    }
}
