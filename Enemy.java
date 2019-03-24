public class Enemy {
    private static final int ENEMY_HEIGHT = 15;
    private static final int ENEMY_WIDTH = 60;

    private static double x = Pong.getWindowWidth()/2-(ENEMY_WIDTH/2);
    private static double y = 60;

    private void moveRight(){
        if(x + (ENEMY_WIDTH/2) < Pong.getWindowWidth() && x < Pong.getWindowWidth() - ENEMY_WIDTH)
            x += 1;
    }

    private void moveLeft(){
        if(x + (ENEMY_WIDTH/2) > 0 && x > ENEMY_WIDTH)
            x -= 1;
    }

    public void move(Ball ball){
        if(x < ball.getx())
            moveRight();
        else if(x > ball.gety())
            moveLeft();
    }

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }

    public int getHeight(){
        return ENEMY_HEIGHT;
    }

    public int getWidth(){
        return ENEMY_WIDTH;
    }
}