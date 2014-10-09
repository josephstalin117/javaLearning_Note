package com.Score.Management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MainForm {
	
	static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
	static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {

		// 学生数组
		hashMap.put("Tom", 0);
		hashMap.put("Jerry", 0);
		hashMap.put("Andy", 0);
		hashMap.put("John", 0);

		// System.out.print(hashMap);
		welcome();
    //showScore(hashMap);
    //insertScore(hashMap);
    //findScore(hashMap);
		
	}

	public static void welcome() {
		System.out.println("********欢迎进入成绩管理系统********");
		System.out.println("请选择功能：1成绩录入" + " 2-成绩列表 3-成绩查询"+" 6-退出系统");

		int options = scanner.nextInt();
		try {
			switch (options) {
			
			case 1:
				insertScore(hashMap);
				break;
			case 2:
				showScore(hashMap);
				break;
			case 3:
				findScore(hashMap);
				break;
			}
		} catch (Exception e) {
			System.out.println("请输入 1-3 的数");
			welcome();
		}

	}

	public static HashMap<String,Integer> insertScore(HashMap<String,Integer> hashMap) {
		Iterator<String> score = hashMap.keySet().iterator();
		
		System.out.println("请输入成绩");
		
		while (score.hasNext()) {
			String key = (String) score.next();
			
			int s=scanner.nextInt();
			
			hashMap.put(key, s);
			System.out.println("姓名" + key);
			System.out.println("成绩" + hashMap.get(key));
		}
		return hashMap;
	}
	
	public static void showScore(HashMap hashMap){
		
		Iterator<String> score = hashMap.keySet().iterator();
		
		double average;
		int sum = 0;
		
		while (score.hasNext()) {
			String key = (String) score.next();
			System.out.println("姓名" + key);
			System.out.println("成绩" + hashMap.get(key));
			
			sum=sum+(Integer)hashMap.get(key);
		}
		
		int length=hashMap.size();
		average=sum/length;
		System.out.println(average);
	}
	
	public static void findScore(HashMap hashMap){
		
		String name = null;
		
		name=scanner.next();
		
		if(hashMap.containsKey(name)){
			System.out.println("姓名" + name);
			System.out.println("成绩" + hashMap.get(name));
		}
		
	}
	

}
