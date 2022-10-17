package currencyExchange.controller;

import currencyExchange.Model.Currency;
import currencyExchange.Model.ExchangeRate;
import currencyExchange.Model.Money;
import currencyExchange.Model.persistence.web.ExchangeRateLoaderWeb;
import currencyExchange.view.Dialog;
import currencyExchange.view.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyCalculatorController implements ActionListener {

    private final Display display;
    private final Dialog dialog;
    private final ExchangeRateLoaderWeb exchangeRateLoaderWeb; // TODO: Convert to

    public MoneyCalculatorController(Display display, Dialog dialog, ExchangeRateLoaderWeb exchangeRateLoaderWeb) {
        this.display = display;
        this.dialog = dialog;
        this.exchangeRateLoaderWeb = exchangeRateLoaderWeb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: When button gets activated, load money and currency from dialog, load exchange rate,
        //  transform to objective currency and finally that Money send it to display

        Money fromMoney = dialog.getMoney();
        Currency toCurrency = dialog.getCurrencyTo();

        ExchangeRate exchangeRate = exchangeRateLoaderWeb.loadOne(fromMoney.getCurrency(), toCurrency);


    }
}
