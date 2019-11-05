package main.test.ru.miet.testing;

import main.java.ru.miet.testing.GUI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import static org.junit.jupiter.api.Assertions.assertEquals;
class MainMock extends GUI {
    public MainMock() {super();}
    public String error;

    public void displayError(String message) {
        error = message;
    }
}

public class UITester {
    private static MainMock app;
    private static Robot robot;
    private static double a,b;
    private final String[] errors = {"Wrong number inputed", "Input a number", "You can't divide by zero"};
    @BeforeAll
    public static void init() {
        //new Thread(() -> {
            app = new MainMock();
            app.setVisible(true);
            app.setSize(500,200);
        //}).start();
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        a = Math.random();
        b = Math.random();
    }
    public void click(JButton button, int dx, int dy) throws InterruptedException {
        Point p = button.getLocation();
        robot.mouseMove(-1000,-1000);
        robot.mouseMove(p.x-dx,p.y-dy);
        //Thread.sleep(10);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //Thread.sleep(10);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
    }
    private void setA(double a) throws InterruptedException {
        app.first_argument.setText(Double.toString(a));
        Thread.sleep(20);
    }
    private void setB(double b) throws InterruptedException {
        app.second_argument.setText(Double.toString(b));
        Thread.sleep(20);
    }
    @Test
    public void test_button_sum() throws InterruptedException {
        //init();
        Thread.sleep(1500);
        setA(a);
        setB(b);
        //click(app.button_sum, 10, 10);
        app.button_sum.doClick();
        assertEquals(app.Summary.getText(),Double.toString(a + b));
        Thread.sleep(1000);
    }
    @Test
    public void test_button_minus() throws InterruptedException {
        //init();
        setA(a);
        setB(b);
        //click(app.button_minus,20, 20);
        app.button_minus.doClick();
        assertEquals(app.Summary.getText(),Double.toString(a - b));
        Thread.sleep(1000);
    }
    @Test
    public void test_Mult() throws InterruptedException {
        //init();
        setA(a);
        setB(b);
        //click(app.button_multiply, 50, 50);
        app.button_multiply.doClick();
        assertEquals(app.Summary.getText(),Double.toString(a * b));
        Thread.sleep(1000);
    }
    @Test
    public void testDiv() throws InterruptedException {
        //init();
        setA(a);
        setB(b+10e-8);
        //click(app.button_divide, 50,100);
        app.button_divide.doClick();
        assertEquals(app.Summary.getText(),Double.toString(a / (b+10e-8)));
        Thread.sleep(1000);
    }
    @Test
    public void testNullbutton_sumA() throws InterruptedException {
        //init();
        app.first_argument.setText(null);
        Thread.sleep(1000);
        setB(b);
        //click(app.button_sum, 10, 10);
        app.button_sum.doClick();
        assertEquals(errors[0],app.error,errors[0]);
    }
    @Test
    public void testNupbutton_minusA() throws InterruptedException {
        //init();
        app.first_argument.setText(null);
        Thread.sleep(1000);
        setB(b);
        //click(app.button_minus, 20, 20);
        app.button_minus.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNullMultA() throws InterruptedException {
        //init();
        app.first_argument.setText(null);
        Thread.sleep(1000);
        setB(b);
        //click(app.button_multiply, 50, 50);
        app.button_multiply.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNullDivA() throws InterruptedException {
        //init();
        app.first_argument.setText(null);
        Thread.sleep(1000);
        setB(b);
        //click(app.button_divide, 50, 100);
        app.button_divide.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNullbutton_sumB() throws InterruptedException {
        //init();
        app.second_argument.setText(null);
        Thread.sleep(1000);
        setA(b);
        //click(app.button_sum, 10, 10);
        app.button_sum.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNSMinusiB() throws InterruptedException {
        //init();
        app.second_argument.setText(null);
        Thread.sleep(1000);
        setA(b);
        //click(app.button_minus, 20, 20);
        app.button_minus.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNullMultB() throws InterruptedException {
        //init();
        app.second_argument.setText(null);
        Thread.sleep(1000);
        setA(b);
        //click(app.button_multiply, 50, 50);
        app.button_multiply.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNullDivB() throws InterruptedException {
        //init();
        app.second_argument.setText(null);
        Thread.sleep(1000);
        setA(b);
        //click(app.button_divide, 50, 100);
        app.button_divide.doClick();
        assertEquals(errors[0],app.error);
    }

    @Test
    public void testNSbutton_sumA() throws InterruptedException {
        app.first_argument.setText("Random");
        Thread.sleep(1000);
        setB(b);
        //click(app.button_sum, 10, 10);
        app.button_sum.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testpbutton_minusA() throws InterruptedException {
        app.first_argument.setText("Random");
        Thread.sleep(1000);
        setB(b);
        //click(app.button_minus, 20, 20);
        app.button_minus.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNSMultA() throws InterruptedException {
        //init();
        app.first_argument.setText("Random");
        Thread.sleep(1000);
        setB(b);
        //click(app.button_multiply, 50, 50);
        app.button_multiply.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNSDivA() throws InterruptedException {
        //init();
        app.first_argument.setText("Random");
        Thread.sleep(1000);
        setB(b);
        //click(app.button_divide, 50, 100);
        app.button_divide.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNSbutton_sumB() throws InterruptedException {
        //init();
        app.second_argument.setText("Random");
        Thread.sleep(1000);
        setA(b);
        //click(app.button_sum, 10, 10);
        app.button_sum.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNSMinusB() throws InterruptedException {
        //init();
        app.second_argument.setText("Random");
        Thread.sleep(1000);
        setA(b);
        //click(app.button_minus, 20, 20);
        app.button_minus.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNSMultB() throws InterruptedException {
        //init();
        app.second_argument.setText("Random");
        Thread.sleep(1000);
        setA(b);
        //click(app.button_multiply, 50, 50);
        app.button_multiply.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testNSDivB() throws InterruptedException {
        //init();
        app.second_argument.setText("Random");
        Thread.sleep(1000);
        setA(b);
        //click(app.button_divide, 50, 100);
        app.button_divide.doClick();
        assertEquals(errors[0],app.error);
    }
    @Test
    public void testDivByZero() throws  InterruptedException {
        //init();
        app.second_argument.setText("0");
        Thread.sleep(1000);
        setA(a);
        //click(app.button_divide,50,100);
        app.button_divide.doClick();
        assertEquals(errors[2],app.error);
    }
}
