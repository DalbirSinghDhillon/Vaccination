import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

class VaccineDistributionIntegrationTest {

	@Test
	void test() throws IOException, ParseException {
		
			String alreadySortedList = "[{\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.32640034531732\",\"Longitude\":\"-9.330507216517065\",\"Age\":19,\"Name\":\"Kina Clarke\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.161129420392996\",\"Longitude\":\"-8.756068149165229\",\"Age\":21,\"Name\":\"Bruna Ton\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"51.73179954429017\",\"Longitude\":\"-8.872671965863201\",\"Age\":27,\"Name\":\"Pa Sheckler\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.495270066269185\",\"Longitude\":\"-7.295747147257919\",\"Age\":31,\"Name\":\"Eda Gorby\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.410916007245454\",\"Longitude\":\"-8.85988243844568\",\"Age\":45,\"Name\":\"Kirstie Mcneece\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.339088032060765\",\"Longitude\":\"-7.974000437248384\",\"Age\":45,\"Name\":\"Keva Lohse\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.21628813045871\",\"Longitude\":\"-9.095194827481372\",\"Age\":48,\"Name\":\"Page Bermea\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"51.90566326251937\",\"Longitude\":\"-8.956775775107436\",\"Age\":55,\"Name\":\"Mabelle Deakins\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.28408186101206\",\"Longitude\":\"-9.648871036977118\",\"Age\":59,\"Name\":\"Tiffani O'Reilly\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.05486256870476\",\"Longitude\":\"-9.344349121754458\",\"Age\":59,\"Name\":\"Irwin Juneau\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.44467704112486\",\"Longitude\":\"-8.077814793170662\",\"Age\":61,\"Name\":\"Suk Mccright\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"51.743112417921374\",\"Longitude\":\"-8.936012917251347\",\"Age\":63,\"Name\":\"Henriette Fitts\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.34331644285846\",\"Longitude\":\"-9.192088098139026\",\"Age\":68,\"Name\":\"Tandy Creegan\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.30947784015802\",\"Longitude\":\"-8.091656698408055\",\"Age\":69,\"Name\":\"Kendal Boltz\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.27984782255751\",\"Longitude\":\"-9.205930070018244\",\"Age\":70,\"Name\":\"Marianna Strader\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.43623920881322\",\"Longitude\":\"-9.060589998383787\",\"Age\":70,\"Name\":\"Porter Wiemann\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"52.29678168165427\",\"Longitude\":\"-9.226692861232511\",\"Age\":71,\"Name\":\"Eden Polston\"}, {\"ClosestVaccinationCenter\":\"City Hall Cork\",\"Latitude\":\"51.927007877958104\",\"Longitude\":\"-9.538135795077968\",\"Age\":72,\"Name\":\"Yu Northam\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.11863254296309\",\"Longitude\":\"-6.942778563704384\",\"Age\":20,\"Name\":\"John Oehler\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"52.63830130844275\",\"Longitude\":\"-6.603651885388238\",\"Age\":20,\"Name\":\"Brittney Eakle\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.96987157268892\",\"Longitude\":\"-7.6833204272631175\",\"Age\":22,\"Name\":\"Sima Haymon\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.135244045893096\",\"Longitude\":\"-7.392640417277852\",\"Age\":22,\"Name\":\"Cecile Olea\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"52.42779977379135\",\"Longitude\":\"-6.569047122294754\",\"Age\":23,\"Name\":\"Arthur Schepis\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"54.1526632034115\",\"Longitude\":\"-6.915094753229597\",\"Age\":24,\"Name\":\"Delila Hollaway\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.33821430342904\",\"Longitude\":\"-7.6902414458859205\",\"Age\":24,\"Name\":\"Dung Chesser\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"52.59207753424467\",\"Longitude\":\"-6.9358576110856855\",\"Age\":29,\"Name\":\"Marylyn Welle\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.91283890397367\",\"Longitude\":\"-7.0535137389617075\",\"Age\":34,\"Name\":\"Danica Rosati\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.089546943013005\",\"Longitude\":\"-7.697162332500511\",\"Age\":35,\"Name\":\"Jacquelin Luster\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"54.01869466415213\",\"Longitude\":\"-7.378798536592707\",\"Age\":36,\"Name\":\"Winter Bergman\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.79445163520835\",\"Longitude\":\"-7.551822327507879\",\"Age\":36,\"Name\":\"Jason Mcvay\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.39090261307827\",\"Longitude\":\"-7.063240487792548\",\"Age\":38,\"Name\":\"Sherise Hambly\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.67982871947617\",\"Longitude\":\"-6.382181334948116\",\"Age\":38,\"Name\":\"Marguerita Brittian\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.98208271629691\",\"Longitude\":\"-7.704083285119208\",\"Age\":40,\"Name\":\"Ilse Luebke\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.69212470034142\",\"Longitude\":\"-7.413403275133943\",\"Age\":42,\"Name\":\"Marge Hatten\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"52.96467152455411\",\"Longitude\":\"-7.697162332500511\",\"Age\":42,\"Name\":\"Ermelinda Donlon\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.10201460568079\",\"Longitude\":\"-6.236841329955483\",\"Age\":44,\"Name\":\"Rochel Hardrick\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"52.53627304145948\",\"Longitude\":\"-6.822509765625001\",\"Age\":47,\"Name\":\"Sebastian Gerth\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.93321663808781\",\"Longitude\":\"-7.136565236390174\",\"Age\":51,\"Name\":\"Margarito Bundren\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.23477831692155\",\"Longitude\":\"-7.281905175378703\",\"Age\":54,\"Name\":\"Arnoldo Rucks\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.52376867470518\",\"Longitude\":\"-7.586427090601362\",\"Age\":55,\"Name\":\"Emmaline Beverlin\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.85164590770672\",\"Longitude\":\"-6.942778521614808\",\"Age\":58,\"Name\":\"Hiedi Pasternak\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.818973032130444\",\"Longitude\":\"-6.347576571854631\",\"Age\":58,\"Name\":\"Tobie Steffens\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.94136499103616\",\"Longitude\":\"-7.136565237027894\",\"Age\":59,\"Name\":\"Cora Jahns\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.31754715782852\",\"Longitude\":\"-7.510296611795698\",\"Age\":59,\"Name\":\"Xenia Noto\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.904685014071774\",\"Longitude\":\"-7.2888261279974\",\"Age\":63,\"Name\":\"Leon Luppino\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.33589589194191\",\"Longitude\":\"-6.296082599573021\",\"Age\":63,\"Name\":\"Lindy Gerke\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.60597741344063\",\"Longitude\":\"-6.271446093048965\",\"Age\":67,\"Name\":\"Pa Sheckler\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"54.04308476487112\",\"Longitude\":\"-7.63487375893224\",\"Age\":69,\"Name\":\"Ezequiel Hepfer\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.72489643194486\",\"Longitude\":\"-7.537980422270485\",\"Age\":70,\"Name\":\"Christiane Aubuchon\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.367131555977366\",\"Longitude\":\"-7.551822327507879\",\"Age\":71,\"Name\":\"Bj�rk Gu�mundsd�ttir\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"52.83525354194617\",\"Longitude\":\"-6.610572771365111\",\"Age\":71,\"Name\":\"Talitha Laird\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.99835867444377\",\"Longitude\":\"-7.503375659177001\",\"Age\":71,\"Name\":\"Keith Merlin\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"52.96174013198847\",\"Longitude\":\"-7.289577755453199\",\"Age\":75,\"Name\":\"Jetta Twomey\"}, {\"ClosestVaccinationCenter\":\"Citywest Convention Centre Dublin\",\"Latitude\":\"53.810800826759106\",\"Longitude\":\"-6.513679434703355\",\"Age\":75,\"Name\":\"Jamaal Tutor\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.39190213695199\",\"Longitude\":\"-8.174708063190593\",\"Age\":20,\"Name\":\"Rosalinda Eusebio\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.57722252951432\",\"Longitude\":\"-9.55197763431126\",\"Age\":23,\"Name\":\"Georgeann Kowalczyk\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.13644761914938\",\"Longitude\":\"-9.48968906074299\",\"Age\":25,\"Name\":\"Lorri Currey\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"52.914620090650814\",\"Longitude\":\"-8.562281409837615\",\"Age\":27,\"Name\":\"Diana Strassburg\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.06769454247903\",\"Longitude\":\"-8.66817747665899\",\"Age\":29,\"Name\":\"Clark Ospina\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.80262702783318\",\"Longitude\":\"-9.392795724081234\",\"Age\":30,\"Name\":\"Christopher Deveau\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.69212470034142\",\"Longitude\":\"-9.475847155505596\",\"Age\":31,\"Name\":\"Janella Rabalais\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.542786433740105\",\"Longitude\":\"-9.585872216446724\",\"Age\":39,\"Name\":\"Celinda Hamilton\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"52.72221951273094\",\"Longitude\":\"-9.295902453423581\",\"Age\":43,\"Name\":\"Lindy Gerke\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.89830497300189\",\"Longitude\":\"-8.116737588176672\",\"Age\":45,\"Name\":\"Toni Appleby\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.659327411269004\",\"Longitude\":\"-8.458467186561265\",\"Age\":46,\"Name\":\"Luci Force\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.05121158803821\",\"Longitude\":\"-8.576123381079112\",\"Age\":47,\"Name\":\"Howard Encarnacion\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.10805506237944\",\"Longitude\":\"-7.724846167527548\",\"Age\":51,\"Name\":\"Rod Suter\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.83122835258862\",\"Longitude\":\"-7.8701861479679325\",\"Age\":54,\"Name\":\"Cristine Kravetz\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.08954691537851\",\"Longitude\":\"-8.472309091798659\",\"Age\":55,\"Name\":\"Mavis Unzueta\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.88775482346\",\"Longitude\":\"-8.167787110571897\",\"Age\":56,\"Name\":\"Neoma Leong\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.12022569047719\",\"Longitude\":\"-8.756068083161125\",\"Age\":58,\"Name\":\"Carma Tirrell\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.09402405506328\",\"Longitude\":\"-8.020019531250002\",\"Age\":59,\"Name\":\"Tayna Durr\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.96729206495634\",\"Longitude\":\"-7.856344242730539\",\"Age\":59,\"Name\":\"Nilsa Marcus\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"52.75800064780398\",\"Longitude\":\"-9.124967235028667\",\"Age\":60,\"Name\":\"Larhonda Clutter\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.941364984621565\",\"Longitude\":\"-8.776830941017217\",\"Age\":61,\"Name\":\"Janel Laubscher\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.10201460568079\",\"Longitude\":\"-8.326969020801922\",\"Age\":62,\"Name\":\"Arlen Turpin\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.91283889073915\",\"Longitude\":\"-7.738688072764941\",\"Age\":63,\"Name\":\"Chris Hegwood\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.9291419086983\",\"Longitude\":\"-7.7248461429753\",\"Age\":63,\"Name\":\"Priscilla Lampert\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"53.00633546237756\",\"Longitude\":\"-8.589988238739855\",\"Age\":67,\"Name\":\"Londa Feld\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.20531997935034\",\"Longitude\":\"-9.517372871217775\",\"Age\":68,\"Name\":\"Margarite Macdougall\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.30235644330621\",\"Longitude\":\"-8.292364324350263\",\"Age\":71,\"Name\":\"Bobbi Byerley\"}, {\"ClosestVaccinationCenter\":\"Galway Racecourse\",\"Latitude\":\"54.74818594314777\",\"Longitude\":\"-8.126261419411966\",\"Age\":73,\"Name\":\"Cherlyn Heuser\"}]";
		
		    VaccineDistribution vd = new VaccineDistribution();
		
		    FileReader reader = new FileReader("./InputFiles/People.txt");
		    assertEquals(true,reader!=null); //file is found 
			
		    JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(reader);
			JSONArray jsonArray = (JSONArray) obj;
			reader.close();
			
			jsonArray.stream().forEach(t -> vd.parseObject((JSONObject) t));
			ArrayList<JSONObject> sortedList = vd.groupAndSort(jsonArray);
			assertEquals(true,sortedList.toString().equals(alreadySortedList));
			//checks list is sorted correctly
			
			FileWriter writer = new FileWriter("./OutputFiles/SortedList.json");
			File checkFile = new File("./OutputFiles/SortedList.json");
			assertEquals(true,checkFile.exists());  //checks file is created
			
			writer.close();

	}

}