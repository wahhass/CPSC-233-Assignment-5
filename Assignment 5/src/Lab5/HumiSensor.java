package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

/**
 * Class used to get and set all the values
 */
public class HumiSensor {
    private double desiredHumidity, upperLimit, lowerLimit;
    private int updateRate;

    /**
     * Initializes all the values
     */
    public HumiSensor(){

        desiredHumidity = 0;
        upperLimit = 0;
        lowerLimit = 0;
        updateRate = 0;
    }
    /**
     * Method to set the Desired Humidity
     * @param desiredHumidity current Humidity
     */
    public void setDesiredHumidity(double desiredHumidity){
        this.desiredHumidity = desiredHumidity;
    }

    /**
     * Method to get the Desired Humidity
     * @return desiredHumidity
     */
    public double getDesiredHumidity(){
        return this.desiredHumidity;
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
     * Method to set the update refresh rate
     * @param updateRate refreshes the gui label
     */
    public void setUpdateRate(int updateRate){
        this.updateRate = updateRate;
    }

    /**
     * Method to get the update refresh rate
     * @return updateRate
     */
    public int getUpdateRate(){
        return this.updateRate;
    }
}
