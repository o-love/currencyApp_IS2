package currencyExchange.Model.persistence.files;

import currencyExchange.Model.Currency;
import currencyExchange.Model.persistence.Loader;

import java.util.List;

public class CurrencyLoaderFile implements Loader<Currency> {
    private final String fileName;

    public CurrencyLoaderFile(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<Currency> load() {
        return null;
    }
}
