import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class PlayBox extends JPanel {
private static final int SMALL_BOX_HEIGHT = 20;
private static final int LINE_WIDTH = 8;
private static final int SMALL_CIRCLE = 12;
private static final int BIG_CIRCLE = 65;
private static final int MID_CIRCLE = 15;

    Player player = new Player();
    Ball ball = new Ball();
    Enemy enemy = new Enemy();

    Color backGroundColor = new Color(200, 223, 255); //a pale blue
    Color stuffColor = new Color(84, 104, 107); //a light grey
    Color myRed = new Color(255, 71, 71); //a light red
    Color lineColor = new Color(66, 134, 244); //a slightly darker blue
    Font myFont = new Font("Helvetica", Font.BOLD, 30);

    int scoreEnemy = 0;
    int scorePlayer = 0;

    String scoreE = Integer.toString(scoreEnemy);
    String scoreP = Integer.toString(scorePlayer);

    public void paint(Graphics g){
        //clears the panel first
        super.paint(g);
        //draws frame
        g.setColor(backGroundColor);
        g.fillRect(0, 0, Pong.getWindowWidth(), Pong.getWindowHeight());

        //draws red rectangles
        g.setColor(myRed);
        g.fillRect(0, 0, Pong.getWindowWidth(), SMALL_BOX_HEIGHT);
        g.fillRect(0, Pong.getWindowHeight() - SMALL_BOX_HEIGHT, Pong.getWindowWidth(), SMALL_BOX_HEIGHT);
        //draws circle and line in middle
        g.setColor(lineColor);
        g.fillOval(Pong.getWindowWidth()/2-(BIG_CIRCLE/2), Pong.getWindowHeight()/2-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
        g.setColor(backGroundColor);
        g.fillOval(Pong.getWindowWidth()/2-(BIG_CIRCLE/2)+(LINE_WIDTH), Pong.getWindowHeight()/2-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
        g.setColor(lineColor);
        g.fillRect(0, (Pong.getWindowHeight()/2) - (LINE_WIDTH/2), Pong.getWindowWidth(), LINE_WIDTH);
        g.fillOval(Pong.getWindowWidth()/2-(MID_CIRCLE/2), Pong.getWindowHeight()/2-(MID_CIRCLE/2), MID_CIRCLE, MID_CIRCLE);
        //more circles in corners
        g.setColor(lineColor);
        g.fillOval(Pong.getWindowWidth()/5-(BIG_CIRCLE/2), Pong.getWindowHeight()/5-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
        g.fillOval(4*Pong.getWindowWidth()/5-(BIG_CIRCLE/2), 4*Pong.getWindowHeight()/5-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
        g.fillOval(Pong.getWindowWidth()/5-(BIG_CIRCLE/2), 4*Pong.getWindowHeight()/5-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
        g.fillOval(4*Pong.getWindowWidth()/5-(BIG_CIRCLE/2), Pong.getWindowHeight()/5-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
        g.setColor(backGroundColor);
        g.fillOval(Pong.getWindowWidth()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), Pong.getWindowHeight()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
        g.fillOval(4*Pong.getWindowWidth()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), 4*Pong.getWindowHeight()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
        g.fillOval(4*Pong.getWindowWidth()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), Pong.getWindowHeight()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
        g.fillOval(Pong.getWindowWidth()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), 4*Pong.getWindowHeight()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
        g.setColor(lineColor);
        g.fillOval(Pong.getWindowWidth()/5-(SMALL_CIRCLE/2), Pong.getWindowHeight()/5-(SMALL_CIRCLE/2), SMALL_CIRCLE, SMALL_CIRCLE);
        g.fillOval(4*Pong.getWindowWidth()/5-(SMALL_CIRCLE/2), 4*Pong.getWindowHeight()/5-(SMALL_CIRCLE/2), SMALL_CIRCLE, SMALL_CIRCLE);
        g.fillOval(4*Pong.getWindowWidth()/5-(SMALL_CIRCLE/2), Pong.getWindowHeight()/5-(SMALL_CIRCLE/2), SMALL_CIRCLE, SMALL_CIRCLE);
        g.fillOval(Pong.getWindowWidth()/5-(SMALL_CIRCLE/2), 4*Pong.getWindowHeight()/5-(SMALL_CIRCLE/2), SMALL_CIRCLE, SMALL_CIRCLE);
        //draws player
        g.setColor(stuffColor);
        g.fillRoundRect((int)player.getx(), (int)player.gety(), player.getWidth(), player.getHeight(), 10, 10);
        //draws ball
        g.fillOval(ball.getx(), ball.gety(), ball.getBallSize(), ball.getBallSize());
        //draws enemy
        g.fillRoundRect((int)enemy.getx(), (int)enemy.gety(), enemy.getWidth(), enemy.getHeight(), 10, 10);
        //draw scores
        g.setColor(myRed);
        g.setFont(myFont);
        g.drawString(scoreE, 0, Pong.getWindowHeight()/4);
        g.drawString(scoreP, 0, 3*Pong.getWindowHeight()/4);
        //flashes red and blue if something scores
        for(int k = 0; k < Pong.getWindowWidth(); k++){
            for(int i = 0; i < SMALL_BOX_HEIGHT; i++){
                if(i == ball.gety() && k == ball.getx() || Pong.getWindowHeight() - i == ball.gety() && k == ball.getx()){
                    g.setColor(Color.red);
                    g.fillRect(0, 0, Pong.getWindowWidth(), SMALL_BOX_HEIGHT);
                    g.fillRect(0, Pong.getWindowHeight() - SMALL_BOX_HEIGHT, Pong.getWindowWidth(), SMALL_BOX_HEIGHT);
                    g.drawString(scoreE, 0, Pong.getWindowHeight()/4);
                    g.drawString(scoreP, 0, 3*Pong.getWindowHeight()/4);
                    g.setColor(Color.blue);
                    g.fillOval(Pong.getWindowWidth()/2-(BIG_CIRCLE/2), Pong.getWindowHeight()/2-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
                    g.setColor(backGroundColor);
                    g.fillOval(Pong.getWindowWidth()/2-(BIG_CIRCLE/2)+(LINE_WIDTH), Pong.getWindowHeight()/2-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
                    g.setColor(Color.blue);
                    g.fillRect(0, (Pong.getWindowHeight()/2) - (LINE_WIDTH/2), Pong.getWindowWidth(), LINE_WIDTH);
                    g.fillOval(Pong.getWindowWidth()/2-(MID_CIRCLE/2), Pong.getWindowHeight()/2-(MID_CIRCLE/2), MID_CIRCLE, MID_CIRCLE);
                    g.setColor(Color.blue);
                    g.fillOval(Pong.getWindowWidth()/5-(BIG_CIRCLE/2), Pong.getWindowHeight()/5-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
                    g.fillOval(4*Pong.getWindowWidth()/5-(BIG_CIRCLE/2), 4*Pong.getWindowHeight()/5-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
                    g.fillOval(Pong.getWindowWidth()/5-(BIG_CIRCLE/2), 4*Pong.getWindowHeight()/5-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
                    g.fillOval(4*Pong.getWindowWidth()/5-(BIG_CIRCLE/2), Pong.getWindowHeight()/5-(BIG_CIRCLE/2), BIG_CIRCLE, BIG_CIRCLE);
                    g.setColor(backGroundColor);
                    g.fillOval(Pong.getWindowWidth()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), Pong.getWindowHeight()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
                    g.fillOval(4*Pong.getWindowWidth()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), 4*Pong.getWindowHeight()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
                    g.fillOval(4*Pong.getWindowWidth()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), Pong.getWindowHeight()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
                    g.fillOval(Pong.getWindowWidth()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), 4*Pong.getWindowHeight()/5-(BIG_CIRCLE/2)+(LINE_WIDTH), BIG_CIRCLE-2*LINE_WIDTH, BIG_CIRCLE-2*LINE_WIDTH);
                    g.setColor(Color.blue);
                    g.fillOval(Pong.getWindowWidth()/5-(SMALL_CIRCLE/2), Pong.getWindowHeight()/5-(SMALL_CIRCLE/2), SMALL_CIRCLE, SMALL_CIRCLE);
                    g.fillOval(4*Pong.getWindowWidth()/5-(SMALL_CIRCLE/2), 4*Pong.getWindowHeight()/5-(SMALL_CIRCLE/2), SMALL_CIRCLE, SMALL_CIRCLE);
                    g.fillOval(4*Pong.getWindowWidth()/5-(SMALL_CIRCLE/2), Pong.getWindowHeight()/5-(SMALL_CIRCLE/2), SMALL_CIRCLE, SMALL_CIRCLE);
                    g.fillOval(Pong.getWindowWidth()/5-(SMALL_CIRCLE/2), 4*Pong.getWindowHeight()/5-(SMALL_CIRCLE/2), SMALL_CIRCLE, SMALL_CIRCLE);
        
                }
            }
        }
    }

    public void move(){
        player.move();
        ball.move(player, enemy, this);
        enemy.move(ball);
    }

    public void upPlayerScore(){
        scorePlayer++;
        scoreP = Integer.toString(scorePlayer);

    }

    public void upEnemyScore(){
        scoreEnemy++;
        scoreE = Integer.toString(scoreEnemy);
    }
}