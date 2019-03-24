class Ball {
    private static final int BALL_SIZE = 10;

    private static int x = Pong.getWindowWidth()/2-(BALL_SIZE/2);
    private static int y = Pong.getWindowHeight()/2-(BALL_SIZE/2);

    private static int horizontalDirection = 1;
    private static int verticalDirection = -1;

    public int getBallSize(){
        return BALL_SIZE;
    }

    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }

    public void move(Player player, Enemy enemy, PlayBox playBox){
        if(x + BALL_SIZE == Pong.getWindowWidth() || x == 0)
            horizontalDirection *= -1;
        if(y == 0){
            verticalDirection *= -1;
            playBox.upPlayerScore();
        }
        else if(y + BALL_SIZE == Pong.getWindowHeight()){
            verticalDirection *= -1;
            playBox.upEnemyScore();
        }
        //this checks to see if there has been a collison
        if(x >= (int)player.getx() && y == player.gety() - BALL_SIZE && verticalDirection == 1 && x <= (int)player.getx() + player.getWidth()){
            verticalDirection *= -1;
            if(x < player.getx() + player.getWidth()/3)
                horizontalDirection = -1;
            else if(x > player.getx() + player.getWidth()/3*2)
                horizontalDirection = 1;
        }
        else if(x >= (int)enemy.getx() && y == enemy.gety() + enemy.getHeight() && verticalDirection == -1 && x <= (int)enemy.getx() + enemy.getWidth()){
            verticalDirection *= -1;
            if(x < enemy.getx() + enemy.getWidth()/3)
                horizontalDirection = -1;
            else if(x > enemy.getx() + enemy.getWidth()/3*2)
                horizontalDirection = 1;
        }
        x += horizontalDirection;
        y += verticalDirection;
    }
}