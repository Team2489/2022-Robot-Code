// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WinchClimber extends SubsystemBase {
  
  WPI_TalonSRX rightClimbMotor;
  WPI_TalonSRX leftClimbMotor;
  public WinchClimber() {
    rightClimbMotor = new WPI_TalonSRX(Constants.RIGHT_CLIMB_MOTOR);
    leftClimbMotor = new WPI_TalonSRX(Constants.LEFT_CLIMB_MOTOR);
    rightClimbMotor.configVoltageCompSaturation(12);
    leftClimbMotor.configVoltageCompSaturation(12);
    rightClimbMotor.enableVoltageCompensation(true);
    leftClimbMotor.enableVoltageCompensation(true);
    rightClimbMotor.setSafetyEnabled(true);
    leftClimbMotor.setSafetyEnabled(true);
   }
   public void raiseClimb(){
     double kRightClimbMotorVoltage = 12/rightClimbMotor.getBusVoltage();
     double kLeftClimbMotorVoltage = 12/leftClimbMotor.getBusVoltage();
     rightClimbMotor.set(ControlMode.PercentOutput, 0.5*kRightClimbMotorVoltage);
     leftClimbMotor.set(ControlMode.PercentOutput, 0.5*kLeftClimbMotorVoltage);
   }
   public void lowerClimb(){
    double kRightClimbMotorVoltage = 12/rightClimbMotor.getBusVoltage();
    double kLeftClimbMotorVoltage = 12/leftClimbMotor.getBusVoltage();
    rightClimbMotor.set(ControlMode.PercentOutput, -0.5*kRightClimbMotorVoltage);
    leftClimbMotor.set(ControlMode.PercentOutput, -0.5*kLeftClimbMotorVoltage);
   }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
