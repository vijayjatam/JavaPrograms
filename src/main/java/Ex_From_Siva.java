import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by mpalavelli on 25-08-2017.
 */
public class Ex_From_Siva {
    private final static Map<String, String> maleDemographicCodes= new HashMap<>();
    private final static Map<String, String> femaleDemographicCodes= new HashMap<>();
    private final static Map<String, String> personDemographicCodes= new HashMap<>();

    static{
        //Female demographic codes
        femaleDemographicCodes.put("13-17","1000");
        femaleDemographicCodes.put("18-20","1003");
        femaleDemographicCodes.put("21-24","1004");
        femaleDemographicCodes.put("25-29","1005");
        femaleDemographicCodes.put("30-34","1006");
        femaleDemographicCodes.put("35-39","1007");
        femaleDemographicCodes.put("40-44","1008");
        femaleDemographicCodes.put("45-49","1009");
        femaleDemographicCodes.put("50-54","1010");
        femaleDemographicCodes.put("55-64","1011");
        femaleDemographicCodes.put("65","1012");
        femaleDemographicCodes.put("2-12","1013");

        //male demographic codes
        maleDemographicCodes.put("13-17","2000");
        maleDemographicCodes.put("2-11","2001");
        maleDemographicCodes.put("12-17","2002");
        maleDemographicCodes.put("18-20","2003");
        maleDemographicCodes.put("21-24","2004");
        maleDemographicCodes.put("25-29","2005");
        maleDemographicCodes.put("30-34","2006");
        maleDemographicCodes.put("35-39","2007");
        maleDemographicCodes.put("40-44","2008");
        maleDemographicCodes.put("45-49","2009");
        maleDemographicCodes.put("50-54","2010");
        maleDemographicCodes.put("55-64","2011");
        maleDemographicCodes.put("65","2012");
        maleDemographicCodes.put("2-12","2013");
    }
    private static String getDemographicCodesByDemostring(String demoString) {
        int startIndex = Integer.parseInt(demoString.substring(1,demoString.indexOf("-")));
        int endIndex = Integer.parseInt(demoString.substring(demoString.indexOf("-")+1,demoString.length()));
        StringBuilder sb = new StringBuilder();
        if(demoString.startsWith("P")||demoString.startsWith("p")) {
            for (int index = startIndex; index <= endIndex; index = index + 5) {
                sb.append(femaleDemographicCodes.get(String.valueOf(index) + "-" + String.valueOf(index + 4)) + ",");
                sb.append(maleDemographicCodes.get(String.valueOf(index) + "-" + String.valueOf(index + 4)) + ",");
            }
        }else if (demoString.startsWith("F")||demoString.startsWith("f")){
            sb.append(femaleDemographicCodes.get(String.valueOf(startIndex) + "-" + String.valueOf(endIndex)));
        }else {
            sb.append(maleDemographicCodes.get(String.valueOf(startIndex) + "-" + String.valueOf(endIndex)));
        }
        String str = new String(new String(sb).replaceAll(",$", ""));
        str = stringSorting(str);
        return str;
    }

    public static void main(String[] args) {
       // System.out.println(getDemographicCodesByDemostring("P25-49"));
        File file = new File("D:\\FileforAdd.txt");
        addFileData(file);
    }
    public static String stringSorting(String unSorted){
        StringBuilder sb = new StringBuilder();
        if(unSorted.indexOf(",")>0){
            List<String> list = Arrays.asList(unSorted.split(","));
            Collections.sort(list);
            for(String str : list){
                sb.append(str+",");
            }
            return new String(new String(sb).replaceAll(",$", ""));
        }
        else {
            return null;
        }
    }

    public static void addFileData(File file){
        BigInteger bigInteger = new BigInteger("0");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                bigInteger = bigInteger.add(new BigInteger(inputLine));
            }
            System.out.println(bigInteger);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
