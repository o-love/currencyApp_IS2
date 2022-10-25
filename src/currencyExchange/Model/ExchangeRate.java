package currencyExchange.Model;

import java.util.Objects;

public record ExchangeRate(Currency from, Currency to, float rate) {

    /**
     * @param from Source {@code Currency}
     * @param to Result {@code Currency}.
     * @param rate Value of a unit of {@code from} to {@code to}.
     *
     * @throws NullPointerException if {@code from} or {@code to} is {@code null}.
     * @throws IllegalArgumentException if {@code rate} is 0.
     */
    public ExchangeRate {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);

        if (rate == 0.0f) {
            throw new IllegalArgumentException("Rate is 0.0 for ExchangeRate");
        }
    }

    /**
     * Creates a new {@code Money} that has the same value as
     * @param from The monitary value to be converted to the new currency.
     * @return A new {@code Money} with {@code Currency} being {@code ExchangeRate.to()} and with its value being the equivalent
     * of {@code from}'s value in the new {@code Currency}.
     *
     * @throws IllegalArgumentException If {@code ExchangeRate.from() != Money.getCurrency()}
     */
    public Money convertMoney(Money from) {
        if (!from.currency().equals(this.from())) {
            throw new IllegalArgumentException("Converting a Money in a currency with different ExchangeRate currency");
        }
        return new Money(this.rate() * from.amount(), this.to());
    }
}
