package currencyExchange.Model;

import java.util.Objects;

public record Currency(String name, String code, String symbol) {

    /**
     * @param name
     * @param code
     * @param symbol
     *
     * @throws NullPointerException if currency code is {@code null}.
     */
    public Currency {
        Objects.requireNonNull(code);
    }
}
