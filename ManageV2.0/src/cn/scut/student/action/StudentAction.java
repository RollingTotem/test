package cn.scut.student.action;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.scut.student.bean.StudentBean;
import cn.scut.student.dao.StudentDAO;
import cn.scut.student.service.StudentService;
import cn.scut.student.service.StudentServiceImpl;


@Controller
public class StudentAction {
	//yeshu��yema--���ڷ�ҳ��ѯ
	private int yeshu ;
	private int yema;
	//updatemode,addmode,searchmode -- ���ڿ�����ɾ��ģʽ
	private int updatemode;
	private int addmode;
	private int searchmode;
	//searchname,searchhome,searchno -- ��ѯ����
	private String searchname;
	private String searchno;
	private String searchhome;
	//students,singlestudent -- ����jsp-action�䴫��bean��������struts1�е�Actionform
	private StudentBean[] students;
	private StudentBean singlestudent;
	//stu_no -- �����޸�ҳ�棬���ݲ�ѯֵ���Խ���¼ȫ����ȡ
	private String stu_no;
	//private static StudentService service = new StudentServiceImpl();
	@Autowired private StudentServiceImpl service;
	
	public String getSearchname() {
		return searchname;
	}
	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}
	public String getSearchhome() {
		return searchhome;
	}
	public void setSearchhome(String searchhome) {
		this.searchhome = searchhome;
	}
	public int getSearchmode() {
		return searchmode;
	}
	public void setSearchmode(int searchmode) {
		this.searchmode = searchmode;
	}
	public int getAddmode() {
		return addmode;
	}
	public void setAddmode(int addmode) {
		this.addmode = addmode;
	}
	public int getUpdatemode() {
		return updatemode;
	}
	public void setUpdatemode(int updatemode) {
		this.updatemode = updatemode;
	}
	public String getSearchno() {
		return searchno;
	}
	public void setSearchno(String searchno) {
		this.searchno = searchno;
	}
	public int getYeshu() {
		return yeshu;
	}
	public void setYeshu(int yeshu) {
		this.yeshu = yeshu;
	}
	public int getYema() {
		return yema;
	}
	public void setYema(int yema) {
		this.yema = yema;
	}
	public StudentBean[] getStudents() {
		return students;
	}
	public void setStudents(StudentBean[] students) {
		this.students = students;
	}
	public String getStu_no() {
		return stu_no;
	}
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	public StudentBean getSinglestudent() {
		return singlestudent;
	}
	public void setSinglestudent(StudentBean singlestudent) {
		this.singlestudent = singlestudent;
	}
	/**
	 * ��ѯѧ����¼�����ֲ�ѯ�����µĲ�ѯ
	 * @return
	 */
	public String execute(){
		if(searchmode==0){  //Ĭ�ϲ�ѯ����ȡ��ҳ��ʾ���
			StringBuilder builder = new StringBuilder();
			builder.append("select * from rm_inf_student limit ");
			builder.append(""+(yeshu*(yema-1)+1)+","+yeshu);
			ArrayList<StudentBean> studentsArray = (ArrayList<StudentBean>) StudentDAO.getInstance().executeSQL(builder.toString());
			students = new StudentBean[yeshu];
			for(int i=0;i<yeshu;i++){
				StudentBean stu = studentsArray.get(i);
				students[i] = stu;
			}
		}else {     //��չ��ѯ�����ڲ�ѯ����������ѧ�Ų�ѯ�������Ϊ1����0
			if(!searchno.equals("")){
			    StudentBean studentBean = service.queryStudent(searchno);
		    	students = new StudentBean[1];
			    students[0]=studentBean;
			}
			if(!searchname.equals("")){  //��չ��ѯ�����ڲ�ѯ����������������ѯ�������Ϊn����0
				ArrayList<StudentBean> studentArray = (ArrayList<StudentBean>) service.queryStudent(searchname, searchhome);
				Iterator<StudentBean> iterator = studentArray.iterator();
				students = new StudentBean[studentArray.size()];
				int i = 0;
				while(iterator.hasNext()){
					students[i] = iterator.next();
					i++;
				}
			}
		}
		return "success";
	}
	/**
	 * ����ѧ����¼
	 * updatemode=0 -- ��ת��update����             updatemode=1--���update
	 * @return
	 */
	public String updateStudent(){
		System.out.println("--------------");
		if(updatemode==0){
			singlestudent = service.queryStudent(stu_no);
			return "updateStudent";
		}else{
			service.updateStudent(singlestudent);
			return execute();
		}
	}
	/**
	 * ɾ��ѧ����¼
	 * @return
	 */
	public String deleteStudent(){
		service.deleteStudent(stu_no);
		return execute();
	}
	/**
	 * addmode=0--��ת������ѧ������               addmode=1--�������ѧ��
	 * ������ѧ����¼
	 * @return
	 */
	public String addStudent(){
		if(addmode == 0){
			return "addStudent";
		}else{
			service.addNewStudent(singlestudent);
			return execute();
		}
	}
}
