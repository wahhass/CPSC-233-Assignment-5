package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

/**
 * Class used to get and set all the values
 */
public class GreenhouseSensor {
    private double currentTemp, tempEffect, currentSoil,soilEffect, humidityEffect, currentHumidity;

    /**
     * Initializes all the values
     */
    public GreenhouseSensor(){
        currentTemp = 0;
        currentSoil = 0;
        currentHumidity = 0;
        tempEffect = 0;
        soilEffect = 0;
        humidityEffect = 0;
    }

    /**
     * Method to set the Current Temperature
     * @param currentTemp current temperature
     */
    public void setCurrentTemp(double currentTemp){
        this.currentTemp = currentTemp;
    }


    /**
     * Method to set the Current Moisture
     * @param currentSoil current moisture
     */
    public void setCurrentSoil(double currentSoil){
        this.currentSoil = currentSoil;
    }


    /**
     * Method to set the Current Humidity
     * @param currentHumidity current humidity
     */
    public void setCurrentHumidity(double currentHumidity){
        this.currentHumidity = currentHumidity;
    }


    /**
     * Method to set the External Temperature Effect
     * @param tempEffect current effect
     */
    public void setTempEffect(double tempEffect){
        this.tempEffect = tempEffect;
    }


    /**
     * Method to set the External Moisture Effect
     * @param soilEffect current effect
     */
    public void setSoilEffect(double soilEffect){
        this.soilEffect = soilEffect;
    }


    /**
     * Method to set the External Humidity Effect
     * @param humidityEffect current effect
     */
    public void setHumidityEffect(double humidityEffect){
        this.humidityEffect = humidityEffect;
    }

}
