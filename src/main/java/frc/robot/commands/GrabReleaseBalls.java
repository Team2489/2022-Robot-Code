// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class GrabReleaseBalls extends CommandBase {
  /** Creates a new Intake. */
  private final Intake intake;
  private final double power;

  
  public GrabReleaseBalls(Intake intake, double power) {
    this.intake = intake;
    this.power = power;
    addRequirements(intake);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.run(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stop();  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
