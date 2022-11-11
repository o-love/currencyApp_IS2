package currencyExchange.Model.persistence.exchangeRate;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.persistence.Loader;

import java.util.Collection;

public interface ExchangeRateLoader extends Loader<ExchangeRate> {
    ExchangeRate loadOne(Currency source, Currency target);

    static ExchangeRateLoader build(ExchangeRateLoaderBufferReaderFactory bufferReaderFactory, Collection<Currency> currencies) {
        return new ExchangeRateLoaderFromBufferedReader(bufferReaderFactory, currencies);
    }
}
