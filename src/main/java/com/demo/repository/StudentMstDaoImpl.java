package com.demo.repository;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.StudentMst;

@Repository
public class StudentMstDaoImpl {

	@Autowired
	SessionFactory session;

	@Transactional
	public void saveStudentMst(StudentMst stud) {
		session.getCurrentSession().save(stud);
	}

	@Transactional
	public StudentMst getStudentMstById(Integer id) {
		Criteria crit = session.getCurrentSession().createCriteria(StudentMst.class);
		crit.add(Restrictions.eq("id", id));
		return crit.list().size() > 0 ? (StudentMst) crit.list().get(0) : null;
	}
}
