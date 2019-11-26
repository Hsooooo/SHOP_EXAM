package exam.user.dto;

import org.apache.commons.lang.StringUtils;

public class UserDto {
	private String user_no;
	private String user_name;
	private String user_birth;
	private String user_join_type;
	private String user_reg_date;
	private String user_addr;
	private String user_post_code;
	private String user_addr_detail;
	private String user_email;
	private String addr_flag;	
	private String user_id;
	
	public String getUser_addr() {
		return StringUtils.defaultIfEmpty(user_addr, "");
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public String getUser_post_code() {
		return StringUtils.defaultIfEmpty(user_post_code, "");
	}
	public void setUser_post_code(String user_post_code) {
		this.user_post_code = user_post_code;
	}
	public String getUser_addr_detail() {
		return StringUtils.defaultIfEmpty(user_addr_detail, "");
	}
	public void setUser_addr_detail(String user_addr_detail) {
		this.user_addr_detail = user_addr_detail;
	}
	public String getUser_email() {
		return StringUtils.defaultIfEmpty(user_email, "");
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getAddr_flag() {
		return StringUtils.defaultIfEmpty(addr_flag, "");
	}
	public void setAddr_flag(String addr_flag) {
		this.addr_flag = addr_flag;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_join_type() {
		return user_join_type;
	}
	public void setUser_join_type(String user_join_type) {
		this.user_join_type = user_join_type;
	}
	public String getUser_reg_date() {
		return user_reg_date;
	}
	public void setUser_reg_date(String user_reg_date) {
		this.user_reg_date = user_reg_date;
	}
	
	
}
