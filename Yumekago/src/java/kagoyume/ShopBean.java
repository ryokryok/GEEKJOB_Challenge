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
public class ShopBean implements Serializable {

    private int id;
    private String code;
    private String name;
    private String script;
    private String url;
    private String imgSm;
    private String imgMd;
    private String review;
    private int revcnt;
    private int price;

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getScript() {
        return this.script;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setImgSm(String sm) {
        this.imgSm = sm;
    }

    public String getImgSm() {
        return this.imgSm;
    }

    public void setImgMd(String md) {
        this.imgMd = md;
    }

    public String getImgMd() {
        return this.imgMd;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return this.review;
    }

    public void setRevcnt(String revcnt) {
        this.revcnt = Integer.parseInt(revcnt);
    }

    public int getRevcnt() {
        return this.revcnt;
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }

    public int getPrice() {
        return this.price;
    }

}
