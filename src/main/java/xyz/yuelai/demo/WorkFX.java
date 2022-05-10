package xyz.yuelai.demo;

import cn.hutool.core.io.resource.ResourceUtil;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import xyz.yuelai.FXApplication;
import xyz.yuelai.View;

public class WorkFX extends FXApplication {

    @Override
    public void start(Stage primaryStage) throws Exception {
        setElementStyleEnable(true);

        MainView view = View.createView(MainView.class);
        StackPane root = (StackPane)view.getRoot();
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        root.prefWidthProperty().bind(primaryStage.widthProperty());
        root.prefHeightProperty().bind(primaryStage.heightProperty());
        primaryStage.setMinWidth(600);
        primaryStage.setTitle("日常工具箱");
        primaryStage.getIcons().add(new Image(ResourceUtil.getResource("logo.png").toExternalForm()));
//        CSSFX.start();
        primaryStage.show();
    }
}
