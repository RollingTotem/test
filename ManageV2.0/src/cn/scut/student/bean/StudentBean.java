package cn.scut.student.bean;

import java.sql.Date;

public class StudentBean {
	private String stu_no;    //学号
	private String stu_name;  //姓名
	private Date stu_birth;   //出生年月
	private int stu_gender;   //性别
	private String stu_home;  //籍贯
	private String stu_phone;  //联系号码
	private int maj_no;        //专业代码
	private String stu_idnum;  //身份证号
	private String stu_psw;    //登录密码
	
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}
	public String getStu_no() {
		return stu_no;
	}
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public Date getStu_birth() {
		return stu_birth;
	}
	public void setStu_birth(Date stu_birth) {
		this.stu_birth = stu_birth;
	}
	public int getStu_gender() {
		return stu_gender;
	}
	public void setStu_gender(int stu_gender) {
		this.stu_gender = stu_gender;
	}
	public String getStu_home() {
		return stu_home;
	}
	public void setStu_home(String stu_home) {
		this.stu_home = stu_home;
	}
	public String getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}
	public int getMaj_no() {
		return maj_no;
	}
	public void setMaj_no(int i) {
		this.maj_no = i;
	}
	public String getStu_idnum() {
		return stu_idnum;
	}
	public void setStu_idnum(String stu_idnum) {
		this.stu_idnum = stu_idnum;
	}
	public String getStu_psw() {
		return stu_psw;
	}
	public void setStu_psw(String stu_psw) {
		this.stu_psw = stu_psw;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = this.stu_name+"	"+this.stu_no+"	"+this.stu_gender+"	"+this.stu_home+"	"
			+this.stu_phone+"	"+this.stu_idnum;
		return str;
	}
	public String getString(){
		return "'"+stu_no+"','"+stu_name+"','"+stu_birth+"','"+stu_gender+"','"+stu_home+"','"+stu_phone+"','"+maj_no+"','"+stu_idnum+"','"+stu_psw+"'";
	}
}
