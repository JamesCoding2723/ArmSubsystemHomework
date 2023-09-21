package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.arm.ArmSubsystem;

public class MoveArmWithJoystick extends CommandBase {
  /** Creates a new MoveArmWithJoystick. */

  //initialize your subsystems, controllers
  XboxController joystick1;
  ArmSubsystem arm1;
  public MoveArmWithJoystick(ArmSubsystem armSubsystem, XboxController joystick1) {
    //add your parameters to the command
    // Use addRequirements() here to declare subsystem dependencies.
    this.joystick1 = joystick1;
    arm1 = armSubsystem;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double joystickArmPower = joystick1.getLeftY(); //use this joystick armpower to set power to your motors
    arm1.open(joystickArmPower);
  }

  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
      arm1.stop();
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
