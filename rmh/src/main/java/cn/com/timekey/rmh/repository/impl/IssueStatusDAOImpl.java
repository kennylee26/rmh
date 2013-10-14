/**
 *  <b>日期：</b>Oct 14, 2013-11:17:43 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.repository.AbstractRepository;
import cn.com.timekey.rmh.repository.IssueStatusDAO;

/**
 * <b>类名称：</b>IssueStatusDAOImpl<br/>
 * <b>类描述：</b>IssueStatusDAO的实现类<br/>
 * <b>创建时间：</b>Oct 14, 2013 11:17:43 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Repository("issueStatusDAO")
public class IssueStatusDAOImpl extends AbstractRepository implements
		IssueStatusDAO {

	private final Log logger = LogFactory.getLog(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.timekey.rmh.repository.IssueStatusDAO#findByIsClosed(boolean)
	 */
	@SuppressWarnings("unchecked")
	public List<IssueStatus> findByIsClosed(boolean isClosed) {
		logger.debug("IssueStatusDAOImpl.findByIsClosed()");
		return getEntityManager()
				.createNamedQuery("IssueStatus.findByIsClosed")
				.setParameter("isClosed", isClosed ? 1 : 0).getResultList();
	}
}
