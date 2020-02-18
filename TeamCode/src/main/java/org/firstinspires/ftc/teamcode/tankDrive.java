package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Disabled
@TeleOp(name="tankDrive")
public class tankDrive extends OpMode {
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
        double rightX = gamepad1.right_stick_x;

        double[] tankArray = {(leftY + rightX),
                (leftY - rightX)
        };

        double max = 1;
        for(int i = 0; i < tankArray.length; i++){
            if((Math.abs(tankArray[i]))> 1){
                tankArray[i] = max;
            }
        }

        if(max > 1){
            for(int i = 0; i < tankArray.length; i++){
                tankArray[i] /= max;
            }
        }


        hardware.bottomRight.setPower(tankArray[1]);
        hardware.topRight.setPower(tankArray[1]);
        hardware.bottomLeft.setPower(tankArray[0]);
        hardware.topLeft.setPower(tankArray[0]);

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
