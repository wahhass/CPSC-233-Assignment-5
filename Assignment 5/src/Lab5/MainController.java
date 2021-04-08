package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class used for the main test method and launching all the threads.
 */
public class MainController {
    public static void main(String[] args) throws Exception{


        GreenhouseSensor gSensor = new GreenhouseSensor();
        GreenhouseView gView = new GreenhouseView();
        Greenhouse gcontroller = new Greenhouse(gSensor, gView);

        TemperatureSensor tempSensor = new TemperatureSensor();
        TempView tempView = new TempView();
        TemperatureController temperatureController = new TemperatureController(tempSensor, tempView, gView, gSensor);

        SoilSensor ssensor = new SoilSensor();
        SoilView sview = new SoilView();
        SoilController soilController = new SoilController(ssensor, sview, gView, gSensor);

        HumiSensor hsensor = new HumiSensor();
        HumiView hview = new HumiView();
        HumidityController humiController = new HumidityController(hsensor, hview, gView, gSensor);

        /**
         * Creating the various gui's
         */
        gView.createGreenGUI();
        tempView.createTempGUI();
        sview.createSoilGUI();
        hview.createHumiGUI();

        /**
         * Creates a button listener in which all the new threads are created and executed then terminated
         * by a press of a button.
         */
        class ButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                Thread grun = new Thread(gcontroller);
                Thread trun = new Thread(temperatureController);
                Thread srun = new Thread(soilController);
                Thread hrun = new Thread(humiController);

                try {
                    grun.start();
                    trun.start();
                    srun.start();
                    hrun.start();
                    Thread.sleep(500);

                    gcontroller.kill();
                    temperatureController.kill();
                    soilController.kill();
                    humiController.kill();

                }catch(Exception e1){
                    return;
                }

            }
        }
        /**
         * A button listener, listens to the start button
         */
        ButtonListener listener = new ButtonListener();
        gView.addButtonListeners(listener);


    }
}
