package com.hgapp.controller;

public class TestApp {
	public static void main(String ar[]) {
		String str="Hanmant1@";
		char[] reverse=str.toCharArray();
	
		int k=0;
		char temp;
		for(int i=reverse.length-1;i>0;i--) {
			if(reverse[i]!='@'&&reverse[i]!='1') {
				for(int j=k;j<i;j++) {
					k++;
					if(reverse[j]!='@'&&reverse[j]!='1') {
						temp=reverse[j];
						reverse[j]=reverse[i];
						reverse[i]=temp;
					}
					
				}
			}
			System.out.println("test "+reverse);
		}
		
	}
	

}
