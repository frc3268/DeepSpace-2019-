/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.RobotMap;
import org.usfirst.frc.team3268.robot.commands.DrivingCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The motors which drive the robot, and their methods of control.
 */
public class LiftSubSystem extends Subsystem {
	
	Compressor c;
	DoubleSolenoid frontPiston;
	DoubleSolenoid backPiston;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public LiftSubSystem() {
		c = new Compressor();
		frontPiston  = new DoubleSolenoid (1, 2);
		backPiston = new DoubleSolenoid(3, 4);
	}
	
	public void SetCompressor(int type) 
	{
		switch (type) 
		{
			case 0:
				c.start();
				break;
			
			case 1:
				c.stop();
				break;
		}
	}
	
	public void ExtendPiston(int type) 
	{
		switch (type) 
		{
			case 0:
				frontPiston.set(DoubleSolenoid.Value.kForward);
				break;
			
			case 1:
				backPiston.set(DoubleSolenoid.Value.kForward);
				break;
		}
	}
	
	public void ReversePiston(int type) 
	{
		switch (type)
		{
			case 0:
				frontPiston.set(DoubleSolenoid.Value.kReverse);
				break;
			
			case 1:
				backPiston.set(DoubleSolenoid.Value.kReverse);
				break;
		}
	}
	

	public void stop() {
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DrivingCommand());
	}
}
