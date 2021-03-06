/**
 *  <b>日期：</b>Oct 12, 2013-10:05:25 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <b>类名称：</b>DateUtils<br/>
 * <b>类描述：</b>日期工具类<br/>
 * <b>创建时间：</b>Oct 12, 2013 10:05:25 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public class DateUtils {

	private static final Log logger = LogFactory.getLog(DateUtils.class);

	/**
	 * <p>
	 * 根据年份月份获取跨度，返回值如2013年10月1日到2013年11月1日。
	 * </p>
	 * 
	 * @param year
	 *            年份
	 * @param monthNumber
	 *            月份，1月份=1，2月份=2，如此类推
	 * @return
	 */
	public static Date[] getDatePeriod(int year, int monthNumber) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date[] result = null;
		String source = String.valueOf(year);
		if (monthNumber < 10) {
			source += "0";
		}
		source += String.valueOf(monthNumber);
		source += "01";
		Calendar cal = Calendar.getInstance();
		try {
			Date begin = sdf.parse(source);
			cal.setTime(begin);
			cal.add(Calendar.MONTH, 1);
			Date end = cal.getTime();
			result = new Date[] { begin, end };
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
}
