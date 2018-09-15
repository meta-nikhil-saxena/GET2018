package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.EADSession10EmployeePortal.models.Job;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_FIND_JOB = "from Job where id = :jobId";
	private final String SQL_DELETE_JOB = "delete from Job where id = :jobId";
	private final String SQL_UPDATE_JOB = "update Job set job= :job WHERE id= :jobId";
	private final String SQL_GET_ALL = "from Job";

	@SuppressWarnings("unchecked")
	@Override
	public Job getJobById(int id) {
		TypedQuery<Job> query = sessionFactory.getCurrentSession().createQuery(
				SQL_FIND_JOB);
		query.setParameter("jobId", id);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getAllJobs() {
		TypedQuery<Job> query = sessionFactory.getCurrentSession().createQuery(
				SQL_GET_ALL);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteJob(Job job) {
		TypedQuery<Job> query = sessionFactory.getCurrentSession().createQuery(
				SQL_DELETE_JOB);
		query.setParameter("jobId", job.getId());
		return (query.executeUpdate() > 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateJob(Job job) {
		TypedQuery<Job> query = sessionFactory.getCurrentSession().createQuery(
				SQL_UPDATE_JOB);
		query.setParameter("job", job.getJob());
		query.setParameter("jobId", job.getId());
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean createJob(Job job) {
		sessionFactory.getCurrentSession().save(job);
		return true;
	}

}
