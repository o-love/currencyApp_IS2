package currencyExchange.model;

import java.util.Objects;

public record Currency(String code, String name, String symbol) {

    /**
     * @param code e.g.: USD, EUR
     * @param name e.g.: 'Dollar', 'Euro'
     * @param symbol e.g.: '$', '€'
     *
     * @throws NullPointerException if {@code code}, {@code name}, or {@code symbol} is {@code null}.
     */
    public Currency {
        Objects.requireNonNull(code);
        Objects.requireNonNull(name);
        Objects.requireNonNull(symbol);
    }
}
