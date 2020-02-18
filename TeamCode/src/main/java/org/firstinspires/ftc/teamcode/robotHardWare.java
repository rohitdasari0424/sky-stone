package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class robotHardWare{
    public Servo leftFoundationHook;
    public com.qualcomm.robotcore.hardware.Servo rightFoundationHook;
    public DcMotor bottomRight;
    public DcMotor bottomLeft;
    public DcMotor topRight;
    public DcMotor topLeft;
    public DcMotor intakeLeftMotor;
    public DcMotor intakeRightMotor;






    public void init(HardwareMap hardwareMap){
        leftFoundationHook = hardwareMap.servo.get("leftHook");
        rightFoundationHook = hardwareMap.servo.get("rightHook");
        bottomLeft = hardwareMap.dcMotor.get("bottom_left");
        bottomRight = hardwareMap.dcMotor.get("bottom_right");
        topLeft = hardwareMap.dcMotor.get("top_left");
        topRight = hardwareMap.dcMotor.get("top_right");
        intakeLeftMotor = hardwareMap.dcMotor.get("intake_left");
        intakeRightMotor = hardwareMap.dcMotor.get("intake_right");



    }

}
