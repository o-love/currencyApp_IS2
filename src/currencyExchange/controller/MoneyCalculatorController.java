package currencyExchange.controller;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.Money;
import currencyExchange.Model.persistence.exchangeRate.ExchangeRateLoader;
import currencyExchange.view.Dialog;
import currencyExchange.view.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyCalculatorController implements ActionListener {

    private final Display display;
    private final Dialog dialog;
    private final ExchangeRateLoader exchangeRateLoader;

    public MoneyCalculatorController(Display display, Dialog dialog, ExchangeRateLoader exchangeRateLoader) {
        this.display = display;
        this.dialog = dialog;
        this.exchangeRateLoader = exchangeRateLoader;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Money fromMoney = dialog.getMoney();
        Currency toCurrency = dialog.getCurrencyTo();

        ExchangeRate exchangeRate = exchangeRateLoader.loadOne(fromMoney.currency(), toCurrency);

        Money result = exchangeRate.convertMoney(fromMoney);

        display.refreshMoney(result);
    }
}
