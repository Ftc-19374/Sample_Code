package org.firstinspires.ftc.teamcode;
// import statements
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

/*
The purpose of this program is to obtain telemetry data from the color sensor/distance sensor
so that we can write another program that uses the color to perform a task.
This program is being created as an autonomous program because I do not expect input from the
gamepads.
The long-term goal is to use game elements from a previous season (yellow brick or brick
with a black image),and the robot will detect if the brick is yellow.
If so, the robot will move forward for 1 second.  Otherwise, it will move backward for 1s.
 */

@Autonomous(name="Color Sensing Fun")
public class FindColor extends LinearOpMode {

    //declare motors - chassis is two motor pushbot
    DcMotor motor1;
    DcMotor motor2;

    /* declare sensor(s) - I named the sensors according to their function to make the code
     more readable */
    ColorSensor color;
    DistanceSensor distance;

    /* the following method will be run after "Init" is pressed on the driver hub; it will
    essentially make sure that the variable names in configuration file on the driver hub matches
    the variables declared here; in other words we will bind the variables in the program (lhs) to
    the robot's hardware (rhs)
     */
    @Override
    public void runOpMode() throws InterruptedException {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        color = hardwareMap.get(ColorSensor.class, "color");
        distance = hardwareMap.get(DistanceSensor.class, "distance");

    /* at this point, we don't want to do anything else until the start button is pressed on the
     robot controller
     */
    waitForStart();

    /* next, we want to obtain a reading from the color sensor, and output the data to the robot
    controller.  The bigger picture is that we are going to need to know how the color sensor is
    "seeing" a color so that in future programs we can use these values for comparison and then
    have the robot complete a task.
     */
    telemetry.addData("Red", color.red());
    telemetry.addData("Green", color.green());
    telemetry.addData("Blue", color.blue());
    telemetry.update();
    }
}
