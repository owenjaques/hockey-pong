import java.awt.event.KeyEvent;

public class Player {
    private static final int PLAYER_HEIGHT = 15;
    private static final int PLAYER_WIDTH = 60;

    private static int direction = 0;

    private static double x = Pong.getWindowWidth()/2-(PLAYER_WIDTH/2);
    private static double y = Pong.getWindowHeight()-60;

    private void moveRight(){
        if((x+(PLAYER_WIDTH)) < Pong.getWindowWidth())
            x += 1;
    }

    private void moveLeft(){
        if(x > 0)
            x -= 1;
    }

    public static void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            direction = 1;
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
            direction = -1;
        
    }

    public static void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && direction != -1)
            direction = 0;
        else if(e.getKeyCode() == KeyEvent.VK_LEFT && direction != 1)
            direction = 0;
    }

    public void move(){
        if(direction == 1)
            moveRight();
        if(direction == -1)
            moveLeft();
    }

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }

    public int getHeight(){
        return PLAYER_HEIGHT;
    }

    public int getWidth(){
        return PLAYER_WIDTH;
    }

}