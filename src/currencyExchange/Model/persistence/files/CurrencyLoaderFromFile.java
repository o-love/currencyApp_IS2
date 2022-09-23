package currencyExchange.Model.persistence.files;

import currencyExchange.Model.Currency;
import currencyExchange.Model.persistence.Loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CurrencyLoaderFromFile implements Loader<Currency> {

    private static final String REGEX_SEPARATOR_FOR_CSV = ",\s?";

    private final String fileName;

    public CurrencyLoaderFromFile(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<Currency> load() {
        try {
            return loadAllCurrenciesFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Currency> loadAllCurrenciesFromFile() throws IOException {
        List<String> fileLines = loadLinesFromFile();

        return fileLines.stream().map(this::createCurrencyFromLine).toList();
    }

    private List<String> loadLinesFromFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        return lines.collect(Collectors.toList());
    }

    private Currency createCurrencyFromLine(String line) {
        String[] splitLine = line.split(REGEX_SEPARATOR_FOR_CSV);

        return new Currency(splitLine[0], splitLine[1], splitLine[2]);
    }
}
