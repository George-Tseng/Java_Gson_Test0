package javaTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GsonInputJson {
	public static void main(String[] args) {
		/*先檢查檔案是否存在*/
		if(File_Conf.checkResultFile()){
			/*嘗試開檔*/
			if(File_Conf.readResultFile().equals("")){
				System.out.println("開啟檔案失敗！程式已終止...");
			}
			/*成功*/
			else{
				System.out.println("開啟檔案成功！開始載入資料...");

				/*生成Gson物件*/
				Gson gson0 = new Gson();

				/*將讀取的內容轉為String*/
				String jsonListString0 = File_Conf.readResultFile();

				/*陣列反序列化*/
				List<HDD> testHddList0 = gson0.fromJson(jsonListString0, new TypeToken<List<HDD>>() {}.getType());

				StringBuilder sb0 = new StringBuilder();
				sb0.append("id,productID,size,productName,hddRPM,company" + System.lineSeparator());

				/*印出結果*/
				for(int i = 0; i < testHddList0.size(); i++) {
					System.out.println(testHddList0.get(i).toNormalString());
					String[] hddInfo = testHddList0.get(i).toNormalString().split(",");
					for(int j = 0; j < hddInfo.length; j++){
						String[] hddDetail = hddInfo[j].split(":");
						sb0.append(hddDetail[1]);
						if(j < hddInfo.length - 1){
							sb0.append(",");
						}
					}
					sb0.append(System.lineSeparator());
				}

				/*輸出成檔案*/
				if(!File_Conf.writeSourceFile(sb0.toString()).equals("")){
					System.out.println("操作失敗！錯誤資訊為：" + System.lineSeparator() + File_Conf.writeSourceFile(sb0.toString()).equals(""));
				}
				/*成功*/
				else{
					System.out.println("成功輸出原始資料...");
				}
			}
		}
		/*不存在*/
		else{
			System.out.println("目標檔案不存在！無法進行解析...");
		}
	}
}
