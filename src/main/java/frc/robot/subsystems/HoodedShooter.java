// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HoodedShooter extends SubsystemBase {
  /** Creates a new HoodedShooter. */
  CANSparkMax shooterMotor;
  CANSparkMax hoodMotor;
  CANSparkMax turretMotor;
  RelativeEncoder shooterEncoder;
  RelativeEncoder hoodEncoder;
  RelativeEncoder turretEncoder;
  
  public HoodedShooter() {

    shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR_PORT, MotorType.kBrushless);
    hoodMotor = new CANSparkMax(Constants.HOOD_MOTOR_PORT, MotorType.kBrushless);
    turretMotor = new CANSparkMax(Constants.TURRET_MOTOR_PORT, MotorType.kBrushless);
    shooterMotor.enableVoltageCompensation(12);
    shooterEncoder = shooterMotor.getEncoder();
    hoodMotor.enableVoltageCompensation(12);
    hoodEncoder = hoodMotor.getEncoder();
    turretMotor.enableVoltageCompensation(12);
    turretEncoder = turretMotor.getEncoder();
  }
  public void shoot(double shooterSpeed){
    double shooterVoltage = shooterMotor.getBusVoltage();
    shooterMotor.setInverted(true);
    shooterMotor.set(shooterSpeed*shooterVoltage);
  }
  public void setHood(double hoodAngle){
    double hoodVoltage = hoodMotor.getBusVoltage();
    double shooterDegrees = (-hoodEncoder.getPosition())*360/64;
    System.out.println(shooterDegrees);
    hoodMotor.set(hoodAngle*hoodVoltage);
    if(shooterDegrees >= 360){
      hoodMotor.set(0);
    }
  }
  public void resetHoodEncoder(){
    hoodEncoder.setPosition(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
