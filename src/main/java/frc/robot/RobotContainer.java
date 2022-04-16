// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.AutonomousCommandThree;
import frc.robot.commands.AutonomousCommandTwo;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.Grab;
import frc.robot.commands.GrabReleaseBalls;
import frc.robot.commands.LowerClimb;
import frc.robot.commands.ManualShoot;
import frc.robot.commands.ManualShootThree;
import frc.robot.commands.ManualShootTwo;
import frc.robot.commands.RaiseClimb;
import frc.robot.subsystems.HoodedShooter;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.NEODrivetrain;
import frc.robot.subsystems.WinchClimber;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  private final NEODrivetrain driveTrain = new NEODrivetrain();
  private final XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  private final XboxController xboxControllerTwo = new XboxController(Constants.XBOX_CONTROLLER_PORT_2);
  private final WinchClimber winchClimber = new WinchClimber();
  private final Intake intake = new Intake();
  private final HoodedShooter hoodedShooter = new HoodedShooter();
 

  private final AutonomousCommandTwo m_autoCommand = new AutonomousCommandTwo(driveTrain, 
    hoodedShooter,
    0.0,  // drivePower
    0.75,  // shooterPower
    1.0,  // feederPower
    -0.3,  // rotation, 
    6.25,  // driveTime, 
    1.5,  // rampUpTime, 
    3.0   // feedTime
    );
  // private final AutonomousCommandThree m_autoCommand = new AutonomousCommandThree(driveTrain, 
  //     hoodedShooter, 
  //     intake, 
  //     0.5, //intakePower 
  //     0.0, //drivePower 
  //     0.75, //shooterPower, 
  //     -1.0, //feederPower, 
  //     -0.4, //rotation, 
  //     2.5, //driveTime, 
  //     1.5, //rampUpTime, 
  //     5.0  //feedTime
  // );
  

  public RobotContainer() {
    // Configure the button bindings
    
    
    configureButtonBindings();
     driveTrain.setDefaultCommand(new DriveArcade(driveTrain, xboxController::getRightX, xboxController::getLeftY));
    // hoodedShooter.setDefaultCommand(new ManualShoot(hoodedShooter, xboxController::getLeftBumper));
    
  }


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

     new JoystickButton(xboxController, Button.kX.value).whenHeld(new RaiseClimb(winchClimber));
     new JoystickButton(xboxController, Button.kY.value).whenHeld(new LowerClimb(winchClimber));
    // new JoystickButton(xboxController, Button.kLeftBumper.value).whenPressed(new Drive(driveTrain, 0.75, 0).withTimeout(2));
    new JoystickButton(xboxControllerTwo, Button.kX.value).whenHeld(new GrabReleaseBalls(intake,-0.5));
    new JoystickButton(xboxControllerTwo, Button.kY.value).whenHeld(new GrabReleaseBalls(intake, 0.5));
    // new JoystickButton(xboxController, Button.kLeftBumper.value).whenPressed(new GrabReleaseBalls(intake, -0.3).withTimeout(3));
    // new JoystickButton(xboxController, Button.kRightBumper.value).whenPressed(new GrabReleaseBalls(intake, 0.3).withTimeout(3));
    // new JoystickButton(xboxController, Button.kB.value).whenPressed(new Grab(intake, 0.3));
    new JoystickButton(xboxControllerTwo, Button.kA.value).whenPressed(new ManualShootTwo(hoodedShooter, 0.75, 1, 1.5, 3));
    new JoystickButton(xboxControllerTwo, Button.kB.value).whenPressed(new ManualShootThree(hoodedShooter, 0.3, 1, 1.5, 3));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

