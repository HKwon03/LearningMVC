package membership03;

public class MemberDTO03 {
	
	//멤버 변수 선언(테이블의 컬럼명)
	
	private String id;
	private String pass;
	private String name;
	private String regidate;
	private String grade;
	
	//생성자 (디버깅을 위해서 생성), 완성이되면 주석처리하면 된다.
	public MemberDTO03() {
		System.out.println("MemberDTO03 이 잘 생성되었습니다.");
	}
	
	//getter, setter 생성
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
