package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_PlaceGearOnly extends Command {

	CommandGroup openServos;
	
	double rEnc = Robot.robotmap.FRSRX.getEncPosition();
	double lEnc = Robot.robotmap.BLSRX.getEncPosition();
    
	int DistanceToPeg = 28340;  
	
	public Auto_PlaceGearOnly() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.FRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BLSRX.setPosition(0);
    	Robot.robotmap.FRSRX.setPosition(0);
    	openServos = new CG_OpenServos();
    	setTimeout(5);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(lEnc < DistanceToPeg && rEnc < DistanceToPeg)
    	{
    		Robot.drivetrain.tankDrive(-0.75, -0.75);
    	}
    	else
    	{
    		Robot.drivetrain.tankDrive(0.0, 0.0);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
