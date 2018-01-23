package models;

import java.util.List;

import models.beans.User;
import services.UserService;

public class UserModel extends Model<User> {

	UserService service;

	public UserModel() {
		service = new UserService();
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
	public boolean delete(int id) {
		return service.delete(id);
	}

	@Override
	public User update(User row) {
		service.update(row.getId(), null);
		return null;
	}

	@Override
	public boolean insert(User row) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> selectByName(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
