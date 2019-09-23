package com.edpas.java8.g.map;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RevertString {

	public static void main(String []args){
       String input = "dlrow olleh";
       
       Iterator<Character> revIter = input.chars()
           .mapToObj(item -> new Character((char)item))
           .collect(Collectors.toCollection(ArrayDeque::new))
           .descendingIterator();
           
       String output = StreamSupport
           .stream(Spliterators.spliteratorUnknownSize(revIter, Spliterator.ORDERED), false)
           .map(Object::toString)
           .collect(Collectors.joining(""));

       System.out.println(output);
    }
}
