package currencyExchange.view;

import currencyExchange.model.Currency;
import currencyExchange.model.Money;

public interface Dialog {
    Money getMoney();
    Currency getCurrencyTo();
}
