package javaTest;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class File_Conf {
    /*固定來源檔路徑*/
    private final static File sourceF = new File("data/HDD_Data_Origin.csv");
    /*固定輸出檔路徑*/
    private final static File resultF = new File("data/HDD_Data.json");

    /**
     * 寫入輸出檔
     *
     * @param Data 產生的JSON資訊(String)
     *
     * @return 狀態值，正常執行時會回傳空字串(String)
     *
     * @see FileOutputStream
     * @see OutputStreamWriter
     * @see StandardCharsets
     * @see IOException
     */
    /*寫入輸出檔*/
    protected static String writeResultFile(String Data){
        FileOutputStream fos0;
        OutputStreamWriter osw0;
        String result = "";

        try{
            fos0 = new FileOutputStream(resultF);
            osw0 = new OutputStreamWriter(fos0, StandardCharsets.UTF_8);

            osw0.write(Data);
            osw0.flush();
            fos0.close();
            osw0.close();
        } catch(IOException IOE){
            result = IOE.toString();
        }
        return result;
    }

    /**
     * 讀取輸出檔
     *
     * @return 狀態值，正常執行時會回傳非空字串，即為檔案內容(String)
     *
     * @see FileOutputStream
     * @see OutputStreamWriter
     * @see StandardCharsets
     * @see StringBuilder
     * @see IOException
     */
    /*讀取輸出檔*/
    protected static String readResultFile(){
        FileInputStream fis0;
        InputStreamReader isr0;
        int count;
        String result = "";

        try{
            fis0 = new FileInputStream(resultF);
            isr0 = new InputStreamReader(fis0, StandardCharsets.UTF_8);
            StringBuilder sb0 = new StringBuilder();

            while((count = isr0.read()) != -1){
                char inputChar = (char)count;
                sb0.append(inputChar);
            }

            result = sb0.toString();
            fis0.close();
            isr0.close();
        } catch(IOException IOE){
            System.out.println(IOE.toString());
        }
        return result;
    }

    /**
     * 寫入來源檔
     *
     * @param Data 產生的原始資訊(String)
     *
     * @return 狀態值，正常執行時會回傳空字串(String)
     *
     * @see FileOutputStream
     * @see OutputStreamWriter
     * @see StandardCharsets
     * @see IOException
     */
    /*寫入來源檔*/
    protected static String writeSourceFile(String Data){
        FileOutputStream fos0;
        OutputStreamWriter osw0;
        String result = "";

        try{
            fos0 = new FileOutputStream(sourceF);
            osw0 = new OutputStreamWriter(fos0, StandardCharsets.UTF_8);

            osw0.write(Data);
            osw0.flush();
            fos0.close();
            osw0.close();
        } catch(IOException IOE){
            result = IOE.toString();
        }
        return result;
    }

    /**
     * 讀取來源檔
     *
     * @return 狀態值，正常執行時會回傳非空字串，即為檔案內容(String)
     *
     * @see FileOutputStream
     * @see OutputStreamWriter
     * @see StandardCharsets
     * @see StringBuilder
     * @see IOException
     */
    /*讀取來源檔*/
    protected static String readSourceFile(){
        FileInputStream fis0;
        InputStreamReader isr0;
        int count;
        String result = "";

        try{
            fis0 = new FileInputStream(sourceF);
            isr0 = new InputStreamReader(fis0, StandardCharsets.UTF_8);
            StringBuilder sb0 = new StringBuilder();

            while((count = isr0.read()) != -1){
                char inputChar = (char)count;
                sb0.append(inputChar);
            }

            result = sb0.toString();
            fis0.close();
            isr0.close();
        } catch(IOException IOE){
            System.out.println(IOE.toString());
        }
        return result;
    }

    /**
     * 確認輸出檔是否存在
     *
     * @return true代表輸出檔案存在
     *
     * @see File#exists()
     */
    /*確認輸出檔是否存在*/
    protected static boolean checkResultFile() {
        return resultF.exists();
    }

    /**
     * 確認輸出檔是否存在
     *
     * @return true代表來源檔案存在
     *
     * @see File#exists()
     */
    /*確認輸出檔是否存在*/
    protected static boolean checkSourceFile() {
        return sourceF.exists();
    }
}
