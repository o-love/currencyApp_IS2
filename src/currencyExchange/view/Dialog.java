package currencyExchange.view;

import currencyExchange.Model.Currency;
import currencyExchange.Model.Money;

public interface Dialog {
    Money getMoney();
    Currency getCurrencyTo();
}
