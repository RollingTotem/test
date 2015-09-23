package cn.scut.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.scut.student.bean.StudentBean;
import cn.scut.student.dao.StudentDAO;

@Component
public class StudentServiceImpl implements StudentService{
	@Autowired private StudentDAO studentDAO;
	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addNewStudent(StudentBean student) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("insert into rm_inf_student ");
		builder.append("values (");
		builder.append(student.getString()+")");
		studentDAO.deleteOrUpdate(builder.toString());
	}

	@Override
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("delete from rm_inf_student where STU_NO='"+id+"'");
		studentDAO.deleteOrUpdate(builder.toString());
	}

	/**
	 * œ»…æ≥˝£¨∫Û≤Â»Î
	 */
	@Override
	public void updateStudent(StudentBean student) {
		// TODO Auto-generated method stub
		deleteStudent(student.getStu_no());
		addNewStudent(student);
	}

	@Override
	public StudentBean queryStudent(String id) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("select * from rm_inf_student where stu_no = "+id);
		List<StudentBean> studentBeans = studentDAO.executeSQL(builder.toString());
		if(studentBeans.size()!=0){
			return studentBeans.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<StudentBean> queryStudent(String name, int academyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentBean> queryStudent(String name, String home) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("select * from rm_inf_student where stu_name = '"+name+"'");
		List<StudentBean> studentBeans = studentDAO.executeSQL(builder.toString());
		return studentBeans;
	}

}
