package currencyExchange.Model;

import java.util.Objects;

public record Currency(String code, String name, String symbol) {

    /**
     * @param code
     * @param name
     * @param symbol
     *
     * @throws NullPointerException if currency code is {@code null}.
     */
    public Currency {
        Objects.requireNonNull(code);
    }
}
