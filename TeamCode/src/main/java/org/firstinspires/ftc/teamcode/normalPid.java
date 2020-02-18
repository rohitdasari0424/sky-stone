package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class normalPid {
    private double error;
    private double KP;
    private double KI;
    private double KD;
    private double previousTime;
    private double previousError;
    private double i = 0;
    private double d = 0;
    private double deltaTime;
    private double power;

    public double runPid(double currentLocation, double targetLocation){
        error = targetLocation - currentLocation;
        deltaTime = System.currentTimeMillis() - previousTime;
        d = (error - previousError)/ deltaTime;
        if(currentLocation > targetLocation*0.8){
            i += deltaTime*error;
        }
        previousTime = System.currentTimeMillis();
        error = previousError;
        power = (KP*error)+(KI*i)+(KD*d);
        return power;

    }
    public double getError(){
        return error;
    }

}
