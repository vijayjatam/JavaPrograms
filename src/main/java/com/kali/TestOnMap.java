package com.kali;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Stream;

public class TestOnMap {
	public static void main(String[] args) {
		Map<String,String> m=new HashMap<String,String>();
	
		m.put("prasanna", "1");
		m.put("kumar", "2");
		m.put(null, "20");
		
		new TestOnMap().lambadaExpression();
//		randomArraylist();
//		System.out.println(m.put(null, "50"));
		
		
//		System.out.println(m.values());
//		System.out.println(m.keySet());
//		System.out.println(m.entrySet());
		/*for(Map.Entry<String, String> entryObj : m.entrySet()){
			System.out.println(entryObj.getKey().hashCode()+"   "+entryObj.getValue().hashCode());
		}*/
//		print(m);
	}
	public static void print(Map m){
		System.out.println(m.get("kumar"));
	}
	STSBean bean = new STSBean();
	
	

	
	/*	Map<STSBean,String> map =new HashMap<STSBean,String>();
	STSBean bean = new STSBean();
	
	bean.setAccount("java");
	
	STSBean bean1 = new STSBean();
	bean1.setName("Kali");
	
	STSBean bean2 = new STSBean();
	
	map.put(bean, "1");
	map.put(bean1, "2");
	map.put(bean2, "1");
	
	m(map);
//	System.out.println(map);
	
	
	
	
//	System.out.println(map.size());
}
public static void m(Map map){
	List<Map.Entry<STSBean, String>> list =new LinkedList<Map.Entry<STSBean, String>>(map.entrySet());
	for(Map.Entry<STSBean, String> entryObj : list){
		if(entryObj.getKey().getName()!=null&&entryObj.getKey().getName().equalsIgnoreCase("kali"))
		System.out.println(entryObj.getKey() +" , "+entryObj.getValue());
	}*/
	
	public void lambadaExpression(){
		Map<Integer,Integer> m=new HashMap<>();
		m.put(20, 2);
		m.put(34, 20);
		m.put(25, 22);
		m.put(0, 2103);
//		System.out.println(m);
		
//		System.out.println();
//		iteratorOfMap(sortByKey(m));
		System.out.println("----------------------------------");
//		iteratorOfMap(sortByValue(m));
		
		
		Map<String,STSBean> mapWithBean = new HashMap<>();
		STSBean bean1 = new STSBean();
		bean1.setAccount("ACC 12010232");
		bean1.setName("MahanKali");
		bean1.setNumber(6546212);
		
		mapWithBean.put("1st", bean1);
		STSBean bean2 = new STSBean();
		bean2.setAccount("ACC 2223");
		bean2.setName("Mahan");
		bean2.setNumber(46212);
		mapWithBean.put("2nd", bean2);
		STSBean bean3 = new STSBean();
		bean3.setAccount("ACC 25612010");
		bean3.setName("Kali");
		bean3.setNumber(12222352);
		mapWithBean.put("3rd", bean3);
		iteratorOfMap(mapWithBean);
		System.out.println("------------------------------------------------");
		
		sortForBean(mapWithBean);
		
		List<String> list = new ArrayList<>();
		list.add("10");
		list.add("20");
		list.add("30");
		list.add("kali");
//		list.forEach(System.out::println);
	}
	private static void log(Object string) {
		System.out.println(string);
 
	}
	private static <K extends Comparable<? super K>, V> Map<K,V> sortByKey(Map<K,V> unsortedMap){
		Map<K,V> resultMap = new LinkedHashMap<>();
		Stream<Entry<K, V>> stream = unsortedMap.entrySet().stream();
		stream.sorted(Entry.comparingByKey()).forEachOrdered(C -> resultMap.put(C.getKey() , C.getValue()));
//		stream.sorted();
		return resultMap;
	}
	private static <K,V>void iteratorOfMap(Map<K,V> sortedmap){
		sortedmap.forEach((K,V) -> {
			System.out.println("Key: "+K+" \t\t Value:"+V);
		});
	}
	
	private static <K, V extends Comparable<? super V>> Map<K,V> sortByValue(Map<K,V> unsortedMap){
		Map<K,V> resultMap = new LinkedHashMap<>();
		Stream<Entry<K, V>> stream = unsortedMap.entrySet().stream();
		stream.sorted(Entry.comparingByValue()).forEachOrdered(C -> resultMap.put(C.getKey() , C.getValue()));
		
		return resultMap;
	}
	public static void randomArraylist(){
		List<String> list = new ArrayList<>();
		Random random = new Random();
		list.add("1st");
		list.add("2nd");
		list.add("3rd");
		list.add("4th");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(random.nextInt(list.size())));
		}
	}
	private static <K, V extends Comparable<? super V>> void sortForBean(Map<K,V> unsortedMap){
		Stream<Entry<K, V>> stream = unsortedMap.entrySet().stream();
		stream.sorted(Entry.comparingByValue(/*new Comparator<V>() {

			@Override
			public int compare(V arg0, V arg1) {
				// TODO Auto-generated method stub
				return 0;
			}}*/)).forEachOrdered(O -> System.out.println("Key: "+O.getKey()+" \t\t Value: "+((STSBean)O.getValue()).getName()+","+((STSBean)O.getValue()).getAccount()+","+((STSBean)O.getValue()).getNumber()));
	}
}
