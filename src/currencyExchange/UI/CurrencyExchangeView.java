package currencyExchange.UI;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;

import javax.swing.*;
import java.util.List;

public class CurrencyExchangeView extends JComponent {

    // Input line
    JLabel inputLabel;
    JTextField inputValueTextField;
    JComboBox<Currency> inputCurrencyJComboBox;

    // To line
    JLabel toLabel;
    JComboBox<Currency> outputCurrencyJComboBox;

    // Result line
    JLabel resultLabel;
    JTextField outputTextField;
    JButton calculateButton;


    public CurrencyExchangeView(List<Currency> currencyList, List<ExchangeRate> exchangeRatesList) {
        super();

        createGUI();
    }


    private void createGUI() {

        // input line
        this.inputLabel = new JLabel("Input: ");

        this.inputValueTextField = new JTextField();
        // TODO: only allow float type value, either while inputting or as check when done or when pushing calculating button

        this.inputCurrencyJComboBox = new JComboBox<>();


        // To line


        // Output line

    }
}
