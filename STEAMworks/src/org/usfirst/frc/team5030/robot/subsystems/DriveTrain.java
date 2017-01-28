package org.usfirst.frc.team5030.robot.subsystems;

//import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.RobotMap;
import org.usfirst.frc.team5030.robot.commands.JoystickOperation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem
{
	public static RobotDrive drive;
	final double driverBands = 0.08;
		
	public DriveTrain()
	{
		drive = new RobotDrive(RobotMap.FLSRX, RobotMap.BLSRX, RobotMap.FRSRX, RobotMap.BRSRX);
		drive.setExpiration(1.0);
	}
	public void tankDrive(double leftJoy , double rightJoy)
	{
		drive.tankDrive(-leftJoy, -rightJoy, true);
	}
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoystickOperation());
	}

}
