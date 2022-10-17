package currencyExchange.Model.persistence.web;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.persistence.Loader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExchangeRateLoaderWeb implements Loader<ExchangeRate> {

    private String currency_URL;
    private Collection<Currency> currencies;

    public ExchangeRateLoaderWeb(String url, Collection<Currency> currencies) {
        this.currency_URL = url;
        this.currencies = currencies;
    }

    @Override
    public Collection<ExchangeRate> load() {
        try {
            return loadAll();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ExchangeRate loadOne(Currency source, Currency target) {
        try {
            return loadExchangeRate(source, target);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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

        System.out.println(ourSplit);
        return Float.parseFloat(ourSplit);
    }
}
