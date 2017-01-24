package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.ClimberOff;


public class Climber extends Subsystem {

    public void ClimberOff()
    {
    	RobotMap.Climber.set(0.0);
    }
    
    public void ClimberCW()
    {
    	RobotMap.Climber.set(1.0);
    }

    public void ClimberCCW()
    {
    	RobotMap.Climber.set(-1.0);
    }
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new ClimberOff());
    }
}

