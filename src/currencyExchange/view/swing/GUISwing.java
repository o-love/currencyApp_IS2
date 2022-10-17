package currencyExchange.view.swing;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUISwing extends JFrame {

    private static class WindowCloseManager extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
        }
    }

    public GUISwing(JPanel jPanel, String string) {
        super(string);

        getContentPane().add(jPanel);

        this.addWindowListener(new WindowCloseManager());
        setVisible(true);
    }
}
