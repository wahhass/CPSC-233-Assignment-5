package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */
import java.awt.event.*;

/**
 * Thread class used to combine the Greenhouse view and sensor and use them to get value
 */
public class Greenhouse implements Runnable{


    GreenhouseView gview;
    GreenhouseSensor gsensor;
    boolean flag;

    /**
     * Method to kill the thread once finished
     */
    public void kill(){
        flag = false;
    }

    /**
     * Method to initialize the greenhouse sensor and view
     * @param gsensor is the greenhouse sensor class
     * @param gview is the greenhouse view class
     */
    public Greenhouse(GreenhouseSensor gsensor, GreenhouseView gview){

        this.gview = gview;
        this.gsensor = gsensor;
    }

    /**
     * Method which the runnable thread uses to run the thread
     */
    public void run(){

        /**
         * Handler to close the system once the x button at the top has been pressed
         */
        class MyHandler extends WindowAdapter {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        }
        /**
         * creates a listener for the exit button
         */
        MyHandler handler = new MyHandler();
        gview.addWindowListener(handler);

        flag = true;
        /**
         * As the boolean stays true, this while statement gain and set the values of various environmental values.
         */
        while (flag) {

            double currentTemp, tempEffect, currentSoil, soilEffect, currentHumi, humiEffect;

            currentTemp = 0;
            tempEffect = 0;
            currentSoil = 0;
            soilEffect = 0;
            currentHumi = 0;
            humiEffect = 0;

            currentTemp = gview.getCurrent();
            tempEffect = gview.getTempEffect();
            currentSoil = gview.getCurrentSoil();
            soilEffect = gview.getSoilEffect();
            currentHumi = gview.getCurrentHumidity();
            humiEffect = gview.getHumiEffect();

            gsensor.setCurrentTemp(currentTemp);
            gsensor.setTempEffect(tempEffect);
            gsensor.setCurrentSoil(currentSoil);
            gsensor.setSoilEffect(soilEffect);
            gsensor.setCurrentHumidity(currentHumi);
            gsensor.setHumidityEffect(humiEffect);

        }

    }
}
