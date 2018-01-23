package services;

import java.util.ArrayList;
import java.util.Arrays;

public class PlantService extends Service {

	private ArrayList<ArrayList<Object>> list;

	public PlantService() {
		list = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> one = new ArrayList<Object>(
				Arrays.asList(new Object[] { 1, "Hugo", "DECAT" }));
		ArrayList<Object> two = new ArrayList<Object>(
				Arrays.asList(new Object[] { 2, "Janaína", "DEARQ" }));
		ArrayList<Object> three = new ArrayList<Object>(
				Arrays.asList(new Object[] { 3, "Diego", "DECAT" }));
		ArrayList<Object> four = new ArrayList<Object>(
				Arrays.asList(new Object[] { 4, "Marlon", "DEMAT" }));
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
	}

	@Override
	public ArrayList<ArrayList<Object>> selectAll() {
		return list;
	}

	@Override
	public ArrayList<Object> select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id, ArrayList<Object> row) {
		int match = -1;
		
		for (ArrayList<Object> line : list) {
			if((int) line.get(0) == id) {
				line.add(1, row.get(1));
				line.add(2, row.get(2));
				match = id;
			}
		}
		
		return match;
	}

	@Override
	public void insert(ArrayList<Object> row) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<ArrayList<Object>> selectByName(String name) {
		ArrayList<ArrayList<Object>> mainList = new ArrayList<ArrayList<Object>>();
		for (ArrayList<Object> line : list) {
			if(line.get(1).toString().toLowerCase().contains(name)) {
				mainList.add(line);
				return mainList;
			}
		}
		return null;
	}

}
