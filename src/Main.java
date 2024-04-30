import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {

    public Main() {

        Random random = new Random();

        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        Color randomColor = new Color(red, green, blue);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Close Me");
        list.add("Try Again");
        list.add("I Bet you can't");
        list.add("You don't stand a chance");
        list.add("Can't touch this");
        list.add("I'm warning you");
        list.add("You better not");

        setLayout(new FlowLayout());
        setTitle(list.get(random.nextInt(7)));
        setSize(400, 225);
        getContentPane().setBackground(randomColor);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            dispose();
            for (int i = 0; i < 1000; i++) {
                new Main().setVisible(true);
            }
        });

        add(closeButton);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = random.nextInt(screenSize.width - getWidth());
        int y = random.nextInt(screenSize.height - getHeight());
        setLocation(x, y);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main window = new Main();
            window.setVisible(true);
        });
    }
}