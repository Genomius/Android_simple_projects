package genome.firstgame;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class GameManager {
    public static final int ENEMY_CIRCLE_COUNT = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> enemyCircles;
    private CanvasView canvasView;
    private static int width;
    private static int height;


    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;

        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        enemyCircles = new ArrayList<EnemyCircle>();
        for(int i = 0; i< ENEMY_CIRCLE_COUNT; i++){
            EnemyCircle enemyCircle;
            do {
                enemyCircle = EnemyCircle.getRandomCircle();
            } while(enemyCircle.isInterSect(mainCircleArea));
            enemyCircles.add(enemyCircle);
        }
        calculateAndSetEnemyCirclesColor();
    }
    
    private void calculateAndSetEnemyCirclesColor() {
        for (EnemyCircle enemyCircle : enemyCircles) {
            enemyCircle.setEnemyOfFoodColorDependsOn(mainCircle);
        }
    }
    
    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }
    
    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);

        for (EnemyCircle enemyCircle : enemyCircles) {
             canvasView.drawCircle(enemyCircle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        checkCollision();
        moveEnemyCircles();
    }

    private void checkCollision() {
        SimpleCircle enemyCircleForDelete = null;

        for (EnemyCircle enemyCircle : enemyCircles) {
            if (mainCircle.isInterSect(enemyCircle)){
                if (enemyCircle.isSmallerThan(mainCircle)){
                    mainCircle.growRadius(enemyCircle);

                    enemyCircles.remove(enemyCircle);
                    if (enemyCircles.isEmpty()){
                        gameEnd("YOU WIN!");
                        return;
                    }

                    calculateAndSetEnemyCirclesColor();

                    break;
                }
                else{
                    gameEnd("YOU LOSE!");
                    return;
                }
            }
        }
    }

    private void gameEnd(String message) {
        canvasView.showMessage(message);

        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.reDraw();
    }

    private void moveEnemyCircles() {
        for (EnemyCircle enemyCircle : enemyCircles) {
            enemyCircle.moveOnStep();
        }
    }
}
