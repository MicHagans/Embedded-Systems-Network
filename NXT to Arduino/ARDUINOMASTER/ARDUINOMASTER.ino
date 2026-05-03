#include <Wire.h>

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
