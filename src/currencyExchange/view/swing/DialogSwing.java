package currencyExchange.view.swing;

import currencyExchange.Model.Currency;
import currencyExchange.Model.Money;
import currencyExchange.Model.persistence.web.ExchangeRateLoaderWeb;
import currencyExchange.controller.MoneyCalculatorController;
import currencyExchange.view.Dialog;

import javax.swing.*;
import java.util.List;

public class DialogSwing extends JComponent implements Dialog {

    // Final text labels
    private static final String CALCULATE_BUTTON_LABEL = "calculate";


    //

    private List<Currency> currencyList;
    private DisplaySwing displaySwing;

    private MoneyCalculatorController moneyCalculatorController;

    //

    private JLabel moneyValueLable, currencyFromLabel, currencyToLabel;
    private JTextField moneyValueTextField;
    private JComboBox<Currency> currencyFromComboBox;
    private JComboBox<Currency> currencyTo;
    private JButton calculateButton;


    public DialogSwing(List<Currency> currencyList, DisplaySwing displaySwing, MoneyCalculatorController moneyCalculatorController) {
        this.currencyList = currencyList;
        this.displaySwing = displaySwing;
        this.moneyCalculatorController = moneyCalculatorController;
    }

    private void setupGUI() {

    }

    @Override
    public Money getMoney() {
        return null;
    }

    @Override
    public Currency getCurrencyTo() {
        return null;
    }
}
