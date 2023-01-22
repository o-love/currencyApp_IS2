package currencyExchange.view.persistence.currency;

import currencyExchange.model.Currency;
import currencyExchange.view.persistence.Loader;

import java.io.BufferedReader;
import java.util.Objects;

public interface CurrencyLoader extends Loader<Currency> {

    /**
     * @throws NullPointerException if {@code bufferedReader} is {@code null}.
     */
    static CurrencyLoader create(BufferedReader bufferedReader) {
        Objects.requireNonNull(bufferedReader);

        return new CurrencyLoaderFromBufferedReader(bufferedReader);
    }
}
