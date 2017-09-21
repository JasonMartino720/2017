package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinUp extends Command {

    public SpinUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.ShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.ShooterMotor.changeControlMode(TalonControlMode.Speed);
    	Robot.robotmap.ShooterMotor.setNominalClosedLoopVoltage(12.0);
    	Robot.robotmap.ShooterMotor.reverseSensor(true);
    	Robot.robotmap.ShooterMotor.setP(0.25); // 0.25
    	Robot.robotmap.ShooterMotor.setI(0.001);
    	Robot.robotmap.ShooterMotor.setD(2.0);
    	Robot.robotmap.ShooterMotor.setF(0.07);//0.129
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    /*	if(Robot.robotmap.ShooterMotor.getEncVelocity() > -2200)
    	{
    		Robot.robotmap.ShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    		Robot.robotmap.ShooterMotor.set(-0.5);
    		System.out.println("Spinning");
    	}
    	else
    	{
    	*/
    	Robot.shooter.SpinFlywheel(-3000);
    	
    	System.out.println("Shooter Velocity " + Robot.robotmap.ShooterMotor.getEncVelocity());
    	//Robot.robotmap.ShooterMotor.getEncVelocity()
    	//}
    	//Robot.robotmap.ShooterMotor.
    	
    	
    	
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
