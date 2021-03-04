package zad1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class DrawTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();

        Random random = new Random();
        Point pnt1 = new Point(new double[]
                {random.nextInt(20_001)/100.0,
                        random.nextInt(20_001)/100.0});//(0-20000)/100.0
        Point pnt2 = new Point(new double[]
                {random.nextInt(20_001)/100.0,
                        random.nextInt(20_001)/100.0});//(0-20000)/100.0
    //[0 - 20_000] -> [0 - 200] може да е 197.56
        //[15-40] -> 1. [0-25] -> 2. nextInt(26) -> 3. nextInt(26) + 15

        Rectangle rectangle = new Rectangle(pnt1, 50, 100);
        Rectangle rectangle2 = new Rectangle(pnt2, 100, 50);

        rectangle.draw(group);
        rectangle2.draw(group);

        Point pnt3 = new Point(new double[]{
                pnt1.getCoords()[0] + rectangle.getWidth(),
                pnt1.getCoords()[1] + rectangle.getHeight()});
        Point pnt4 = new Point(new double[]{
                pnt1.getCoords()[0],
                pnt1.getCoords()[1] + rectangle.getHeight()});
        Point pnt5 = new Point(new double[]{
                pnt1.getCoords()[0] + rectangle.getWidth(),
                pnt1.getCoords()[1]});
        Point pnt6 = new Point(new double[]{
                pnt2.getCoords()[0] + rectangle2.getWidth(),
                pnt2.getCoords()[1] + rectangle2.getHeight()});
        Point pnt7 = new Point(new double[]{
                pnt2.getCoords()[0],
                pnt2.getCoords()[1] + rectangle2.getHeight()});
        Point pnt8 = new Point(new double[]{
                pnt2.getCoords()[0] + rectangle2.getWidth(),
                pnt2.getCoords()[1]});

        Line diagonalOne = new Line(pnt1, pnt3);
        Line diagonalTwo = new Line(pnt4, pnt5);
        Line diagonalThree = new Line(pnt2, pnt6);
        Line diagonalFour = new Line(pnt7, pnt8);

        diagonalOne.draw(group);
        diagonalTwo.draw(group);
        diagonalThree.draw(group);
        diagonalFour.draw(group);

        primaryStage.setTitle("Draw rectangles and lines");
        primaryStage.setScene(new Scene(group, 300, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
