package currencyExchange.Model.persistence.web;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.persistence.ExchangeRateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ExchangeRateLoaderWeb implements ExchangeRateLoader {

    private final String currency_URL;
    private final Collection<Currency> currencies;

    /**
     *
     * @param url String which specifies the URL from which to load the exchange rates.
     * @param currencies Collection with the currencies to load the {@code ExchangeRate} for.
     *
     * @throws NullPointerException if {@code url} or {@code currencies} is {@code null}.
     */
    public ExchangeRateLoaderWeb(String url, Collection<Currency> currencies) {
        Objects.requireNonNull(url);
        Objects.requireNonNull(currencies);

        this.currency_URL = url;
        this.currencies = currencies;
    }

    @Override
    public Collection<ExchangeRate> load() {
        try {
            return loadAll();
        }
        catch (IOException e) {
            throw new RuntimeException("Unable to load from "+currency_URL, e);
        }
    }

    @Override
    public ExchangeRate loadOne(Currency source, Currency target) {
        try {
            return loadExchangeRate(source, target);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load from "+currency_URL, e);
        }
    }

    private Collection<ExchangeRate> loadAll() throws IOException {
        Set<ExchangeRate> exchangeRateSet = new HashSet<>();

        for (Currency sourceCurrency : currencies) {
            for (Currency objectiveCurrency : currencies) {
                if (!sourceCurrency.equals(objectiveCurrency)) {
                    ExchangeRate exchangeRate = loadExchangeRate(sourceCurrency, objectiveCurrency);
                    exchangeRateSet.add(exchangeRate);
                }
            }
        }

        return exchangeRateSet;
    }

    private ExchangeRate loadExchangeRate(Currency source, Currency target) throws IOException {
        URL url = urlBuilder(source, target);

        String json = getJSONfromURL(url);

        float rate = jsonParser(json);

        return new ExchangeRate(source, target, rate);
    }

    private URL urlBuilder(Currency source, Currency target) throws MalformedURLException {
        String urlString =  String.format("%s/%s/%s.json", this.currency_URL, source.code(), target.code());
        return new URL(urlString);
    }

    private String getJSONfromURL(URL url) throws IOException {
        InputStream inputStream = url.openStream();
        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);
        return new String(buffer, 0, length);
    }

    private float jsonParser(String JSON) {
        String ourSplit = JSON.split(",")[1];
        ourSplit = ourSplit.substring(ourSplit.indexOf(":") + 1);
        ourSplit = ourSplit.substring(0, ourSplit.indexOf("}")).stripTrailing().stripLeading();

        return Float.parseFloat(ourSplit);
    }
}
