package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Class to view all the labels, buttons, texfields on the GUI.
 */
public class SoilView {

    private JFrame frame;
    private JTextField desiredField, upperField, lowerField, moisturechangeField, updateField;
    private JLabel calcSolution, calcSolution3;

    /**
     * Creates the title name, and sets the size of the calculator
     */
    public SoilView() {
        frame = new JFrame("Soil Moisture GUI");
        frame.setSize(300,450);
    }

    /**
     * Creates all the  UI elements and defines them, including labels, textfields,and creates the GUI.
     */
    public void createSoilGUI() {

        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(1,1));

        JPanel bigBoxPanel = new JPanel();
        bigBoxPanel.setLayout(new BorderLayout());

        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4,1,5,5));

        JPanel currentPanel = new JPanel();
        currentPanel.setLayout(new GridLayout(3,1));

        JLabel currentsoillabel = new JLabel("Current Moisture (%)");
        currentPanel.add(currentsoillabel);

        calcSolution = new JLabel();
        currentPanel.add(calcSolution);

        JPanel desiredPanel = new JPanel();
        desiredPanel.setLayout(new FlowLayout());

        JLabel desiredsoillabel = new JLabel("Desired Moisture (%)");
        desiredPanel.add(desiredsoillabel);

        desiredField = new JTextField(5);
        desiredField.setPreferredSize(new Dimension(80,25));
        desiredPanel.add(desiredField);

        JPanel comfortPanel = new JPanel();
        comfortPanel.setLayout(new GridLayout(3,1));

        JPanel upPanel = new JPanel();
        upPanel.setLayout(new FlowLayout());

        JLabel upperlabel = new JLabel("Upper Maximum (%)");
        upPanel.add(upperlabel);
        comfortPanel.add(upPanel);

        upperField = new JTextField(5);
        upperField.setPreferredSize(new Dimension(80,25));
        upPanel.add(upperField);
        comfortPanel.add(upPanel);

        JPanel lowPanel = new JPanel();
        lowPanel.setLayout(new FlowLayout());

        JLabel lowerlabel = new JLabel("Lower Minimum (%)");
        lowPanel.add(lowerlabel);
        comfortPanel.add(lowPanel);

        lowerField = new JTextField(5);
        lowerField.setPreferredSize(new Dimension(80,25));
        lowPanel.add(lowerField);
        comfortPanel.add(lowPanel);

        JPanel moisturechangePanel = new JPanel();
        moisturechangePanel.setLayout(new FlowLayout());

        JLabel moisturechangelabel = new JLabel("Moisture Change Rate (%/Min)");
        moisturechangePanel.add(moisturechangelabel);

        moisturechangeField = new JTextField(5);
        moisturechangeField.setPreferredSize(new Dimension(80,25));
        moisturechangePanel.add(moisturechangeField);

        JPanel onoffPanel = new JPanel();
        onoffPanel.setLayout(new GridLayout(2,1));

        JPanel sprinPanel = new JPanel();
        sprinPanel.setLayout(new FlowLayout());

        JLabel sprinlabel = new JLabel("Sprinklers: ");
        sprinPanel.add(sprinlabel);

        calcSolution3 = new JLabel();
        sprinPanel.add(calcSolution3);

        onoffPanel.add(sprinPanel);

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new FlowLayout());

        JLabel uplabel = new JLabel("Update Rate (seconds)");
        updatePanel.add(uplabel);

        updateField = new JTextField(5);
        updateField.setPreferredSize(new Dimension(80,25));
        updatePanel.add(updateField);

        currentPanel.add(desiredPanel);

        comfortPanel.add(moisturechangePanel);

        bigPanel.add(currentPanel);

        bigPanel.add(comfortPanel);
        bigPanel.add(onoffPanel);
        bigPanel.add(updatePanel);
        bigBoxPanel.add(bigPanel,"Center");
        bigBoxPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        pane.add(bigBoxPanel);
        frame.setVisible(true);
    }

    /**
     * Method for the window listener, listens for the close button
     * @param listener close button listener
     */
    public void addWindowListener(WindowListener listener) {
        frame.addWindowListener(listener);
    }

    /**
     *Method to get Desired Soil
     * @return 0 or desired soil
     */
    public double getDesiredSoil(){
        if (desiredField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(desiredField.getText());
        }
    }

    /**
     *Method to get Upper Maximum
     * @return 0 or upper maximum
     */
    public double getUpper(){
        if (upperField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(upperField.getText());
        }
    }

    /**
     *Method to get Lower Minimum
     * @return 0 or lower minimum
     */
    public double getLower(){
        if (lowerField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(lowerField.getText());
        }
    }

    /**
     *Method to get moisture change rate
     * @return 0 or moisture change rate
     */
    public double getMoistureChange(){
        if (moisturechangeField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(moisturechangeField.getText());
        }
    }

    /**
     *Method to get Update rate
     * @return 0 or update rate
     */
    public int getUpRate(){
        if (updateField.getText().isEmpty())
            return 0;
        else {
            return Integer.parseInt(updateField.getText());
        }
    }

    /**
     * Method to set the current soil moisture on the label
     * @param result is the current moisture
     */
    public void setCalcSolution(String result) {
        this.calcSolution.setText(result);

    }
    /**
     * Method to set the on and off switch of the Sprinkler on the label
     * @param result is the current status of the Sprinkler
     */
    public void setCalcSolution3(String result) {
        this.calcSolution3.setText(result);
    }


}
