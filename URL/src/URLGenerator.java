import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class URLGenerator {
    static String BASE_URL = "tinyurl/";
    static final Set<Integer> picked = new HashSet<>();

    public static void urlGenerator(String s) {
        ShortUrlGenerator generator = new ShortUrlGenerator();
        String tiny = generator.encode(pickRandom(100000));
        System.out.println(s + "->" + BASE_URL.concat(tiny));
    }

    /* we are doing this to get a unique random number which will bge unique to a particular url ,this random
     * number will be used to generate short URL,
     * Ideally, we can get this unique ID from DB for each row directly , if we are using any DB
     *  Using this method, since we are not using DB here
     */
    public static Integer pickRandom(Integer k) {
        Random RANDOM = new Random();
        while ( picked.add(RANDOM.nextInt(k + 1)) != true) {
            pickRandom(k);
        }
        picked.add(RANDOM.nextInt(k + 1));
        return RANDOM.nextInt(k + 1);
    }
}
