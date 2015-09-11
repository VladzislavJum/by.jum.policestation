package by.jum.policestation;

import javax.swing.SwingUtilities;

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuWindow::new);
    }
}
