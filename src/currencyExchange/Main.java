package currencyExchange;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.persistence.files.CurrencyLoaderFile;
import currencyExchange.Model.persistence.files.ExchangeRateLoaderWeb;

import java.util.List;

public class Main {


    public static final List<Currency> currencies = new CurrencyLoaderFile("currencies.csv").load();
    public static final List<ExchangeRate> exchangeRates = new ExchangeRateLoaderWeb().load();

    public static void main(String[] args) {

        // Load currencies
    }
}