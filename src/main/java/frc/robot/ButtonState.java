package frc.robot;


import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ButtonState {

    private JoystickButton b;
    
    public ButtonState(OI oi, int joystickID, int buttonID) {
        if(joystickID == RobotMap.LEFT_JOYSTICK)
            b = new JoystickButton(oi.leftJoystick, buttonID);
        if(joystickID == RobotMap.RIGHT_JOYSTICK)
            b = new JoystickButton(oi.rightJoystick, buttonID);
    }

    public boolean pressed() {
        return b.get();
    }

    private boolean prevBit = false, clickedState = false;
    
    public boolean clicked() {
        boolean bit = b.get();
        if(!prevBit && bit) clickedState = !clickedState;
        prevBit = bit;
        return clickedState;
    }
}