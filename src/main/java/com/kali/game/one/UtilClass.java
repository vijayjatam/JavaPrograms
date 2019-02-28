package com.kali.game.one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class UtilClass {
	/**
	 * Place Map values to StringBuilder
	 * 
	 * @param dataMap
	 * @param data
	 */
	public static void mapToStringBuilder(Map<String, String> dataMap,
			StringBuilder data) {
		Iterator<String> itr = dataMap.keySet().iterator();
		while (itr.hasNext()) {
			String ipAddress = itr.next();
			data.append(ipAddress);
			data.append("=:");
			data.append(dataMap.get(ipAddress));
			data.append("\n");
		}
	}

	/**
	 * Place StringBuilder values to Map
	 * 
	 * @param dataMap
	 * @param data
	 */
	public static Map<String, String> stringBuilderToMap(StringBuilder data,
			Map<String, String> dataMap) {
		String[] values = data.toString().split("=:");
		dataMap.put(values[0], values[1]);
		return dataMap;
	}

	/**
	 * Updating oldMap values
	 * 
	 * @param KEYVsVALUE
	 * @param KEY
	 * @return
	 */
	public static Map<String, String> updateOldInfoWithNewInfo(
			Map<String, String> KEYVsVALUE, String KEY, String score) {

		String subKey = null;
		StringBuilder strBuilder = new StringBuilder();

		if (KEY.contains("^")) {
			subKey = KEY.substring(0, KEY.indexOf('^'));
		} else
			subKey = KEY;

		if (KEYVsVALUE.containsKey(subKey)) {
			String str = KEYVsVALUE.get(subKey);
			if (null == score) {
				Integer playTime = Integer.parseInt(str)+ 1;
				strBuilder.append(playTime);
			} else {
				strBuilder.append(score + "^"
						+ KEY.substring(KEY.indexOf('^') + 1));
			}
			KEYVsVALUE.remove(subKey);
			KEYVsVALUE.put(subKey, strBuilder.toString());
		}
		return KEYVsVALUE;
	}

	/**
	 * Updating oldMap values
	 * 
	 * @param KEYVsVALUE
	 * @param KEY
	 * @return
	 */
	public static Map<String, String> updateOldInfoWithNewInfo(Map<String, String> KEYVsVALUE, String KEY) {
		return updateOldInfoWithNewInfo(KEYVsVALUE, KEY, null);
	}

	/**
	 * True if give value found in Map, else false
	 * 
	 *
	 *
	 */
	public static boolean findValueInFile(
			Map<String, String> oldIPAddressVsPlayTimes, String whatValueToFind) {
		if (oldIPAddressVsPlayTimes.containsKey(whatValueToFind))
			return true;
		else
			return false;
	}

	/**
	 * Reading already existing data from file
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> getExistedDataFromFile(File file)
			throws IOException {
		Map<String, String> ipAddressVsPlayTimes = new ConcurrentHashMap<String, String>();
		if (!file.exists())
			return ipAddressVsPlayTimes;
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			if (inputLine.length() != 0) {
				String conditional_Flage = inputLine.substring(inputLine.indexOf("=:") + 2);
//				if(!conditional_Flage.contains("^"))
				ipAddressVsPlayTimes.put(
						inputLine.substring(0, inputLine.indexOf("=:")),
						conditional_Flage);
				/*else
					ipAddressVsPlayTimes.put(
							inputLine.substring(0, inputLine.indexOf("=:")),
							inputLine.substring(inputLine.indexOf("=:") + 2, inputLine.indexOf("^")));*/
			}
		}
		return ipAddressVsPlayTimes;
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static Map<Integer, Map<String,String>> getDetailsOfScoreFile(File file) throws IOException {
		Map<Integer,Map<String, String>> topLevelMap = new HashMap<Integer,Map<String, String>>();
		Map<String, String> buttomLevelMap;
		StringBuilder strBuilder = new StringBuilder();
		TreeSet<Integer> set = new TreeSet<Integer>();
		if(!file.exists())
			return topLevelMap;
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			if(inputLine.length() != 0) {
				if(inputLine.contains("^")) {
					set.add(Integer.parseInt(inputLine.substring(inputLine.indexOf("^")+1)));
					strBuilder.append(inputLine+"#");
				}
			}
		}
		System.out.println(set);
		String[] strArray = strBuilder.toString().split("#");
		Iterator itr = set.iterator();
		String selectedLevel;
		while(itr.hasNext()) {
			buttomLevelMap = new HashMap<String, String>();
			selectedLevel = itr.next().toString();
			for(int i = 0; i<strArray.length; i++) {
				String individualStr = strArray[i];
				if(individualStr.contains("^"+selectedLevel)) {
					buttomLevelMap.put(individualStr.substring(0, individualStr.indexOf("=:")), individualStr.substring(individualStr.indexOf("=:")+2, individualStr.indexOf("^")));
				}
			}
			topLevelMap.put(Integer.parseInt(selectedLevel), buttomLevelMap);
		}
		return topLevelMap;
	}
	public static void main(String[] args) throws IOException {
		getDetailsOfScoreFile(new File("src/main/java/com/kali/game/one/score.txt"));
	}
	
	public static String encription(String source) {
		return null;
	}
	/**
	 * Place Map values to StringBuilder
	 * 
	 * @param dataMap
	 * @param data
	 */
	/*
	 * private static void mapToStringBuilder(Map<String, String> dataMap,
	 * StringBuilder data) { Iterator<String> itr = dataMap.keySet().iterator();
	 * while (itr.hasNext()) { String ipAddress = itr.next();
	 * data.append(ipAddress); data.append("=:");
	 * data.append(dataMap.get(ipAddress)); data.append("\n"); } }
	 */

	/**
	 * Updating oldMap values
	 * 
	 * @param oldIPAddressVsPlayTimes
	 * @param ipAddress
	 * @return
	 * @throws IOException 
	 */
	/*
	 * private static Map<String, String> processing( Map<String, String>
	 * oldIPAddressVsPlayTimes, String ipAddress) { if
	 * (oldIPAddressVsPlayTimes.containsKey(ipAddress)) { Integer playTime =
	 * Integer.parseInt(oldIPAddressVsPlayTimes .get(ipAddress)); playTime =
	 * playTime + 1; oldIPAddressVsPlayTimes.remove(ipAddress);
	 * oldIPAddressVsPlayTimes.put(ipAddress, playTime.toString()); } return
	 * oldIPAddressVsPlayTimes; }
	 */
	
}
