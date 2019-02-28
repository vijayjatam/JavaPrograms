package com.kali.sg;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Program_6 {
	public static void main(String[] args) {
	    String[] strArray = new String[]{ "kali[]","[()[]]","[([]([])[]))", "[()[([])]]", "[(])", "[(((jjj])))[]","(jsak)ghjgj[kjkjj(oiu(0)khjh)cffdfd]lkju"};
        Arrays.asList(strArray).stream().forEach(str->System.out.println(str+" -> checkType3 "+checkType_3(str)));
	    /*for(String str : strArray)
		    System.out.println(str+" -> checkType3 "+checkType_3(str));*/
	}
	public static boolean checkType_1(String str){
		boolean flag = false;
		for(int i=0;i<=str.length()/2;){
			flag = false;
			int num = (int)str.charAt(i);
			int lastNum = (int)str.charAt(str.length()-(1+i));
			
			if(num==41 || num==93){
				break;
			}
			
			if((num==40&&((num+1)==(int)str.charAt(i+1))) || (num==91&&((num+2)==(int)str.charAt(i+1)))){
				flag = true;
				i=i+2;
			}
			else if((num==40&&((num+1)==lastNum)) || (num==91&&((num+2)==lastNum))){
				flag = true;
				i++;
			}
			else{
				for(int j=str.length()-(1+i);j>i;j--){
					if(flag)
						break;
					lastNum = (int)str.charAt(j);
					if((num==40&&((num+1)==lastNum)) || (num==91&&((num+2)==lastNum))){
						flag = true;
					}
				}
				i++;
			}
		}
		return flag;
	}

    public static boolean checkType_2(String str){
        boolean flag = false;
        List list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            int charAnsii = (int) str.charAt(i);
            if (charAnsii==40 || charAnsii==91){
                list.add(charAnsii);
            }
            else{
                int selectedChar = (int) list.get(list.size()-1);
                if((selectedChar==40 && charAnsii==41) || (selectedChar==91 && charAnsii==93)){
                    flag = true;
                    list.remove(list.size()-1);
                }
                else if((selectedChar==40 && charAnsii==93) || (selectedChar==91 && charAnsii==41)){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean checkType_3(String str){
        String openSymbol=null;
        List<String> openSymbolsList = new CopyOnWriteArrayList<String>();
        Map<String,String> symbolsMap = new HashMap<String,String>(){{
            put("[","]");
            put("(",")");
        }};
        if(symbolsMap.containsValue(String.valueOf(str.charAt(0)))){
            return false;
        }
        for(int index=0;index<str.length();index++){
            openSymbol = String.valueOf(str.charAt(index));
            if(openSymbolsList!=null&&openSymbolsList.size()>0&&!symbolsMap.containsKey(openSymbol)){
                if(openSymbol.equalsIgnoreCase(symbolsMap.get(openSymbolsList.get(openSymbolsList.size()-1)))){
                    openSymbolsList.remove(openSymbolsList.size()-1);
                    openSymbol = "";
                }else if(symbolsMap.containsValue(openSymbol)){
                    break;
                }
            }
            else if(symbolsMap.containsKey(openSymbol)){
                openSymbolsList.add(openSymbol);
            }
        }
        if(openSymbolsList!=null&&openSymbolsList.size()>0){
            return false;
        }else if(symbolsMap.containsValue(openSymbol)){
            return false;
        }
        return true;
    }
}

//[()[]], [([]([])[])) , [()[([])]], [(]), [((()))[]