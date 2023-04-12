/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daftarAnime;

/**
 *
 * @author Adin
 */
public class Anime {
    private int id;
    private String title;
    private String deskripsi;
    private String studio;
    private byte[] picture;
    
    public Anime(){
        
    }
    
    public Anime(int id, String title, String deskripsi, String studio, byte[] picture){
        this.id = id;
        this.title = title;
        this.deskripsi = deskripsi;
        this.studio = studio;
        this.picture = picture;
    }
    
    public Anime(int id, String title, String deskripsi, String studio){
        this.id = id;
        this.title = title;
        this.deskripsi = deskripsi;
        this.studio = studio;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getStudio() {
        return studio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }    

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    
}
