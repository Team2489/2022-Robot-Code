// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  WPI_TalonSRX firstIntakeMotor;
  WPI_TalonSRX secondaryIntakeMotor;
  DigitalInput ballIn;
  public Intake() {
    firstIntakeMotor = new WPI_TalonSRX(Constants.FIRST_INTAKE_MOTOR);
    secondaryIntakeMotor = new WPI_TalonSRX(Constants.SECONDARY_INTAKE_MOTOR);
    firstIntakeMotor.configVoltageCompSaturation(12);
    secondaryIntakeMotor.configVoltageCompSaturation(12);
    firstIntakeMotor.enableVoltageCompensation(true);
    secondaryIntakeMotor.enableVoltageCompensation(true);
    firstIntakeMotor.setSafetyEnabled(true);
    secondaryIntakeMotor.setSafetyEnabled(true);
    ballIn = new DigitalInput(0);
   }
   public void intakeBalls(boolean grab, boolean release){
     double kFirstIntakeMotorVoltage = 12/firstIntakeMotor.getBusVoltage();
     double kSecondaryIntakeMotorVoltage = 12/secondaryIntakeMotor.getBusVoltage();
    if(grab){
      firstIntakeMotor.set(ControlMode.PercentOutput, 0.75*kFirstIntakeMotorVoltage);
      secondaryIntakeMotor.set(ControlMode.PercentOutput, 0.75*kSecondaryIntakeMotorVoltage);
    }
    else if(release){
      firstIntakeMotor.set(ControlMode.PercentOutput, -0.75*kFirstIntakeMotorVoltage);
      secondaryIntakeMotor.set(ControlMode.PercentOutput, -0.75*kSecondaryIntakeMotorVoltage);
    }
    else{
      firstIntakeMotor.set(ControlMode.PercentOutput, 0);
      secondaryIntakeMotor.set(ControlMode.PercentOutput, 0);
    }
  }

    public void run(double power){
      double kFirstIntakeMotorVoltage = 12/firstIntakeMotor.getBusVoltage();
      double kSecondaryIntakeMotorVoltage = 12/secondaryIntakeMotor.getBusVoltage();
      firstIntakeMotor.set(ControlMode.PercentOutput, power*kFirstIntakeMotorVoltage);
      secondaryIntakeMotor.set(ControlMode.PercentOutput, power*kSecondaryIntakeMotorVoltage);
     
    }
    public void stop(){
      firstIntakeMotor.set(0);
      secondaryIntakeMotor.set(0);
    }
    public boolean isStopped(){
      return ballIn.get();
    }
   

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
