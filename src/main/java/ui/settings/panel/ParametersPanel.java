package ui.settings.panel;

import javax.swing.*;

public class ParametersPanel extends SettingPanel {
    private JTextField textFieldMaxIterations;
    private JTextField textFieldEscapeRadius;


    //constants
    private final int DEFAULT_MAX_ITERATIONS = 25;
    private final double DEFAULT_ESCAPE_RADIUS = 2;

    public ParametersPanel(){
        super();
        setSize(450,600);


        //Max iterations
        textFieldMaxIterations = new JTextField();
        JLabel currentMaxIterations = new JLabel("Max Iterations:");
        textFieldMaxIterations.setBounds(110,0,50,30);
        currentMaxIterations.setBounds(10,0,100,30);



        //Escape radius
        textFieldEscapeRadius = new JTextField();
        JLabel currentEscapeRadius = new JLabel("Escape Radius:");
        textFieldEscapeRadius.setBounds(110,70,50,30);
        currentEscapeRadius.setBounds(10,70,100,30);

        add(textFieldEscapeRadius);
        add(textFieldMaxIterations);
        add(currentMaxIterations);
        add(currentEscapeRadius);
    }

    public int getMaxIterations() {
        String text = textFieldMaxIterations.getText().trim();
        if(text.isEmpty()){
            return DEFAULT_MAX_ITERATIONS;
        }
        boolean isNumeric;
        try {
            Integer.parseInt(text);
            isNumeric = true;
        } catch (NumberFormatException e) {
            isNumeric = false;
            return DEFAULT_MAX_ITERATIONS;
        }
        return Integer.parseInt(text);
    }

    public double getEscapeRadius() {
        String text = textFieldEscapeRadius.getText().trim();
        if (text.isEmpty()) {
            return DEFAULT_ESCAPE_RADIUS; // Use the default value if the text field is empty
        }
        try {
            return Double.parseDouble(text); // Parse directly as double
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return DEFAULT_ESCAPE_RADIUS;
        }
    }

    public void setTextFieldMaxIterations(int maxIterations){
        textFieldMaxIterations.setText(Integer.toString(maxIterations));
    }

    public void setTextFieldEscapeRadius(double escapeRadius){
        textFieldEscapeRadius.setText(Double.toString(escapeRadius));
    }

}