package currencyExchange.model.persistence.files;


import currencyExchange.model.Currency;
import currencyExchange.view.persistence.currency.CurrencyLoader;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyLoaderFromBufferedReaderTest {

    @Test
    void loadTest() {
        List<Currency> currencyList = new ArrayList<>(loadCurrencies());

        assertEquals(currencyList.remove(0), new Currency("USD", "Dólar USA", "$"));
        assertEquals(currencyList.remove(0), new Currency("CAD", "Dólar Canadá", "$"));
        assertEquals(currencyList.remove(0), new Currency("EUR", "Euro", "€"));
    }

    private Collection<Currency> loadCurrencies() {
        String path = Paths.get("tests", "resources", "currency.csv").toString();
        try {
            return CurrencyLoader.create(new BufferedReader(new FileReader(path))).load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}