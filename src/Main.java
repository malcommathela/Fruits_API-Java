import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.stream.Location;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String fruit;

            do {
                //Retrieve User Input
                System.out.println("===========================================");
                System.out.println("Enter any Fruit (Say No to QUIT): ");
                fruit = scanner.nextLine();

                if (fruit.equalsIgnoreCase("No")) break;

                //Get fruit data
                JSONObject fruitData = (JSONObject) getFruitData(fruit);

                displayFruitData(fruit);


            } while (!fruit.equalsIgnoreCase("No"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayFruitData(String fruit) {
        try{

            //1.Fetch the API response based on te API link
            String urlString = String.format("https://www.fruityvice.com/api/fruit/%s", fruit);;
            HttpURLConnection apiConnection = fetchApiConnection(urlString);

            //Check for response status
            //200 - means that the connection was a success
            if (apiConnection.getResponseCode() != 200) {
                System.out.println("Error: Could not to API");
                return;
            }

            //2.Read the response and convert store String Type
            String jsonResponse = readApiResponse(apiConnection);

            //3.Parse the String into a JSON Object
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);

            //4.Store the data into their corresponding data Type
            String name = (String) jsonObject.get("name");
            System.out.println("Name: "+name);

            String family = (String) jsonObject.get("family");
            System.out.println("Family: "+family);

            String order = (String) jsonObject.get("order");
            System.out.println("Order: "+order);

            String genus = (String) jsonObject.get("genus");
            System.out.println("Genus: "+genus);

            //
            JSONObject nutritionJson = (JSONObject) jsonObject.get("nutritions");

            long calories = (long) nutritionJson.get("calories");
            System.out.println("Calories: "+calories);

            double fat = (double) nutritionJson.get("fat");
            System.out.println("Fat: "+fat);

            double sugar = (double) nutritionJson.get("sugar");
            System.out.println("Sugar: "+sugar);

            double carbohydrates = (double) nutritionJson.get("carbohydrates");
            System.out.println("carbohydrates: "+carbohydrates);

            double protein = (double) nutritionJson.get("protein");
            System.out.println("Protein: "+protein);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static JSONObject getFruitData(String fruit) {

        fruit = fruit.replaceAll(" ", "+");
        String urlString = String.format("https://www.fruityvice.com/api/fruit/%s", fruit);;

        try {
            //1.Fetch the API response based on te API link
            HttpURLConnection apiConnection = fetchApiConnection(urlString);

            //Check for response status
            //200 - means that the connection was a success
            if (apiConnection.getResponseCode() != 200) {
                System.out.println("Error: Could not to API");
                return null;
            }

            //2.Read thr response and convert store String type
            String jsonResponse = readApiResponse(apiConnection);

            //3.Parse the String into a JSON Object
            JSONParser parser = new JSONParser();
            JSONObject resultJsonObj = (JSONObject) parser.parse(jsonResponse);

            return (JSONObject) resultJsonObj;


        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readApiResponse(HttpURLConnection apiConnection) {
        try {
            //Create a StringBuilder to store the resulting JSON data
            StringBuilder resultJson = new StringBuilder();

            //Create a scanner to read from the inputStream of the HttpsURLConnection
            Scanner scanner = new Scanner(apiConnection.getInputStream());

            //Loop through each line in the response and append it to the StringBuilder
            while(scanner.hasNextLine()){
                //Read and append the current line to StringBuilder
                resultJson.append(scanner.nextLine());
            }

            //Close the Scanner to release resources associated with it
            scanner.close();

            return resultJson.toString();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpURLConnection fetchApiConnection(String urlString) {
        try {
            //Attempt to create connection
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //SET request method to "GET"
            conn.setRequestMethod("GET");

            return conn;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
