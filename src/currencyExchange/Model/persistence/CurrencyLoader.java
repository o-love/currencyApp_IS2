package currencyExchange.Model.persistence;

import currencyExchange.Model.Currency;

import java.util.List;

public interface CurrencyLoader {

    public List<Currency> loadCurrencies();
}
