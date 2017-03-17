package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {

	
	public void AllOff()
    {
    	Robot.robotmap.ShooterMotor.set(0.0);
    	Robot.robotmap.KickerMotor.set(0.0);
    	Robot.robotmap.SploosherMotor.set(0.0);
    	Robot.robotmap.BlenderMotor.set(Relay.Value.kOff);
    }
    
    public void SpinFlywheel(int RPMSetpoint)
    {
    	Robot.robotmap.ShooterMotor.set(RPMSetpoint);
    }
    
    public void PulseFeeder()
    {
    
    	Robot.robotmap.KickerMotor.set(-1.0);
    	Robot.robotmap.BlenderMotor.set(Relay.Value.kReverse);
      	Robot.robotmap.SploosherMotor.set(1.0); 
    	
    	
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


