// package org.firstinspires.ftc.teamcode.Old;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.CRServo;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.util.ElapsedTime;
// 
//  
//  import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//  import com.qualcomm.robotcore.util.ElapsedTime;
//  import com.qualcomm.robotcore.hardware.DcMotor;
//  import com.qualcomm.robotcore.hardware.CRServo;
//  import com.qualcomm.robotcore.hardware.Servo;
//  import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//  import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//  
//  @Autonomous (name = "Auto_Observe/Specimen")
//  
//  public class Auto extends LinearOpMode {
//      
//     Arm arm = new Arm(hardwareMap);
//     Drive move = new Drive(hardwareMap);
//     Claw grab = new Claw(hardwareMap);
//     ElapsedTime runtime = new ElapsedTime();
// 
//      @Override
//      public void runOpMode() {
// 
//      waitForStart();
//      runtime.reset();
// 
// /* 
// Robot moves to samples and puts them in observation zone and
// human player turns them into specimens then robot grbs the
// specimens and hangs them up one at a time.
// */
// 
// for (int i = 0; i < 2; i++) {
// // RightFront.setPower(1);
// // LeftFront.setPower(1);
// // RightBack.setPower(1);
// // LeftBack.setPower(1);
// // sleep(1000);
// 
//     //Drive forward 19 in.
//     move.driveDist(10, 0); 
//   //Strafe right 20 in.
//     move.driveDist(0, 10); 
//     //Drive forward 20 in.
//     move.driveDist(10, 0); 
//     //Strafe right 20 in.
//     move.driveDist(0, 10); 
//     //Drive back 52 in.
//     move.driveDist(-10, 0); 
//     //Drive forward x52 in.
//     move.driveDist(10, 0);  
//     //Strafe left 20 in.
//     move.driveDist(0, -10); 
//     //Drive forward 19 in.
//     move.driveDist(10, 0); 
//     //Strafe right 20 in.
//     move.driveDist(0, 10); 
//     //Drive back 52 in.
//     move.driveDist(-10, 0); 
//     //Drive forward x52 in.
//     move.driveDist(10, 0); 
//     //Strafe left 19 in.
//     move.driveDist(0, -10); 
//     //Drive forward 20 in.
//     move.driveDist(10, 0); 
//     //Strafe right 19 in.
//     move.driveDist(0, 10); 
//     //Drive back 52 in.
//     move.driveDist(-10, 0); 
//     //Turn 180 degrees
//     move.turnDegrees(180); 
//     //Move arm to specimen pos.
//     arm.goToPosition(arm.SPECIMEN_GRAB);
//     //Open claw
//     grab.openClaw();
//     //Close claw
//     grab.closeClaw();
//     //Turn 90 degrees
//     move.turnDegrees(90); 
//     //Drive forward 20 in.
//     move.driveDist(10, 0); 
//     //Turn 90 degrees
//     move.turnDegrees(90); 
//     //Drive forward 10 in.
//     move.driveDist(10, 0); 
//     //Move arm to hang
//     arm.goToPosition(arm.HIGH_RUNG);
//     //Open claw
//     grab.openClaw();
//     //Drive back 20 in.
//     move.driveDist(-10, 0); 
//     //Strafe right 19 in.
//     move.driveDist(0, 10); 
//     //Turn 180 degrees
//     move.turnDegrees(180); 
//     //Repeat twice
//     
//   }
//  }
// }
// 
