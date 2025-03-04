package be.ugent.objprog.sladders;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BoardPanel extends Pane {

    private final ImageView playerToken;

    public BoardPanel (Game game) {
        ImageView imageView = new ImageView(BoardPanel.class.getResource("board.png").toExternalForm());
        imageView.setFitWidth(704);
        imageView.setPreserveRatio(true);
        imageView.setX(0);
        imageView.setY(16);
        getChildren().add(imageView);
        setPrefSize(704, 720);

        this.playerToken = new ImageView(new Image(BoardPanel.class.getResource("player.png").toExternalForm()));
        getChildren().add(playerToken);
        playerToken.setFitWidth(40);
        playerToken.setPreserveRatio(true);

        moveToken(game.getPosition());
        game.positionProperty().addListener(o -> moveToken(game.getPosition()));
    }

    public void moveToken (int position) {
        int row = (position - 1) / 8;
        int column = position - 1 - 8*row;
        if (row % 2 == 1) {
            column = 7 - column;
        }
        playerToken.setLayoutX(25 + 88*column);
        playerToken.setLayoutY(10 + 88*(7-row));
    }
}
