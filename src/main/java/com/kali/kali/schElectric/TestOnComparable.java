package com.kali.kali.schElectric;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestOnComparable {
	public static void main(String[] args) {
		Dog d1 = new Dog(10, 20, "ab");
		Dog d2 = new Dog(10,10,"bc");
		Dog d3 = new Dog(10,10,"ce");
		//Dog d4 = new Dog();
		
		
		
		
		
		HashSet<Dog> setValue = new HashSet<Dog>();
		setValue.add(d1);
		setValue.add(d2);
		setValue.add(d3);
		Map<Dog, String> map = new HashMap<>();
		map.put(d1,"1");
		map.put(d2,"2");
		map.put(d3,"3");
		System.out.println(map.size());
//		System.out.println(setValue.size());
		List<Dog> list = new ArrayList<Dog>(setValue);
		/*Collections.sort(list,new Comparator<Dog>() {
			@Override
			public int compare(Dog o1, Dog o2) {
				return (o1.weight>o2.weight && (o1.cost<o2.cost))?-1:1;
				*//*if((o1.cost>o2.cost)&&(o1.name.compareTo(o2.name)==1)){
					return 1;
				}
				else{
					return -1;
				}*//*
			}
		});*/
		System.out.println("List:\nList Size: "+list.size());
		list.stream().forEach(dog -> System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName()));
		/*for(Dog dog : list){
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		for(Iterator<Dog> itr=list.iterator();itr.hasNext();){ 
			Dog dog = (Dog) itr.next();
			if(dog.equals(d1)){
				dog.setWeight(100);
			}
		}
		System.out.println("---------------------------------------------------------------------");
		list.stream().forEach(dog -> System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName()));
		/*for(Dog dog : list){
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		for(Iterator<Dog> itr=list.iterator();itr.hasNext();){ 
			Dog dog = (Dog) itr.next();
			if(dog.equals(d1)){
				itr.remove();
			}
		}
		System.out.println("---------------------------------------------------------------------");
		list.stream().forEach(dog -> System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName()));
		/*for(Dog dog : list){
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		
		
		System.out.println("Set:\nSet Size: "+setValue.size());
		setValue.stream().forEach(dog -> System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName()));
		/*for(Dog dog : setValue){
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		for(Iterator<Dog> itr=setValue.iterator();itr.hasNext();){ 
			Dog dog = (Dog) itr.next();
			if(dog.equals(d2)){
				dog.setWeight(100);
			}
		}
		System.out.println("---------------------------------------------------------------------");
		setValue.stream().forEach(dog -> System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName()));
		/*for(Dog dog : setValue){
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		for(Iterator<Dog> itr=setValue.iterator();itr.hasNext();){ 
			Dog dog = (Dog) itr.next();
			if(dog.equals(d1)){
				itr.remove();
			}
		}
		System.out.println("---------------------------------------------------------------------");
		setValue.stream().forEach(dog -> System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName()));
		/*for(Dog dog : setValue){
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		
		System.out.println("Map:\nMap Size: "+map.size());
		map.entrySet().stream().forEach(dog -> System.out.println(dog.getKey().getCost()+" , "+dog.getKey().getWeight()+" , "+dog.getKey().getName()));
		/*for(Map.Entry<Dog, String> entryObj : map.entrySet()){
			Dog dog = entryObj.getKey();
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		for(Iterator<Dog> itr=map.keySet().iterator();itr.hasNext();){ 
			Dog dog = (Dog) itr.next();
			if(dog.equals(d3)){
				dog.setWeight(100);
			}
		}
		System.out.println("---------------------------------------------------------------------");
		map.entrySet().stream().forEach(dog -> System.out.println(dog.getKey().getCost()+" , "+dog.getKey().getWeight()+" , "+dog.getKey().getName()));
		/*for(Map.Entry<Dog, String> entryObj : map.entrySet()){
			Dog dog = entryObj.getKey();
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		for(Iterator<Dog> itr=map.keySet().iterator();itr.hasNext();){ 
			Dog dog = (Dog) itr.next();
			if(dog.equals(d1)){
				itr.remove();
			}
		}
		System.out.println("---------------------------------------------------------------------");
		map.entrySet().stream().forEach(dog -> System.out.println(dog.getKey().getCost()+" , "+dog.getKey().getWeight()+" , "+dog.getKey().getName()));
		/*for(Map.Entry<Dog, String> entryObj : map.entrySet()){
			Dog dog = entryObj.getKey();
			System.out.println(dog.getCost()+" , "+dog.getWeight()+" , "+dog.getName());
		}*/
		
		
		
		
		
		
		

//		System.out.println(setValue.size());
		/*for(Map.Entry<Dog, String> entryObj : map.entrySet()){
			Dog dog = entryObj.getKey();
			System.out.println(dog.getName());
			if(dog.equals(d1)){
				dog.setName("Raj");
			}
			System.out.println(dog.getName());
		}*/
	}
}
class Dog implements Comparable<Dog>{
	Integer cost;
	Integer weight;
	String name;
	public Dog(Integer cost,Integer weight, String name){
		super();
		this.cost = cost;
		this.weight = weight;
		this.name =name;
	}
	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Dog o) {
		return this.cost.compareTo(o.cost);
	}
	@Override
	public boolean equals(Object obj){
		boolean flag = false;
		if(obj instanceof Dog){
			if(this.cost == ((Dog)obj).cost){
				flag = true;
			}
		}
		return flag;
	}
	@Override
	public int hashCode(){
		return this.cost.hashCode()+1;
	}
}
