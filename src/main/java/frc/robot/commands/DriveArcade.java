// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;



import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NEODrivetrain;

public class DriveArcade extends CommandBase {
  /** Creates a new DriveArcade. */
   private final NEODrivetrain driveTrain;
    private final double speed;
    private final double rotation;
  public DriveArcade(NEODrivetrain driveTrain, double speed, double rotation) {
    
    this.driveTrain = driveTrain;
    this.speed = speed;
    this.rotation = rotation;
    addRequirements(driveTrain);
    
  }
  @Override
  public void execute() {
    driveTrain.arcadeDrive(speed, rotation);
    
  }

}
 
