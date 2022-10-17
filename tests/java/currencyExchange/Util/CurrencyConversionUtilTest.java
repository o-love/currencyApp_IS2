package currencyExchange.Util;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConversionUtilTest {

    @Test
    void testCorrectValue() {
        Currency currency1 = new Currency("USD", "dollar", "$");
        Currency currency2 = new Currency("EUR", "euro", "€");

        ExchangeRate exchangeRate = new ExchangeRate(currency1, currency2, 2);

        Money money1 = new Money(10.f, currency1);

        Money result = CurrencyConversionUtil.convertMoneyWithExchangeRate(money1, exchangeRate);

        assertEquals(result.getAmount(), 20.f);
    }

    @Test
    void testCorrectCurrency() {
        Currency currency1 = new Currency("USD", "dollar", "$");
        Currency currency2 = new Currency("EUR", "euro", "€");

        ExchangeRate exchangeRate = new ExchangeRate(currency1, currency2, 2);

        Money money1 = new Money(10.f, currency1);

        Money result = CurrencyConversionUtil.convertMoneyWithExchangeRate(money1, exchangeRate);

        assertEquals(result.getCurrency(), currency2);
    }
}