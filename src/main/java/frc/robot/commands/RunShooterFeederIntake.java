// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HoodedShooter;
import frc.robot.subsystems.Intake;

public class RunShooterFeederIntake extends CommandBase {
  /** Creates a new RunShooterFeeder. */
  HoodedShooter hoodedShooter;
  Intake intake;
  double shooterPower;
  double feederPower;
  double intakePower;
  public RunShooterFeederIntake(HoodedShooter hoodedShooter, Intake intake, double shooterPower, double feederPower, double intakePower) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.hoodedShooter = hoodedShooter;
    this.shooterPower = shooterPower;
    this.feederPower =  feederPower;
    this.intakePower = intakePower;
    this.intake = intake;

    addRequirements(hoodedShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    hoodedShooter.shoot(shooterPower);
    hoodedShooter.feed(feederPower);
    intake.run(-intakePower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hoodedShooter.stopShoot();
    intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
