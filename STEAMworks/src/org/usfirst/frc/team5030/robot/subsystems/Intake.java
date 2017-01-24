 package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

static final int intakeHoodDefault = 0;
static final int intakeHoodToHopper = 45;


	public void IntakeOff()
	{
		RobotMap.intakeBack.set(0.0);
		RobotMap.intakeFront.set(0.0);
		RobotMap.intakeHood.setAngle(intakeHoodDefault);
	}
	
	public void IntakeIn()
	{
		RobotMap.intakeBack.set(-1.0);
		RobotMap.intakeFront.set(1.0);
		RobotMap.intakeHood.setAngle(intakeHoodToHopper);
	}

    public void initDefaultCommand() 
    {
        
    	
    	
    }
}

