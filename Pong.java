import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.Dimension;

class Pong {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 400;

    public static void main(String [] args) throws InterruptedException {
        JFrame window = new JFrame("Pong Hockey");
        window.getContentPane().setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        window.pack();
        
        PlayBox playBox = new PlayBox();
        playBox.setFocusable(true);
        KeyListener listener = new KeyL();
        playBox.addKeyListener(listener);
        window.add(playBox);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);

        Thread.sleep(2000);
        while(true){
            playBox.move();
            playBox.repaint();
            Thread.sleep(3);
        }
    }

    public static int getWindowHeight(){
        return WINDOW_HEIGHT;
    }

    public static int getWindowWidth(){
        return WINDOW_WIDTH;
    }
}