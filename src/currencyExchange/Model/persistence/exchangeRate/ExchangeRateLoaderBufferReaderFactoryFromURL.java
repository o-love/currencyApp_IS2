package currencyExchange.Model.persistence.exchangeRate;

import currencyExchange.Model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

class ExchangeRateLoaderBufferReaderFactoryFromURL implements ExchangeRateLoaderBufferReaderFactory {

    final String baseURL;

    protected ExchangeRateLoaderBufferReaderFactoryFromURL(String baseURL) {
        Objects.requireNonNull(baseURL);

        this.baseURL = baseURL;
    }

    @Override
    public BufferedReader getExchangeRateReader(Currency from, Currency to) throws IOException {
        return new BufferedReader(new InputStreamReader(urlBuilder(from, to).openStream()));
    }

    private URL urlBuilder(Currency source, Currency target) throws MalformedURLException {
        String urlString =  String.format("%s/%s/%s.json", this.baseURL, source.code(), target.code());
        return new URL(urlString);
    }
}
