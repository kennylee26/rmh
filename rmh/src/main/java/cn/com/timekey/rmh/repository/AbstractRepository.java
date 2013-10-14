/**
 *  <b>日期：</b>Oct 14, 2013-11:20:24 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;

/**
 * <b>类名称：</b>BaseRepository<br/>
 * <b>类描述：</b>持久化层Repository的抽象类<br/>
 * <b>创建时间：</b>Oct 14, 2013 11:20:24 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public abstract class AbstractRepository {
	@Resource(name = "entityManagerFactory")
	protected EntityManagerFactory emf;

	/**
	 * <p>
	 * 获取EntityManager。
	 * </p>
	 * 
	 * @return <code>EntityManager</code>
	 */
	public EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(emf);
		return em;
	}
}
