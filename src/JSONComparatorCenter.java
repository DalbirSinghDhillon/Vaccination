import java.util.Comparator;

import org.json.simple.JSONObject;

public class JSONComparatorCenter implements Comparator<JSONObject> {

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		// TODO Auto-generated method stub

		String v1 = (String) (o1.get("ClosestVaccinationCenter"));
		String v3 = (String) (o2.get("ClosestVaccinationCenter"));
		return v1.compareTo(v3);

		/*
		 * System.out.println("from compare    "+o1.get("ClosestVaccinationCenter").
		 * getClass()); return 1;
		 */
	}

}
