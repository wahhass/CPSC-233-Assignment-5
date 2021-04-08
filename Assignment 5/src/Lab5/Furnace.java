package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

/**
 * Class used to heat the Temperature inside the Greenhouse
 */
public class Furnace {

    private double heatupRate, heatingTemp;

    /**
     * Initializes all the values
     */
    public Furnace(){
        heatupRate = 0;
        heatingTemp = 0;
    }

    /**
     * Method to set the heatup rate
     * @param heatupRate the rate of heat
     */
    public void setHeatupRate(double heatupRate){
        this.heatupRate = heatupRate;
    }

    /**
     * Method to set the Heating Temperature
     * @param currentTemp the current temperature
     * @param heatupRate the current heat up rate
     */
    public void setHeatingTemp(double currentTemp,double heatupRate){

        heatingTemp = currentTemp + heatupRate;
    }

    /**
     * Method to get the heating temperature
     * @return heatingTemp
     */
    public double getHeatingTemp(){
        return this.heatingTemp;
    }
}
