package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Random1 {
	private static int shortRandAdd = 0;
    private static int longRandAdd = 0;
    private static int randFirstName = 0;
    private static int randLastName = 0;
    
   /* public static int genFirstNameRandomNo() {
    	return randFirstName++;
    }
    
    public static int genLastNameRandomNo() {
    	return randLastName++;
    }
*/
   /* public static synchronized long genShortRandNumber() {
        return shortRandAdd++;
    }*/
    
	public static int genInt(int from, int to){
		int tmp = 0;
		if(to >= from)
			tmp = (int) (from + Math.round((Math.random() * (to - from))));
		return tmp;
	}

	public static float genFloat(double from, double to){
		float tmp = .0f;
		if(to >= from)
			tmp = (float) (from + (Math.random() * (to - from)));
		return tmp;
	}

    public static float genFloat(double from, double to, int precision){
        float number = genFloat(from, to);
        return (float) Math.round(number * Math.pow(10,precision)) / (float) Math.pow(10,precision);
    }

    public static synchronized long genRandNumber() {
        return System.currentTimeMillis() % 10_000_000_000L + longRandAdd++;
    }

    public static synchronized long genShortRandNumber() {
        return (genInt(1, 9) * 10_000_000) + (System.currentTimeMillis() % 10_000_000) + shortRandAdd++;
    }
    
    public static synchronized long genFirstNameRandomNo() {
        return (genInt(1, 9) * 10_000_000) + (System.currentTimeMillis() % 10_000_000) + randFirstName++;
    }
    
    public static synchronized long genLastNameRandomNo() {
        return (genInt(1, 9) * 10_000_000) + (System.currentTimeMillis() % 10_000_000) + randLastName++;
    }

    public static String genStreet() {
        return genRandNumber() + " Main str.";
    }

    public static String genPhone() {
        return "555" + genInt(1000000, 9999999);
    }

    public static String genEmail() {
        return "mailname+" + genInt(1000000, 9999999) + "@gmail.com";
    }

    public static String genEmail(String emailPattern) {
        return emailPattern.substring(0, emailPattern.indexOf("@")) + "+" + genShortRandNumber()
                + emailPattern.substring(emailPattern.indexOf("@"), emailPattern.length());
    }

    public static String genWebsite() {
        return genRandNumber() + ".com";
    }

  /*  public static String genCityName() {
        JsonParser parser = new JsonParser();
        File citiesFile = new File(Properties.getCitiesFilePath());
        FileReader fr = null;
        try {
            fr = new FileReader(citiesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonElement element = parser.parse(new JsonReader(fr));
        JsonObject obj = element.getAsJsonObject();

        Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();
        int stateIndex = genInt(1, entries.size());

        Iterator<Map.Entry<String, JsonElement>> stateIterator = entries.iterator();
        IntStream.range(1,stateIndex).forEach(i -> stateIterator.next());
        Map.Entry<String, JsonElement> stateEntry = stateIterator.next();

        JsonArray cityList = stateEntry.getValue().getAsJsonArray();
        int cityIndex = genInt(0, cityList.size()-1);
        String cityName = cityList.get(cityIndex).toString().replaceAll("\"|'", "");
        String stateNamae = stateEntry.getKey();
        Debugger.Logger.info("random State: " + stateNamae + ", random City: " + cityName);
        return cityName;
    }*/

}
