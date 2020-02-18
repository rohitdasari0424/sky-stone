package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class basicauto extends LinearOpMode {
    public ColorSensor color;





    public robotHardWare hardware = new robotHardWare();
    @Override
    public void runOpMode() {

        color = hardwareMap.colorSensor.get("stone_color");



        hardware.topRight.setDirection(DcMotorSimple.Direction.REVERSE);
        hardware.bottomRight.setDirection(DcMotorSimple.Direction.REVERSE);

        hardware.init(hardwareMap);



        waitForStart();




        forwardUsingEncoder();
        stoneDetect();
        check();
        /*spinRight(.5,-.5);
        sleep(1500);
        stop(0);
        strafeLeft(-.5,.5);
        sleep(2000);
        stop(0);
        hookDown(1,1);
        sleep(1000);
        stop(0);
        moveForward(.5);
        sleep(2000);
        stop(0);
        hookUp(0,0);
        sleep(500);
        stop(0);
        strafeRight(.5,-.5);
        sleep(2000);
        stop(0);
         */




    }

    public void moveForward(double a){
        hardware.bottomRight.setPower(a);
        hardware.topRight.setPower(a);
        hardware.topLeft.setPower(a);
        hardware.bottomLeft.setPower(a);

    }
    public void moveBack(double a){
        hardware.bottomRight.setPower(a);
        hardware.topRight.setPower(a);
        hardware.topLeft.setPower(a);
        hardware.bottomLeft.setPower(a);

    }
    public void spinRight(double a, double b){
        hardware.bottomRight.setPower(a);
        hardware.topRight.setPower(a);
        hardware.topLeft.setPower(b);
        hardware.bottomLeft.setPower(b);
    }
    public void strafeLeft(double a, double b){
        hardware.topLeft.setPower(a);
        hardware.bottomRight.setPower(a);
        hardware.topRight.setPower(b);
        hardware.bottomLeft.setPower(b);

    }
    public void hookDown(int a, int b){
        hardware.leftFoundationHook.setPosition(a);
        hardware.rightFoundationHook.setPosition(b);

    }
    public void hookUp(int a, int b){
        hardware.leftFoundationHook.setPosition(a);
        hardware.rightFoundationHook.setPosition(b);

    }

    public void strafeRight(double a, double b){
        hardware.topLeft.setPower(a);
        hardware.bottomLeft.setPower(b);
        hardware.bottomRight.setPower(a);
        hardware.topRight.setPower(b);
    }
    public void stop(int a){
        hardware.topLeft.setPower(a);
        hardware.topRight.setPower(a);
        hardware.bottomLeft.setPower(a);
        hardware.bottomRight.setPower(a);

    }
    public void stoneDetect(){
        telemetry.addData("red",color.red());
        telemetry.addData("green", color.green());
        telemetry.addData("blue",color.blue());
        telemetry.update();


    }
    public double distance(){
        int c1 = color.red();
        int c2 = color.green();
        int c3= color.blue();
        int mc1= 0;
        int mc2= 0;
        int mc3= 0;

        return Math.sqrt((c1 - mc1)^2 + (c2 - mc2)^2 + (c3 - mc3)^3);

    }

    public void check(){
        if (distance() < 40) {
            moveForward(.5);
            sleep(100);
            stop(0);
            hardware.intakeLeftMotor.setPower(-1);
            hardware.intakeRightMotor.setPower(1);
            sleep(1000);
            moveBack(-.5);
            sleep(500);
            stop(0);
            strafeLeft(-.5, .5);
            sleep(4000);
            stop(0);
            hardware.intakeLeftMotor.setPower(1);
            hardware.intakeRightMotor.setPower(-1);
            sleep(1000);
            strafeRight(.5, -.5);
            sleep(4000);
            stop(0);

        } else {
            strafeRight(.5, -.5);
            sleep(200);
            stop(0);
            stoneDetect();
            if(distance() < 40){
                moveForward(.5);
                sleep(100);
                stop(0);
                hardware.intakeLeftMotor.setPower(-1);
                hardware.intakeRightMotor.setPower(1);
                sleep(1500);
                moveBack(-.5);
                sleep(500);
                stop(0);
                strafeLeft(-.5, .5);
                sleep(4000);
                stop(0);
                hardware.intakeLeftMotor.setPower(1);
                hardware.intakeRightMotor.setPower(-1);
                sleep(1000);

                strafeRight(.5, -.5);
                sleep(4000);
                stop(0);

            }
            else {
                strafeRight(.5, -.5);
                sleep(200);
                stop(0);
                moveForward(.5);
                sleep(100);
                stop(0);
                hardware.intakeLeftMotor.setPower(-1);
                hardware.intakeRightMotor.setPower(1);
                sleep(1000);
                moveBack(-.5);
                sleep(500);
                strafeLeft(-.5, .5);
                sleep(4000);
                stop(0);
                hardware.intakeLeftMotor.setPower(1);
                hardware.intakeRightMotor.setPower(-1);
                sleep(1000);
                strafeRight(.5, -.5);
                sleep(4000);
                stop(0);
            }
        }
    }

    public void forwardUsingEncoder(){
        hardware.bottomLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hardware.topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hardware.bottomRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hardware.topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int distanceToStone = 12960;


        hardware.bottomRight.setTargetPosition(distanceToStone);
        hardware.topRight.setTargetPosition(distanceToStone);
        hardware.bottomLeft.setTargetPosition(distanceToStone);
        hardware.topLeft.setTargetPosition(distanceToStone);

        hardware.bottomLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.topLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.bottomRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.topRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moveForward(1);

        while(hardware.bottomRight.isBusy() && hardware.bottomLeft.isBusy() && hardware.topLeft.isBusy() && hardware.topRight.isBusy()){
            telemetry.addData("current position: ", hardware.bottomLeft.getCurrentPosition());
            telemetry.addData("current position: ", hardware.bottomRight.getCurrentPosition());
            telemetry.addData("current position: ", hardware.topLeft.getCurrentPosition());
            telemetry.addData("current position: ", hardware.topRight.getCurrentPosition());
            telemetry.update();




        }

        stop(0);



    }

    public void runPid(double distance){
        normalPid PID = new normalPid();
        double stopState = 0;
        double startTime = 0;

        while(opModeIsActive() && stopState < 1000){
            double currentPosition = hardware.bottomLeft.getCurrentPosition();
            double positionInInches = (currentPosition/Math.PI*4)*1440;
            double power = PID.runPid(positionInInches,distance);
            hardware.bottomLeft.setPower(power);
            hardware.bottomRight.setPower(power);
            hardware.topRight.setPower(power);
            hardware.topLeft.setPower(power);
        }
        if((PID.getError())< 1){
            stopState = System.currentTimeMillis() - startTime;
        }
        else{
            startTime += System.currentTimeMillis();
        }
    }
}
