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
	//yeshu，yema--用于分页查询
	private int yeshu ;
	private int yema;
	//updatemode,addmode,searchmode -- 用于控制增删改模式
	private int updatemode;
	private int addmode;
	private int searchmode;
	//searchname,searchhome,searchno -- 查询条件
	private String searchname;
	private String searchno;
	private String searchhome;
	//students,singlestudent -- 用于jsp-action间传递bean，类似于struts1中的Actionform
	private StudentBean[] students;
	private StudentBean singlestudent;
	//stu_no -- 用于修改页面，传递查询值，以将记录全部获取
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
	 * 查询学生记录，各种查询条件下的查询
	 * @return
	 */
	public String execute(){
		if(searchmode==0){  //默认查询，获取分页显示结果
			StringBuilder builder = new StringBuilder();
			builder.append("select * from rm_inf_student limit ");
			builder.append(""+(yeshu*(yema-1)+1)+","+yeshu);
			ArrayList<StudentBean> studentsArray = (ArrayList<StudentBean>) StudentDAO.getInstance().executeSQL(builder.toString());
			students = new StudentBean[yeshu];
			for(int i=0;i<yeshu;i++){
				StudentBean stu = studentsArray.get(i);
				students[i] = stu;
			}
		}else {     //扩展查询，用于查询条件，根据学号查询，结果集为1或者0
			if(!searchno.equals("")){
			    StudentBean studentBean = service.queryStudent(searchno);
		    	students = new StudentBean[1];
			    students[0]=studentBean;
			}
			if(!searchname.equals("")){  //扩展查询，用于查询条件，根据姓名查询，结果集为n或者0
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
	 * 更新学生记录
	 * updatemode=0 -- 跳转到update界面             updatemode=1--完成update
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
	 * 删除学生记录
	 * @return
	 */
	public String deleteStudent(){
		service.deleteStudent(stu_no);
		return execute();
	}
	/**
	 * addmode=0--跳转到增加学生界面               addmode=1--完成增加学生
	 * 增加新学生记录
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
