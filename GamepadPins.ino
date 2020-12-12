#include <XInput.h>

// Directional Pad Pins
const int Pin_DpadUp    = 0;
const int Pin_DpadDown  = 0;
const int Pin_DpadLeft  = A0;
const int Pin_DpadRight = A1;

void setup() 
{

	pinMode(Pin_DpadUp, INPUT_PULLUP);
	pinMode(Pin_DpadDown, INPUT_PULLUP);
	pinMode(Pin_DpadLeft, INPUT_PULLUP);
	pinMode(Pin_DpadRight, INPUT_PULLUP);

	XInput.begin();
}

void loop() {
	boolean dpadUp    = !digitalRead(Pin_DpadUp);
	boolean dpadDown  = !digitalRead(Pin_DpadDown);
	boolean dpadLeft  = !digitalRead(Pin_DpadLeft);
	boolean dpadRight = !digitalRead(Pin_DpadRight);
	
	XInput.setDpad(dpadUp, dpadDown, dpadLeft, dpadRight);

	XInput.send();
}