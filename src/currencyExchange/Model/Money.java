package currencyExchange.Model;

public class Money {
    private Currency currency;
    private float amount;

    public Money(float amount, Currency currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setAmount(float amount){
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
