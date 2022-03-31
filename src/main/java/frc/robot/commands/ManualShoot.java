// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HoodedShooter;

public class ManualShoot extends CommandBase {
  /** Creates a new ManualShoot. */
  private final HoodedShooter hoodedShooter;
  private final double shooterSpeed;
  public ManualShoot(HoodedShooter hoodedShooter, double shooterSpeed) {
    this.hoodedShooter = hoodedShooter;
    this.shooterSpeed = shooterSpeed;
    
  }

  // Called when the command is initially scheduled.
 
  @Override
  public void execute() {
    hoodedShooter.shoot(shooterSpeed);
  }

  
}
