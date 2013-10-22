/**
 *  <b>日期：</b>Oct 22, 2013-4:25:56 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

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
}
