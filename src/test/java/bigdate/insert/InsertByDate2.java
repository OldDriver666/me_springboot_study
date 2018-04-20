package bigdate.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class InsertByDate2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		final String url = "jdbc:mysql://127.0.0.1/test";
		final String name = "com.mysql.jdbc.Driver";
		final String user = "root";
		final String password = "123456";
		Connection conn = null;
		Class.forName(name);// 指定连接类型
		conn = DriverManager.getConnection(url, user, password);// 获取连接
		if (conn != null) {
			System.out.println("获取连接成功");
			insert(conn);
		} else {
			System.out.println("获取连接失败");
		}

	}

	public static void insert(Connection conn) throws ParseException {
		// 开始时间
		Long begin = new Date().getTime();
		// sql前缀
		String prefix = "INSERT INTO imevent0 (user_id, event_key, location_x, location_y, location_from, battery, sq, event_level, param, createtime) VALUES ";

		int c = 1500; // 设备数量
		int count = 0;
		try {
			// 保存sql后缀
			StringBuffer suffix = new StringBuffer();
			// 设置事务为非自动提交
			conn.setAutoCommit(false);
			// 比起st，pst会更好些
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");// 准备执行语句
			// 外层循环，总提交事务次数

			// 循环日期
			Calendar ca = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date curDate = df.parse("2018-04-01 00:00:00");
			Date endDate = df.parse("2018-04-31 00:00:00");
			int flag = 0;
			int max = 30;
			
			while (curDate.compareTo(endDate) <= 0) {
				count++;
				ca.setTime(curDate);
				// 业务处理...
				ca.add(ca.MINUTE, 5);
				curDate = ca.getTime();
				
				// 第j次提交步长
				for (int z = 1; z <= c; z++) {
					// 构建SQL后缀
					suffix.append("(");
					suffix.append(z);
					suffix.append(",16, 22.6845380, 113.9856481, 0, 20, 5, 1, 'step:2021','");
					suffix.append(df.format(curDate));
					suffix.append("'),");
				}
				flag ++;
				if (flag == max) {
					// 构建完整SQL
					String sql = prefix + suffix.substring(0, suffix.length() - 1);
					// 添加执行SQL
					pst.addBatch(sql);
					// 执行操作
					pst.executeBatch();
					// 提交事务
					conn.commit();
					flag = 0;
					suffix = new StringBuffer();
				}


			}
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 结束时间
		Long end = new Date().getTime();
		// 耗时
		System.out.println(count*c/10000 + "万条数据插入花费时间 : " + (end - begin) / 1000 + " s");
		System.out.println("插入完成");
	}
}