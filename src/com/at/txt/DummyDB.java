package com.at.txt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DummyDB {
	private int totalCountries;
	private String data = "Afghanistan,	Albania, Zimbabwe";
	private Map<String,String> datamap=new HashMap();
	
	private List<String> countries;
	public DummyDB() {
		countries = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(data, ",");
		
		while(st.hasMoreTokens()) {
			countries.add(st.nextToken().trim());
		}
		totalCountries = countries.size();
		datamap.put("afghanistan", "Afghanistan-Map");
		datamap.put("albania", "Albania-Map");
		datamap.put("zimbabwe", "Zimbabwe-Map");
	}
	
	public List<String> getData(String query) {
		String country = null;
		query = query.toLowerCase();
		System.out.println("data for "+query);
		List<String> matched = new ArrayList<String>();
		String mat=datamap.get(query);
		System.out.println("mat si  for "+mat);
		if(mat==null) {
		for(int i=0; i<totalCountries; i++) {
			System.out.println("getting countroes ");
			country = countries.get(i).toLowerCase();
			if(country.startsWith(query)) {
				matched.add(countries.get(i));
			}
		}
		}else {
			System.out.println("getting from map");
			matched.add(mat);
		}
		return matched;
	}
}
