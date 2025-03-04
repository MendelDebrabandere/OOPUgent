package be.ugent.objprog.eightqueens;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * Een rechthoekig veld waarop kan geklikt worden
 */
public class Field extends StackPane implements EventHandler<MouseEvent>, EightQueensListener {

    private final ImageView imageView;
    private final Rectangle rect;

    private final EightQueensModel model;

    private final int column;
    private final int row;

    public Field(EightQueensModel model, int column, int row) {
        this.model = model;
        model.registerListener(this);
        this.column = column;
        this.row = row;

        // bottom child is a rectangle
        this.rect = new Rectangle(50, 50);
        getChildren().add(rect);
        rect.setOnMouseClicked(this);

        // top child is an image view
        this.imageView = new ImageView(new Image(getClass().getResourceAsStream("queen.png")));
        imageView.setMouseTransparent(true); // mouse events are handled by the rectangle
        getChildren().add(imageView);

        //
        setAppearance();
    }

    private void setAppearance () {
        if ((row + column) % 2 == 0) {
            rect.setFill(model.isThreatened(row, column) ? Color.THISTLE : Color.ANTIQUEWHITE);
        } else {
            rect.setFill(model.isThreatened(row, column) ? Color.PALEVIOLETRED : Color.SLATEGRAY);
        }
        imageView.setVisible(model.hasQueen(row, column));
    }

    @Override
    public void handle(MouseEvent event) {
        model.toggleQueen(row, column);
    }

    @Override
    public void modelHasChanged() {
        setAppearance();
    }
}
