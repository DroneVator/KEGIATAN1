
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.Query;
import javafx.beans.Observable;
import javafx.collections.FXCollections;   
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class KuliahController {
    env env = new env();
    Kuliah kuliah = new Kuliah(null, null, null, null, null);

    public void checkConnection() {
        // KuliahController klh = new KuliahController();
        // klh.Connection();
    }

    public void createKuliah(String namaDosen, String matkul, String gkb, String ruang, String waktu) {
        String query = "INSERT INTO " + kuliah.table() + " VALUES (" + null + ", '" + namaDosen + "', '" + matkul
                + "', '" + gkb + "', '" + waktu + "', '" + ruang + "');";

        try {
            Statement create = env.dbConnection();
            create.execute(query);
            System.out.println("Data Berhasil Di Tambahkan");

        } catch (Exception e) {
            System.out.println("Data Gagal Di Tambahkan");
        }

    }

    public void dataView() {
        ResultSet result;
        Kuliah kuliah = new Kuliah(null, null, null, null, null);
        String query = "SELECT * FROM " + kuliah.table();

        try {
            Statement read = env.dbConnection();
            result = read.executeQuery(query);

            while (result.next()) {
                // data += "Nama Dosen : " + result.getString("namaDosen");
                System.out.println("Nama Dosen : " + result.getString("namaDosen"));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void searchUpdate(String namaDosen) {
        ResultSet result;
        UpdateView updateScene = new UpdateView();
        Kuliah kuliah = new Kuliah(null, null, null, null, null);
        String query = "SELECT * FROM " + kuliah.table() + " WHERE namaDosen LIKE '" + namaDosen + "'";

        try {
            Statement search = env.dbConnection();
            result = search.executeQuery(query);

            while (result.next()) {
                System.out.println("Nama Dosen : " + result.getString("namaDosen"));
                updateScene.update(
                        result.getString("id"),
                        result.getString("namaDosen"),
                        result.getString("mataKuliah"),
                        result.getString("GKB"),
                        result.getString("ruang"),
                        result.getString("waktu"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchDelete(String namaDosen) {
        ResultSet result;
        DeleteView deleteScene = new DeleteView();
        Kuliah kuliah = new Kuliah(null, null, null, null, null);
        String query = "SELECT * FROM " + kuliah.table() + " WHERE namaDosen LIKE '" + namaDosen + "'";

        try {
            Statement search = env.dbConnection();
            result = search.executeQuery(query);

            while (result.next()) {
                System.out.println("Nama Dosen : " + result.getString("namaDosen"));
                deleteScene.delete(
                        result.getString("id"),
                        result.getString("namaDosen"),
                        result.getString("mataKuliah"),
                        result.getString("GKB"),
                        result.getString("ruang"),
                        result.getString("waktu"));

                // if(result.getString("id") == null){
                //     System.out.println("test");
                // }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateKuliah(String id, String dosen, String matkul, String GKB, String ruang, String waktu) {
        int result;
        Kuliah kuliah = new Kuliah(null, null, null, null, null);
        String query = "UPDATE "+kuliah.table()+" SET namaDosen = '"+dosen+"', mataKuliah = '"+matkul+"', GKB = '"+GKB+"', waktu = '"+waktu+"', ruang = '"+ruang+"'"+" WHERE id = "+id;

        try {
            Statement update = env.dbConnection();
            result = update.executeUpdate(query);
            System.out.println("Data Berhasil Di Ubah");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Data Gagal Di Ubah");
        }

    }

    public void deleteKuliah(String id) {
        int result;
        Kuliah kuliah = new Kuliah(null, null, null, null, null);
        String query = "DELETE FROM "+kuliah.table()+" WHERE id = "+id;

        try {
            Statement delete = env.dbConnection();
            result = delete.executeUpdate(query);
            System.out.println("Data Berhasil Di Hapus");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Data Gagal Di Hapus");
        }

    }

}
