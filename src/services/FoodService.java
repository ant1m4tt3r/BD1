package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;

public class FoodService extends Service {

	@Override
	public ArrayList<ArrayList<Object>> selectAll() {
		ArrayList<ArrayList<Object>> tuples = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> tuple;
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM alimento");
			while (rs.next()) {
				tuple = new ArrayList<Object>();
				int code = rs.getInt(1);
				String name = rs.getString(2);
				String kind = rs.getString(3);
				tuple.add(code);
				tuple.add(name);
				tuple.add(kind);
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
			return s.execute("DELETE FROM alimento WHERE codigo = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(int id, ArrayList<Object> row) {
		String name = (String) row.get(1);
		String kind = (String) row.get(2);
		try {
			Statement s = connection.createStatement();
			return s.execute("UPDATE `alimento` SET `NOME` ='" + name + "',`Tipo` = '" + kind
					+ "' WHERE `alimento`.`codigo` = " + id);
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
			return !s.execute("INSERT INTO `alimento` (`codigo`, `nome`, `tipo`) VALUES (" + values + ")");
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
			ResultSet rs = s.executeQuery("SELECT * FROM alimento WHERE NOME = '" + nameToQuery + "'");
			while (rs.next()) {
				tuple = new ArrayList<Object>();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String kind = rs.getString(3);
				tuple.add(id);
				tuple.add(name);
				tuple.add(kind);
				tuples.add(tuple);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tuples;
	}

}
