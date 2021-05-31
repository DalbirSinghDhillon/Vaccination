import java.util.Comparator;

import org.json.simple.JSONObject;

public class JSONComparatorAge implements Comparator<JSONObject> {

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		// TODO Auto-generated method stub

		Long v1 = (Long) (o1.get("Age"));
		Long v3 = (Long) (o2.get("Age"));
		return v1.compareTo(v3);

	}

}
