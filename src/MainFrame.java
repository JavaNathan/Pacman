import javax.swing.*;
public class MainFrame implements Runnable{
    private GraphicsPanel panel;

    public MainFrame(){
        JFrame frame = new JFrame("Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);

        panel = new GraphicsPanel();
        frame.add(panel);

        frame.setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
    }
    public void run(){
        while (true){
            panel.repaint();
        }
    }
}
