// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;



import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NEODrivetrain;

public class DriveArcade extends CommandBase {
  /** Creates a new DriveArcade. */
   private final NEODrivetrain driveTrain;
    private final DoubleSupplier speed;
    private final DoubleSupplier rotation;
  public DriveArcade(NEODrivetrain driveTrain, DoubleSupplier speed, DoubleSupplier rotation) {
    
    this.driveTrain = driveTrain;
    this.speed = speed;
    this.rotation = rotation;
    addRequirements(driveTrain);
    
  }
  @Override
  public void execute() {
    driveTrain.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    
  }

}
 
