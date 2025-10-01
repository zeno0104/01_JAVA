package com.hw1.run;

import java.util.ArrayList;
import java.util.List;

import com.hw1.model.dto.Friend;

public class Run {
	public static void main(String[] args) {
		List<Friend> list = new ArrayList<Friend>();
		
		list.add(new Friend("짱구"));
		list.add(new Friend("철수"));
		list.add(new Friend("유리"));
		list.add(new Friend("훈이"));
		list.add(new Friend("맹구"));
		
		int num = (int) (Math.random() * list.size() + 1);
		
		System.out.println(list.get(num).getName() + "가 떡잎방범대 대장이다!");
	}
}
