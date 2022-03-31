// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WinchClimber;

public class RaiseClimb extends CommandBase {
  /** Creates a new RaiseClimb. */
  private final WinchClimber winchClimber;
  public RaiseClimb(WinchClimber winchClimber) {
    this.winchClimber = winchClimber;
    addRequirements(winchClimber);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    winchClimber.raiseClimb();
  }
  @Override
  public boolean isFinished() {
    return true;
  }
}

  // Called every time the scheduler runs while the command is scheduled.


  // Called once the command ends or is interrupted.

