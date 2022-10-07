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

public class UpdateView {
    public void update(String id, String namaDosen, String mataKuliah, String GKB, String ruang, String waktu){

        // Update
        Stage stage1 = new Stage();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        stage1.setScene(scene);

        Text scenetitle = new Text("Update");
        scenetitle.setFont(Font.font(0));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Nama Dosen
        Label namaDosenLabel = new Label("Nama Dosen :");
        grid.add(namaDosenLabel, 0, 1);
        TextField namaDosenInput = new TextField();
        namaDosenInput.setText(namaDosen);
        grid.add(namaDosenInput, 1, 1);

        // Matkul
        Label matkulLabel = new Label("MataKuliah :");
        grid.add(matkulLabel, 0, 2);
        TextField matkulInput = new TextField();
        matkulInput.setText(mataKuliah);
        grid.add(matkulInput, 1, 2);

        // GKB
        Label gkbLabel = new Label("GKB :");
        grid.add(gkbLabel, 0, 3);
        TextField gkbInput = new TextField();
        gkbInput.setText(GKB);
        grid.add(gkbInput, 1, 3);

        // Ruang
        Label ruangLabel = new Label("Ruang :");
        grid.add(ruangLabel, 0, 4);
        TextField ruangInput = new TextField();
        ruangInput.setText(ruang);
        grid.add(ruangInput, 1, 4);

        // GKB
        Label waktuLabel = new Label("Waktu :");
        grid.add(waktuLabel, 0, 5);
        TextField waktuInput = new TextField();
        waktuInput.setText(waktu);
        grid.add(waktuInput, 1, 5);

        Button btn = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 8);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (namaDosenInput.getText().isEmpty()) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Input Nama Dosen");
                } else if (matkulInput.getText().isEmpty()) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Input Matkul");
                } else if (gkbInput.getText().isEmpty()) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Input GKB");
                } else if (ruangInput.getText().isEmpty()) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Input Ruangan");
                } else if (waktuInput.getText().isEmpty()) {
                    actiontarget.setText("Input waktu");
                } else {
                    KuliahController update = new KuliahController();
                    update.updateKuliah(
                        id, 
                        namaDosenInput.getText(),
                        matkulInput.getText(),
                        gkbInput.getText(), 
                        ruangInput.getText(), 
                        waktuInput.getText()
                    );

                    actiontarget.setFill(Color.BLUE);
                    actiontarget.setText("Data Berhasil DiUbah");

                    namaDosenInput.clear();
                    matkulInput.clear();
                    gkbInput.clear();
                    ruangInput.clear();
                    waktuInput.clear();
                }
            }
        });

        stage1.setTitle("Create Data");
        stage1.show();
        
    }

    public void searchUpdate() {
        Stage stage1 = new Stage();
        KuliahController crate = new KuliahController();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 500, 500);
        stage1.setScene(scene);

        Text scenetitle = new Text("Updat e");
        scenetitle.setFont(Font.font(0));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Nama Dosen
        Label namaDosenLabel = new Label("Masukan Nama Dosen Yang Ingin Update :");
        grid.add(namaDosenLabel, 0, 1);
        TextField namaDosenInput = new TextField();
        grid.add(namaDosenInput, 0, 2);

        Button btn = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 8);

        final Text message = new Text();
        grid.add(message, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (namaDosenInput.getText().isEmpty()) {
                    message.setFill(Color.FIREBRICK);
                    message.setText("Input Nama Dosen Terlebih Dahulu");
                }
                else{
                    KuliahController search = new KuliahController();
                    search.searchUpdate(namaDosenInput.getText());
                    stage1.close();
                }
            }
        });

        stage1.setTitle("Delete Data");
        stage1.show();
    }


}
