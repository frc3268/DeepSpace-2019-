/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands;

import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class BallCommand extends Command {
	public BallCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.ballIntake);
		requires(Robot.ballShooting);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.ballIntake.SetSpeed(1);
		Robot.ballShooting.SetSpeed(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}