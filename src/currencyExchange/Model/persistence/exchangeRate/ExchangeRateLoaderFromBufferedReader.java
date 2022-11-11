package currencyExchange.Model.persistence.exchangeRate;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class ExchangeRateLoaderFromBufferedReader implements ExchangeRateLoader {

    private final ExchangeRateLoaderBufferReaderFactory bufferReaderFactory;
    private final Collection<Currency> currencies;

    protected ExchangeRateLoaderFromBufferedReader(ExchangeRateLoaderBufferReaderFactory bufferReaderFactory, Collection<Currency> currencies) {
        Objects.requireNonNull(bufferReaderFactory);
        Objects.requireNonNull(currencies);

        this.bufferReaderFactory = bufferReaderFactory;
        this.currencies = currencies;
    }

    @Override
    public Collection<ExchangeRate> load() {
        try {
            return loadAll();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ExchangeRate loadOne(Currency source, Currency target) {
        try {
            return loadExchangeRate(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        String json = getJSONfromBufferedReader(bufferReaderFactory.getExchangeRateReader(source, target));

        float rate = jsonParser(json);

        return new ExchangeRate(source, target, rate);
    }


    private String getJSONfromBufferedReader(BufferedReader bufferedReader) throws IOException {
        char[] buffer = new char[1024];
        int length = bufferedReader.read(buffer);
        return new String(buffer, 0, length);
    }

    private float jsonParser(String JSON) {
        String ourSplit = JSON.split(",")[1];
        ourSplit = ourSplit.substring(ourSplit.indexOf(":") + 1);
        ourSplit = ourSplit.substring(0, ourSplit.indexOf("}")).stripTrailing().stripLeading();

        return Float.parseFloat(ourSplit);
    }
}
