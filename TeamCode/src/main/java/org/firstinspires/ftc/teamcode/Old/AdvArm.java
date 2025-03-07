package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

// Numbers for the arm position:
// 0 is bottom
// 2930 is top

public class AdvArm {
   private DcMotor rotaryArm;
   private DcMotor linearArm;
   
   public final int START = 0; //Do NOT set this under 0!!!
   public final int SAMPLE_INTAKE = 300;
   public final int HIGH_BASKET = 2930; //Do NOT set this over 2930!!!
   public final int SPECIMEN_GRAB = 990;
   public final int SPECIMEN_PLACE = 1270;
   
   private int[] presets = {START,SAMPLE_INTAKE,SPECIMEN_GRAB,SPECIMEN_PLACE,HIGH_BASKET};

   private PIDCoefficients pid = new PIDCoefficients(1,0,0);
   private boolean dDownPrev;
   private boolean dUpPrev;
   private int poseIndex;
   private int adjust;
    
   public AdvArm(HardwareMap hardwareMap){
      this.linearArm = hardwareMap.get(DcMotor.class, "linearArm");
      this.linearArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      
      this.rotaryArm = hardwareMap.get(DcMotor.class, "rotaryArm");
      this.rotaryArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      this.rotaryArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      this.rotaryArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      dDownPrev = false;
      dUpPrev = false;
      poseIndex = 0;
      adjust = 0;
   }
  public void setPoseIndex(int poseInput){
     poseIndex = poseInput;
  }
  public void nextPresetPose(boolean indexUpButton){
     if (indexUpButton == true && dUpPrev == false){
        poseIndex = poseIndex+1;
     }
     dUpPrev = indexUpButton;
  }
   public void prevPresetPose(boolean indexDownButton){
      if (indexDownButton == true && dDownPrev == false){
         poseIndex = poseIndex-1;
      }
      
      
      dDownPrev = indexDownButton;
      
   }
  
   public void rotateArm(int rotatePower){
      presets[0] = presets[0] + ( rotatePower / 8);
      presets[1] = presets[1] + ( rotatePower / 8);
      if (poseIndex < 0){
         poseIndex = 0;
      }
      if (poseIndex > 4) {
         poseIndex = 4;
      }
      // if (rotatePower > 0) { // Move fast going up
         goToPosition(presets[poseIndex]);
      // } else if (rotatePower < 0) { // Move slow going down so its not jerky
      //    goToPosition((int)(getArmPosition() + (30 * rotatePower)));
      // }
   }
   
   public void extendArm(double extendPower){
      this.linearArm.setPower(extendPower);
   }
   
   public void test(boolean a){
      if(a){
         this.rotaryArm.setPower(.05);
      }
      else{
         this.rotaryArm.setPower(0);
      }
   }
   
   public int getArmPosition() {
      return this.rotaryArm.getCurrentPosition();
   }
   
   public int getExtensionPosition() {
      return this.linearArm.getCurrentPosition();
   }
   
   private void armAdjust(double adjusterJoy){
      adjust = adjust + ((int) adjusterJoy * 100);
   }
   
   
   public void goToPosition(int position) {
      if ((position >= START) && (position <= HIGH_BASKET)) {
         this.rotaryArm.setTargetPosition(position);
         this.rotaryArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
         this.rotaryArm.setPower(1);
      }
   }
   
   // public void goToPosition(boolean dUp, boolean dDown, double adjusterJoy) {
      
   //    armAdjust(adjusterJoy);
      
   //    if (dUp == true && dUpPrev == false) {
   //       poseIndex = poseIndex + 1;
   //    }
      
   //    if (dDown == true && dDownPrev == false) {
   //        poseIndex = poseIndex - 1;
   //    }
      
   //    if (poseIndex > 5) {
   //       poseIndex = 5;
   //        }
   //    if (poseIndex < 0) {
   //           poseIndex = 0;
   //        }
   //    switch (poseIndex){
   //    case 1: 
   //       this.rotaryArm.setTargetPosition(SAMPLE_INTAKE);
   //       break;
   //    case 2: 
   //       this.rotaryArm.setTargetPosition(SPECIMEN_GRAB + adjust);
   //       break;
   //    case 3: 
   //       this.rotaryArm.setTargetPosition(SPECIMEN_PLACE);
   //       break;
   //    case 4: 
   //       this.rotaryArm.setTargetPosition(HIGH_BASKET);
   //       break;
   //    default: 
   //       this.rotaryArm.setTargetPosition(adjust);
   //    }
   //       this.rotaryArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
   //       this.rotaryArm.setPower(1);
   //       dDownPrev = dDown;
   //       dUpPrev = dUp;
   // }
}
