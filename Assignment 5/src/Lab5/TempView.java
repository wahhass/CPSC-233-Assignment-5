package Lab5;

/**
 * Created by Wahaj Hassan ID: 10136892 on 2016-04-05.
 * TA: Sydney
 * Prof: Leonard C Manzara
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class to view all the labels, buttons, texfields on the GUI.
 */
public class TempView {

    private JFrame frame;
    private JTextField desiredField, upperField, lowerField, coolingField, heatingField, updateField;
    private JLabel calcSolution, calcSolution2, calcSolution3;

    /**
     * Creates the title name, and sets the size of the calculator
     */
    public TempView() {
        frame = new JFrame("Temperature GUI");
        frame.setSize(300,450);
    }

    /**
     * Creates all the  UI elements and defines them, including labels, textfields,and creates the GUI.
     */
    public void createTempGUI() {

        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(1,1));

        JPanel bigBoxPanel = new JPanel();
        bigBoxPanel.setLayout(new BorderLayout());

        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4,1));

        JPanel currentPanel = new JPanel();
        currentPanel.setLayout(new GridLayout(3,1));

        JLabel currentTemplabel = new JLabel("Current Temperature (°C)");
        currentPanel.add(currentTemplabel);

        calcSolution = new JLabel();
        currentPanel.add(calcSolution);

        JPanel desiredPanel = new JPanel();
        desiredPanel.setLayout(new FlowLayout());

        JLabel desiredTemplabel = new JLabel("Desired Temperature (°C)");
        desiredPanel.add(desiredTemplabel);

        desiredField = new JTextField(5);
        desiredField.setPreferredSize(new Dimension(80,25));
        desiredPanel.add(desiredField);

        currentPanel.add(desiredPanel);

        JPanel comfortPanel = new JPanel();
        comfortPanel.setLayout(new GridLayout(2,1));

        JPanel upPanel = new JPanel();
        upPanel.setLayout(new FlowLayout());

        JLabel upperlabel = new JLabel("Upper Maximum (°C)");
        upPanel.add(upperlabel);
        comfortPanel.add(upPanel);

        upperField = new JTextField(5);
        upperField.setPreferredSize(new Dimension(80,25));
        upPanel.add(upperField);
        comfortPanel.add(upPanel);

        JPanel lowPanel = new JPanel();
        lowPanel.setLayout(new FlowLayout());

        JLabel lowerlabel = new JLabel("Lower Minimum (°C)");
        lowPanel.add(lowerlabel);
        comfortPanel.add(lowPanel);

        lowerField = new JTextField(5);
        lowerField.setPreferredSize(new Dimension(80,25));
        lowPanel.add(lowerField);
        comfortPanel.add(lowPanel);

        JPanel coolingPanel = new JPanel();
        coolingPanel.setLayout(new FlowLayout());

        JLabel coolinglabel = new JLabel("Cooling Rate (°C/Min)");
        coolingPanel.add(coolinglabel);

        coolingField = new JTextField(5);
        coolingField.setPreferredSize(new Dimension(80,25));
        coolingPanel.add(coolingField);

        JPanel heatingPanel = new JPanel();
        heatingPanel.setLayout(new FlowLayout());

        JLabel heatinglabel = new JLabel("Heating Rate (°C/Min)");
        heatingPanel.add(heatinglabel);

        heatingField = new JTextField(5);
        heatingField.setPreferredSize(new Dimension(80,25));
        heatingPanel.add(heatingField);

        JPanel onoffPanel = new JPanel();
        onoffPanel.setLayout(new GridLayout(1,1));

        JPanel acPanel = new JPanel();
        acPanel.setLayout(new FlowLayout());

        JLabel aclabel = new JLabel("Air Conditioner: ");
        acPanel.add(aclabel);

        calcSolution2 = new JLabel();
        acPanel.add(calcSolution2);

        JPanel furPanel = new JPanel();
        furPanel.setLayout(new FlowLayout());

        JLabel furlabel = new JLabel("Furnace: ");
        furPanel.add(furlabel);

        calcSolution3 = new JLabel();
        furPanel.add(calcSolution3);

        onoffPanel.add(acPanel);
        onoffPanel.add(furPanel);

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new FlowLayout());

        JLabel uplabel = new JLabel("Update Rate (seconds)");
        updatePanel.add(uplabel);

        updateField = new JTextField(5);
        updateField.setPreferredSize(new Dimension(80,25));
        updatePanel.add(updateField);



        comfortPanel.add(coolingPanel);
        comfortPanel.add(heatingPanel);

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
     *Method to get Desired Temperature
     * @return 0 or desired temp
     */
    public double getDesiredTemp(){
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
     *Method to get the cooling rate
     * @return 0 or cooling rate
     */
    public double getCooling(){
        if (coolingField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(coolingField.getText());
        }
    }

    /**
     *Method to get the heating rate
     * @return 0 or heating rate
     */
    public double getHeating(){
        if (heatingField.getText().isEmpty())
            return 0;
        else {
            return Double.parseDouble(heatingField.getText());
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
     * Method to set the current temperature on the label
     * @param result is the current temperature
     */
    public void setCalcSolution(String result) {
        this.calcSolution.setText(result);
    }

    /**
     * Method to set the on and off switch of the Air conditioner on the label
     * @param result is the current status of the AC
     */
    public void setCalcSolution2(String result) {
        this.calcSolution2.setText(result);
    }

    /**
     * Method to set the on and off switch of the Furnace on the label
     * @param result is the current status of the Furnace
     */
    public void setCalcSolution3(String result) {
        this.calcSolution3.setText(result);
    }


}