import lejos.nxt.Button;

public class HelloWorld {
    public static void main (String[] args) {
        System.out.println("Hello VS Code");
        Button.waitForAnyPress();
    }
}

// useful?: LCD.drawString("Message", 0, 0);
