package currencyExchange.Util;

import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.Money;

public class CurrencyConversionUtil {

    /**
     * Creates a new {@code Money} that has the same value as
     * @param from The monitary value to be converted to the new currency.
     * @param exchangeRate The {@code Currency} to
     * @return A new {@code Money} with {@code Currency} being {@code ExchangeRate.to()} and with its value being the equivalent
     * of {@code from}'s value in the new {@code Currency}.
     *
     * @throws IllegalArgumentException If {@code ExchangeRate.from() != Money.getCurrency()}
     */
    public static Money convertMoneyWithExchangeRate(Money from, ExchangeRate exchangeRate) {
        if (!from.getCurrency().equals(exchangeRate.from())) {
            throw new IllegalArgumentException("Converting a Money in a currency with different ExchangeRate currency");
        }
        return new Money(exchangeRate.rate() * from.getAmount(), exchangeRate.to());
    }
}
