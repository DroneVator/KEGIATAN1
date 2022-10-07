// import javafx.beans.property.SimpleStringProperty;

public class Kuliah{
    // private final SimpleStringProperty namaDosen, matkul, gkb, ruang, waktu;
    private String namaDosen, matkul, gkb, ruang, waktu;

    public String table(){
        String table = "kuliah";
        return table;
    }

    public Kuliah(String namaDosen, String matkul, String gkb, String ruang, String waktu){                     
        this.namaDosen = namaDosen; 
        this.matkul = matkul;
        this.gkb = gkb;
        this.ruang = ruang;
        this.waktu = waktu;
    }

    public void setNamaDosen(String namaDosen){
        // this.namaDosen.set(namaDosen);
    }

    public String getNamaDosen(){
        return namaDosen;
        // return namaDosen.get();
    }

    public void setMatkul(String matkul){
        // this.matkul.set(matkul);
    }

    public String getMatkul(){
        return matkul;
        // return matkul.get();
    }

    public void setGkb(String gkb){
        // this.gkb.set(gkb);
    }

    public String getGkb(){
        return gkb;
        // return gkb.get();
    }

    public void setRuang(String ruang){
        // this.ruang.set(ruang);
    }

    public String getRuang(){
        return ruang;
        // return ruang.get();
    }

    public void setWaktu(String waktu){
        // this.waktu.set(waktu);
    }

    public String getWaktu(){
        return waktu;
        // return waktu.get();
    }


}
