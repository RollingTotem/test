package cn.scut.student.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.scut.student.bean.StudentBean;


public interface StudentService {
	
	/*
	 * ������ͬѧ
	 * 
	 */
	public void addNewStudent(StudentBean student);
	
	/**
	 * ����ѧ��id��ɾ��ѧ����¼
	 * @param id
	 */
	public void deleteStudent(String id);
	
	/**
	 * ����ѧ����
	 * @param student
	 */
	public void updateStudent(StudentBean student);
	
	/**
	 * ����ѧ��ѧ�ţ���ѯѧ����¼
	 * @param id
	 * @return
	 */
	public StudentBean queryStudent(String id);
	
	/**
	 * ����ѧԺ���룬ѧ��������ѯѧ����¼
	 * @param name
	 * @param academyId
	 * @return
	 */
	public List<StudentBean> queryStudent(String name,int academyId);
	
	/**
	 * ����ѧ�������������ѯѧ����¼
	 * @param name
	 * @param home
	 * @return
	 */
	public List<StudentBean> queryStudent(String name,String home);
}
