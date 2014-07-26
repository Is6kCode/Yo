package org.yo.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class DateUtils {

	public static final Locale LOCALE = Locale.US;

	public static final String APPLICATION_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final DateFormat APPLICATION_FORMAT = new SimpleDateFormat(APPLICATION_PATTERN, LOCALE);

	/***
	 * 返回当前服务器时间
	 * 
	 * @return
	 */
	public static String formatCurrent() {
		return APPLICATION_FORMAT.format(new Date());
	}

	public static long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 将指定字符串转换为Date对象，并返回Date对象的毫秒数<br/>
	 * 日期字符串必须符合格式：yyyy-MM-dd HH:mm:ss <br/>
	 * 
	 * @param source
	 *            日期字符串
	 * @return 毫秒数
	 * @throws ParseException
	 */
	public static long toDateMillis(String source) throws ParseException {
		Date d = APPLICATION_FORMAT.parse(source);
		return d.getTime();
	}

	/**
	 * 将指定毫秒数转换成固定格式的日期字符串<br/>
	 * 日期字符串固定格式：yyyy-MM-dd HH:mm:ss <br/>
	 * 
	 * @param milliseconds
	 *            毫秒数
	 * @return 日期字符串
	 * @throws ParseException
	 */
	public static String toFormatDate(long milliseconds) throws ParseException {
		String date = APPLICATION_FORMAT.format(new Date(milliseconds));
		return date;
	}

	/**
	 * 将日期对象转换成固定格式的日期字符串<br/>
	 * 日期字符串固定格式：yyyy-MM-dd HH:mm:ss <br/>
	 * 
	 * @param d
	 * @return
	 * @throws ParseException
	 */
	public static String toFormatDate(Date d) throws ParseException {
		String date = toFormatDate(d.getTime());
		return date;
	}

	/**
	 * 判断是否为日期对象<br/>
	 * 日期字符串固定格式：yyyy-MM-dd HH:mm:ss <br/>
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValidDate(String s) {
		try {
			APPLICATION_FORMAT.parse(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
