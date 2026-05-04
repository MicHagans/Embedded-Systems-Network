import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import lejos.util.Delay;

public class NXTSlave {
    public static void main(String[] args) {
        // Force the port to a 'dead' state first to clear Error 5
        SensorPort.S1.setType(SensorPort.TYPE_NO_SENSOR);
        Delay.msDelay(500);
        
        // Now set it to I2C mode
        SensorPort.S1.setType(SensorPort.TYPE_LOWSPEED);
        System.out.println("Port Reset. Ready.");

        byte[] buf = new byte[1];
        while (!Button.ESCAPE.isDown()) {
            // Check status BEFORE trying to read
            int status = SensorPort.S1.i2cStatus();
            
            if (status == 0) {
                // If status is 0, the bus is FREE
                System.out.println("Bus Free!");
            } else {
                System.out.println("Error: " + status);
            }
            Delay.msDelay(500);
        }
    }
}
