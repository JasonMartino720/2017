package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_PlaceGearOnly extends Command {

	CommandGroup openServos;
	
	Timer timer;
	
	boolean Complete = false;
	double rEnc = Robot.robotmap.BRSRX.getEncPosition();
	double lEnc = Robot.robotmap.BLSRX.getEncPosition();
    
	int DistanceToPeg = 10000;  
	
	public Auto_PlaceGearOnly() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.gearmechanism);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.reverseOutput(true);
    	//openServos = new CG_OpenServos();
    	Robot.robotmap.gearMechanismServo.setAngle(0);
    	Robot.robotmap.HopperServo.setAngle(180);
    	setTimeout(4.5);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	double rEnc = Robot.robotmap.BRSRX.getEncPosition();
    	double lEnc = Robot.robotmap.BLSRX.getEncPosition();
    	
    	if(lEnc < DistanceToPeg && rEnc < DistanceToPeg)
    	{
    		Robot.drivetrain.tankDrive(0.45, 0.45);
    		System.out.println("R Enc " + rEnc);
    		System.out.println("L Enc " + lEnc);
    	}
    	else
    	{
    		Robot.drivetrain.tankDrive(0.0, 0.0);
    	}
    	*/
    	if(timeSinceInitialized() < 4.5)
    	{
    	
    		Robot.drivetrain.tankDrive(-0.65, -0.65);
    	
    	
    	}
    	else if(timeSinceInitialized() < 5.25 && timeSinceInitialized() > 4.5)
    	{
    		Robot.drivetrain.tankDrive(0.0, 0.0);
    		Robot.gearmechanism.GearMechJoyControl(-.6);
    	}
    	else if(timeSinceInitialized() < 7.5 && timeSinceInitialized() > 5.25)
    	{
    		Robot.gearmechanism.GearMechforTime(0.0);
    		Robot.drivetrain.tankDrive(0.65, 0.65);
    	}
    	else if(timeSinceInitialized() < 14.5 && timeSinceInitialized() > 7.5)
    	{
    		Robot.drivetrain.tankDrive(0.0, 0.0);
    	}
    	else
    	{
    		
    	}
    		
    	
    	   	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
