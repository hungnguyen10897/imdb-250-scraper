import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {

    final static String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";

    public static void main(String[] args) {
        try{
            final Document doc = Jsoup.connect(url).get();

            //Print the whole HTML file
            //System.out.println(doc.outerHtml());

            for(Element row: doc.select("table.chart.full-width tr")){

                final String title = row.select(".titleColumn a").text();
                final String rating = row.select(".imdbRating").text();

                System.out.println(title + " -> Rating: " + rating);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
