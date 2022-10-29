package currencyExchange.view.swing;

import javax.swing.*;
import java.awt.*;

public class CombinedViewSwing extends JPanel {

    private final JPanel topPanel;
    private final JPanel bottomPanel;

    public CombinedViewSwing(JPanel top, JPanel bottom) {
        this.topPanel = top;
        this.bottomPanel = bottom;

        setupGUI();
    }

    private void setupGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}
