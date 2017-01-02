package genome.firstgame;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {
    
    
    public static final int TO_RADIUS = 100;
    public static final int FROM_RADIUS = 10;
    public static final int ENEMY_CIRCLE_COLOR = Color.RED;
    public static final int FOOD_CIRCLE_COLOR = Color.GREEN;
    public static final int ENEMY_CIRCLE_SPEED = 10;
    private int dx;
    private int dy;
    
    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(ENEMY_CIRCLE_SPEED);
        int dy = 1 + random.nextInt(ENEMY_CIRCLE_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius, dx, dy);
        return enemyCircle;
    }

    public void setEnemyOfFoodColorDependsOn(MainCircle mainCircle) {
        if(isSmallerThan(mainCircle))
            setColor(FOOD_CIRCLE_COLOR);
        else
            setColor(ENEMY_CIRCLE_COLOR);
    }

    public boolean isSmallerThan(SimpleCircle circle) {
        if(radius < circle.radius)
            return true;

        return false;
    }
    
    public void moveOnStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x+(radius/2) > GameManager.getWidth() || x-(radius/2) < 0) {
            dx = -dx;
        }
        if (y+(radius/2) > GameManager.getHeight() || y-(radius/2) < 0) {
            dy = -dy;
        }
    }
}
