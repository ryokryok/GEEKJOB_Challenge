/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import net.arnx.jsonic.JSON;

public class YahooAPI {

    /**
     * Yahoo!ディベロッパーのAPP ID
     */
    private static String APP_ID = "dj00aiZpPUpFdUx2eDJ6VjMwcCZzPWNvbnN1bWVyc2VjcmV0Jng9OWY-";

    /**
     * Yahoo!ショッピングAPIのベースURI
     */
    private static String BASE_URI = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
    // サンプルコード (google)

    public static void main(String[] args) {

        try {

            Product product = new Product();
            product.search = "google";

            Gson gson = new Gson();

            System.out.println(gson.toJson(product));

            YahooAPI.productData(product);

            System.out.println(gson.toJson(product));
            System.out.println(product.name);
            System.out.println(product.price);
            System.out.println(product.script);
            System.out.println(product.imgMd);
            System.out.println(product.imgSm);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * YahooショッピングAPIを使って商品データを検索し、Productインスタンスの該当フィールドを補足する
     *
     * @param product
     * @throws IOException
     */
    public static void productData(Product product) throws IOException {

        if (product != null && product.search != null) {

            URL url = new URL(BASE_URI + "?appid=" + APP_ID + "&query=" + product.search);

            HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.setInstanceFollowRedirects(false);

            urlconn.connect();

            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));

            StringBuilder responseBuffer = new StringBuilder();
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                responseBuffer.append(line);
            }

            reader.close();
            urlconn.disconnect();

            String response = responseBuffer.toString();

            parse(product, response);

        }
    }

    /**
     * JSONテキストをパースして、Productインスタンスの該当フィールドに追加
     *
     * @param product
     * @param jsonText
     */
    private static void parse(Product product, String jsonText) {

        Map<String, Map<String, Object>> json = JSON.decode(jsonText);

        if (!Integer.valueOf((String) json.get("ResultSet").get("totalResultsAvailable")).equals(0)) {

            @SuppressWarnings("unchecked")
            Map<String, Object> result = ((Map<String, Object>) ((Map<String, Map<String, Object>>) json.get("ResultSet").get("0")).get("Result").get("0"));

            String name = result.get("Name").toString();
            String script = result.get("Description").toString();
            String imgMd = ((Map<String, Object>) result.get("Image")).get("Medium").toString();
            String imgSm = ((Map<String, Object>) result.get("Image")).get("Small").toString();
            String price = ((Map<String, Object>) result.get("Price")).get("_value").toString();

            product.setName(name);
            product.setScript(script);
            product.setImgMd(imgMd);
            product.setImgSm(imgSm);
            product.setPrice(price);

        }

    }

}

/**
 * 商品データを受け取るクラス
 */
class Product {

    public String search = "";
    public String name = "";
    public String script = "";
    public String imgMd = "";
    public String imgSm = "";
    public int price = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void setImgMd(String url) {
        this.imgMd = url;
    }

    public void setImgSm(String url) {
        this.imgSm = url;
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }
}
