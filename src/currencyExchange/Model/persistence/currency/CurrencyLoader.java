package currencyExchange.Model.persistence.currency;

import currencyExchange.Model.Currency;
import currencyExchange.Model.persistence.Loader;

import java.io.BufferedReader;
import java.util.Objects;

public interface CurrencyLoader extends Loader<Currency> {

    /**
     * @throws NullPointerException if {@code bufferedReader} is {@code null}.
     */
    static CurrencyLoader of(BufferedReader bufferedReader) {
        Objects.requireNonNull(bufferedReader);

        return new CurrencyLoaderFromBufferedReader(bufferedReader);
    }
}
