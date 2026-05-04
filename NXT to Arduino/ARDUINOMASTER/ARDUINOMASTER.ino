#include <Wire.h>

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
