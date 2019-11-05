package main.java.ru.miet.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JDialog implements CalculatorView {

    private CalcPres calcPres = new CalcPres(this);
    public JPanel contentPane;
    public JButton button_divide;
    public JButton button_multiply;
    public JButton button_minus;
    public JButton button_sum;
    public JTextField first_argument;
    public JTextField second_argument;
    public JTextField Summary;

    //public CalculatorPresenter calcPres;
    public GUI() {
        setContentPane(contentPane);
        //setModal(true);
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        button_sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calcPres.onPlusClicked();
            }
        });
        button_minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calcPres.onMinusClicked();
            }
        });
        button_multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calcPres.onMultiplyClicked();
            }
        });
        button_divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calcPres.onDivideClicked();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    @Override
    public void printResult(double result) {
        Summary.setText(Double.toString(result));
    }

    @Override
    public void displayError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public String getFirstArgumentAsString() {
        return first_argument.getText();
    }

    @Override
    public String getSecondArgumentAsString() {
        return second_argument.getText();
    }

    public static void main(String[] args) {
        GUI dialog = new GUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
