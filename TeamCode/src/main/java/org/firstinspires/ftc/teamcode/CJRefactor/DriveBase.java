package org.firstinspires.ftc.teamcode.CJRefactor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveBase {
    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private DcMotor leftBack;

    // Calculate the COUNTS_PER_INCH for your specific drive train.
    // Go to your motor vendor website to determine your motor's COUNTS_PER_MOTOR_REV
    // For external drive gearing, set DRIVE_GEAR_REDUCTION as needed.
    // For example, use a value of 2.0 for a 12-tooth spur gear driving a 24-tooth spur gear.
    // This is gearing DOWN for less speed and more torque.
    // For gearing UP, use a gear ratio less than 1.0. Note this will affect the direction of wheel rotation.
    static final double     COUNTS_PER_MOTOR_REV    = 537.6 ;    // goBilda 5203 Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // No External Gearing.
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);


    public DriveBase(HardwareMap hardwareMap) {
        this.rightFront  = hardwareMap.get(DcMotor.class, "RightFront");
        this.leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        this.rightBack  = hardwareMap.get(DcMotor.class, "RightBack");
        this.leftBack = hardwareMap.get(DcMotor.class, "LeftBack");

        this.leftFront.setDirection(DcMotor.Direction.REVERSE);
        this.leftBack.setDirection(DcMotor.Direction.REVERSE);

        //reset encoder values
        this.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //set run mode to use encoders
        this.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }



    public void drive(double  rightY, double  rightX, double leftX, double speed) {
        rightFront.setPower((rightY - rightX - leftX)/speed);
        leftFront.setPower((rightY + rightX + leftX)/speed);
        rightBack.setPower((rightY + rightX - leftX)/speed);
        leftBack.setPower((rightY - rightX + leftX)/speed);
    }

    public void moveRelativeByDistance(double inchesForward, double inchesRight, double speed) {

        int newRightFrontTarget;
        int newLeftFrontTarget;
        int newRightBackTarget;
        int newLeftBackTarget;

        //Calculate new target encoder values for each wheel to achieve the desired movement
        //TODO current implemenation only moves forward. Implement strafing as well
        newRightFrontTarget = rightFront.getCurrentPosition() + (int)(inchesForward * COUNTS_PER_INCH);
        newLeftFrontTarget = leftFront.getCurrentPosition() + (int)(inchesForward * COUNTS_PER_INCH);
        newRightBackTarget = rightBack.getCurrentPosition() + (int)(inchesForward * COUNTS_PER_INCH);
        newLeftBackTarget = leftBack.getCurrentPosition() + (int)(inchesForward * COUNTS_PER_INCH);

        //Set target positions
        rightFront.setTargetPosition(newRightFrontTarget);
        leftFront.setTargetPosition(newLeftFrontTarget);
        rightBack.setTargetPosition(newRightBackTarget);
        leftBack.setTargetPosition(newLeftBackTarget);

        // Turn On RUN_TO_POSITION
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Start motion
        rightFront.setPower(Math.abs(speed));
        leftFront.setPower(Math.abs(speed));
        rightBack.setPower(Math.abs(speed));
        leftBack.setPower(Math.abs(speed));

        //Wait for motion to end
        //TODO implement a timeout and check opModeIsActive to exit the loop
        //in case a wheel gets stuck or operator kills the program
        while (rightFront.isBusy() && leftFront.isBusy() && rightBack.isBusy() && leftBack.isBusy()) {

        }

        //Stop motion
        rightFront.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        leftBack.setPower(0);

        //set run mode to use encoders
        this.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

}
