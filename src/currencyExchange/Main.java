package currencyExchange;

import currencyExchange.Model.Currency;
import currencyExchange.Model.Money;
import currencyExchange.Model.persistence.ExchangeRateLoader;
import currencyExchange.Model.persistence.files.CurrencyLoaderFromFile;
import currencyExchange.Model.persistence.web.ExchangeRateLoaderWeb;
import currencyExchange.controller.MoneyCalculatorController;
import currencyExchange.view.swing.CombinedViewSwing;
import currencyExchange.view.swing.DialogSwing;
import currencyExchange.view.swing.DisplaySwing;
import currencyExchange.view.swing.GUISwing;

import javax.swing.*;
import java.util.Collection;

public class Main {

    private static final String URL_FOR_CURRENCY_EXCHANGE_RATES = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/";

    public static void main(String[] args) {

        // Load currencies
        Collection<Currency> currencies = new CurrencyLoaderFromFile("currency.csv").load();

        ExchangeRateLoader exchangeRateLoader = new ExchangeRateLoaderWeb(URL_FOR_CURRENCY_EXCHANGE_RATES, currencies);

        SwingUtilities.invokeLater(() -> {
            // Model for GUI
            Money money = new Money(23.f, currencies.iterator().next());

            // GUI
            DisplaySwing display = new DisplaySwing(money);

            DialogSwing dialog = new DialogSwing(currencies);

            // Controller
            MoneyCalculatorController moneyCalculatorController = new MoneyCalculatorController(display, dialog, exchangeRateLoader);
            dialog.setController(moneyCalculatorController);

            new GUISwing(display, "Display");
            new GUISwing(dialog, "Dialog");

            // Combined view
            new GUISwing(new CombinedViewSwing(dialog, display), "Combined");
        });

    }
}