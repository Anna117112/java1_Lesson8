package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JLabel display;
    private Double leftOperand;
    private Double rightOperand;
    private String operation;



    public static void main(String[] args) {
        new Calculator();
    }


    public Calculator(){
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(new BorderLayout());

        ActionListener numberActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JButton source = (JButton) e. getSource();
                 String text =  source.getText();
                String displayText = display.getText();

                if ("+/-".equals(text)) {
                    displayText = "-";
                    text = "";
                }
                if ("0".equals(displayText)) {
                    displayText = "";
                }
                if ("".equals(displayText) &&".".equals(text)){
                    displayText = "0";
                }

                if (".".equals(text) && displayText.contains(".")){
                    return;

                }
                displayText +=text;
                display.setText(displayText);


            }
        };

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JButton source = (JButton) e.getSource();
                final String text =  source.getText();
                if ("=".equals(text)){
                    rightOperand = Double.parseDouble(display.getText());
                    if (leftOperand!=null){
                        switch (operation){
                            case "+":
                                display.setText( String.valueOf  (leftOperand+rightOperand));
                                break;
                            case "-":
                                display.setText( String.valueOf  (leftOperand-rightOperand));
                                break;
                            case "*":
                                display.setText( String.valueOf  (leftOperand*rightOperand));
                                break;
                            case "/":
                                display.setText( String.valueOf  (leftOperand/rightOperand));
                                break;


                        }
                        leftOperand = Double.parseDouble(display.getText());
                        rightOperand = null;
                        operation = null;
                    }
                    return;


                }
                leftOperand = Double.parseDouble(display.getText());
                display.setText("0");
                operation = text;

                if ("С".equals(text)) {


                    display.setText("0");
                }



            }
        };





                final JPanel numberPanel = new JPanel();
        final GridLayout numberLayout = new GridLayout(4,3,10,10);
        numberPanel.setLayout(numberLayout);

        for (int i = 0; i < 10; i++) {

            final  JButton button = new JButton(String.valueOf(i));
            button.addActionListener(numberActionListener);
            numberPanel.add(button);
        }
        final JButton pointButton = new JButton(".");
        numberPanel.add(pointButton);
        pointButton.addActionListener(numberActionListener);
        final JButton pointButton1 = new JButton("+/-");
        numberPanel.add(pointButton1);
        pointButton1.addActionListener(numberActionListener);


        JPanel buttonPanel = new JPanel();
        final GridLayout buttonLayout = new GridLayout(2,3,10,10);
        buttonPanel.setLayout(buttonLayout);
        for (char c : "C+-*/=".toCharArray()){
           final JButton button = new JButton(String.valueOf(c));
           button.addActionListener(actionListener);
            buttonPanel.add(button);
        }



        display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD,17 ));
        add(display, BorderLayout.NORTH);
        add(numberPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);




        setVisible(true);

    }



}
