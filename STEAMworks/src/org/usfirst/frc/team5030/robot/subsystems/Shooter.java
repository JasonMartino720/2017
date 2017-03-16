package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5030.robot.commands.FlywheelOff;

/**
 *
 */
public class Shooter extends Subsystem {

	
	public void AllOff()
    {
    	Robot.robotmap.ShooterMotor.set(0.0);
    	Robot.robotmap.feederMotor.set(0.0);
    	Robot.robotmap.SploosherMotor2.set(0.0);
    	Robot.robotmap.SploosherMotor.set(Relay.Value.kOff);
    }
    
    public void SpinFlywheel()
    {
    	Robot.robotmap.ShooterMotor.set(-2750);
    }
    
    public void PulseFeeder()
    {
    
    	Robot.robotmap.feederMotor.set(1.0);
    	Robot.robotmap.SploosherMotor.set(Relay.Value.kReverse);
    	//Robot.robotmap.ShooterMotor.set(-3000);
    	Robot.robotmap.SploosherMotor2.set(-1.0); 
    	
    	
    }
    
    public void FlywheelOff()
    {
    	Robot.robotmap.ShooterMotor.set(0.0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new FlywheelOff());
    }
}


