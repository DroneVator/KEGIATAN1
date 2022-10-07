import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    Scene scene = new Scene(new Group());

    @Override
    public void start(Stage stage) throws SQLException {
        // = new Stage();

        // Read Data
        env connect = new env();
        final HBox hb = new HBox();
        TableView<Kuliah> table = new TableView<Kuliah>();
        ObservableList<Kuliah> data = FXCollections.observableArrayList();

        ResultSet result;
        Kuliah kuliah = new Kuliah(null, null, null, null, null);
        String query = "SELECT * FROM " + kuliah.table();

        // try {
        Statement read = env.dbConnection();
        result = read.executeQuery(query);

        while (result.next()) {
            data.add(
                    new Kuliah(
                            result.getString("namaDosen"),
                            result.getString("mataKuliah"),
                            result.getString("GKB"),
                            result.getString("ruang"),
                            result.getString("waktu")));
        }

        stage.setTitle("Kuliah");
        stage.setWidth(1024);
        stage.setHeight(768);

        final Label label = new Label("DATA");
        label.setFont(new Font(20));

        table.setEditable(true);

        TableColumn namaDosen = new TableColumn("Nama Dosen");
        namaDosen.setMinWidth(200);
        namaDosen.setCellValueFactory(
                new PropertyValueFactory<Kuliah, String>("namaDosen"));

        TableColumn matkul = new TableColumn("Mata Kuliah");
        matkul.setMinWidth(200);
        matkul.setCellValueFactory(
                new PropertyValueFactory<Kuliah, String>("matkul"));

        TableColumn gkb = new TableColumn("GKB");
        gkb.setMinWidth(100);
        gkb.setCellValueFactory(
                new PropertyValueFactory<Kuliah, String>("gkb"));

        TableColumn ruang = new TableColumn("Ruang");
        ruang.setMinWidth(100);
        ruang.setCellValueFactory(
                new PropertyValueFactory<Kuliah, String>("ruang"));

        TableColumn waktu = new TableColumn("Waktu");
        waktu.setMinWidth(200);
        waktu.setCellValueFactory(
                new PropertyValueFactory<Kuliah, String>("waktu"));

        table.setItems(data);
        table.getColumns().addAll(namaDosen, matkul, gkb, ruang, waktu);

        final Button reloadButton = new Button("Reload");
        reloadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stageRead = new Stage();
                App read = new App();

                try {
                    stageRead.setWidth(1024);
                    stageRead.setHeight(768);
                    read.start(stageRead);
                    stage.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        final Button createButton = new Button("Create");
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CreateView create = new CreateView();
                create.create();
            }
        });

        final Button updateButton = new Button("Update");
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                UpdateView update = new UpdateView();
                update.searchUpdate();
            }
        });

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                DeleteView delete = new DeleteView();
                delete.searchDelete();
            }
        });

        hb.getChildren().addAll(reloadButton);
        hb.setSpacing(3);

        hb.getChildren().addAll(createButton);
        hb.setSpacing(4);

        hb.getChildren().addAll(updateButton);
        hb.setSpacing(5);

        hb.getChildren().addAll(deleteButton);
        hb.setSpacing(6);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(50, 10, 10, 50));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
        // System.out.println("test");
    }
}
