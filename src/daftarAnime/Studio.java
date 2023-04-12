/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daftarAnime;

/**
 *
 * @author Adin
 */
public class Studio {
    private int id;
    private String name;
    private String tahun;
    private int total_anime;
    
    public Studio(){
        
    }
    
    public Studio(int id, String name, String tahun) {
        this.id = id;
        this.name = name;
        this.tahun = tahun;
    }
    

    public Studio(int id, String name, String tahun, int total_anime) {
        this.id = id;
        this.name = name;
        this.tahun = tahun;
        this.total_anime = total_anime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTahun() {
        return tahun;
    }

    public int getTotal_anime() {
        return total_anime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public void setTotal_anime(int total_anime) {
        this.total_anime = total_anime;
    }    
}
