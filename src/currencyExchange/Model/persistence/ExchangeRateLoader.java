package currencyExchange.Model.persistence;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;

public interface ExchangeRateLoader extends Loader<ExchangeRate> {
    ExchangeRate loadOne(Currency source, Currency target);
}
