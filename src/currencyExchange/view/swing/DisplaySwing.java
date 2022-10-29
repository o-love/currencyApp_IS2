package currencyExchange.view.swing;

import currencyExchange.Model.Money;
import currencyExchange.view.Display;

import javax.swing.*;
import java.awt.*;

public class DisplaySwing extends JPanel implements Display {

    private JTextArea display;

    public DisplaySwing(Money money) {
        createComponentsGUI();
        refreshMoney(money);
    }

    @Override
    public void refreshMoney(Money money) {
        this.display.setText(String.format("MONEY:\n================\n%f %s", money.amount(), money.currency().symbol()));
    }

    private void createComponentsGUI() {
        this.display = new JTextArea(10, 40);
        this.display.setEditable(false);

        this.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(display);

        this.add(scrollPane, BorderLayout.CENTER);
    }
}
