// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NEODrivetrain;

public class Drive extends CommandBase {
  /** Creates a new DriveStraightTime. */
  private final double power;
  private final double angle;
  private final NEODrivetrain driveTrain;
  public Drive(NEODrivetrain driveTrain, double power, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(driveTrain);
  this.driveTrain = driveTrain;
  this.power = power;
  this.angle = angle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(power, angle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
