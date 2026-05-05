import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;

public class NXT_to_EV3 {
    public static void main(String[] args) throws Exception {
        LCD.drawString("Waiting...", 0, 0);
        BTConnection conn = Bluetooth.waitForConnection();
        LCD.drawString("Connected!", 0, 0);

        DataInputStream dis = conn.openDataInputStream();

        while (!Button.ESCAPE.isDown()) {
            if (dis != null && dis.available() > 0) {
                byte[] buffer = new byte[128];
                int bytesRead = dis.read(buffer);
                
                if (bytesRead > 0) {
                    String raw = new String(buffer, 0, bytesRead);
                    
                    // The "Smart Filter": Only act if the keyword is found
                    // .indexOf() returns -1 if the word is NOT found. 
                    // If it's 0 or higher, it means the word IS in the string.

                    if (raw.indexOf("FORWARD") != -1) {
                        LCD.clear();
                        LCD.drawString("CMD: FORWARD", 0, 1);
                        Motor.A.forward();
                    } else if (raw.indexOf("STOP") != -1) {
                        LCD.clear();
                        LCD.drawString("CMD: STOP", 0, 1);
                        Motor.A.stop();
                    }
                }
            }
        }
        conn.close();
    }
}
    // public static void main(String[] args) throws Exception {
    //     LCD.drawString("Waiting for BT...", 0, 0);
        
    //     // Wait for EV3 to connect
    //     BTConnection connection = Bluetooth.waitForConnection();
    //     LCD.clear();
    //     LCD.drawString("Connected!", 0, 0);

    //     DataInputStream dis = connection.openDataInputStream();
        
    //     while (dis.available() > 0) {
    //     String received = dis.readUTF(); 
    //     LCD.clear();
    //     LCD.drawString("Cmd: " + received, 0, 1);
    //     }
        
        // DataOutputStream dos = connection.openDataOutputStream();

        // // Send a string back to the EV3
        // dos.writeUTF("ACK_OK");
        // dos.flush();

        // connection.close();
    

