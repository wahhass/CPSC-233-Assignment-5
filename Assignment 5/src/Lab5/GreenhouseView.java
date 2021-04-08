package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

/**
 * Class to view all the labels, buttons, texfields on the GUI.
 */
public class GreenhouseView{
    private JFrame frame;
    private JTextField currentTempField, tempEffectField, soilEffectField, currentSoilField;
    private JTextField humiEffectField, currentHumiField;
    private JButton startButton, saveButton, loadButton;


    /**
     * Creates the title name, and sets the size of the calculator
     */
    public GreenhouseView(){
        frame = new JFrame("Temperature GUI");
        frame.setSize(300,450);
    }

    /**
     * Creates all the  UI elements and defines them, including labels, textfields,and creates the GUI.
     */
    public void createGreenGUI(){
        Container bigpane = frame.getContentPane();
        bigpane.setLayout(new GridLayout(1,1));

        JPanel bigPanel2 = new JPanel();
        bigPanel2.setLayout(new GridLayout(4,1,10,10));

        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new FlowLayout());

        JLabel environmentTemplabel = new JLabel("Environment Temperature (°C)");
        tempPanel.add(environmentTemplabel);

        currentTempField = new JTextField(5);
        currentTempField.setPreferredSize(new Dimension(50,25));
        tempPanel.add(currentTempField);

        JPanel tempEffectPanel = new JPanel();
        tempEffectPanel.setLayout(new FlowLayout());

        JLabel tempEffectlabel = new JLabel("Temperature Effect (°C/Min)");
        tempEffectPanel.add(tempEffectlabel);

        tempEffectField = new JTextField(5);
        tempEffectField.setPreferredSize(new Dimension(50,25));
        tempEffectPanel.add(tempEffectField);

        JPanel soilPanel = new JPanel();
        soilPanel.setLayout(new FlowLayout());

        JLabel environmentSoillabel = new JLabel("Environment soil moisture (%)");
        soilPanel.add(environmentSoillabel);

        currentSoilField = new JTextField(5);
        currentSoilField.setPreferredSize(new Dimension(50,25));
        soilPanel.add(currentSoilField);

        JPanel soilEffectPanel = new JPanel();
        soilEffectPanel.setLayout(new FlowLayout());

        JLabel soilEffectlabel = new JLabel("Negative Moisture Effect (%/Min)");
        soilEffectPanel.add(soilEffectlabel);

        soilEffectField = new JTextField(5);
        soilEffectField.setPreferredSize(new Dimension(50,25));
        soilEffectPanel.add(soilEffectField);

        JPanel humiPanel = new JPanel();
        humiPanel.setLayout(new FlowLayout());

        JLabel environmentHumilabel = new JLabel("Environment Humidity (%)");
        humiPanel.add(environmentHumilabel);

        currentHumiField = new JTextField(5);
        currentHumiField.setPreferredSize(new Dimension(50,25));
        humiPanel.add(currentHumiField);

        JPanel humiEffectPanel = new JPanel();
        humiEffectPanel.setLayout(new FlowLayout());

        JLabel humiEffectlabel = new JLabel("Negative Humidity Effect (°C/Min)");
        humiEffectPanel.add(humiEffectlabel);

        humiEffectField = new JTextField(5);
        humiEffectField.setPreferredSize(new Dimension(50,25));
        humiEffectPanel.add(humiEffectField);

        JPanel stButtonPanel = new JPanel();
        stButtonPanel.setLayout(new BorderLayout());

        JPanel stButPanel = new JPanel();
        stButPanel.setLayout(new FlowLayout());
        stButtonPanel.add(stButPanel, "Center");

        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100, 60));
        stButPanel.add(startButton);

        tempPanel.add(tempEffectPanel);
        soilPanel.add(soilEffectPanel);
        humiPanel.add(humiEffectPanel);
        bigPanel2.add(tempPanel);
        bigPanel2.add(soilPanel);
        bigPanel2.add(humiPanel);
        bigPanel2.add(stButtonPanel);
        bigPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        bigpane.add(bigPanel2);

        frame.setVisible(true);
    }
    /**
     *Method to get the current Temperature
     * @return 0 or current temperature
     */
    public double getCurrent(){
        if (currentTempField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(currentTempField.getText());
        }
    }

    /**
     *Method to get the environmental temperature effect
     * @return 0 or environmental temperature effect
     */
    public double getTempEffect(){
        if (tempEffectField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(tempEffectField.getText());
        }
    }

    /**
     *Method to get the current Soil
     * @return 0 or current soil
     */
    public double getCurrentSoil(){
        if (currentSoilField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(currentSoilField.getText());
        }
    }

    /**
     *Method to get the environmental moisture effect
     * @return 0 or environmental moisture effect
     */
    public double getSoilEffect(){
        if (soilEffectField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(soilEffectField.getText());
        }
    }

    /**
     *Method to get the current Humidity
     * @return 0 or current humidity
     */
    public double getCurrentHumidity(){
        if (currentHumiField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(currentHumiField.getText());
        }
    }

    /**
     *Method to get the environmental humidity effect
     * @return 0 or environmental humidity effect
     */
    public double getHumiEffect(){
        if (humiEffectField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(humiEffectField.getText());
        }
    }

    /**
     * Method for the window listener, listens for the close button
     * @param listener close button listener
     */
    public void addWindowListener(WindowListener listener) {
        frame.addWindowListener(listener);
    }

    /**
     * Method for the button listener, listens for the start button
     * @param listener start button listener
     */
    public void addButtonListeners(ActionListener listener){
        startButton.addActionListener(listener);
    }


}
