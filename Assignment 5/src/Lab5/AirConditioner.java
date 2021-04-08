package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

/**
 * Class used to cool the Temperature inside the Greenhouse
 */
public class AirConditioner {
    private double cooldownRate, coolingTemp;

    /**
     * Initializes all the values
     */
    public AirConditioner(){
        cooldownRate = 0;
        coolingTemp = 0;
    }

    /**
     * Method to set the cooldown rate
     * @param cooldownRate the rate of cooling
     */
    public void setCooldownRate(double cooldownRate){
        this.cooldownRate = cooldownRate;
    }


    /**
     * Method to set the Cooling Temperature
     * @param currentTemp the current temperature
     * @param cooldownRate the current cool down up rate
     */
    public void setCoolingTemp(double currentTemp,double cooldownRate){

        coolingTemp = currentTemp - cooldownRate;
    }

    /**
     * Method to get the Cooling Temperature
     * @return coolingTemp
     */
    public double getCoolingTemp(){
        return this.coolingTemp;
    }
}
