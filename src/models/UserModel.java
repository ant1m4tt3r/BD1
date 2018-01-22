package models;

import java.util.List;

import models.beans.Plant;
import models.beans.User;

public class UserModel extends Model<User> {
	
	private UserModel service;

	public UserModel() {
		service = new UserModel();
	}

	@Override
	public List<User> selectAll() {
		service.selectAll();
		return null;
	}

	@Override
	public User select(int id) {
		service.select(id);
		return null;
	}

	@Override
	public User delete(int id) {
		service.delete(id);
		return null;
	}

	@Override
	public User update(int id) {
		service.update(id);
		return null;
	}

	@Override
	public List<User> selectByName(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
