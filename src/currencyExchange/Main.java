package currencyExchange;

import currencyExchange.Model.Currency;
import currencyExchange.Model.persistence.files.CurrencyLoaderFile;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Currency> currencies = new CurrencyLoaderFile().loadCurrencies();
    }
}