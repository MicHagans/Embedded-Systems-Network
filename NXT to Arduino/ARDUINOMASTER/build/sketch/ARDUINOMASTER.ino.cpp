#include <Arduino.h>
#line 1 "C:\\Users\\Mikey\\Documents\\GitHub\\Embedded-Systems-Network\\NXT to Arduino\\ARDUINOMASTER\\ARDUINOMASTER.ino"
#include <Wire.h>

#line 3 "C:\\Users\\Mikey\\Documents\\GitHub\\Embedded-Systems-Network\\NXT to Arduino\\ARDUINOMASTER\\ARDUINOMASTER.ino"
void setup();
#line 10 "C:\\Users\\Mikey\\Documents\\GitHub\\Embedded-Systems-Network\\NXT to Arduino\\ARDUINOMASTER\\ARDUINOMASTER.ino"
void loop();
#line 3 "C:\\Users\\Mikey\\Documents\\GitHub\\Embedded-Systems-Network\\NXT to Arduino\\ARDUINOMASTER\\ARDUINOMASTER.ino"
void setup() {
  Wire.begin();
  Wire.setClock(5000);  // Drop to 5kHz (The NXT's "comfort zone")
  Serial.begin(9600);
  Serial.println("Started");
}

void loop() {
  
  Wire.beginTransmission(8); // The address the NXT is listening for
  Wire.write(0x01);             // Send a "Header" or Register byte
  Wire.write(42);              // Send the actual data (0-255)
  Wire.endTransmission();
  
  Serial.println("Sent to NXT");
  
  
  delay(500); 
}

