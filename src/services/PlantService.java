package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlantService extends Service {

	@Override
	public List<ArrayList<Object>> selectAll() {
		List<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> one = new ArrayList<Object>(
				Arrays.asList(new Object[] { 1, "Hugo", "TI" }));
		ArrayList<Object> two = new ArrayList<Object>(
				Arrays.asList(new Object[] { 1, "Hugo", "TI" }));
		ArrayList<Object> three = new ArrayList<Object>(
				Arrays.asList(new Object[] { 1, "Hugo", "TI" }));
		ArrayList<Object> four = new ArrayList<Object>(
				Arrays.asList(new Object[] { 1, "Hugo", "TI" }));
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
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
	public Object update(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
