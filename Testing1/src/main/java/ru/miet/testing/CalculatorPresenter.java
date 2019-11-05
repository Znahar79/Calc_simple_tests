package main.java.ru.miet.testing;


public interface CalculatorPresenter {
    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '+'
     */
    void onPlusClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '-'
     */
    void onMinusClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '/'
     */
    void onDivideClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '*'
     */
    void onMultiplyClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '1-9; ,'
     */
    void on0Clicked();
    void on1Clicked();
    void on2Clicked();
    void on3Clicked();
    void on4Clicked();
    void on5Clicked();
    void on6Clicked();
    void on7Clicked();
    void on8licked();
    void on9Clicked();
    void onCommaClicked();





}
