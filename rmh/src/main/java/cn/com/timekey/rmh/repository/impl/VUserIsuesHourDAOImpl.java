/**
 *  <b>日期：</b>Oct 11, 2013-4:34:35 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.entity.VUserIsuesHour;
import cn.com.timekey.rmh.repository.VUserIsuesHourDAO;

/**
 * <b>类名称：</b>VUserIsuesHourDAOImpl<br/>
 * <b>类描述：</b>VUserIsuesHourDAO的实现类<br/>
 * <b>创建时间：</b>Oct 11, 2013 4:34:35 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Repository("vUserIsuesHourDAO")
public class VUserIsuesHourDAOImpl implements VUserIsuesHourDAO {

	private final Log logger = LogFactory.getLog(getClass());
	@Resource(name = "entityManagerFactory")
	protected EntityManagerFactory emf;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.repository.VUserIsuesHourDAO#findByExample(cn.com.
	 * timekey.rmh.entity.VUserIsuesHour)
	 */
	public List<VUserIsuesHour> findByExample(VUserIsuesHour example) {
		logger.debug("VUserIsuesHourDAOImpl.findByExample()");
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(emf);
		List<VUserIsuesHour> l = new ArrayList<VUserIsuesHour>();
		Map<Integer, Object> parameters = null;
		String queryString = "SELECT user_name,year,month,isues_hours FROM v_user_isues_hours ";
		User user = null;
		if (example != null) {
			parameters = new HashMap<Integer, Object>();
			queryString += " WHERE 1=1 ";
			// 有user对象条件的话，则用user对象查询出来的结果作为用户名。
			if (example.getUser() != null && example.getUser().getId() != null) {
				user = em.find(User.class, example.getUser().getId());
				if (user == null) {
					return l;
				} else {
					example.setUserName(user.getFirstname().concat(
							user.getLastname()));
				}
			}

			// user name
			if (example.getUserName() != null) {
				queryString += " AND user_name=? ";
				parameters.put(parameters.size(), example.getUserName());
			} else {
				queryString += " AND user_name is null ";
			}
			// year
			if (example.getYear() != null) {
				queryString += " AND year=? ";
				parameters.put(parameters.size(), example.getYear());
			}
			// month
			if (example.getMonth() != null) {
				queryString += " AND month=? ";
				parameters.put(parameters.size(), example.getMonth());
			}
		}
		queryString += " ORDER BY year desc, month desc ";
		Query query = em.createNativeQuery(queryString);
		if (CollectionUtils.isEmpty(parameters) == false) {
			for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey() + 1, entry.getValue());
			}
		}
		List<?> r = query.getResultList();
		if (CollectionUtils.isEmpty(r) == false) {
			for (int i = 0; i < r.size(); i++) {
				Object[] colemnsVals = (Object[]) r.get(i);
				String userName = (String) colemnsVals[0];
				int year = ((BigInteger) colemnsVals[1]).intValue();
				int month = ((BigInteger) colemnsVals[2]).intValue();
				double isuesHours = (Double) colemnsVals[3];
				isuesHours = new BigDecimal(isuesHours).setScale(2,
						RoundingMode.HALF_UP).doubleValue();
				VUserIsuesHour vUserIsuesHour = new VUserIsuesHour(userName,
						year, month, isuesHours);
				vUserIsuesHour.setUser(user);
				l.add(vUserIsuesHour);
			}
		}
		return l;
	}
}
