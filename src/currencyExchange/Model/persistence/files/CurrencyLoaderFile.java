package currencyExchange.Model.persistence.files;

import currencyExchange.Model.Currency;
import currencyExchange.Model.persistence.CurrencyLoader;

import java.util.List;

public class CurrencyLoaderFile implements CurrencyLoader {
    private final String fileName;

    public CurrencyLoaderFile() {
        this.fileName = "currencies";
    }


    @Override
    public List<Currency> loadCurrencies() {
        return null;
    }
}
