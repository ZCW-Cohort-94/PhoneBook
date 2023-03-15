package com.zipcodewilmington.phonebook;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        if(phonebook.containsKey(name)){
            return true;
        }
        else return false;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String result = "";
        for(Map.Entry<String, List<String>> entry : phonebook.entrySet()){
            if(entry.getValue().contains(phoneNumber)){
                result = result + entry.getKey();
            }
        }
        return result;
    }

    public List<String> getAllContactNames() {
        String result = "";
        for(String s : phonebook.keySet()){
            result += s + ",";
        }
        List<String>  lastResult = new ArrayList<>(Arrays.asList(result.split(",")));

        return lastResult;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
