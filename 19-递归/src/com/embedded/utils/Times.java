package com.embedded.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计算时间的工具类
 * @author rnang0
 * @date 2020/8/22
 */
public class Times {
	private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");
	
	public interface Task {
		void execute();
	}
	
	public static void test(String title, Task task) {
		if (task == null) return;
		title = (title == null) ? "" : ("【" + title + "】");
		System.out.println(title);
		System.out.println("开始：" + fmt.format(new Date()));
		long begin = System.currentTimeMillis();
		task.execute();
		long end = System.currentTimeMillis();
		System.out.println("结束：" + fmt.format(new Date()));
		double delta = (end - begin) / 1000.0;
		System.out.println("耗时：" + delta + "秒");
		System.out.println("-------------------------------------");
	}
}
