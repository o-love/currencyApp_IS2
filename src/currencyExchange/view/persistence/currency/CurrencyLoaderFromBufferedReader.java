package currencyExchange.view.persistence.currency;

import currencyExchange.model.Currency;

import java.io.BufferedReader;
import java.util.List;
import java.util.Objects;

class CurrencyLoaderFromBufferedReader implements CurrencyLoader {

    private static final String REGEX_SEPARATOR_FOR_CSV = ",\s?";

    private final BufferedReader bufferedReader;

    protected CurrencyLoaderFromBufferedReader(BufferedReader bufferedReader) {
        Objects.requireNonNull(bufferedReader);

        this.bufferedReader = bufferedReader;
    }


    @Override
    public List<Currency> load() {
        return loadLinesFromFile()
                .stream().map(this::createCurrencyFromLine)
                .toList();
    }

    private List<String> loadLinesFromFile() {
        return bufferedReader.lines().toList();
    }

    private Currency createCurrencyFromLine(String line) {
        String[] splitLine = line.split(REGEX_SEPARATOR_FOR_CSV);

        return new Currency(splitLine[0], splitLine[1], splitLine[2]);
    }
}
