package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.metacube.training.EADSession10EmployeePortal.models.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_FIND_EMPLOYEE = "from Employee where id =:id";
	private final String SQL_DELETE_EMPLOYEE = "delete from Employee where id =:id";
	private final String SQL_UPDATE_EMPLOYEE = "update Employee set firstname=:firstname,lastname=:lastname,dob=:dob,skills=:skills,gender=:gender,primarycontact=:primarycontact,secondarycontact=:secondarycontact,email=:email,profileImage=:profileImage,password=:password WHERE id=:id";
	private final String SQL_GET_ALL = "from Employee";
	private final String SQL_UPDATE_PASSWORD = "update Employee set password=:password WHERE email=:email";
	private final String SQL_CHECK_BY_EMAIL_PASSWORD = "from Employee WHERE email=:email AND password=:password";
	private final String SQL_CHECK_BY_EMAIL = "from Employee WHERE email=:email";
	private final String GET_BY_EMAIL = "from Employee WHERE email=:email";

	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployeeById(int id) {

		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_EMPLOYEE);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteEmployee(Employee employee) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_EMPLOYEE);
		query.setParameter("id", employee.getId());
		return (query.executeUpdate() > 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateEmployee(Employee employee) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_EMPLOYEE);
		query.setParameter("firstname", employee.getFirstName());
		query.setParameter("lastname", employee.getLastname());
		query.setParameter("dob", employee.getDob());
		query.setParameter("gender", employee.getGender());
		query.setParameter("skills", employee.getSkills());
		query.setParameter("primarycontact", employee.getPrimarycontact());
		query.setParameter("secondarycontact", employee.getSecondarycontact());
		query.setParameter("email", employee.getEmail());
		query.setParameter("profileImage", employee.getProfileImage());
		query.setParameter("password", employee.getPassword());
		query.setParameter("id", employee.getId());
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updatePassword(String username, String password) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_PASSWORD);
		query.setParameter("password", password);
		query.setParameter("email", username);
		return (query.executeUpdate() > 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkByEmailAndPassword(String username, String password) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_CHECK_BY_EMAIL_PASSWORD);
		query.setParameter("password", password);
		query.setParameter("email", username);
		Employee emplopyee = query.getSingleResult();
		if (emplopyee != null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkByEmail(String email) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_CHECK_BY_EMAIL);
		query.setParameter("email", email);
		Employee employee = query.getSingleResult();
		if (employee != null) {
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployeeByName(String email) {
		@SuppressWarnings("unchecked")
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(GET_BY_EMAIL);
		query.setParameter("email", email);
		return query.getSingleResult();
	}
}
