package com.edpas.java8.k.rxjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;


public class RXApp {

	private List<Integer> list1;
	private List<Integer> list2;
	
	
	public RXApp() {
		this.list1 = new ArrayList<Integer>();
		this.list2 = new ArrayList<Integer>();
		this.fillLists();
	}
	
	private void fillLists() {
		for (int i=0; i<10; i++) {
			this.list1.add(i);
			this.list2.add(i);
		}
	}
	
	private void search() {
		Observable<Integer> observable1 = Observable.from(this.list1);
		Observable<Integer> observable2 = Observable.from(this.list2);
		/*
		Observable.merge(observable1, observable2).subscribe(new Action1<Integer>() {
			@Override
			public void call(Integer number) {
				if (number%2 == 0) {
					System.out.println(number);
				}
			}			
		});
		*/
		Observable.merge(observable1, observable2).filter(x -> x%2==0).subscribe(System.out::println);
	}
	
	public static void main(String[] args) {
		RXApp app = new RXApp();
		
		app.search();
	}
}
