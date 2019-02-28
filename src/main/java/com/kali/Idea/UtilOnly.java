package com.kali.Idea;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class UtilOnly {
    private static Map<String,Map<String,Double>> finalMap = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        readData();
    }
    public static void readData() {
        Map<String,List<PersonDTO>> InvesterVsContributes = new ConcurrentHashMap<>();
        File file = new File("src/main/java/com/kali/Idea/database.txt");
        if(file.exists()){
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file)));
                String inputLine;
                PersonDTO personDTO;

                while ((inputLine = br.readLine()) != null) {
                    if(inputLine.length() != 0) {
                        personDTO = new PersonDTO();
                        String investerName = inputLine.substring(0,inputLine.indexOf("#D#"));
                        String description = inputLine.substring(inputLine.indexOf("#D#")+3,inputLine.indexOf("#W#"));
                        List<String> contributeOn = Arrays.asList(inputLine.substring(inputLine.indexOf("#W#")+3,inputLine.indexOf("#M#")).split(","));
                        double money = Double.parseDouble(inputLine.substring(inputLine.indexOf("#M#")+3,inputLine.indexOf("#P#")));
                        double perHead = money / (contributeOn.size()+1);//Double.parseDouble(inputLine.substring(inputLine.indexOf("#P#")+3,inputLine.length()));
                        Map<String,Double> personVsperHead = convertListToMap(contributeOn,perHead);

                        personDTO.setPaidPerson(investerName);
                        personDTO.setDescription(description);
                        personDTO.setContributedList(personVsperHead);
                        personDTO.setTotalMoney(money);
                        personDTO.setPerHeadMoney(perHead);
                        List<PersonDTO> listDTOs;
                        if(InvesterVsContributes!=null &&InvesterVsContributes.size()>0
                                &&InvesterVsContributes.get(investerName)!=null){
                            listDTOs = InvesterVsContributes.get(investerName);
                            listDTOs.add(personDTO);
                        } else{
                            listDTOs = new ArrayList<>();
                            listDTOs.add(personDTO);
                        }
                        InvesterVsContributes.put(investerName,listDTOs);
                    }
                }
                System.out.println();
                mappingData(InvesterVsContributes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void mappingData(Map<String,List<PersonDTO>> InvesterVsContributes){
        int countOfPPL = 1;
        for (Map.Entry<String,List<PersonDTO>> entry : InvesterVsContributes.entrySet()){
            List<PersonDTO> listDTOs = entry.getValue();
            Map<String,Double> outerMap = new ConcurrentHashMap<>();
            for (PersonDTO personDTO : listDTOs) {
                Map<String,Double> innerMap = personDTO.getContributedList();
                for (Map.Entry<String,Double> innerEntry : innerMap.entrySet()){
                    Double perHead = new Double("0");
                    if(outerMap!=null&&outerMap.size()>0&&outerMap.get(innerEntry.getKey())!=null){
                        perHead = outerMap.get(innerEntry.getKey())+innerEntry.getValue();

                    }else {
                        perHead = innerEntry.getValue();
                    }
                    outerMap.put(innerEntry.getKey(),perHead);
                }
            }
            finalMap.put(entry.getKey(),outerMap);
        }
        for(Map.Entry<String,Map<String,Double>> entry : finalMap.entrySet()){
            String paidPerson = entry.getKey();
            Map<String,Double> outerMap = entry.getValue();
            for(Map.Entry<String,Double> innerEntry : outerMap.entrySet()){
                Double innerPersonMoney = innerEntry.getValue();
                Map<String,Double> notPaidPersons = new ConcurrentHashMap<>();
                if(finalMap.get(innerEntry.getKey())!=null && finalMap.get(innerEntry.getKey()).containsKey(paidPerson)){
                    Double outerPersonMonney = finalMap.get(innerEntry.getKey()).get(paidPerson);
                    if(innerPersonMoney > outerPersonMonney){
                        innerPersonMoney = innerPersonMoney - outerPersonMonney;
                        outerMap.put(innerEntry.getKey(),innerPersonMoney);
                        finalMap.get(innerEntry.getKey()).put(paidPerson,new Double("0"));
                    } else {
                        outerPersonMonney = outerPersonMonney - innerPersonMoney;
                        finalMap.get(innerEntry.getKey()).put(paidPerson,outerPersonMonney);
                        outerMap.put(innerEntry.getKey(),new Double("0"));
                    }
                } else if(finalMap.get(innerEntry.getKey())==null){
                    notPaidPersons.put(paidPerson,new Double("0"));
                    finalMap.put(innerEntry.getKey(),notPaidPersons);
                } else {
                    notPaidPersons = finalMap.get(innerEntry.getKey());
                    notPaidPersons.put(paidPerson,new Double("0"));
                    finalMap.put(innerEntry.getKey(),notPaidPersons);
                }
            }
        }
        System.out.println(finalMap);
    }
    public static Map<String,Double> convertListToMap(List<String> contributers,double perHead){
        Map<String, Double> map = contributers.stream().distinct().collect(Collectors.toMap(s->s,p -> Double.valueOf(perHead)));
        /*for(String name : contributers){
            map.put(name,Double.valueOf(perHead));
        }*/
        return map;
    }
}
