package currencyExchange.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeRateTest {

    @Test
    void testConvertCorrectValueExchange() {
        Currency currency1 = new Currency("USD", "dollar", "$");
        Currency currency2 = new Currency("EUR", "euro", "€");

        ExchangeRate exchangeRate = new ExchangeRate(currency1, currency2, 2);

        Money money1 = new Money(10.f, currency1);

        Money result = exchangeRate.convertMoney(money1);

        assertEquals(result.amount(), 20.f);
    }

    @Test
    void testConvertCorrectCurrency() {
        Currency currency1 = new Currency("USD", "dollar", "$");
        Currency currency2 = new Currency("EUR", "euro", "€");

        ExchangeRate exchangeRate = new ExchangeRate(currency1, currency2, 2);

        Money money1 = new Money(10.f, currency1);

        Money result = exchangeRate.convertMoney(money1);

        assertEquals(result.currency(), currency2);
    }
}