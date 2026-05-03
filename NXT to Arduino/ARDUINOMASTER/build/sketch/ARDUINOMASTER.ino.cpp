#include <Arduino.h>
#line 1 "C:\\Users\\Mikey\\Documents\\GitHub\\Embedded-Systems-Network\\NXT to Arduino\\ARDUINOMASTER\\ARDUINOMASTER.ino"
#include <Wire.h>

#line 3 "C:\\Users\\Mikey\\Documents\\GitHub\\Embedded-Systems-Network\\NXT to Arduino\\ARDUINOMASTER\\ARDUINOMASTER.ino"
void setup();
#line 8 "C:\\Users\\Mikey\\Documents\\GitHub\\Embedded-Systems-Network\\NXT to Arduino\\ARDUINOMASTER\\ARDUINOMASTER.ino"
void loop();
#line 3 "C:\\Users\\Mikey\\Documents\\GitHub\\Embedded-Systems-Network\\NXT to Arduino\\ARDUINOMASTER\\ARDUINOMASTER.ino"
void setup() {
  Wire.begin(); // Master mode
  Serial.begin(9600);
}

void loop() {
  Wire.beginTransmission(0x0A); // The address the NXT is listening for
  Wire.write(0x01);             // Send a "Header" or Register byte
  Wire.write(255);              // Send the actual data (0-255)
  Wire.endTransmission();
  
  Serial.println("Sent to NXT");
  delay(500); // Wait half a second
}

