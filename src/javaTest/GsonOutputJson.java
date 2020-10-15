package javaTest;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class GsonOutputJson {
	public static void main(String[] args) {
		/*有無資料*/
		boolean hasData = true;

		/*生成Gson物件*/
		Gson gson0 = new Gson();

		/*產生陣列並準備寫入資料*/
		List<HDD> hddList0 = new ArrayList<HDD>();

		/*先檢查檔案是否存在*/
		if(File_Conf.checkSourceFile()){
			/*嘗試讀檔*/
			if(File_Conf.readSourceFile().equals("")){
				System.out.println("開啟檔案失敗！將自行產生資料...");
				hasData = false;
			}
			/*成功*/
			else{
				System.out.println("開啟檔案成功！開始載入資料...");

				/*將讀取的內容轉為String*/
				String allData = File_Conf.readSourceFile();

				/*將內容拆成一行一行*/
				String [] dataLine = allData.split(System.lineSeparator());

				for(int i = 1; i < dataLine.length; i++){
					String [] hddInfo = dataLine[i].split(",");
					hddList0.add(new HDD(Integer.parseInt(hddInfo[0]), hddInfo[1], Double.parseDouble(hddInfo[2]), hddInfo[3], Integer.parseInt(hddInfo[4]), hddInfo[5]));
				}
			}
		}
		/*不存在*/
		else{
			System.out.println("來源檔案不存在！將自行產生資料...");
			hasData = false;
		}

		/*沒有從檔案讀到資料*/
		if(!hasData){
			hddList0.add(new HDD(1, "WD1003FZEX", 3.5, "Black Label HDD", 7200, "Western Digital"));
			hddList0.add(new HDD(2, "ST1000DX002", 3.5, "Firecuda SSHD", 7200, "Seagate"));
			hddList0.add(new HDD(3, "WD10SPSX", 2.5, "Black Label Mobile HDD", 7200, "Western Digital"));
			hddList0.add(new HDD(4, "ST1000LX015", 2.5, "Firecuda Mobile SSHD", 5400, "Seagate"));
			hddList0.add(new HDD(5, "ST1000LM0049", 2.5, "Barracuda Pro Mobile HDD", 7200, "Seagate"));
			hddList0.add(new HDD(6, "WD1005FBYZ", 3.5, "Gold Label Enterprise HDD", 7200, "Western Digital"));
			hddList0.add(new HDD(7, "ST1000NM0008", 3.5, "ExOS 7E2 Enterprise HDD", 7200, "Seagate"));
			hddList0.add(new HDD(8, "HUS722T1TALA604", 3.5, "UltraStar DC HA210 Enterprise HDD", 7200, "Western Digital"));
		}
		
		/*陣列序列化*/
		String jsonListString0 = gson0.toJson(hddList0);

		/*印出結果*/
		System.out.println("json化後的資訊為:" + System.lineSeparator() + jsonListString0);
		
		/*輸出成檔案*/
		if(!File_Conf.writeResultFile(jsonListString0).equals("")) {
			System.out.println("發生錯誤！錯誤資訊為：" + System.lineSeparator() + File_Conf.writeResultFile(jsonListString0));
		}
		/*成功*/
		else {
			System.out.println("完成檔案的輸出...");
		}
	}
}
