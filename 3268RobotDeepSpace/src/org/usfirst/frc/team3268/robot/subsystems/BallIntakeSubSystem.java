/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class BallIntakeSubSystem extends Subsystem {
	Talon BallIntakeMotor;
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public BallIntakeSubSystem() {
		BallIntakeMotor = new Talon(RobotMap.PWM_ballIntakeMotor);
		
		BallIntakeMotor.setInverted(true);
	}
	public void SetSpeed(double speed) {
		BallIntakeMotor.set(speed);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
