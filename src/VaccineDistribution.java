import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class VaccineDistribution {

	// To parse the object, add the attribute in the object
	public static void parseObject(JSONObject obj) {
		
		double latitude = Double.valueOf((String) obj.get("Latitude"));
		double longitude = Double.valueOf((String) obj.get("Longitude"));
		String nearestVaccinationCenter = NearestVaccinationCenter(latitude, longitude);
		obj.put("ClosestVaccinationCenter", nearestVaccinationCenter);

	}

	// calculate the distance for nearest Vaccination center
	public static String NearestVaccinationCenter(double latitude, double longitude) {

		double latGalwayRacecourse = 53.298810877564875;
		double longGalwayRacecourse = -8.997003657335881;

		double latCityHallCork = 51.89742637092438;
		double longCityHallCork = -8.465763459121026;

		double latCitywestConventionCentre = 53.28603418885669;
		double longCitywestConventionCentre = -6.4444477725802285;

		double distanceToGalwayRacecourse = CalculateDistance(Math.toRadians(latGalwayRacecourse),
				Math.toRadians(longGalwayRacecourse), Math.toRadians(latitude), Math.toRadians(longitude));
		

		double distanceToCityHallCork = CalculateDistance(Math.toRadians(latCityHallCork),
				Math.toRadians(longCityHallCork), Math.toRadians(latitude), Math.toRadians(longitude));
		

		double distanceToCitywestConventionCentreDublin = CalculateDistance(Math.toRadians(latCitywestConventionCentre),
				Math.toRadians(longCitywestConventionCentre), Math.toRadians(latitude), Math.toRadians(longitude));
		

		if (distanceToGalwayRacecourse <= distanceToCityHallCork
				&& distanceToGalwayRacecourse <= distanceToCitywestConventionCentreDublin)
			return "Galway Racecourse";

		else if (distanceToCityHallCork <= distanceToGalwayRacecourse
				&& distanceToCityHallCork <= distanceToCitywestConventionCentreDublin)
			return "City Hall Cork";

		else
			return "Citywest Convention Centre Dublin";

	}

	// calculate the Distance using Haversine's Formula
	public static double CalculateDistance(double centerLatRadian, double centerLongRadian, double latRadian,
			double longRadian) {

		double radiusOfEarth = 6371.009; // in Kilometers

		double calculation = Math.pow(Math.sin((latRadian - centerLatRadian) / 2), 2) + Math.cos(centerLatRadian)
				* Math.cos(latRadian) * Math.pow(Math.sin((longRadian - centerLongRadian) / 2), 2);

		return radiusOfEarth * 2 * Math.asin(Math.sqrt(calculation));

	}

	public static ArrayList<JSONObject> groupAndSort(JSONArray jsonArray) {
		ArrayList<JSONObject> list = new ArrayList<>();
		for (int i = 0; i < jsonArray.size(); i++) {
			list.add((JSONObject) jsonArray.get(i));

		}
		Collections.sort(list, new JSONComparatorAge());
		Collections.sort(list, new JSONComparatorCenter());

		return list;

	}

	public static void main(String[] args) throws FileNotFoundException {
		

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("./InputFiles/People.txt")) {
			// Read JSON File
			Object obj = jsonParser.parse(reader);
			JSONArray jsonArray = (JSONArray) obj;
			reader.close();
			jsonArray.stream().forEach(t -> parseObject((JSONObject) t));
			ArrayList<JSONObject> sortedList = groupAndSort(jsonArray);

			System.out.println("\n\nList is grouped by Closest Vaccination Center and sorted by Age \n\n");
			sortedList.forEach(t -> System.out.println("Name : " + t.get("Name") + "  " 
													  + "Age : " + t.get("Age")+ "  " 
													  + "Latitude : " + t.get("Latitude")+ ", " 
													  + "Longitude : " + t.get("Longitude") + " "
													  + "    ClosestVaccinationCenter : " + t.get("ClosestVaccinationCenter")));
			FileWriter writer = new FileWriter("./OutputFiles/SortedList.json");
			writer.write(sortedList.toString());
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
