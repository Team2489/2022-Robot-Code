// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WinchClimber extends SubsystemBase {
  
  WPI_TalonSRX rightClimbMotor;
  WPI_TalonSRX leftClimbMotor;
  double rightMotorPower;
  double leftMotorPower;

  public WinchClimber() {
    rightClimbMotor = new WPI_TalonSRX(Constants.RIGHT_CLIMB_MOTOR);
    leftClimbMotor = new WPI_TalonSRX(Constants.LEFT_CLIMB_MOTOR);
    rightClimbMotor.configVoltageCompSaturation(12);
    leftClimbMotor.configVoltageCompSaturation(12);
    rightClimbMotor.enableVoltageCompensation(true);
    leftClimbMotor.enableVoltageCompensation(true);
    rightClimbMotor.setSafetyEnabled(true);
    leftClimbMotor.setSafetyEnabled(true);
    
    rightMotorPower = 0.0;
    leftMotorPower = 0.0;
   }
   public void raiseClimb(){
    rightClimbMotor.setNeutralMode(NeutralMode.Brake);
    leftClimbMotor.setNeutralMode(NeutralMode.Brake);
     rightMotorPower = 0.5;
     leftMotorPower = 0.5;
     double kRightClimbMotorVoltage = 12/rightClimbMotor.getBusVoltage();
     double kLeftClimbMotorVoltage = 12/leftClimbMotor.getBusVoltage();
     rightClimbMotor.set(ControlMode.PercentOutput, rightMotorPower*kRightClimbMotorVoltage);
     leftClimbMotor.set(ControlMode.PercentOutput, leftMotorPower*kLeftClimbMotorVoltage);
   }
   public void lowerClimb(){
    rightClimbMotor.setNeutralMode(NeutralMode.Brake);
    leftClimbMotor.setNeutralMode(NeutralMode.Brake);
    rightMotorPower = -0.5;
    leftMotorPower = -0.5;
    double kRightClimbMotorVoltage = 12/rightClimbMotor.getBusVoltage();
    double kLeftClimbMotorVoltage = 12/leftClimbMotor.getBusVoltage();
    rightClimbMotor.set(ControlMode.PercentOutput, rightMotorPower*kRightClimbMotorVoltage);
    leftClimbMotor.set(ControlMode.PercentOutput, leftMotorPower*kLeftClimbMotorVoltage);
   }
   public void stopClimb(){
    rightMotorPower = 0.0;
    leftMotorPower = 0.0;
    rightClimbMotor.set(0);
    leftClimbMotor.set(0);
   }
   public void rightClimb(){

   }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double kRightClimbMotorVoltage = 12/rightClimbMotor.getBusVoltage();
    double kLeftClimbMotorVoltage = 12/leftClimbMotor.getBusVoltage();
    rightClimbMotor.set(ControlMode.PercentOutput, rightMotorPower*kRightClimbMotorVoltage);
    leftClimbMotor.set(ControlMode.PercentOutput, leftMotorPower*kLeftClimbMotorVoltage);
  }
}
