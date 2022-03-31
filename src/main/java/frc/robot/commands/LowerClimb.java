// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WinchClimber;

public class LowerClimb extends CommandBase {
  /** Creates a new LowerClimb. */
  private final WinchClimber winchClimber;
  public LowerClimb(WinchClimber winchClimber) {
    this.winchClimber = winchClimber;
    addRequirements(winchClimber);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    winchClimber.lowerClimb();
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
