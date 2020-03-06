import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class URLSender {
    public static void main(String[] args) {

        try {
            Scanner s = new Scanner(System.in);
            String url = s.nextLine();
            URLGenerator.urlGenerator(url);
        } catch (Exception e) {
            System.out.println("error reading input");
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            List<String> list = new ArrayList<>();
            list = br.lines().collect(Collectors.toList());
            br.close();
            list.forEach(s -> URLGenerator.urlGenerator(s));

        } catch (IOException ex) {
            System.out.println("error reading input");
            ex.printStackTrace();
        }

    }

}


