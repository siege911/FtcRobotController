package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmAttachment {
    public Arm arm;
    public Extension elevator;
    public Gripper gripper;
    public WristHinge wristHinge;
    public WristRotate wristRotate;
    public ArmAttachment(HardwareMap hardwareMap) {
        arm = new Arm(hardwareMap);
        elevator = new Extension(hardwareMap);
        gripper = new Gripper(hardwareMap);
        wristHinge = new WristHinge(hardwareMap);
        wristRotate = new WristRotate(hardwareMap);
    }


}
