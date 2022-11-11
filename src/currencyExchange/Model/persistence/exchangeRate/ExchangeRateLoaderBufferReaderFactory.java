package currencyExchange.Model.persistence.exchangeRate;

import currencyExchange.Model.Currency;

import java.io.BufferedReader;
import java.io.IOException;

public interface ExchangeRateLoaderBufferReaderFactory {
    BufferedReader getExchangeRateReader(Currency from, Currency to) throws IOException;

    static ExchangeRateLoaderBufferReaderFactory of(String baseURL) {
        return new ExchangeRateLoaderBufferReaderFactoryFromURL(baseURL);
    }
}
