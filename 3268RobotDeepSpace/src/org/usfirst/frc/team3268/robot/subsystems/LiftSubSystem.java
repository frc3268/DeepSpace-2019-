/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.commands.DrivingCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The motors which drive the robot, and their methods of control.
 */
public class LiftSubSystem extends Subsystem {
	
	Compressor c;
	DoubleSolenoid frontRightPiston;
	DoubleSolenoid frontLeftPiston;
	
	DoubleSolenoid backRightPiston;
	DoubleSolenoid backLeftPiston;
	public static final double TRAVEL_TIME = 2.0;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public LiftSubSystem() {
		c = new Compressor();
		frontRightPiston  = new DoubleSolenoid (1, 2);
		frontLeftPiston = new DoubleSolenoid(3, 4);
		
		backRightPiston = new DoubleSolenoid(5, 6);
		backLeftPiston = new DoubleSolenoid(7, 8);

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
				frontRightPiston.set(DoubleSolenoid.Value.kForward);
				frontLeftPiston.set(DoubleSolenoid.Value.kForward);
				break;
			
			case 1:
				backRightPiston.set(DoubleSolenoid.Value.kForward);
				backLeftPiston.set(DoubleSolenoid.Value.kForward);
				break;
		}
	}
	
	public void ReversePiston(int type) 
	{
		switch (type)
		{
			case 0:
				frontRightPiston.set(DoubleSolenoid.Value.kReverse);
				frontLeftPiston.set(DoubleSolenoid.Value.kReverse);
				break;
			
			case 1:
				backRightPiston.set(DoubleSolenoid.Value.kReverse);
				backLeftPiston.set(DoubleSolenoid.Value.kReverse);
				break;
		}
	}
	

	public void stopPiston(int type) {
		switch (type)
		{
			case 0:
				frontRightPiston.set(DoubleSolenoid.Value.kOff);
				frontLeftPiston.set(DoubleSolenoid.Value.kOff);
				break;
			
			case 1:
				backRightPiston.set(DoubleSolenoid.Value.kOff);
				backLeftPiston.set(DoubleSolenoid.Value.kOff);
				break;
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DrivingCommand());
	}
}
