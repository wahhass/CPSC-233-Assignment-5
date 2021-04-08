package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */
import java.awt.event.*;

/**
 * Thread class used to combine the Temperature view and sensor and use them to get value
 */
public class TemperatureController implements Runnable{

    TempView tview;
    TemperatureSensor tsensor;

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
     * Method to initialize the Greenhouse sensor, view and Temperature sensor and view.
     * @param tsensor is the temperature view class
     * @param tview is the temperature view class
     * @param gview is the greenhouse view class
     * @param gsensor is the greenhouse sensor class
     */
    public TemperatureController(TemperatureSensor tsensor, TempView tview, GreenhouseView gview, GreenhouseSensor gsensor){
        super();
        this.tview = tview;
        this.tsensor = tsensor;
        this.gsensor = gsensor;
        this.gview = gview;
    }

    /**
     * Method which the runnable thread uses to run the thread
     */
    public void run() {

        Furnace fur = new Furnace();
        AirConditioner ac = new AirConditioner();

        /**
         * Handler to close the system once the x button at the top has been pressed
         */
        class MyHandler extends WindowAdapter {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }

        /**
         * creates a listener for the exit button
         */
        MyHandler handler = new MyHandler();
        tview.addWindowListener(handler);

        tview.setCalcSolution2("OFF");
        tview.setCalcSolution3("OFF");
        tview.setCalcSolution("0.0" + "°C");

        flag = true;

        double currentTemp, desiredTemp, upperLimit, lowerLimit, heatupRate, heatingTemp, cooldownRate, coolingTemp;
        double tempEffect;
        int updateRate;

        desiredTemp = 0;
        upperLimit = 0;
        lowerLimit = 0;
        heatupRate = 0;
        cooldownRate = 0;
        updateRate = 0;

        currentTemp = gview.getCurrent();

        tempEffect = gview.getTempEffect();
        desiredTemp = tview.getDesiredTemp();
        upperLimit = tview.getUpper();
        lowerLimit = tview.getLower();
        heatupRate = tview.getHeating();

        cooldownRate = tview.getCooling();
        updateRate = tview.getUpRate();


        fur.setHeatupRate(heatupRate);

        gsensor.setCurrentTemp(currentTemp);
        gsensor.setTempEffect(tempEffect);
        tsensor.setDesiredTemp(desiredTemp);
        tsensor.setUpperLimit(upperLimit);
        tsensor.setLowerLimit(lowerLimit);
        tsensor.getUpperLimit();
        tsensor.getLowerLimit();
        tsensor.getUpdateRate();

        fur.setHeatupRate(heatupRate);
        ac.setCooldownRate(cooldownRate);

        tview.setCalcSolution2("OFF");
        tview.setCalcSolution3("OFF");

        try {
            /**
             * As the boolean stays true, this while statement gain and set the values of various temperature values.
             */
            while (flag) {

                tview.setCalcSolution(Double.toString(currentTemp) + "%");
                try {
                    Thread.sleep(updateRate * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (desiredTemp != currentTemp) {
                    if (currentTemp >= upperLimit) {

                        while (currentTemp > desiredTemp) {
                            tview.setCalcSolution2("ON");
                            ac.setCoolingTemp(currentTemp, cooldownRate);
                            currentTemp = ac.getCoolingTemp() + tempEffect;
                            tview.setCalcSolution(Double.toString(currentTemp) + "°C");
                            Thread.sleep(updateRate * 1000);

                        }

                        tview.setCalcSolution2("OFF");

                    } else if (currentTemp <= lowerLimit) {

                        while (currentTemp < desiredTemp) {
                            tview.setCalcSolution3("ON");
                            fur.setHeatingTemp(currentTemp, heatupRate);
                            currentTemp = fur.getHeatingTemp() + tempEffect;
                            tview.setCalcSolution(Double.toString(currentTemp) + "°C");
                            Thread.sleep(updateRate * 1000);
                        }

                        tview.setCalcSolution3("OFF");
                    } else {
                        tview.setCalcSolution(Double.toString(currentTemp) + "°C");
                        break;
                    }

                }

            }
        }catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        return;
    }
}
