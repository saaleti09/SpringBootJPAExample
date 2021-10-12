package com.aaleti.springbootjpa;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ComplexUserRepository complexUserRepository;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Environment env;

	@Autowired
	private String appName;

	@GetMapping({ "/get", "/get/{id}" })
	public List<User> get(@PathVariable(required = false, name = "id") Long userId) {

		System.out.println(env.getProperty("spring.application.name"));

		List<User> users = new ArrayList<User>();
		if (userId != null) {
			// User user = getUserByGet(userId);
			// Criteria API

			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userId", userId));
			return criteria.list();
		}
		Iterator<User> iterator = userRepository.findAll().iterator();

		while (iterator.hasNext()) {
			users.add(iterator.next());
		}

		return users;

	}

	public void testMethod() {
		Session session = sessionFactory.openSession();

	}

	/*
	 * Code sample to return Users based on namedQuery
	 */
	private User getUserUsingNamedQuery(Long userId) {

		System.out.println("######calling  getUserUsingNamedQuery######");

		Session session = sessionFactory.openSession();
		Query<User> userQuery = session.getNamedQuery("GetUserByUserIdNamedQuery");
		userQuery.setParameter("userId", userId);
		return userQuery.getSingleResult();

	}

	/*
	 * Code sample to return User using session.load
	 */
	private User getUserByLoad(Long userId) {
		System.out.println("######calling  getUserByLoad######");

		Session session = sessionFactory.openSession();
		return session.load(User.class, userId);
	}

	/*
	 * Code sample to return User using session.get
	 */
	private User getUserByGet(Long userId) {

		System.out.println("######calling  getUserByGet######");

		Session session = sessionFactory.openSession();
		return session.get(User.class, userId);
	}

	@PostMapping("/create")
	public User create(@RequestBody User user) {

		if (user.getUserName().equals("JAGAN"))
			throw new InvalidParameterException("JAGAN");

		System.out.println("######calling  create######");

		UserProfile userProfile = new UserProfile();
		/*
		 * userProfile.setPhoneNumber("9030421522"); user.setUserProfile(userProfile);
		 * userProfile.setUser(user);
		 */
		User savedUser = userRepository.save(user);
		System.out.print("Saved User Profile is " + savedUser.getUserProfile());
		return savedUser;

	}

	/*
	 * Create user using plain Hibernate
	 */
	@PostMapping("/create1")
	public Long saveUsingPlainHibernate(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(user);
		System.out.println("Printing User Id " + user.getUserId());
		transaction.commit();
		session.close();
		System.out.println("Printing User Id after commit " + user.getUserId());

		return user.getUserId();

	}

	public User saveUsingSpringDataJpa(User user) {
		UserProfile userProfile = new UserProfile();
		/*
		 * userProfile.setPhoneNumber("9030421522"); user.setUserProfile(userProfile);
		 * userProfile.setUser(user);
		 */
		User savedUser = userRepository.save(user);
		System.out.print("Saved User Profile is " + savedUser.getUserProfile());
		return savedUser;

	}

	@GetMapping("/delete/{userId}")
	public String delete(@PathVariable("userId") Long userId) {

		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		} else {
			return "Can't Find Record";
		}
		if (!userRepository.existsById(userId))
			return "Success";
		else
			return "Failure";

	}

	@PostMapping("/createComplexUser")
	public ComplexUser createComplexUser(@RequestBody ComplexUser complexUser) {

		System.out.println("######calling  complex create######");
		ComplexUser savedUser = complexUserRepository.save(complexUser);
		return savedUser;

	}

}
