import lejos.nxt.*;

public class SIMPLE {
    public static void main(String[] args) throws Exception {
        // 1. Reset the port to clear any stuck -5 errors
        SensorPort.S4.setType(SensorPort.TYPE_NO_SENSOR);
        Thread.sleep(500);
        SensorPort.S4.setType(SensorPort.TYPE_LOWSPEED);
        Thread.sleep(500);

        // 2. Initialize the sensor object (Arduino Address 8 -> 0x10)
        I2CSensor arduino = new I2CSensor(SensorPort.S4, 0x10);
        byte[] buffer = new byte[1];

        while (!Button.ESCAPE.isDown()) {
            LCD.clear();
            
            // 3. Request data
            int status = arduino.getData(0x00, buffer, 1);
            
            if (status == 0) {
                LCD.drawString("Status: OK", 0, 0);
                LCD.drawString("Value: ", 0, 1);
                LCD.drawInt(buffer[0] & 0xFF, 7, 1);
            } else {
                LCD.drawString("Error: ", 0, 0);
                LCD.drawInt(status, 7, 0);
            }
            
            Thread.sleep(200);
        }
    }
}
