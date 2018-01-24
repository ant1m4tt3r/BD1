package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlantService extends Service {

	@Override
	public ArrayList<ArrayList<Object>> selectAll() {
		ArrayList<ArrayList<Object>> tuples = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> tuple;
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM PLANTAS");
			while (rs.next()) {
				tuple = new ArrayList<Object>();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String depto = rs.getString(3);
				tuple.add(id);
				tuple.add(name);
				tuple.add(depto);
				tuples.add(tuple);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tuples;
	}

	@Override
	public ArrayList<Object> select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		try {
			Statement s = connection.createStatement();
			return s.execute("DELETE FROM PLANTAS WHERE ID = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(int id, ArrayList<Object> row) {
		String name = (String) row.get(1);
		String depto = (String) row.get(2);
		try {
			Statement s = connection.createStatement();
			return s.execute("UPDATE `PLANTAS` SET `NOME` ='" + name + "',`DEPARTAMENTO` = '" + depto
					+ "' WHERE `PLANTAS`.`ID` = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(ArrayList<Object> row) {
		String values = "NULL, '" + row.get(1) + "' , '" + row.get(2) + "'";
		try {
			Statement s = connection.createStatement();
			return !s.execute("INSERT INTO `PLANTAS` (`ID`, `NOME`, `DEPARTAMENTO`) VALUES (" + values + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<ArrayList<Object>> selectByName(String nameToQuery) {
		ArrayList<ArrayList<Object>> tuples = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> tuple;
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM PLANTAS WHERE NOME = '" + nameToQuery + "'");
			while (rs.next()) {
				tuple = new ArrayList<Object>();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String depto = rs.getString(3);
				tuple.add(id);
				tuple.add(name);
				tuple.add(depto);
				tuples.add(tuple);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tuples;
	}

}
