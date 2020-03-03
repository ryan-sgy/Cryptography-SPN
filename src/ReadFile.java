import java.io.*;
import java.util.HashMap;

public class ReadFile {
    public  static int readM(String path) throws  IOException{
        int m = 0;
        try {
            File file = new File(path);
            InputStreamReader reader1 = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader1 = new BufferedReader(reader1);
            String lineText1 = null;
            lineText1 = bufferedReader1.readLine();
            lineText1 = bufferedReader1.readLine();
            m = Integer.parseInt(lineText1);
            bufferedReader1.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return m;
    }

    public static int[] readX(String path, int m) throws IOException{
        int[] plainText = new int[m];
        try {
            File file = new File(path);
            InputStreamReader reader2 = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader2 = new BufferedReader(reader2);
            String lineText2 = bufferedReader2.readLine();
            while(!lineText2.equals("Message(x):")){
                lineText2 = bufferedReader2.readLine();
            }
            lineText2 = bufferedReader2.readLine();
            String[] s = lineText2.split("");
            for(int i =0;i < m;i++) {
                plainText[i] = Integer.parseInt(s[i]);
            }
            bufferedReader2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return plainText;
    }

    public static int[][] readKey(String path)throws IOException {
        int [][] keyDict = new int[9][32];
        try{
            File file = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText = bufferedReader.readLine();
            while(!lineText.equals("Key:")) {
                lineText = bufferedReader.readLine();
            }
            for(int i = 0;i<9;i++) {
                lineText = bufferedReader.readLine();
                String[] s = lineText.split(",");
                for (int j = 0; j < 32; j++) {
                    keyDict[i][j] = Integer.parseInt(s[j]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return keyDict;
    }

    public static HashMap<Integer,Integer> readSbox(String path) throws IOException{
        HashMap<Integer,Integer> sBox = new HashMap<>();
        try{
            File file = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText = bufferedReader.readLine();
            while(!lineText.equals("S-box(function f):")){
                lineText = bufferedReader.readLine();
            }
            lineText = bufferedReader.readLine();
            while(!lineText.equals("Permutation:")){
                String[] s = lineText.split(",");
                sBox.put(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
                lineText = bufferedReader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sBox;
    }

    public static HashMap<Integer,Integer> readP(String path)throws IOException{
        HashMap<Integer,Integer> pDict = new HashMap<>();
        try {
            File file = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText = bufferedReader.readLine();
            while(!lineText.equals("Permutation:")){
                lineText = bufferedReader.readLine();
            }
            lineText = bufferedReader.readLine();
            while(!lineText.equals("a:")) {
                String[] s = lineText.split(",");
                pDict.put(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
                lineText = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pDict;
    }
    public static int readA(String path) throws IOException {
        int a = 0;
        try {
            File file = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText = bufferedReader.readLine();
            while (!lineText.equals("a:")) {
                lineText = bufferedReader.readLine();
            }
            lineText = bufferedReader.readLine();
            a = Integer.parseInt(lineText);
        }catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
}
