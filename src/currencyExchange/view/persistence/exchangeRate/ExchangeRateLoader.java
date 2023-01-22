package currencyExchange.view.persistence.exchangeRate;

import currencyExchange.model.Currency;
import currencyExchange.model.ExchangeRate;
import currencyExchange.view.persistence.Loader;

import java.util.Collection;

public interface ExchangeRateLoader extends Loader<ExchangeRate> {
    ExchangeRate loadOne(Currency source, Currency target);

    static ExchangeRateLoader createJSON(ExchangeRateLoaderBufferReaderFactory bufferReaderFactory, Collection<Currency> currencies) {
        return new ExchangeRateLoaderFromBufferedReader(bufferReaderFactory, currencies);
    }
}
