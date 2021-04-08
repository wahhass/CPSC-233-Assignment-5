package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */
import java.awt.event.*;
/**
 * Thread class used to combine the Humidity view and sensor and use them to get value
 */
public class HumidityController implements Runnable{

    HumiView hview;
    HumiSensor hsensor;

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
     * Method to initialize the Greenhouse sensor, view and Humidity sensor and view.
     * @param hsensor is the temperature view class
     * @param hview is the temperature view class
     * @param gview is the greenhouse view class
     * @param gsensor is the greenhouse sensor class
     */
    public HumidityController(HumiSensor hsensor, HumiView hview, GreenhouseView gview, GreenhouseSensor gsensor){
        super();
        this.hview = hview;
        this.hsensor = hsensor;
        this.gsensor = gsensor;
        this.gview = gview;
    }

    /**
     * Method which the runnable thread uses to run the thread
     */
    public void run(){

        Humidifier humid = new Humidifier();

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
        hview.addWindowListener(handler);

        hview.setCalcSolution3("OFF");
        hview.setCalcSolution("0.0" + "%");

        flag = true;

        double currentHumi, desiredHumi, upperLimit, lowerLimit, humichangeRate;
        double humiEffect;
        int updateRate;

        desiredHumi = 0;
        upperLimit = 0;
        lowerLimit = 0;
        humichangeRate = 0;
        updateRate = 0;

        currentHumi = gview.getCurrentHumidity();

        humiEffect = gview.getHumiEffect();
        desiredHumi = hview.getDesiredHumi();
        upperLimit = hview.getUpper();
        lowerLimit = hview.getLower();
        humichangeRate = hview.getHumidityChange();
        updateRate = hview.getUpRate();

        humid.setHumidityIncrease(currentHumi,humichangeRate);
        humid.getHumidityIncrease();


        gsensor.setCurrentHumidity(currentHumi);

        gsensor.setHumidityEffect(humiEffect);
        hsensor.setDesiredHumidity(desiredHumi);
        hsensor.setUpperLimit(upperLimit);
        hsensor.setLowerLimit(lowerLimit);
        hsensor.getUpperLimit();
        hsensor.getLowerLimit();
        hsensor.getUpdateRate();

        humid.setHumichangeRate(humichangeRate);

        hview.setCalcSolution3("OFF");


        try {
            /**
             * As the boolean stays true, this while statement gain and set the values of various humidity values.
             */
            while (flag) {
                hview.setCalcSolution(Double.toString(currentHumi) + "%");
                try {
                    Thread.sleep(updateRate * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (desiredHumi != currentHumi) {

                    if (currentHumi >= upperLimit) {

                        while (currentHumi > desiredHumi) {

                            currentHumi = currentHumi - humiEffect;
                            hview.setCalcSolution(Double.toString(currentHumi) + "%");
                            Thread.sleep(updateRate * 1000);


                        }

                    }
                    else if (currentHumi <= lowerLimit) {
                        while (currentHumi < desiredHumi) {
                            hview.setCalcSolution3("ON");

                            humid.setHumidityIncrease(currentHumi, humichangeRate);
                            currentHumi = humid.getHumidityIncrease() + humiEffect;
                            hview.setCalcSolution(Double.toString(currentHumi) + "%");
                            Thread.sleep(updateRate * 1000);

                        }

                        hview.setCalcSolution3("OFF");
                    }
                    else {
                        hview.setCalcSolution(Double.toString(currentHumi) + "%");
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

