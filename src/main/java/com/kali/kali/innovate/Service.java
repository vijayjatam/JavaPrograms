package com.kali.kali.innovate;

import com.kali.innovate.DAOImpl;
import com.kali.innovate.DAOInterface;
import com.kali.innovate.DTOClass;
import com.kali.innovate.UClient;
import com.kali.innovate.UtilOnly;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.kali.innovate.UtilOnly.covertToMorse;

public class Service {
    private static String pattern = UtilOnly.getPattern();
    private static String connectedInfo;
    private static DTOClass dtoObject;
    public int verify(String userName,String password){
        int flag =0;
        StringBuffer finalMorseCode = new StringBuffer();
        String uiEncrption = getMorseCode(userName,password);
        String dbEncrption = getDBData(userName,password);
        if(uiEncrption.equalsIgnoreCase(dbEncrption)) {
            UClient.createConnection(dtoObject, connectedInfo);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter code...! ");
            String clientCode = scan.nextLine();
            flag =  dtoObject.getMorseCode().equalsIgnoreCase(UtilOnly.covertToMorse(clientCode))?0:2;
        } else {
            flag = 1;
        }
        return flag;
    }
    public String getMorseCode(String userName, String password){
        StringBuffer finalMorseCode = new StringBuffer("");
        if(userName!=null && password!=null) {
            finalMorseCode.append(covertToMorse(String.valueOf(userName.charAt(Integer.parseInt(String.valueOf(pattern.charAt(0))) % userName.length()))));
            finalMorseCode.append(" ");
            finalMorseCode.append(covertToMorse(String.valueOf(userName.charAt(Integer.parseInt(String.valueOf(pattern.charAt(1))) % userName.length()))));
            finalMorseCode.append(" ");
            finalMorseCode.append(covertToMorse(String.valueOf(password.charAt(Integer.parseInt(String.valueOf(pattern.charAt(2))) % password.length()))));
            finalMorseCode.append(" ");
            finalMorseCode.append(covertToMorse(String.valueOf(password.charAt(Integer.parseInt(String.valueOf(pattern.charAt(3))) % password.length()))));
        }
        return finalMorseCode.toString();
    }
    public String getDBData(String userName, String password){
        DAOInterface daoInterface = new DAOImpl();
        Set<DTOClass> dtoList = daoInterface.readExisted();
        Predicate<DTOClass> filter = (d) -> d.getUserName().equalsIgnoreCase(userName)&&d.getPassword().equalsIgnoreCase(password);

        try {
            Optional<DTOClass> dbData = dtoList.stream().filter(filter).findFirst();
            dtoObject = dbData.get();
        } catch (NoSuchElementException nsee){
            dtoObject = new DTOClass();
        }
        connectedInfo = dtoObject.getConnetedDevice();
        return getMorseCode(dtoObject.getUserName(),dtoObject.getPassword());
    }
}
