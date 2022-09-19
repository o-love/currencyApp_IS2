package currencyExchange.Model;

public class ExchangeRate {
    private final Currency from;
    private final Currency to;
    private final float rate;

    public ExchangeRate(Currency from, Currency to, float rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
}
