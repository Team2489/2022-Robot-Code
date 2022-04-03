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
import frc.robot.commands.Drive;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.LowerClimb;
import frc.robot.commands.ManualShoot;
import frc.robot.commands.RaiseClimb;
import frc.robot.subsystems.HoodedShooter;
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
  private final WinchClimber winchClimber = new WinchClimber();
  private final HoodedShooter hoodedShooter = new HoodedShooter();
 

  private final AutonomousCommand m_autoCommand = new AutonomousCommand();

  public RobotContainer() {
    // Configure the button bindings
    
    double shooterSpeed = xboxController.getRawAxis(3);
    configureButtonBindings();
    driveTrain.setDefaultCommand(new DriveArcade(driveTrain, xboxController::getRightX, xboxController::getLeftY));
    hoodedShooter.setDefaultCommand(new ManualShoot(hoodedShooter, shooterSpeed));
    
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
    new JoystickButton(xboxController, Button.kLeftBumper.value).whenPressed(new Drive(driveTrain, 0.75, 0).withTimeout(2));
    

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

