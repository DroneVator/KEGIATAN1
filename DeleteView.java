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

public class DeleteView {
    public void delete(String id, String namaDosen, String mataKuliah, String GKB, String ruang, String waktu){
        Stage stage = new Stage();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text detail = new Text();
        detail.setText("Apakah Anda Inign Menghapus Data Dengan Detail :"+
        "\nNama Dosen : "+namaDosen+
        "\nMata Kuliah : "+mataKuliah+
        "\nRuang : "+ruang+" GKB "+GKB+
        "\nWaktu : "+waktu);
        grid.add(detail, 1, 1);

        Button btn = new Button("Delete");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 8);

        Text message = new Text();
        grid.add(message, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                KuliahController delete = new KuliahController();
                delete.deleteKuliah(id);
                stage.close();
            }
        });

        Scene scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Delete");
        stage.show();
    }

    public void searchDelete() {
        Stage stage1 = new Stage();
        KuliahController crate = new KuliahController();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 500, 500);
        stage1.setScene(scene);

        Text scenetitle = new Text("Delete");
        scenetitle.setFont(Font.font(0));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Nama Dosen
        Label namaDosenLabel = new Label("Masukan Nama Dosen Yang Ingin Dihapus :");
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
                    search.searchDelete(namaDosenInput.getText());
                    stage1.close();
                }
            }
        });

        stage1.setTitle("Delete Data");
        stage1.show();
    }

}
