 class ShortUrlGenerator {

    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final long BASE = CHARS.length();


    /**
     * Function to generate tinyURL from integer ID
     */
    public String encode(long id) {
        StringBuilder tinyURL = new StringBuilder();
        while (id > 0) {
            tinyURL.insert(0, CHARS.charAt((int) (id % BASE)));
            id = id / BASE;
        }
        return tinyURL.toString();
    }

    /**
     * Function to get integer ID back from tinyURL
     */
    public long decode(String tinyURL) {
        long num = 0;
        for (int i = 0; i < tinyURL.length(); i++) {
            num = num * BASE + CHARS.indexOf(tinyURL.charAt(i));
        }
        return num;
    }
}
