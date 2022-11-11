package currencyExchange;

import currencyExchange.Model.Currency;
import currencyExchange.Model.Money;
import currencyExchange.Model.persistence.currency.CurrencyLoader;
import currencyExchange.Model.persistence.exchangeRate.ExchangeRateLoader;

import currencyExchange.Model.persistence.exchangeRate.ExchangeRateLoaderBufferReaderFactory;
import currencyExchange.controller.MoneyCalculatorController;
import currencyExchange.view.swing.CombinedViewSwing;
import currencyExchange.view.swing.DialogSwing;
import currencyExchange.view.swing.DisplaySwing;
import currencyExchange.view.swing.GUISwing;

import javax.swing.*;
import java.io.*;
import java.util.Collection;

public class Main {

    private static final String URL_FOR_CURRENCY_EXCHANGE_RATES = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/";

    public static void main(String[] args) {

        // Load currencies
        Collection<Currency> currencies = loadCurrencies();
        ExchangeRateLoader exchangeRateLoader = loadExchangeRateLoader(currencies);

        SwingUtilities.invokeLater(() -> {
            // Model for GUI
            Money money = new Money(23.f, currencies.iterator().next());

            // GUI
            DisplaySwing display = new DisplaySwing(money);

            DialogSwing dialog = new DialogSwing(currencies);

            // Controller
            MoneyCalculatorController moneyCalculatorController = new MoneyCalculatorController(display, dialog, exchangeRateLoader);
            dialog.setController(moneyCalculatorController);

            // Combined view
            new GUISwing(new CombinedViewSwing(dialog, display), "Currency Exchanger");
        });

    }

    private static Collection<Currency> loadCurrencies() {
        try {
            return CurrencyLoader.of(new BufferedReader(new FileReader("currency.csv"))).load();
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    private static ExchangeRateLoader loadExchangeRateLoader(Collection<Currency> currencies) {
        return ExchangeRateLoader.build(
                ExchangeRateLoaderBufferReaderFactory.of(URL_FOR_CURRENCY_EXCHANGE_RATES),
                currencies
        );
    }
}