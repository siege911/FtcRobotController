package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous (name = "Auto Test")

public class AutoTest extends LinearOpMode{
    
public final int ARM_START_ANGLE = 0; //Do NOT set this under 0!!!
   public final int ARM_SAMPLE_INTAKE_ANGLE = 300;
   public final int ARM_HIGH_BASKET_ANGLE = 2930; //Do NOT set this over 2930!!!
   public final int ARM_SPECIMEN_INTAKE_ANGLE = 990;
   public final int ARM_SPECIMEN_PLACE_ANGLE = 1270; 
   
   public final double CLAW_OPEN_POSITION = 0.5;
   public final double CLAW_CLOSE_POSITION = 0.8;
   
    

   
   
    // http://192.168.43.1:8080
    // the robot is to be moved facing the right not facing toward the basket
    @Override
    public void runOpMode() {
        
        //Arm arm = new Arm(hardwareMap);
        //Drive drivebase = new Drive(hardwareMap);
        //Claw claw = new Claw(hardwareMap);
        //ElapsedTime runtime = new ElapsedTime();
        MyRobot robot = new MyRobot(hardwareMap);
        
        waitForStart();
        // Execute one-time code here
        double driveSpeed = .7;
        sleep(250);
        robot.armAttachment.claw.close();
        robot.armAttachment.arm.setToSpecimenDeliverPosition();
        robot.armAttachment.wristHinge.setToSpecimenDeliverPosition();
        robot.armAttachment.extension.setToSpecimenDeliverPosition();
        robot.drive.moveRelativeByDistance(18, 0, driveSpeed);
        robot.drive.moveRelativeByDistance(0, -10, driveSpeed);
        //clip specimen
        robot.drive.moveRelativeByDistance(14, 0, driveSpeed);
        robot.armAttachment.claw.open();
        //go to samples
        robot.drive.moveRelativeByDistance(-15, 0, driveSpeed);
        robot.armAttachment.extension.setToMinPosition();
        robot.drive.moveRelativeByDistance(0, 42, driveSpeed);
        robot.drive.moveRelativeByDistance(35, 0, .5);
        //first sample(left)
        robot.drive.moveRelativeByDistance(0, 12, driveSpeed);
        robot.drive.moveRelativeByDistance(-40, 0, driveSpeed);
        robot.drive.moveRelativeByDistance(40, 0, driveSpeed);
        //second sample(middle)
        robot.drive.moveRelativeByDistance(0, 12, .5);
        robot.drive.moveRelativeByDistance(-40, 0, driveSpeed);
        robot.drive.moveRelativeByDistance(40, 0, driveSpeed);
        //last sample(right)
        robot.drive.turnToHeading(160,1);
        robot.drive.moveRelativeByDistance(0, -10, .25);
        robot.armAttachment.arm.setToSpecimenIntakePosition();
        robot.armAttachment.wristHinge.setToSpecimenIntakePosition();
        //specimen intake
        robot.drive.moveRelativeByDistance(35, 0, driveSpeed);
        robot.drive.moveRelativeByDistance(9, 0, .25);
        robot.armAttachment.claw.close();
        sleep(500);
        robot.armAttachment.arm.setToSpecimenDeliverPosition();
        robot.armAttachment.wristHinge.setToSpecimenDeliverPosition();
        robot.drive.moveRelativeByDistance(-5, 0, driveSpeed);
        robot.drive.moveRelativeByDistance(0, 10, driveSpeed);
        robot.drive.turnToHeading(-20,1);
        robot.armAttachment.extension.setToSpecimenDeliverPosition();
        //second specimen delivery
        robot.drive.moveRelativeByDistance(0, -70, driveSpeed);
        robot.drive.moveRelativeByDistance(20, 0, driveSpeed);
        robot.armAttachment.claw.open();
        robot.drive.moveRelativeByDistance(-20, 0, 1);
        robot.drive.moveRelativeByDistance(0, 70, 1);
        robot.armAttachment.extension.setToMinPosition();
        
        
        
        
        
         //robot.armAttachment.wristHinge.setPosition(.3);
         //Please test this code before deleting
         
         
         
        
        while(opModeIsActive()) {
            //telemetry.addData("time", runtime.seconds());
            telemetry.addData("arm:", robot.armAttachment.arm.getPosition());
            telemetry.addData("claw:", robot.armAttachment.claw.getPosition());
            telemetry.addData("extension:", robot.armAttachment.extension.getPosition());
            telemetry.addData("wristHinge:", robot.armAttachment.wristHinge.getPosition());
            telemetry.addData("wristRotate:", robot.armAttachment.wristRotate.getPosition());
            telemetry.update();
        }
    }
}
