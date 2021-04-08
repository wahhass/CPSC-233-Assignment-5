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
public class HumiView {

    private JFrame frame;
    private JTextField desiredField, upperField, lowerField, humiditychangeField, updateField;
    private JLabel calcSolution, calcSolution3;

    /**
     * Creates the title name, and sets the size of the calculator
     */
    public HumiView() {
        frame = new JFrame("Humidity of Air GUI");
        frame.setSize(300,450);
    }

    /**
     * Creates all the  UI elements and defines them, including labels, textfields,and creates the GUI.
     */
    public void createHumiGUI() {

        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(1,1));

        JPanel bigBoxPanel = new JPanel();
        bigBoxPanel.setLayout(new BorderLayout());

        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4,1,5,5));

        JPanel currentPanel = new JPanel();
        currentPanel.setLayout(new GridLayout(3,1));

        JLabel currentsoillabel = new JLabel("Current Humidity (%)");
        currentPanel.add(currentsoillabel);

        calcSolution = new JLabel();
        currentPanel.add(calcSolution);

        JPanel desiredPanel = new JPanel();
        desiredPanel.setLayout(new FlowLayout());

        JLabel desiredsoillabel = new JLabel("Desired Humidity (%)");
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

        JPanel humiditychangePanel = new JPanel();
        humiditychangePanel.setLayout(new FlowLayout());

        JLabel humiditychangelabel = new JLabel("Humidity Change Rate (%/Min)");
        humiditychangePanel.add(humiditychangelabel);

        humiditychangeField = new JTextField(5);
        humiditychangeField.setPreferredSize(new Dimension(80,25));
        humiditychangePanel.add(humiditychangeField);

        JPanel onoffPanel = new JPanel();
        onoffPanel.setLayout(new GridLayout(2,1));

        JPanel humidifierPanel = new JPanel();
        humidifierPanel.setLayout(new FlowLayout());

        JLabel humidifierlabel = new JLabel("Humidifier: ");
        humidifierPanel.add(humidifierlabel);

        calcSolution3 = new JLabel();
        humidifierPanel.add(calcSolution3);

        onoffPanel.add(humidifierPanel);

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new FlowLayout());

        JLabel uplabel = new JLabel("Update Rate (seconds)");
        updatePanel.add(uplabel);

        updateField = new JTextField(5);
        updateField.setPreferredSize(new Dimension(80,25));
        updatePanel.add(updateField);

        currentPanel.add(desiredPanel);

        comfortPanel.add(humiditychangePanel);

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
     *Method to get Desired Humidity
     * @return 0 or desired humidity
     */
    public double getDesiredHumi(){
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
     *Method to get humidity change rate
     * @return 0 or humidity change rate
     */
    public double getHumidityChange(){
        if (humiditychangeField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(humiditychangeField.getText());
        }
    }

    /**
     *Method to get the update rate
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
     * Method to set the current humidity on the label
     * @param result is the current humidity
     */
    public void setCalcSolution(String result) {
        this.calcSolution.setText(result);

    }

    /**
     * Method to set the on and off switch of the Humidifier on the label
     * @param result is the current status of the Humidifier
     */
    public void setCalcSolution3(String result) {
        this.calcSolution3.setText(result);
    }
}
