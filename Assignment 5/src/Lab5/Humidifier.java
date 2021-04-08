package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

/**
 * Class used to humidify the Humidity inside the Greenhouse
 */
public class Humidifier {
    private double humichangeRate, HumidityIncrease;

    /**
     * Initializes all the values
     */
    public Humidifier(){
        humichangeRate = 0;
        HumidityIncrease = 0;
    }

    /**
     * Method to set the humidity change rate
     * @param humichangeRate the rate of humidity changing
     */
    public void setHumichangeRate(double humichangeRate){
        this.humichangeRate = humichangeRate;
    }

    /**
     * Method to set the Humidity Increase
     * @param currentHumi the current humidity
     * @param humichangeRate the current humidity change rate
     */
    public void setHumidityIncrease(double currentHumi,double humichangeRate){

        HumidityIncrease = currentHumi + humichangeRate;
    }

    /**
     * Method to get the Humidity Increase
     * @return HumidityIncrease
     */
    public double getHumidityIncrease(){
        return this.HumidityIncrease;
    }
}
