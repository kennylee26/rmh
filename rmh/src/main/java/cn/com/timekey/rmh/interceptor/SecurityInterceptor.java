/**
 *  <b>日期：</b>Oct 16, 2013-4:22:58 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <b>类名称：</b>SecurityInterceptor<br/>
 * <b>类描述：</b>安全拦截工具<br/>
 * <b>创建时间：</b>Oct 16, 2013 4:22:58 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private final Log logger = LogFactory.getLog(getClass());

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String remoteIp = request.getRemoteAddr();
		if (remoteIp.equals("127.0.0.1") == false) {
			logger.warn("bad ip:" + remoteIp);
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("Post-handle");
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("After completion handle");
	}
}
