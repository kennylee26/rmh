/**
 *  <b>日期：</b>Oct 22, 2013-4:25:56 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.entity.Project;
import cn.com.timekey.rmh.entity.Role;
import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.repository.AbstractRepository;
import cn.com.timekey.rmh.repository.ProjectDAO;

/**
 * <b>类名称：</b>ProjectDAOImpl<br/>
 * <b>类描述：</b>ProjectDAO的实现类<br/>
 * <b>创建时间：</b>Oct 22, 2013 4:25:56 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Repository("projectDAO")
public class ProjectDAOImpl extends AbstractRepository implements ProjectDAO {

	private final Log logger = LogFactory.getLog(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.repository.ProjectDAO#findByMemberRole(cn.com.timekey
	 * .rmh.entity.MemberRole)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findByUserAndRole(User user, Role role) {
		logger.debug("ProjectDAOImpl.findByMemberRole()");
		String qlString = "SELECT p FROM Project p left join p.members members WHERE members.user =:user AND members.memberRole.role=:role AND p.status not in (5)";
		return getEntityManager().createQuery(qlString)
				.setParameter("user", user).setParameter("role", role)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.repository.ProjectDAO#getTotalEstimatedHours(cn.com
	 * .timekey.rmh.entity.Project, java.util.Date, java.util.Date,
	 * java.util.List)
	 */
	@Override
	public double getTotalEstimatedHours(Project project, Date begin, Date end,
			List<IssueStatus> issueStatuses) {
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(emf);
		if (project.getId() == null && project.getIdentifier() != null) {
			project = findUniqueByProperty("identifier",
					project.getIdentifier());
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		String qlString = "";
		qlString += "SELECT sum(i.estimatedHours) FROM Issue i WHERE i.project = :project AND NOT EXISTS ( FROM Issue t WHERE t.parentId = i.id) ";
		parameters.put("project", project);
		if (begin != null) {
			qlString += " AND i.startDate >= :begin";
			parameters.put("begin", begin);
		}
		if (end != null) {
			qlString += " AND i.dueDate < :end";
			parameters.put("end", end);
		}
		if (issueStatuses != null) {
			qlString += " AND i.issueStatus in ( :issueStatus ) ";
			if (logger.isDebugEnabled()) {
				for (IssueStatus st : issueStatuses) {
					logger.info(st.getId());
				}
			}
			parameters.put("issueStatus", issueStatuses);
		}
		Query query = em.createQuery(qlString);
		if (CollectionUtils.isEmpty(parameters) == false) {
			for (Map.Entry<String, Object> e : parameters.entrySet()) {
				query.setParameter(e.getKey(), e.getValue());
			}
		}
		Double d = (Double) query.getSingleResult();
		return d == null ? 0d : d;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findIssues(Project project, Date begin, Date end,
			List<IssueStatus> issueStatuses) {
		String projection = "i,u";
		Query query = generateFindIssueQuery(project, begin, end,
				issueStatuses, projection);
		return query.getResultList();
	}

	/**
	 * <p>
	 * 生成查询实例
	 * </p>
	 * 
	 * @param project
	 *            项目
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束日期
	 * @param issueStatuses
	 *            问题状态
	 * @param projection
	 *            投影描述
	 * @return
	 */
	private Query generateFindIssueQuery(Project project, Date begin, Date end,
			List<IssueStatus> issueStatuses, String projection) {
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(emf);
		Map<String, Object> parameters = new HashMap<String, Object>();
		String qlString = "";
		qlString += "SELECT "
				+ projection
				+ " FROM Issue i,User u, CustomValue cv where i.id = cv.customizedId AND cv.customFieldId=6 AND cv.value=u.id AND i.project = :project AND NOT EXISTS ( FROM Issue t WHERE t.parentId = i.id) ";
		parameters.put("project", project);
		if (begin != null) {
			qlString += " AND i.startDate >= :begin";
			parameters.put("begin", begin);
		}
		if (end != null) {
			qlString += " AND i.dueDate < :end";
			parameters.put("end", end);
		}
		if (issueStatuses != null) {
			qlString += " AND i.issueStatus in ( :issueStatus ) ";
			if (logger.isDebugEnabled()) {
				for (IssueStatus st : issueStatuses) {
					logger.info(st.getId());
				}
			}
			parameters.put("issueStatus", issueStatuses);
		}

		qlString += " ORDER BY i.issueStatus.isClosed ASC , i.dueDate ASC, i.startDate ASC, i.id ASC";
		Query query = em.createQuery(qlString);
		if (CollectionUtils.isEmpty(parameters) == false) {
			for (Map.Entry<String, Object> e : parameters.entrySet()) {
				query.setParameter(e.getKey(), e.getValue());
			}
		}
		return query;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.repository.ProjectDAO#findUniqueByProperty(java.lang
	 * .String, java.lang.Object)
	 */
	@Override
	public Project findUniqueByProperty(String property, Object value) {
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(emf);
		String qlString = "FROM Project model";
		qlString += " WHERE model." + property + "=:" + property;
		Query query = em.createQuery(qlString);
		query.setParameter(property, value);
		return (Project) query.getSingleResult();
	}
}
