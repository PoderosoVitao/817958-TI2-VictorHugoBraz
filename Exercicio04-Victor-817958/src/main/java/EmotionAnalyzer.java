import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.AnalyzeSentimentResult;
import com.azure.ai.textanalytics.models.AnalyzeSentimentOptions;
import com.azure.core.credential.AzureKeyCredential;

public class EmotionAnalyzer {

    public static void main(String[] args) {
        String endpoint = "https://recfacialvitao.cognitiveservices.azure.com/";
        String apiKey = "c03af4fed27940fe9530c8bd325d1509";
        TextAnalyticsClient textAnalyticsClient = new TextAnalyticsClientBuilder()
            .credential(new AzureKeyCredential(apiKey))
            .endpoint(endpoint)
            .buildClient();

        String text = "Eu estou muito feliz hoje!";

        AnalyzeSentimentOptions options = new AnalyzeSentimentOptions().setLanguage("pt");

        AnalyzeSentimentResult sentimentResult = textAnalyticsClient.analyzeSentiment(text, options);

        System.out.println("Pontuação de sentimento: " + sentimentResult.getSentiment());
        System.out.println("Emoções detectadas: " + sentimentResult.getSentences().get(0).getSentiment());
    }
}
