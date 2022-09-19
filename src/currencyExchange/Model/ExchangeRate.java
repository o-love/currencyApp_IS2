package currencyExchange.Model;

import java.util.Objects;

public record ExchangeRate(Currency from, Currency to, float rate) {

    /**
     * @param from
     * @param to
     * @param rate
     *
     * @throws NullPointerException if {@code from} or {@code to} is {@code null}.
     * @throws IllegalArgumentException if rate is 0.
     */
    public ExchangeRate {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);

        if (rate == 0.0f) {
            throw new IllegalArgumentException("Rate is 0.0 for ExchangeRate");
        }
    }
}
