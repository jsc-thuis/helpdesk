import java.util.ArrayList;
import java.util.HashSet;
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
     *
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
        responseMap.put("traag", "Dit is wss een probleem met uw hardware");
        responseMap.put("bug", "Welke versie van het programma gebruikt u?");
        responseMap.put("duur", "Ons programma heeft programmafunctie die niet makkelijk in dezeflde prijscategorie te vinden zijn");
        responseMap.put("onveilig", "We werken samen met één van de beste cybersecuritybedrijven in de wereld. Uw gegevens zijn zeker veilig");
        responseMap.put("proefversie", "We bieden een proefversie van onze programma aan. Deze duurt 30 dagen");
        responseMap.put("app", "U kunt onze app downloaden op ios en android en deze linken aan uw pc");
        responseMap.put("cloud", "Onze klanten hebben recht op 30gb opslagruimte op onze couldservice");
        responseMap.put("betalingsplan", "€59 per maand, €299 voor 6 maanden of €499 voor 12 maanden");
        responseMap.put("delen", "Het programma is bedoelt voor individueel gebruik");
        responseMap.put("sponsor", "Voor sponsordeals zal ik u verwijzen naar onze marketing afdeling");
    }

    private void fillDefaultResponses() {
        defaultResponses.add("Ik verwijs u door naar mijn collega");
        defaultResponses.add("Bekijk onze faq");
        defaultResponses.add("Zou u meer uitleg kunnen geven");
        defaultResponses.add("Wordt er een foutcode vermeld?");
        defaultResponses.add("Start uw computer op?");
        defaultResponses.add("Welke besturingssysteem gebruikt u?");
        defaultResponses.add("Hoe lang gebeurt dit al?");
        defaultResponses.add("U wordt verwezen naar de tutorial");
        defaultResponses.add("Welke windows versie gebruikt u?");
        defaultResponses.add("Welke versie van onze software gebruikt u?");
        defaultResponses.add("U wordt verwezen naar de sales afdeling");
    }

    /**
     * Generate a response.
     * @param word
     * @return String response
     */
    public String generateResponse(HashSet<String> words) {
        String response = null;
        for (String word : words) {
            if (this.responseMap.containsKey(word)) {
                response = this.responseMap.get(word);
            }
        }
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
