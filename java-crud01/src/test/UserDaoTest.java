package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bean.User;
import dao.UserDao;

class UserDaoTest {

	private UserDao dao;

	@BeforeEach
	void setUp() {
		dao = new UserDao();

	}

	@Test
	void testInsertNormal() throws SQLException {
		User user = new User();
		user.setName("田中太郎");
		user.setEmail("taro@example.com");

		dao.insert(user);

		List<User> users = dao.findAll();
		assertTrue(users.stream().anyMatch(u -> u.getName().equals("田中太郎")));

	}

	@Test
	void testInsertNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			User user = new User();
			user.setName(null);
			user.setEmail("nullname@example.com");
			dao.insert(user);
		});
	}

	@Test
	void testInsertEmptyEmail() {
		assertThrows(IllegalArgumentException.class, () -> {
			User user = new User();
			user.setName("名前あり");
			user.setEmail("");
			dao.insert(user);
		});
	}

	@Test
	void testInsertLongName() {
		User user = new User();
		user.setName("あ".repeat(100));
		user.setEmail("longname@example.com");

		assertDoesNotThrow(() -> dao.insert(user));
	}

	@Test
	void testInsertTooLongName() {
		assertThrows(IllegalArgumentException.class, () -> {
			User user = new User();
			user.setName("あ".repeat(101));
			user.setEmail("toolong@example.com");
			dao.insert(user);
		});
	}

	@Test
	void testFindById() throws SQLException {
		User user = new User();
		user.setName("検索対象");
		user.setEmail("search@example.com");
		dao.insert(user);

		List<User> list = dao.findAll();
		int lastId = list.get(list.size() - 1).getId();

		User found = dao.findById(lastId);
		assertEquals("検索対象", found.getName());
		assertEquals("search@example.com", found.getEmail());

	}

	@Test
	void testFindByNullId() throws SQLException {
		User user = new User();
		user.setName("検索対象");
		user.setEmail("search@example.com");
		dao.insert(user);

		int tooNumber = 0;

		assertThrows(NullPointerException.class, () -> {
			User found = dao.findById(tooNumber);
			found.getName();
			found.getEmail();

		});

	}

	@Test
	void testUpdateByid() throws SQLException {
		User user = new User();
		user.setName("変更前対象");
		user.setEmail("update@example.com");
		dao.insert(user);

		List<User> list = dao.findAll();
		int lastId = list.get(list.size() - 1).getId();

		User update = new User(lastId, "変更後対象", "updateEnd@example.com");

		dao.update(update);

		assertEquals(update.getName(), "変更後対象");
		assertEquals(update.getEmail(), "updateEnd@example.com");

	}

	@Test
	void testUpdateByNullId() {

		assertThrows(IllegalArgumentException.class, () -> {
			User nullUpdate = new User(0, "変更後対象", "updateEnd@example.com");

			dao.update(nullUpdate);

		});

	}

}
