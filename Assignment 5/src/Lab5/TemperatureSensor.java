package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

/**
 * Class used to get and set all the values
 */
public class TemperatureSensor {

    private double desiredTemp, upperLimit, lowerLimit;
    private int updateRate;

    /**
     * Initializes all the values
     */
    public TemperatureSensor(){

        desiredTemp = 0;
        upperLimit = 0;
        lowerLimit = 0;
        updateRate = 0;
    }

    /**
     * Method to set the Desired Temperature
     * @param desiredTemp current temperature
     */
    public void setDesiredTemp(double desiredTemp){
        this.desiredTemp = desiredTemp;
    }

    /**
     * Method to set the Upper Maximum
     * @param upperLimit is the upper maximum
     */
    public void setUpperLimit(double upperLimit){
        this.upperLimit = upperLimit;
    }

    /**
     *Method to get Upper Maximum
     * @return upperLimit
     */
    public double getUpperLimit(){
        return this.upperLimit;
    }

    /**
     * Method to set the lower Minimum
     * @param lowerLimit is the lower minimum
     */
    public void setLowerLimit(double lowerLimit){
        this.lowerLimit = lowerLimit;
    }

    /**
     *Method to get Lower Minimum
     * @return lowerLimit
     */
    public double getLowerLimit(){
        return this.lowerLimit;
    }


    /**
     * Method to get the update refresh rate
     * @return updateRate
     */
    public int getUpdateRate(){
        return this.updateRate;
    }

}
