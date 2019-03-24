import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyL implements KeyListener {
    
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
    
        @Override
        public void keyReleased(KeyEvent e) {
            Player.keyReleased(e);
        }
    
        @Override
        public void keyPressed(KeyEvent e) {
            Player.keyPressed(e);
        }
    
}