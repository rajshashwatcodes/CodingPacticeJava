import java.util.Random;

public class RandomQuoteGenerator {
    public static void main(String[] args) {
        String[] quotes = {
            "The only way to do great work is to love what you do. - Steve Jobs",
            "In the end, it's not the years in your life that count. It's the life in your years. - Abraham Lincoln",
            "Believe you can and you're halfway there. - Theodore Roosevelt",
            "The only impossible journey is the one you never begin. - Tony Robbins",
            "It does not matter how slowly you go as long as you do not stop. - Confucius"
        };

        String randomQuote = getRandomQuote(quotes);
        System.out.println("Random Quote: " + randomQuote);
    }

    public static String getRandomQuote(String[] quotes) {
        Random random = new Random();
        int index = random.nextInt(quotes.length);
        return quotes[index];
    }
}
