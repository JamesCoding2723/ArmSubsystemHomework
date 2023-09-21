package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class ArmSubsystem extends SubsystemBase {

    //add motors here

    public static final double PlaceDistance = 0.1;
    public static final double BackAwayDistance = 0.6;

    private PWMVictorSPX motor;
    private DigitalInput limitswitch;

    public ArmSubsystem() {
        motor = new PWMVictorSPX(4);
        addChild("motor",motor);
        motor.setInverted(false);

        limitswitch = new DigitalInput(4);
        addChild("limit switch", limitswitch);
    }

      //consider what methods are necessary for the motor to run effectively

    public void open(double speed) {
        motor.set(speed);
    }

    public void stop() {
        motor.set(0.0);
    }

    public boolean isGripping() {
        return limitswitch.get();
    }

    public double whatSpeed() {
        return motor.get();
    }

    // I was very confused so I "consulted" the wpilib source material
  
    @Override
    public void periodic() {}
}