// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HoodedShooter;

public class ManualShoot extends CommandBase {
  /** Creates a new ManualShoot. */
  private final HoodedShooter hoodedShooter;
  private final double shooterPower;
  private final double feederPower;
  private Timer shooterTimer;
  private Timer feederTimer;
  private final double rampUpTime;
  private final double feedTime;
  private boolean feedStarted;
  public ManualShoot(HoodedShooter hoodedShooter, double shooterPower, double feederPower, double rampUpTime, double feedTime) {
    this.hoodedShooter = hoodedShooter;
    this.shooterPower = shooterPower;
    this.feederPower = feederPower;
    this.rampUpTime = rampUpTime;
    this.feedTime = feedTime;
    //this.shooterTimer = new Timer();
    //this.feederTimer = new Timer();
    this.feedStarted = false;
    addRequirements(hoodedShooter);
    
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.shooterTimer = new Timer();
    this.feederTimer = new Timer();
    shooterTimer.start();
    System.out.println("initlized");
  }
 
  @Override
  public void execute() {
    System.out.println("execute");
    hoodedShooter.shoot(shooterPower);
    if(shooterTimer.hasElapsed(rampUpTime)){
      System.out.println("here");
      if(feedStarted == false){
        feedStarted = true;
        feederTimer.start();
        System.out.println("feed timer started");
      }
      hoodedShooter.feed(feederPower);
    }
  
  }
  @Override
  public void end(boolean interrupted) {
    shooterTimer.stop();
    feederTimer.stop();
    hoodedShooter.stopShoot();
    
  }
  @Override
  public boolean isFinished() {
    System.out.println("isFinished");
    if(feedStarted == false){
      System.out.println("isFinished false");
      return false;
    }
    else{
      // System.out.println(feederTimer.get());
      System.out.println("isFinished true");
      boolean ret =  feederTimer.hasElapsed(feedTime);
      return ret;
    
    }

  }


  
}
