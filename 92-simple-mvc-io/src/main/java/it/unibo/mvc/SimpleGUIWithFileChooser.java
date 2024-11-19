package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();
    private static final int PROPORTION = 5;
    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);
        final JButton browse = new JButton("Browse...");
        panel.add(browse, BorderLayout.CENTER);
        textField.setText(controller.getCurrentFile().getName());
        /*
         * Handlers
         */
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int test = fileChooser.showOpenDialog(frame);
                if ( test == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getCurrentFile().getName());
                } else if (test == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, e, "Error...", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(panel);
    }
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
