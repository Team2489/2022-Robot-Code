// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HoodedShooter;


public class RunFeeder extends CommandBase {
  /** Creates a new RunFeeder. */
  
  HoodedShooter hoodedShooter;
  double power;
 
  public RunFeeder(HoodedShooter hoodedShooter, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.hoodedShooter = hoodedShooter;
    this.power = power;

    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    hoodedShooter.feed(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
