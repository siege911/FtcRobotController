package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    
    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private DcMotor leftBack;
    
    private double rightY = 0;
    private double leftX = 0;
    private double rightX = 0;
    private double inchesForward;
    private double inchesRight;
    private double SPEED = 1;
    
    public Drive(HardwareMap hardwareMap) {
        this.rightFront  = hardwareMap.get(DcMotor.class, "RightFront");
        this.leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        this.rightBack  = hardwareMap.get(DcMotor.class, "RightBack");
        this.leftBack = hardwareMap.get(DcMotor.class, "LeftBack");
        
        this.leftFront.setDirection(DcMotor.Direction.REVERSE);
        this.leftBack.setDirection(DcMotor.Direction.REVERSE);
    }
    
    public void drive(double  rightY, double  rightX, double leftX) {
        rightFront.setPower((rightY - rightX - leftX)/SPEED);
        leftFront.setPower((rightY + rightX + leftX)/SPEED);
        rightBack.setPower((rightY + rightX - leftX)/SPEED);
        leftBack.setPower((rightY - rightX + leftX)/SPEED);
    }
    // public void driveDist(double inchesForward, double inchesRight, double SPEED) {
    //     rightFront.setPosition(double inchesForward - double inchesRight);
    //     leftFront.setPosition(double inchesForward + double inchesRight);
    //     rightBack.setPosition(double inchesForward + double inchesRight);
    //     leftBack.setPosition(double inchesForward - double inchesRight);
    // }
    
    // public void turnDegrees(double degrees) {
    //     this.rightFront.setPosotion(-double degrees);
    //     this.leftFront.setPosition(double degrees);
    //     this.rightBack.setPosotion(-double degrees);
    //     this.leftBack.setPosition(double degrees);
    // }
    
    //test later (move wheels with encoders)
        
    // public void one_motor_position_drive(int position, DcMotor motor, float power){
    //      this.motor.setTargetPosition(position);
    //      this.motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    //      this.motor.setPower(power);
    // }
    
    // public void position_drive(int position) {
    //     one_motor_position_drive(position, rightFront, 0.5);
    //     one_motor_position_drive(position, leftFront, 0.5);
    //     one_motor_position_drive(position, rightBack, 0.5);
    //     one_motor_position_drive(position, leftBack, 0.5);
    // }
}
