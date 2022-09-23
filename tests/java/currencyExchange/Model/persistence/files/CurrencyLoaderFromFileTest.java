package currencyExchange.Model.persistence.files;


import currencyExchange.Model.Currency;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyLoaderFromFileTest {

    @Test
    void loadTest() {
        List<Currency> currencyList = new ArrayList<>(loadCurrencies());

        assertEquals(currencyList.remove(0), new Currency("USD", "Dólar USA", "$"));
        assertEquals(currencyList.remove(0), new Currency("CAD", "Dólar Canadá", "$"));
        assertEquals(currencyList.remove(0), new Currency("EUR", "Euro", "€"));
    }

    private List<Currency> loadCurrencies() {
        String path = Paths.get("tests", "resources", "currency.csv").toString();
        return new CurrencyLoaderFromFile(path).load();
    }


}