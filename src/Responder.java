import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private Random randomGenerator;
    private ArrayList<String> defaultResponses;
    private HashMap<String, String> responseMap;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        randomGenerator = new Random();
        defaultResponses = new ArrayList<String>();
        responseMap = new HashMap<String, String>();
        fillResponseMap();
        fillDefaultResponses();
    }

    private void fillResponseMap() {
        this.responseMap.put("slow", "I think this has to do with your hardware. " +
                "Upgrading your computer should solve this." +
                "Have you got a problem with our software?");
        this.responseMap.put("bug", "Well, all software has some bugs, but" +
                "our engineers are hard working to solve them." +
                "Can you describe the problem a bit further?");
        this.responseMap.put("expensive", "The cost of our product is quite competitive" +
                "Did you compare a product with the same features?");
    }

    private void fillDefaultResponses() {
        defaultResponses.add("That sounds interesting. Tell me more...");
        defaultResponses.add("That sounds odd. Could you describe that problem in more detail?");
        defaultResponses.add("No other customer has ever complained about this before. \n" +
                      "What is your system configuration?");
        defaultResponses.add("That's a known problem with Vista. Windows 7 is much better.");
        defaultResponses.add("I need a bit more information on that.");
        defaultResponses.add("Have you checked that you do not have a dll conflict?");
        defaultResponses.add("That is explained in the manual. Have you read the manual?");
        defaultResponses.add("Your description is a bit wishy-washy. Have you got an expert\n" +
                      "there with you who could describe this more precisely?");
        defaultResponses.add("That's not a bug, it's a feature!");
        defaultResponses.add("Could you elaborate on that?");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(String word) {
        String response = this.responseMap.get(word);
        if (response != null) {
            return response;
        } else {
            return pickDefaultResponse();
        }
    }

    private String pickDefaultResponse() {
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
