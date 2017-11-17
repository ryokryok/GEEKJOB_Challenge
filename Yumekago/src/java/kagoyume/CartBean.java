/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;

/**
 *
 * @author ryokato
 */
public class CartBean implements Serializable {

    private int id;
    private String name;
    private String imgMd;
    private int price;

    public void setID(int ID) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setImgMd(String md) {
        this.imgMd = md;
    }

    public String getImgMd() {
        return this.imgMd;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
