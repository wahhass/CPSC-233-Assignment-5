package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

/**
 * Class used to water the Greenhouse
 */
public class Sprinkler {

    private double moistchangeRate, moistureIncrease;

    /**
     * Initializes all the values
     */
    public Sprinkler(){
        moistchangeRate = 0;
        moistureIncrease = 0;
    }

    /**
     * Method to set the moisture change rate
     * @param moistchangeRate the rate of moisture changing
     */
    public void setMoistChangeRate(double moistchangeRate){
        this.moistchangeRate = moistchangeRate;
    }

    /**
     * Method to set the Moisture increase
     * @param currentSoil the current soil moisture
     * @param moistchangeRate the current moisture change rate
     */
    public void setMoistureIncrease(double currentSoil,double moistchangeRate){

        moistureIncrease = currentSoil + moistchangeRate;
    }

    /**
     * Method to get the Moisture increase
     * @return moistureIncrease
     */
    public double getMoistureIncrease(){
        return this.moistureIncrease;
    }
}

