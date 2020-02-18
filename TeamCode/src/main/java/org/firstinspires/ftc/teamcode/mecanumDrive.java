package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class mecanumDrive extends OpMode {

    robotHardWare hardware = new robotHardWare();

    @Override
    public void init() {
        hardware.init(hardwareMap);
        hardware.bottomRight.setDirection(DcMotorSimple.Direction.REVERSE);
        hardware.topRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double leftY = -gamepad1.left_stick_y;
        double leftX = gamepad1.left_stick_x;
        double rightX = gamepad1.right_stick_x;

        double[] mecanumArray = {
                (leftX + leftY + rightX),
                (leftX - leftY - rightX),
                (leftX - leftY + rightX),
                (leftX + leftY - rightX)
        };

        double max = 1;
        for(int i = 0; i < mecanumArray.length; i++){
            if((Math.abs(mecanumArray[i]))> 1)
            {
                mecanumArray[i] = max;

            }

        }
        if(max > 1){
            for(int i = 0; i < mecanumArray.length; i++){
                mecanumArray[i] /= max;
            }
        }

        hardware.bottomLeft.setPower(mecanumArray[2]);
        hardware.bottomRight.setPower(mecanumArray[3]);
        hardware.topLeft.setPower(mecanumArray[0]);
        hardware.topRight.setPower(mecanumArray[1]);

        if(gamepad1.left_trigger > 0){
            hardware.intakeLeftMotor.setPower(-1);
            hardware.intakeRightMotor.setPower(1);
        }
        else{
            hardware.intakeLeftMotor.setPower(0);
            hardware.intakeRightMotor.setPower(0);
        }

        if(gamepad1.right_trigger > 0){
            hardware.intakeLeftMotor.setPower(1);
            hardware.intakeRightMotor.setPower(-1);
        }
        else{
            hardware.intakeLeftMotor.setPower(0);
            hardware.intakeRightMotor.setPower(0);
        }
    }


}
