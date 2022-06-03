package logon02;

import common.DBConnPool;

public class LogonDAO extends DBConnPool{
	
	//싱글톤 패턴 : 외부에서 여러개의 객체를 생성하지 못하고 하나의 객체만 공유해서 사용하도록 함.
		//0. 객체 생성자는 private 세팅
		//1. private static 으로 객체 생성 2. 생성된 객체를 메소드로 객체를 전달(public static)
	private static LogonDAO instance = new LogonDAO();
	
	//LogonDBBean 객체를 리턴하는 메소드
		//메소드를 사용해서만 객체를 생성할 수 있다.
	public static LogonDAO getInstance( ) {
		return instance;
	}
	
	// 기본 생성자 : private : 외부에서 객체 생성 불가능 함.
		// 부모 클래스의 기본 생성자 호출
	//private LogonDBBean () {super(); };
	
	public LogonDAO () {super(); };
	
	
	//회원 가입 처리(registerPro.jsp)에서 넘어오는 값을 DB에 저장(Insert)
	
	public void insertMember(LogonDTO Member) {
		
		try {
			
			String sql = "insert into member02 values(?, ?, ?, ?, ?, ?, to_date(?,'YYYY-MM-DD')) ";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Member.getU_id());
			psmt.setString(2, Member.getU_pass());
			psmt.setString(3, Member.getU_name());
			psmt.setTimestamp(4, Member.getR_date());
			psmt.setString(5, Member.getU_address());
			psmt.setString(6, Member.getU_tel());
			psmt.setString(7, Member.getU_birthday());
			
			psmt.executeUpdate();
			
			System.out.println("회원정보 DB 입력 성공");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 DB 입력시 예외 발생");
		} finally {
//				instance.close();
		}
		
		
	}
	
	public int userCheck(String u_id, String u_pass) {
		int x = -1;		//x = -1 : 아이디가 존재하지 않음
						//x = 0  : 아이디는 존재하지만 패스워드가 일치하지 않을 때
						//x = 1  : 인증 성공
		
		try {
			
			String orgPass = u_pass;	//폼에서 넘어오는 패스워드
			
			String sql = "select u_pass from member02 where u_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs = psmt.executeQuery();
			
			if (rs.next()) {	//아이디가 존재하면
				String dbpasswd = rs.getString("u_pass");	//DB에서 가져온 패스워드.
				
				if(orgPass.equals(dbpasswd)) {
					x = 1;	// 폼에서 넘겨온 패스워드와 DB에서 가져온 패스워드가 일치할 때 x : 1
				} else {
					x = 0;		//패스워드가 일치하지 않을 때
				}
				
			}
	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("아이디와 패스워드 인증 실패 했습니다.");
		} finally {
//			instance.close();	//객체 사용 종료. rs, stmt, psmt, con
		}

		return x;
	}
	
	//아이디 중복 체크(confirmId.jsp) : 아이디 중복을 확인하는 메소드
	public int confirmId(String u_id) {
		int x = -1;		//x = -1 일때 같은 ID가 DB에 존재하지 않음
						//x = 1 일때 같은 ID가 DB에 존재한다.(중복)
		
		try {
			String sql = "select u_id from member02 where u_id = ?";
			psmt = con.prepareStatement(sql);
			
			System.out.println(sql);
			
			psmt.setString(1, u_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {	//아이디가 DB에 존재하는 경우
				
				System.out.println(u_id + " 는 존재하는 ID입니다.");
				
				x = 1;
			} else {	//아이디가 DB에 존재하지 않는 경우
				System.out.println(u_id + " 는 DB에 존재하지 않는 ID입니다.");
				x = -1;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ID 중복체크 중 예외발생");
		} finally {
//				instance.close();
		}
		return x;
	}


}
