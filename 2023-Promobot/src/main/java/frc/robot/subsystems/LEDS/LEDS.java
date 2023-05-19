package frc.robot.subsystems.LEDS;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import java.util.Random;

public class LEDS {
    AddressableLED LED;
    AddressableLEDBuffer LED_BUF;

    Color RED    = new Color(212, 35, 25);
    Color YELLOW = new Color(212, 193, 25);
    Color ORANGE = new Color(212, 109, 25);

    Color FIRE_COLORS[] = {RED, YELLOW, ORANGE};

    Random RAND;
    // Init
    LEDS(int led_count, int port_no)
    {
        /* setup our LEDS and Buffer */
        LED = new AddressableLED(port_no);
        LED_BUF = new AddressableLEDBuffer(led_count);

        LED.setLength(led_count);
        LED.setData(LED_BUF);

        RAND = new Random();
    }

    /* Utility Functions */

    void Fill(int red, int green, int blue)
    {
        for(int i = 0; i < LED_BUF.getLength(); i++)
        {
            LED_BUF.setRGB(i, red, green, blue);
        }
    }
 
    void Fire_Effect()
    {
        // Seed for proper random
        RAND.setSeed(System.currentTimeMillis());

        for(int i = 0; i < LED_BUF.getLength(); i++)
        {
            int color_index = RAND.nextInt(0, 2);
            LED_BUF.setRGB(i, FIRE_COLORS[color_index].red, FIRE_COLORS[color_index].green, FIRE_COLORS[color_index].green);
        }
    }
}