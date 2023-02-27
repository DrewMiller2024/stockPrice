import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.*;

import java.util.Calendar;
import java.util.List; 
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;

/**
 * Retrieve historical stock prices
 */
public class StockPriceHistory
{

    private final String TICKER = "GOOG";
    private Interval DAILY = Interval.DAILY;
    
    /**
     * Retrieve the stock price data
     */
    public void run() {
        try {
            
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.add(Calendar.YEAR, -1);
 
            Stock google2 = YahooFinance.get("GOOG");
            List<HistoricalQuote> googleHistQuotes = google2.getHistory(from, to, Interval.DAILY);
            Map<String,String> datas = new HashMap<String,String>();
            datas.put("GOOG", googleHistQuotes);
            
            for (int i=0;i < googleHistQuotes.size();i++) {
                datas.put("GOOG", googleHistQuotes.get(i));
            }

            System.out.println(datas);
            
        } catch (Exception e) {
            System.out.println("Error in stock call");    
        }
    }
    
    /**
     * Format a Calendar object to YYYY-MM-DD format
     */
    private String formatDate(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH)+1;
        int day = date.get(Calendar.DATE);
        String monthStr = (month < 10) ? "0"+month : month+"";
        String dayStr = (day < 10) ? "0"+day : day+"";
        
        String dateStr = year+"-"+monthStr+"-"+dayStr;
        return dateStr;
    }
    

    /**
     * Main method to run the program
     */
    public static void main (String[] args) {
        StockPriceHistory sph = new StockPriceHistory();
        sph.run();
    }
}

