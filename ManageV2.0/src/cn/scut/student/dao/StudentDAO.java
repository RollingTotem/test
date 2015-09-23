package cn.scut.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.scut.student.bean.StudentBean;

@Repository
public class StudentDAO {
	
	private static String db_url;
	private static String db_username;
	private static String db_password;
	private static Connection con;
	private static Statement stmt;
	private static ResultSet resultset;
	
	/**
	 * �������ģʽ��������ʽ
	 * ά��һ��DAO����
	 */
	private static StudentDAO dao = new StudentDAO();
	private StudentDAO(){}
	public static StudentDAO getInstance(){
		db_url = "jdbc:mysql://localhost:3306/db_resoucemanage";
		db_username = "root";
		db_password = "xiongyanan";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection)DriverManager.getConnection(db_url,db_username,db_password);
			stmt = (Statement)con.createStatement() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return dao;
	} 
	/**
	 * ��ѯ��䣬
	 * @param sql-sql���
	 * @return  List����
	 */
	public List<StudentBean> executeSQL(String sql){
		List<StudentBean> students = new ArrayList<StudentBean>();
		try {
			resultset = stmt.executeQuery(sql);
			while(resultset.next()){
				StudentBean student = new StudentBean();
				student.setMaj_no(resultset.getInt("MAJ_NO"));
				student.setStu_no(resultset.getString("STU_NO"));
				student.setStu_name(resultset.getString("STU_NAME"));
				student.setStu_home(resultset.getString("STU_HOME"));
				student.setStu_phone(resultset.getString("STU_PHONE"));
				student.setStu_idnum(resultset.getString("STU_IDNUM"));
				student.setStu_psw(resultset.getString("STU_PSW"));
				student.setStu_gender(resultset.getInt("STU_GENDER"));
				student.setStu_birth(resultset.getDate("STU_BIRTH"));
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}
	/**
	 * ���ӡ�ɾ�������²���
	 * @param sql
	 */
	public void deleteOrUpdate(String sql){
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void show(){
		System.out.println("dao����ģʽ�ɹ�ע��");
	}
}
