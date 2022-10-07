import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CreateView {
    public void create() {
        // Crate
        Stage stage1 = new Stage();
        KuliahController create = new KuliahController();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        stage1.setScene(scene);

        Text scenetitle = new Text("Create");
        scenetitle.setFont(Font.font(0));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Nama Dosen
        Label namaDosenLabel = new Label("Nama Dosen :");
        grid.add(namaDosenLabel, 0, 1);
        TextField namaDosenInput = new TextField();
        grid.add(namaDosenInput, 1, 1);

        // Matkul
        Label matkulLabel = new Label("MataKuliah :");
        grid.add(matkulLabel, 0, 2);
        TextField matkulInput = new TextField();
        grid.add(matkulInput, 1, 2);

        // GKB
        Label gkbLabel = new Label("GKB :");
        grid.add(gkbLabel, 0, 3);
        TextField gkbInput = new TextField();
        grid.add(gkbInput, 1, 3);

        // GKB
        Label ruangLabel = new Label("Ruang :");
        grid.add(ruangLabel, 0, 4);
        TextField ruangInput = new TextField();
        grid.add(ruangInput, 1, 4);

        // GKB
        Label waktuLabel = new Label("Waktu :");
        grid.add(waktuLabel, 0, 5);
        TextField waktuInput = new TextField();
        grid.add(waktuInput, 1, 5);

        Text message = new Text();
        grid.add(message, 1, 7);

        Button btn = new Button("Submit");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if(namaDosenInput.getText().isEmpty()){
                    message.setText("Masukan Nama Dosen");
                }
                else if(matkulInput.getText().isEmpty()){
                    message.setText("Masukan Matakuliah");
                }
                else if(gkbInput.getText().isEmpty()){
                    message.setText("Masukan GKB");
                }
                else if(ruangInput.getText().isEmpty()){
                    message.setText("Masukan Ruang");
                }
                else if(waktuInput.getText().isEmpty()){
                    message.setText("Masukan Waktu");
                }
                else{
                    create.createKuliah(namaDosenInput.getText(), matkulInput.getText(), gkbInput.getText(), ruangInput.getText(), waktuInput.getText());
                    namaDosenInput.clear();
                    matkulInput.clear();
                    gkbInput.clear();
                    ruangInput.clear();
                    waktuInput.clear();
                    message.setText("Data Berhasil di Input");
                }
            }
        });

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 8);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        stage1.setTitle("Create Data");
        stage1.show();
    }
}
