package frc.robot.subsystems;

import edu.wpi.first.networktables.*;

public class Limelight {

    public static double kDistanceConstant = 3360;
    public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public static boolean isTargetFound() {
        double tv = getValue("tv", 0);
        return tv > 0.5;
    }

    public static double getTargetDistanceInInches() {
        double width = kDistanceConstant / getValue("thor", 0);
        return width;
    }

    public static double getTargetHorizontalAngle() {
        return getValue("tx", 0);
    }

    public static double getTargetVerticalAngle() {
        return getValue("ty", 0);
    }

    private static double getValue(String key, double defaultValue) {
        return table.getEntry(key).getDouble(defaultValue);
    }
}