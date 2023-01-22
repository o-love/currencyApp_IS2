package currencyExchange.model;

import java.util.Objects;

public record Money(float amount, Currency currency) {

    /**
     * @throws NullPointerException if {@code currency} is {@code null}.
     */
    public Money {
        Objects.requireNonNull(currency);
    }
}
