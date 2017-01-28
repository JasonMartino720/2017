package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickOperation extends Command {

    public JoystickOperation() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	

		double leftJoy; //Xvalue of OperatorStick 
		double rightJoy; //Yvalue of OperatorStick
        double driverBands = 0.08;
		
        //DeadBands
        if (Robot.oi.DriverStick.getY() < driverBands  && Robot.oi.DriverStick.getY() > -driverBands) 
        {
        	leftJoy = 0;
        }
        else 
        {
        	leftJoy = OI.DriverStick.getY();
        }
        if (Robot.oi.DriverStick.getRawAxis(5) < driverBands && Robot.oi.DriverStick.getRawAxis(5) > -driverBands)
        { 
        	rightJoy = 0;
        }
        else 
        {
        	rightJoy = Robot.oi.DriverStick.getRawAxis(5);
        }
    
       // Robot.drivetrain.tankDrive(leftJoy, rightJoy);
        Robot.drivetrain.tankDrive(leftJoy, rightJoy);
   
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

