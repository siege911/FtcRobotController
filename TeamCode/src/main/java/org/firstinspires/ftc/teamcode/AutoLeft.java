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

@Autonomous (name = "Auto Left")

public class AutoLeft extends LinearOpMode{
    
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

        MyRobot robot = new MyRobot(hardwareMap);
        
        waitForStart();
        //Execute one-time code here
        robot.armAttachment.claw.close();
        robot.armAttachment.wristRotate.setToStartPosition();
        robot.drive.moveRelativeByDistance(5, 0, 0.5);
        robot.drive.moveRelativeByDistance(0, -28, 0.5);
        robot.drive.turnToHeading(35, 0.5);
        robot.armAttachment.arm.setToHighBasketPosition();
        robot.armAttachment.extension.setToHighBasketPosition();
        robot.armAttachment.wristHinge.setToMinPosition();
        sleep(1000);
        // Place first sample in bucket
        robot.armAttachment.wristHinge.setToSampleHighBasketDeliveryPosition();
        sleep(1000);
        robot.armAttachment.claw.open();
        sleep(500);
        robot.armAttachment.wristHinge.setToSampleIntakePosition();
        sleep(500);
        robot.armAttachment.extension.setToMinPosition();
        sleep(250);
        //Retrieve 2nd sample
        robot.armAttachment.arm.setToSampleIntakePosition();
        robot.drive.turnToHeading(-6.5, 0.5);
        robot.drive.moveRelativeByDistance(14, 0, 0.5);
        robot.drive.moveRelativeByDistance(0, 13, 0.5);
        robot.drive.moveRelativeByDistance(9, 0, 0.5);
        robot.drive.moveRelativeByDistance(0, 5, 0.25);
        robot.drive.moveRelativeByDistance(0, -5, 0.25);
        robot.drive.moveRelativeByDistance(-1, 0, 0.5);
        robot.armAttachment.arm.setToSampleIntakeHoverPosition();
        robot.armAttachment.claw.close();
        sleep(500);
        //Place 2nd Sample in bucket
        robot.drive.moveRelativeByDistance(-19, 0, 0.5);
        robot.drive.moveRelativeByDistance(0, -16, 0.5);
        robot.drive.turnToHeading(35, 0.5);
        robot.drive.moveRelativeByDistance(-7, 0, 0.5);
        robot.armAttachment.arm.setToHighBasketPosition();
        robot.armAttachment.extension.setToHighBasketPosition();
        robot.armAttachment.wristHinge.setToMinPosition();
        sleep(1000);
        robot.armAttachment.wristHinge.setToSampleHighBasketDeliveryPosition();
        sleep(1000);
        robot.armAttachment.claw.open();
        sleep(500);
        robot.armAttachment.wristHinge.setToSampleIntakePosition();
        sleep(500);
        robot.armAttachment.extension.setToMinPosition();
        sleep(250);
        //retrieve 3rd sample
         robot.armAttachment.arm.setToSampleIntakePosition();
        robot.drive.turnToHeading(-6.5, 0.5);
        robot.drive.moveRelativeByDistance(23, 0, 0.5);
        robot.drive.moveRelativeByDistance(0, 9, 0.25);
        robot.drive.moveRelativeByDistance(0, -4.5, 0.25);
        robot.drive.moveRelativeByDistance(-1, 0, 0.5);
        robot.armAttachment.arm.setToSampleIntakeHoverPosition();
        robot.armAttachment.claw.close();
        sleep(500);
        //deliver 3rd sample into hgh basket
        robot.drive.moveRelativeByDistance(-23, 0, 0.5);
        robot.drive.moveRelativeByDistance(0, -8, 0.5);
        robot.drive.turnToHeading(35, 0.5);
        robot.armAttachment.arm.setToHighBasketPosition();
        robot.armAttachment.extension.setToHighBasketPosition();
        robot.armAttachment.wristHinge.setToMinPosition();
        sleep(1000);
        robot.armAttachment.wristHinge.setToSampleHighBasketDeliveryPosition();
        sleep(1000);
        robot.armAttachment.claw.open();
        sleep(500);
        robot.armAttachment.wristHinge.setToSampleIntakePosition();
        sleep(500);
        robot.armAttachment.extension.setToMinPosition();
        sleep(250);
        robot.drive.turnToHeading(-6.5, 0.5);
        robot.armAttachment.arm.setToMinPosition();
        // robot.armAttachment.arm.setToSpecimenIntakePosition();
        // robot.armAttachment.wristHinge.setToSpecimenIntakePosition();
        //robot.drive.turnToHeading(160,1);
        //sleep(500);
        //robot.drive.turnToHeading(-20,1);
        // robot.armAttachment.arm.setToSpecimenDeliverPosition();
        // robot.armAttachment.claw.close();
        // robot.armAttachment.wristHinge.setPosition(.7);
        // robot.armAttachment.extension.setToSpecimenDeliverPosition();
        // sleep(5000);
        // robot.armAttachment.extension.setToMinPosition();
    
        // // //  arm.setPoseIndex(3);
        // // //  arm.rotateArm(0);
        // //claw.wrist1(false, true);
        // // this is where to start when you uncomment
        // robot.armAttachment.arm.setToSpecimenDeliverPosition();
        // //robot.armAttachment.wristHinge.setToSpecimenDeliverPosition();
        // robot.drive.moveRelativeByDistance(0, -13, 0.5);
        // robot.drive.moveRelativeByDistance(35, 0, 0.5);
        //  sleep (500);
        // robot.drive.moveRelativeByDistance(-5, 0, 0.5);
        // robot.drive.moveRelativeByDistance(0, 41, 0.5);
        // robot.drive.moveRelativeByDistance(25, 0, 0.5);
        // robot.drive.moveRelativeByDistance(0, 12, 0.5);
        // robot.drive.moveRelativeByDistance(-40, 0, 0.5);
        // robot.drive.moveRelativeByDistance(40, 0, .5);
        // robot.drive.moveRelativeByDistance(0, 14, 0.5);
        // robot.drive.moveRelativeByDistance(-40, 0, 0.5);
        // robot.drive.moveRelativeByDistance(40, 0, 0.5);
        // robot.drive.moveRelativeByDistance(0, 15, 0.5);
        // robot.drive.moveRelativeByDistance(-45, 0, 0.5);
        
         //robot.armAttachment.wristHinge.setPosition(.3);
         //Please test this code before deleting
         
         
         
        
         while(opModeIsActive()) {
            //telemetry.addData("time", runtime.seconds());
            telemetry.addData("arm:", robot.armAttachment.arm.getPosition());
            telemetry.addData("claw:", robot.armAttachment.claw.getPosition());
            telemetry.addData("extension:", robot.armAttachment.extension.getPosition());
            telemetry.addData("wristHinge:", robot.armAttachment.wristHinge.getPosition());
            telemetry.addData("wristRotate:", robot.armAttachment.wristRotate.getPosition());
            telemetry.addData("heading:", robot.drive.getHeading());
            telemetry.update();
          }
    }
}
// 