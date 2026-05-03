import lejos.nxt.SensorPort;
import lejos.nxt.I2CSensor;
import lejos.nxt.Button;
import lejos.util.Delay;

public class NXTSlave {
    public static void main(String[] args) {
        // Address 0x0A is 8-bit (matches Arduino 0x05)
        I2CSensor arduino = new I2CSensor(SensorPort.S1, 0x0A);
        
        System.out.println("NXT Slave Ready");
        byte[] buffer = new byte[2];

        while (!Button.ESCAPE.isDown()) {
            // In Slave mode, we "get" data that was sent to us
            // 0x01 is the internal register we are reading from
            int result = arduino.getData(0x01, buffer, 1);
            
            if (result == 0) {
                int val = buffer[0] & 0xFF;
                System.out.println("Recv: " + val);
            }
            
            Delay.msDelay(50);
        }
    }
}
