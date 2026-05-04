import lejos.nxt.SensorPort;
import lejos.nxt.I2CSensor;
import lejos.nxt.Button;
import lejos.util.Delay;

public class NXTSlave {
    public static void main(String[] args) {
        // Address 0x0A is 8-bit (matches Arduino 0x05)
        I2CSensor arduino = new I2CSensor(SensorPort.S1, 0x10);
        
        System.out.println("NXT Slave Ready");
        byte[] buffer = new byte[2];

        while (!Button.ESCAPE.isDown()) {
            // In Slave mode, we "get" data that was sent to us
            // 0x01 is the internal register we are reading from
            int status = arduino.getData(0x01, buffer, 1);
            if (status == 0) {
                System.out.println("Recv: " + (buffer[0] & 0xFF));
            } else {
                // If you see -1 here, the NXT can't see the Arduino at all.
                System.out.println("Error: " + status);
            }
            
            Delay.msDelay(500);
        }
    }
}
