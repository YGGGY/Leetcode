package String;
import java.util.*;

public class EncodeAndDecodeTinyURL_535 {
    HashMap<Integer, String> map = new HashMap<>();
    Random rand = new Random();
    int key = rand.nextInt(Integer.MAX_VALUE);

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while(map.containsKey(key)){
            this.key = rand.nextInt(Integer.MAX_VALUE);
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String numStr = shortUrl.replace("http://tinyurl.com/", "");
        int temp = Integer.parseInt(numStr);
        return map.get(temp);
    }
}
