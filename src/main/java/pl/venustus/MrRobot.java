package pl.venustus;

import javafx.scene.control.Label;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MrRobot {

    public MrRobot() {
    }

    private static final Logger LOGGER = Logger.getLogger(MrRobot.class.getName());

    public void mouseMove() throws IOException, AWTException {
        Robot robot = new Robot();

        /*String nazwa = "notepad.exe";
        Runtime run = Runtime.getRuntime();
        run.exec(nazwa);
        robot.setAutoDelay(50);
        robot.keyPress(KeyEvent.VK_J);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_M); */
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            robot.mouseMove(r.nextInt(1200), r.nextInt(800));
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            robot.setAutoDelay(2000);
            System.out.println(i + " " + LocalDateTime.now());
            LOGGER.log(Level.FINE, "processing {0} entries in loop", i);
            LOGGER.log(Level.INFO, " " + i);
        }
    }

    public void mouseMoveWithLabel(Label label, Integer loop) throws IOException, AWTException {
        Robot robot = new Robot();

        if (loop == null) loop = 1;
        Random r = new Random();
        for (int i = loop; i > 0; i--) {
            robot.mouseMove(r.nextInt(1200), r.nextInt(800));
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

            robot.setAutoDelay(10000);

            System.out.println(i + " " + LocalDateTime.now());
            label.setText(String.valueOf(LocalDateTime.now()));

            LOGGER.log(Level.FINE, "processing {0} entries in loop", i);
            LOGGER.log(Level.INFO, " " + i);
        }
        label.setText("End loop." + LocalDateTime.now());
    }
}