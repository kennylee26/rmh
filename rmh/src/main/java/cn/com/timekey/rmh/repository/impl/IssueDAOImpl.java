/**
 *  <b>日期：</b>Oct 12, 2013-9:57:11 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Repository;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.repository.IssueDAO;

/**
 * <b>类名称：</b>IssueDAOImpl<br/>
 * <b>类描述：</b>问题Issue的DAO实现类<br/>
 * <b>创建时间：</b>Oct 12, 2013 9:57:11 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Repository("issueDAO")
public class IssueDAOImpl implements IssueDAO {

	private final Log logger = LogFactory.getLog(getClass());
	@Resource(name = "entityManagerFactory")
	protected EntityManagerFactory emf;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.timekey.rmh.repository.IssueDAO#findResponsibleIssues(int,
	 * java.util.Date, java.util.Date, java.util.List)
	 */
	public List<Issue> findResponsibleIssues(int userId, Date begin, Date end,
			List<Integer> statusIds) {
		logger.debug("IssueDAOImpl.findResponsibleIssues()");
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(emf);
		String qlString = "";
		// TODO 初步完成，但还要过滤父级任务。
		qlString += "SELECT i FROM Issue i, CustomValue cv where i.id = cv.customizedId AND cv.customFieldId=6 AND i.estimatedHours !=null ";
		qlString += " AND cv.value=:userId ";
		if (begin != null) {
			qlString += " AND i.startDate >= :begin";
		}
		if (end != null) {
			qlString += " AND i.dueDate < :end";
		}
		if (statusIds != null) {
			qlString += " AND i.statusId in ( :statusIds ) ";
		}
		Query query = em.createQuery(qlString);
		query.setParameter("userId", String.valueOf(userId));
		if (begin != null) {
			logger.info("begin: " + begin);
			query.setParameter("begin", begin);
		}
		if (end != null) {
			logger.info("end: " + end);
			query.setParameter("end", end);
		}
		if (statusIds != null) {
			query.setParameter("statusIds", statusIds);
		}
		@SuppressWarnings("unchecked")
		List<Issue> l = query.getResultList();
		return l;
	}

}
