package org.usfirst.frc.team5030.robot.subsystems;

//import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.JoystickOperation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem
{
	public static RobotDrive drive;
	final double driverBands = 0.08;
		
	public DriveTrain()
	{
		drive = new RobotDrive(Robot.robotmap.FLSRX, Robot.robotmap.BLSRX, Robot.robotmap.FRSRX, Robot.robotmap.BRSRX);
		drive.setExpiration(1.0);
	}
	public void tankDrive(double leftJoy , double rightJoy)
	{
		if(Robot.oi.DriverStick.getRawButton(5))
		{
			drive.tankDrive(-leftJoy * 0.5, -rightJoy * 0.5, true);
			
		}
		else
		{
			drive.tankDrive(-leftJoy, -rightJoy, true);
			
		}
		//drive.arcadeDrive(-leftJoy, -rightJoy);
	}
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoystickOperation());
	}

}
