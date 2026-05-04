import lejos.nxt.I2CSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import lejos.util.Delay;

public class NXTMASTER {
    public static void main(String[] args) {
        // --- SAFETY RESET SECTION ---
        System.out.println("Resetting Port...");
        SensorPort.S4.setType(SensorPort.TYPE_NO_SENSOR);
        Delay.msDelay(1000); // Wait for electrical discharge
        
        SensorPort.S4.setType(SensorPort.TYPE_LOWSPEED);
        Delay.msDelay(500); 
        // ----------------------------

        // Address 0x10 is 8-bit (matches Arduino address 8)
        I2CSensor arduino = new I2CSensor(SensorPort.S4, 0x10);
        byte[] buffer = new byte[1]; 

        System.out.println("NXT Master Active");

        while (!Button.ESCAPE.isDown()) {
            // First, check if the bus is even physically clear
            int busStatus = SensorPort.S4.i2cStatus();
            
            if (busStatus != 0) {
                System.out.println("Bus Busy: " + busStatus);
            } else {
                // Try to get data
                int status = arduino.getData(0x00, buffer, 1);
                
                if (status == 0) {
                    System.out.println("Value: " + (buffer[0] & 0xFF));
                } else {
                    System.out.println("I2C Err: " + status);
                }
            }
            
            Delay.msDelay(200); // Polling delay
        }
    }
}