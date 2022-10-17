package currencyExchange;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.Money;
import currencyExchange.Model.persistence.files.CurrencyLoaderFromFile;
import currencyExchange.Model.persistence.web.ExchangeRateLoaderWeb;
import currencyExchange.view.swing.DisplaySwing;
import currencyExchange.view.swing.GUISwing;

import javax.swing.*;
import java.util.Collection;

public class Main {

    private static final String URL_FOR_CURRENCY_EXCHANGE_RATES = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/";

    public static void main(String[] args) {

        // Load currencies
        Collection<Currency> currencies = new CurrencyLoaderFromFile("currency.csv").load();

        // Load ExchangeRates
        Collection<ExchangeRate> exchangeRates = new ExchangeRateLoaderWeb(URL_FOR_CURRENCY_EXCHANGE_RATES, currencies).load();

        exchangeRates.forEach(System.out::println);

        SwingUtilities.invokeLater(() -> {
            Money money = new Money(23.f, currencies.iterator().next());



            new GUISwing(new DisplaySwing(money), "Display");
        });

    }
}