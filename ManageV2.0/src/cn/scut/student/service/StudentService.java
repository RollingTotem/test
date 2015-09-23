package cn.scut.student.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.scut.student.bean.StudentBean;


public interface StudentService {
	
	/*
	 * 增加新同学
	 * 
	 */
	public void addNewStudent(StudentBean student);
	
	/**
	 * 根据学生id，删除学生记录
	 * @param id
	 */
	public void deleteStudent(String id);
	
	/**
	 * 更新学生表
	 * @param student
	 */
	public void updateStudent(StudentBean student);
	
	/**
	 * 根据学生学号，查询学生记录
	 * @param id
	 * @return
	 */
	public StudentBean queryStudent(String id);
	
	/**
	 * 根据学院代码，学生姓名查询学生记录
	 * @param name
	 * @param academyId
	 * @return
	 */
	public List<StudentBean> queryStudent(String name,int academyId);
	
	/**
	 * 根据学生姓名，籍贯查询学生记录
	 * @param name
	 * @param home
	 * @return
	 */
	public List<StudentBean> queryStudent(String name,String home);
}
