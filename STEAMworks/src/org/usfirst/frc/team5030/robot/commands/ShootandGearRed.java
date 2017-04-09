package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootandGearRed extends Command {

	CommandGroup openServos;
	boolean flag1 = false;
	
    public ShootandGearRed() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.shooter);
        requires(Robot.gearmechanism);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.ShooterMotor.changeControlMode(TalonControlMode.Speed);
    	Robot.robotmap.ShooterMotor.setNominalClosedLoopVoltage(12.0);
    	Robot.robotmap.ShooterMotor.reverseSensor(true);
    	Robot.robotmap.ShooterMotor.setP(0.65);
    	Robot.robotmap.ShooterMotor.setI(0.001);
    	Robot.robotmap.ShooterMotor.setD(0);
    	Robot.robotmap.ShooterMotor.setF(0.129);
    	Robot.robotmap.ShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	//Robot.robotmap.BLSRX.reverseOutput(true);
    	Robot.robotmap.BRSRX.setEncPosition(0);
    	Robot.robotmap.BLSRX.setEncPosition(0);
    	openServos = new CG_OpenServos();
    	openServos.start();
    	setTimeout(14.9);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rEnc = Robot.robotmap.BRSRX.getEncPosition();
     	double lEnc = -Robot.robotmap.BLSRX.getEncPosition();
    	
    	if(this.timeSinceInitialized() < 1.5)
    	{
        	Robot.shooter.SpinFlywheel(-2795); //2780
	    	
	    }
    	else if(this.timeSinceInitialized() > 1.5 && this.timeSinceInitialized() < 4.25)
    	{
    		Robot.shooter.PulseFeeder();
    		//flag1 = true;
	    	
    	}
    	else
    	{
    		Robot.shooter.AllOff();
    		if(lEnc < 7000)
    		{
    			Robot.drivetrain.tankDrive(-0.85, -0.75);
    		}
    		else
    		{
    			Robot.drivetrain.tankDrive(0.0, 0.0);
    			Robot.robotmap.BRSRX.setEncPosition(0);
    	    	Robot.robotmap.BLSRX.setEncPosition(0);
    			
    			if(rEnc < 300)
    			{
    				Robot.drivetrain.tankDrive(0.4, -0.4);
    			}
    			else
    			{
    				Robot.drivetrain.tankDrive(0.0, 0.0);
    				Robot.robotmap.BRSRX.setEncPosition(0);
    		    	Robot.robotmap.BLSRX.setEncPosition(0);
    		    	
    		    	if((	rEnc < 1000 && lEnc < 1000) && timeSinceInitialized() < 9.0)
    		    	{
    		    		Robot.drivetrain.tankDrive(-0.5, -0.5);
    		    		
    		    	}
    		    	else
    		    	{
    		    		Robot.drivetrain.tankDrive(0.0, 0.0);
    		    		Robot.gearmechanism.GearMechforTime(-0.6);
    		    		Robot.robotmap.BRSRX.setEncPosition(0);
        		    	Robot.robotmap.BLSRX.setEncPosition(0);
        		    	if(rEnc > -500 && lEnc > -500)
        		    	{
        		    		Robot.drivetrain.tankDrive(0.5, 0.5);
        		    		
        		    	}
        		    	else
        		    	{
        		    		Robot.drivetrain.tankDrive(0.0, 0.0);
        		    	}
    		    	}
    			}
    			
    		}
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
