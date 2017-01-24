package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.RobotMap;
import org.usfirst.frc.team5030.robot.commands.JoystickOperation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem
{
	public static RobotDrive drive = new RobotDrive(RobotMap.FLSRX, RobotMap.BLSRX, RobotMap.FRSRX, RobotMap.BRSRX);
	final double driverBands = 0.08;
    
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoystickOperation());
	}
	
	public void driving()
	{
			
			double leftJoy; //Xvalue of OperatorStick 
			double rightJoy; //Yvalue of OperatorStick
	        
			//DeadBands
	        if (OI.DriverStick.getY() < driverBands && OI.DriverStick.getY() > -driverBands) 
	        {
	        	leftJoy = 0;
	        }
	        else 
	        {
	        	leftJoy = OI.DriverStick.getY();
	        }
	        if (OI.DriverStick.getRawAxis(5) < driverBands && OI.DriverStick.getRawAxis(5) > -driverBands)
	        { 
	        	rightJoy = 0;
	        }
	        else 
	        {
	        	rightJoy = OI.DriverStick.getRawAxis(5);
	        }
        
        
        drive.tankDrive(-leftJoy , -rightJoy, true);
	}
	
}
