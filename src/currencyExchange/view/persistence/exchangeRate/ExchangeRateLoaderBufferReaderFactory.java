package currencyExchange.view.persistence.exchangeRate;

import currencyExchange.model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

public interface ExchangeRateLoaderBufferReaderFactory {
    BufferedReader getExchangeRateReader(Currency from, Currency to) throws IOException;

    static ExchangeRateLoaderBufferReaderFactory create(URL baseURL) {
        return new ExchangeRateLoaderBufferReaderFactoryFromURL(baseURL.toString());
    }
}
