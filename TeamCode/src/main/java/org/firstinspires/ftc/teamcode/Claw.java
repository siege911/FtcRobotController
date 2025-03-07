package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;


public class Claw {

    private Servo servo;

    private boolean clawOpen = true;

    private double MIN_POSITION = 0;
    private double MAX_POSITION = 1;


    public Claw(HardwareMap hardwareMap){
        this.servo = hardwareMap.get(Servo.class, "claw");
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

    public double getPosition() {
        return this.servo.getPosition();
        
       
    }
    
     public void open(){
         if(!clawOpen) {
             setPosition(0.8);
             clawOpen = true;
         }
         
     }
     
     public void close(){
         if(clawOpen) {
             setPosition(0.3);
             clawOpen = false;
         }
     }
     
     public void toggle(){
         if(clawOpen) {
             close();
         } 
         else {
             open();
         }
         
     }
             
}

  



