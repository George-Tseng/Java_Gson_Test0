package javaTest;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TestGson {
	public static void main(String[] args) {
		Gson gson0 = new Gson();
		
		/*寫入資料*/
		HDD hdd00 = new HDD(1, "WD1003FZEX", 3.5, "Black Label HDD", 7200, "Western Digital");
		HDD hdd01 = new HDD(2, "ST1000DX002", 3.5, "Firecuda SSHD", 7200, "Seagate");
		HDD hdd02 = new HDD(3, "WD10SPSX", 2.5, "Black Label Mobile HDD", 7200, "Western Digital");
		HDD hdd03 = new HDD(4, "ST1000LX015", 2.5, "Firecuda Mobile SSHD", 5400, "Seagate");
		HDD hdd04 = new HDD(5, "ST1000LM0049", 2.5, "Barracuda Pro Mobile HDD", 7200, "Seagate");
		HDD hdd05 = new HDD(6, "WD1005FBYZ", 3.5, "Gold Label Enterprise HDD", 7200, "Western Digital");
		HDD hdd06 = new HDD(7, "ST1000NM0008", 3.5, "ExOS 7E2 Enterprise HDD", 7200, "Seagate");
		HDD hdd07 = new HDD(8, "HUS722T1TALA604", 3.5, "UltraStar DC HA210 Enterprise HDD", 7200, "Western Digital");
		
		/*單項序列化*/
		String jsonString00 = gson0.toJson(hdd00);

		/*另一種寫法*/
		String jsonString01 = gson0.toJson(hdd01, HDD.class);

		/*印出結果*/
		System.out.println("jsonString00:"+jsonString00);
		System.out.println("jsonString01:"+jsonString01);

		/*產生陣列並寫入資料*/
		List<HDD> hddList0 = new ArrayList<HDD>();
		hddList0.add(hdd00);
		hddList0.add(hdd01);
		hddList0.add(hdd02);
		hddList0.add(hdd03);
		hddList0.add(hdd04);
		hddList0.add(hdd05);
		hddList0.add(hdd06);
		hddList0.add(hdd07);

		/*陣列序列化*/
		String jsonListString0 = gson0.toJson(hddList0);

		/*印出結果*/
		System.out.println("jsonListString0:"+jsonListString0);
		
		/*單項反序列化*/
		HDD testHdd00 = gson0.fromJson(jsonString00, HDD.class);
		/*印出結果*/
		System.out.println(testHdd00.toNormalString());
		
		/*陣列反序列化*/
		List<HDD> testHddList0 = gson0.fromJson(jsonListString0, new TypeToken<List<HDD>>() {}.getType());

		/*印出結果*/
		for(HDD testHdd: testHddList0) {
			System.out.println(testHdd.toNormalString());
		}
	}
}