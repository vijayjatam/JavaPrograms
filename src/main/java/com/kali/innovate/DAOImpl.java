package com.kali.innovate;

import com.kali.game.one.UtilClass;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DAOImpl implements DAOInterface {
    private Map<String,String> data;
    private Set<DTOClass> dtoList;
    @Override
    public Set<DTOClass> readExisted() {
        try {
            data = UtilClass.getExistedDataFromFile(new File("src/main/java/com/kali/innovate/database.txt"));
            if(data !=null && data.size() > 0) {
                dtoList = new HashSet<>();
                for (Map.Entry<String, String> entryMap : data.entrySet()) {
                    String passwordPhase = entryMap.getValue();
                    DTOClass dtoObject = new DTOClass();
                    dtoObject.setUserName(entryMap.getKey());
                    dtoObject.setPassword(passwordPhase.substring(0, passwordPhase.indexOf("#")));
                    dtoObject.setConnetedDevice(passwordPhase.substring(passwordPhase.indexOf("#")+1));
                    dtoList.add(dtoObject);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dtoList;
    }
}
