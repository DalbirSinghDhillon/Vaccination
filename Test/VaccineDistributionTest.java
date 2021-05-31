import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VaccineDistributionTest {

	@Test
	void testCalculateDistance() {
		double output = VaccineDistribution.CalculateDistance(53.298810877564875, -8.997003657335881, 53.09402405506328,
				-8.020019531250002);
		assertEquals(6201.549611856248, output, 0); // 0 here denotes how much error it can tolerate

	}

	@Test
	void testNearestVaccinationCenter() {
		String output = VaccineDistribution.NearestVaccinationCenter(53.09402405506328, -8.020019531250002);
		assertEquals("Galway Racecourse", output);
	}
}
