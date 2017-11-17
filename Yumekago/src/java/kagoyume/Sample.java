/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

/**
 *
 * @author ryokato
 */
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


public class Sample {

	// メンバ用クラス
	class LinkFormat {
		String link;
		String name;
	}
	
	// メンバに配列
	class SiteData {
		String title;
		int number;
		
		LinkFormat[] urlList;
	}
	
	// メンバに ArrayList
	class SiteDataList {
		String title;
		int number;
		
		ArrayList <LinkFormat> urlList;
	}
		
	public static void main(String[] args) {
	
		String json = null;
		
		// 一般 JSON オブジェクトフォーマット
		System.out.println("-----------------------------------------");
		
		json = "";
		json += "{";
		json += 	"\"link\":\"http://www.yahoo.co.jp/\",";
		json += 	"\"name\":\"Yahoo! JAPAN\"";
		json += "}";
		System.out.println(json);

		Gson gson = new Gson();

		// オブジェクトに変換
		System.out.println("-----------------------------------------");
		
		LinkFormat linkFormat = gson.fromJson(json, LinkFormat.class);

		System.out.println(linkFormat.link);
		System.out.println(linkFormat.name);

		// 一般 配列フォーマット
		System.out.println("-----------------------------------------");
		
		json = "";
		json += "[";
		json += 	"\"http://www.yahoo.co.jp/\",";
		json += 	"\"Yahoo! JAPAN\"";
		json += "]";
		System.out.println(json);

		// 配列に変換
		String[]  data = gson.fromJson(json, String[].class);

		System.out.println(data[0]);
		System.out.println(data[1]);

		// ArrayListに変換
		System.out.println("-----------------------------------------");
		
		Type arrayListType = new TypeToken<ArrayList<String>>(){}.getType();
		ArrayList<String>  al = gson.fromJson(json, arrayListType);

		System.out.println(al.get(0));
		System.out.println(al.get(1));

		// 特殊 JSON オブジェクト配列フォーマット
		System.out.println("-----------------------------------------");
		
		json = "";
		json += "[";
		json += 	"\"サイトデータ\",";
		json += 	"1,";
		json += 	"{";
		json += 		"\"link\":\"http://www.yahoo.co.jp/\",";
		json += 		"\"name\":\"Yahoo! JAPAN\"";
		json += 	"}";
		json += "]";
		System.out.println(json);

		// JSON 文字列配列内の型が違う場合はひとつひとつ対応
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(json).getAsJsonArray();
		String title = gson.fromJson(array.get(0), String.class);
		int number = gson.fromJson(array.get(1), int.class);
		LinkFormat lf = gson.fromJson(array.get(2), LinkFormat.class);

		System.out.println( title );
		System.out.println( number );
		System.out.println( lf.link );
		System.out.println( lf.name );

		// JSON オブジェクト内にオブジェクト配列
		System.out.println("-----------------------------------------");
		
		json = "";
		json += "{";
		json += "\"title\" : \"サイトデータ\",";
		json += "\"number\" : 2,";
		json += "\"urlList\" : [";
		json += 	"{";
		json += 		"\"link\":\"http://www.yahoo.co.jp/\",";
		json += 		"\"name\":\"Yahoo! JAPAN\"";
		json += 	"},";
		json += 	"{";
		json += 		"\"link\":\"https://www.google.co.jp/\",";
		json += 		"\"name\":\"Google\"";
		json += 	"}";
		json += "]";
		json += "}";
		System.out.println(json);
		
		// 配列バージョン
		SiteData sd = gson.fromJson(json, SiteData.class);
		System.out.println( sd.title );
		System.out.println( sd.number );
		System.out.println( sd.urlList[0].link );
		System.out.println( sd.urlList[0].name );
		System.out.println( sd.urlList[1].link );
		System.out.println( sd.urlList[1].name );

		// ArrayList バージョン
		SiteDataList sdl = gson.fromJson(json, SiteDataList.class);
		System.out.println( sdl.title );
		System.out.println( sdl.number );
		System.out.println( sdl.urlList.get(0).link );
		System.out.println( sdl.urlList.get(0).name );
		System.out.println( sdl.urlList.get(1).link );
		System.out.println( sdl.urlList.get(1).name );

	}

}
