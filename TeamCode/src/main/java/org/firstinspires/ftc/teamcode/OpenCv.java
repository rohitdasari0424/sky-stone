package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@TeleOp(name="OpenCv")
public class OpenCv extends LinearOpMode {

    private OpenCvCamera phoneCam;
    OpenCvPipeline OpenCvPipe = new OpenCvPipeline();
    OpenCvPipeline position = new OpenCvPipeline();

    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewID = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewID","Id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.FRONT,cameraMonitorViewID);

        phoneCam.openCameraDevice();

        phoneCam.setPipeline(OpenCvPipe);

        phoneCam.startStreaming(320,240,OpenCvCameraRotation.UPRIGHT);


        while(!opModeIsActive()){
            telemetry.addData("SKYSTONE Position",position.Position);
            telemetry.update();
        }

        waitForStart();
        while(opModeIsActive()){
            if(position.Position.equals("LEFT")){

            }
        }
        if (position.Position.equals("CENTER")){

        }
        if(position.Position.equals("RIGHT")){

        }

    }
}
