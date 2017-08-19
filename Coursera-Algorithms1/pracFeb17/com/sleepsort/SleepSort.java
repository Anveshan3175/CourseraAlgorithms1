package com.sleepsort;

import java.util.ArrayList;
import java.util.List;

public class SleepSort {

	public SleepSort() {
		// TODO Auto-generated constructor stub
	}

	List<Integer> sortedList = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SleepSort sleepSort = new SleepSort();
		sleepSort.sortedList = new ArrayList<>();
		SleepSort.Sort sort = sleepSort.new Sort();
		sort.printSortedNumbers(new int[]{5,9,2,7,1,10,45,3,23,14,1},sleepSort.sortedList);
	}

	class Sort 
	{
		
		void printSortedNumbers(int[] numbers,List<Integer> sortedList){
			for(int i : numbers){
				new Thread(new NumberRunnable(i)).start();
			}
			
		}
	}
	class NumberRunnable implements Runnable {

		int value;
		
		NumberRunnable(int value){
			this.value = value;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(value*10);
				System.out.println(value);
				sortedList.add(value);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}


