// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.print.attribute.PrintRequestAttribute;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions correspondingto
 * each mode, as described in the TimedRobot documentation. If you change the name of this class  or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

Victor frontleft = new Victor(2) ;
Victor frontright = new Victor(1);
Victor backleft = new Victor(0);
Victor backright = new Victor(3);

Victor intake = new Victor(4);
Victor leftshooter = new Victor(5);
Victor rightshooter = new Victor(6);
Victor feeder = new Victor(7);

MotorControllerGroup leftmotor = new MotorControllerGroup(frontleft, backleft) ;
MotorControllerGroup rightmotor = new MotorControllerGroup(frontright, backright) ;

DifferentialDrive drive = new DifferentialDrive(leftmotor, rightmotor);

Joystick Ps4 = new Joystick(1) ;




  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
   
    }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    drive.tankDrive(Ps4.getRawAxis(1), Ps4.getRawAxis(0)) ;  
    
  if(Ps4.getRawButton(1)) {                          
    intake.set(1);
  }
  else if(Ps4.getRawButtonReleased(1)){
    intake.set(0) ; }
  else if(Ps4.getRawButton(2)){
    intake.set(-1);}
  else if(Ps4.getRawButtonReleased(2));{
    intake.set(-1);
  }  

  if(Ps4.getRawButton(3)){
    leftshooter.set(0.70);
    rightshooter.set(0.70);  }
  else if(Ps4.getRawButtonReleased(3)){
    leftshooter.set(0);
    rightshooter.set(0);
  }
  else if(Ps4.getRawButton(4)){
    leftshooter.set(-0.70);
    rightshooter.set(-0.70);
  }
  else if(Ps4.getRawButtonReleased(4)){
    leftshooter.set(0);
    rightshooter.set(0);
  }

  if(Ps4.getRawButton(5)){
    feeder.set(0.50);
  }
  else if(Ps4.getRawButtonReleased(5)){
    feeder.set(0);
  }
  else if(Ps4.getRawButton(6)){
    feeder.set(-0.50);
  }
  else if(Ps4.getRawButtonReleased(6)){
    feeder.set(0);
  }
    
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
