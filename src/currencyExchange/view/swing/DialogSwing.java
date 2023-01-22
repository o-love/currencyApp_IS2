package currencyExchange.view.swing;

import currencyExchange.model.Currency;
import currencyExchange.model.Money;
import currencyExchange.controller.MoneyCalculatorController;
import currencyExchange.view.Dialog;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Collection;

public class DialogSwing extends JPanel implements Dialog {

    // Final text labels
    private static final String MONEY_VALUE_LABEL = "Source Value:";
    private static final String CURRENCY_FROM_LABEL = "Source Currency:";
    private static final String CURRENCY_TO_LABEL = "Destination Currency:";
    private static final String CALCULATE_BUTTON_LABEL = "Calculate";

    private static class CurrencyCBIWrapper {
        Currency currency;

        public CurrencyCBIWrapper(Currency currency) {
            this.currency = currency;
        }

        @Override
        public String toString() {
            return this.currency.code();
        }

    }

    //

    private final Collection<Currency> currencyList;

    //

    private JTextField moneyValueTextField;
    private JComboBox<CurrencyCBIWrapper> currencyFromComboBox;
    private JComboBox<CurrencyCBIWrapper> currencyToComboBox;
    private JButton calculateButton;


    public DialogSwing(Collection<Currency> currencyList) {
        this.currencyList = currencyList;

        setupGUI();
    }

    public void setController(MoneyCalculatorController moneyCalculatorController) {
        calculateButton.addActionListener(moneyCalculatorController);
    }

    private void setupGUI() {

        // JLabel setup
        JLabel moneyValueLabel = new JLabel(MONEY_VALUE_LABEL);
        JLabel currencyFromLabel = new JLabel(CURRENCY_FROM_LABEL);
        JLabel currencyToLabel = new JLabel(CURRENCY_TO_LABEL);

        // Money value
        moneyValueTextField = new JFormattedTextField(NumberFormat.getInstance());
        moneyValueTextField.setEditable(true);
        moneyValueTextField.setColumns(20);

        // Currency Combo Box item array
        CurrencyCBIWrapper[] currencyWrappers = currencyList.stream().map(CurrencyCBIWrapper::new).toArray(CurrencyCBIWrapper[]::new);

        // Currency From Combo Box
        currencyFromComboBox = new JComboBox<>(currencyWrappers);

        // Currency To Combo Box
        currencyToComboBox = new JComboBox<>(currencyWrappers);

        // JButton setup
        calculateButton = new JButton(CALCULATE_BUTTON_LABEL);

        // Panel Setup
        setLayout(new BorderLayout());

        //
        JPanel firstRow = new JPanel();
        firstRow.add(moneyValueLabel);
        firstRow.add(moneyValueTextField);
        firstRow.add(currencyFromLabel);
        firstRow.add(currencyFromComboBox);

        JPanel secondRow = new JPanel();
        secondRow.add(currencyToLabel);
        secondRow.add(currencyToComboBox);

        JPanel thirdRow = new JPanel();
        thirdRow.add(calculateButton);

        // Add rows
        this.add(firstRow, BorderLayout.NORTH);
        this.add(secondRow, BorderLayout.CENTER);
        this.add(thirdRow, BorderLayout.SOUTH);


    }

    @Override
    public Money getMoney() {
        float value = Float.parseFloat(moneyValueTextField.getText());
        return new Money(value, ((CurrencyCBIWrapper) currencyFromComboBox.getSelectedItem()).currency);
    }

    @Override
    public Currency getCurrencyTo() {
        return ((CurrencyCBIWrapper) currencyToComboBox.getSelectedItem()).currency;
    }
}
