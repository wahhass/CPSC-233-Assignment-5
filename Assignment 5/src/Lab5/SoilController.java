package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */
import java.awt.event.*;
import java.awt.*;

/**
 * Thread class used to combine the Soil view and sensor and use them to get value
 */
public class SoilController implements Runnable {

    SoilView sview;
    SoilSensor ssensor;

    GreenhouseView gview;
    GreenhouseSensor gsensor;

    private boolean flag;

    /**
     * Method to kill the thread once finished
     */
    public void kill(){
        flag = false;
    }

    /**
     * Method to initialize the Greenhouse sensor, view and Soil sensor and view.
     * @param ssensor is the Soil view class
     * @param sview is the Soil view class
     * @param gview is the greenhouse view class
     * @param gsensor is the greenhouse sensor class
     */
    public SoilController(SoilSensor ssensor, SoilView sview, GreenhouseView gview, GreenhouseSensor gsensor){
        super();
        this.sview = sview;
        this.ssensor = ssensor;
        this.gsensor = gsensor;
        this.gview = gview;
    }

    /**
     * Method which the runnable thread uses to run the thread
     */
    public void run(){

        Sprinkler sprin = new Sprinkler();

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
        sview.addWindowListener(handler);

        sview.setCalcSolution3("OFF");
        sview.setCalcSolution("0.0" + "%");

        flag = true;

        double currentSoil, desiredSoil, upperLimit, lowerLimit, moistchangeRate;
        double soilEffect;
        int updateRate;

        desiredSoil = 0;
        upperLimit = 0;
        lowerLimit = 0;
        moistchangeRate = 0;
        updateRate = 0;

        currentSoil = gview.getCurrentSoil();

        soilEffect = gview.getSoilEffect();
        desiredSoil = sview.getDesiredSoil();
        upperLimit = sview.getUpper();
        lowerLimit = sview.getLower();
        moistchangeRate = sview.getMoistureChange();
        updateRate = sview.getUpRate();

        sprin.setMoistureIncrease(currentSoil,moistchangeRate);
        sprin.getMoistureIncrease();


        gsensor.setCurrentSoil(currentSoil);

        gsensor.setSoilEffect(soilEffect);
        ssensor.setDesiredMoisture(desiredSoil);
        ssensor.setUpperLimit(upperLimit);
        ssensor.setLowerLimit(lowerLimit);
        ssensor.getUpperLimit();
        ssensor.getLowerLimit();
        ssensor.getUpdateRate();

        sprin.setMoistChangeRate(moistchangeRate);

        sview.setCalcSolution3("OFF");


        try {
            /**
             * As the boolean stays true, this while statement gain and set the values of various moisture values.
             */
            while (flag) {
                sview.setCalcSolution(Double.toString(currentSoil) + "%");
                try {
                    Thread.sleep(updateRate * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (desiredSoil != currentSoil) {

                    if (currentSoil >= upperLimit) {

                        while (currentSoil > desiredSoil) {

                            currentSoil = currentSoil - soilEffect;
                            sview.setCalcSolution(Double.toString(currentSoil) + "%");
                            Thread.sleep(updateRate * 1000);


                        }

                    }
                    else if (currentSoil <= lowerLimit) {
                        while (currentSoil < desiredSoil) {
                            sview.setCalcSolution3("ON");

                            sprin.setMoistureIncrease(currentSoil, moistchangeRate);
                            currentSoil = sprin.getMoistureIncrease() + soilEffect;
                            sview.setCalcSolution(Double.toString(currentSoil) + "%");
                            Thread.sleep(updateRate * 1000);

                        }

                        sview.setCalcSolution3("OFF");
                    }
                    else {
                        sview.setCalcSolution(Double.toString(currentSoil) + "%");
                        break;
                    }

                }
            }

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        return;
    }
}
