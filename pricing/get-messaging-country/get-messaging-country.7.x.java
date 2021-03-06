// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.rest.pricing.v2.messaging.Country;
import com.twilio.type.InboundSmsPrice;

public class Example {
  // Get your Account SID and Auth Token from https://twilio.com/console
  // To set up environment variables, see http://twil.io/secure
  public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    // Get Twilio Messaging pricing information for a specific country
    Country messagingCountry = Country.fetcher("EE").fetch();

    for (InboundSmsPrice price : messagingCountry.getInboundSmsPrices()) {
      // For each message pricing category, print number type and
      // current (reflecting any discounts your account has) price.
      System.out.println(price.getType());
      System.out.println(price.getCurrentPrice());
    }
  }
}
