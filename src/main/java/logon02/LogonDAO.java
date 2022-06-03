package logon02;

import common.DBConnPool;

public class LogonDAO extends DBConnPool{
	
	//�̱��� ���� : �ܺο��� �������� ��ü�� �������� ���ϰ� �ϳ��� ��ü�� �����ؼ� ����ϵ��� ��.
		//0. ��ü �����ڴ� private ����
		//1. private static ���� ��ü ���� 2. ������ ��ü�� �޼ҵ�� ��ü�� ����(public static)
	private static LogonDAO instance = new LogonDAO();
	
	//LogonDBBean ��ü�� �����ϴ� �޼ҵ�
		//�޼ҵ带 ����ؼ��� ��ü�� ������ �� �ִ�.
	public static LogonDAO getInstance( ) {
		return instance;
	}
	
	// �⺻ ������ : private : �ܺο��� ��ü ���� �Ұ��� ��.
		// �θ� Ŭ������ �⺻ ������ ȣ��
	//private LogonDBBean () {super(); };
	
	public LogonDAO () {super(); };
	
	
	//ȸ�� ���� ó��(registerPro.jsp)���� �Ѿ���� ���� DB�� ����(Insert)
	
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
			
			System.out.println("ȸ������ DB �Է� ����");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ȸ������ DB �Է½� ���� �߻�");
		} finally {
//				instance.close();
		}
		
		
	}
	
	public int userCheck(String u_id, String u_pass) {
		int x = -1;		//x = -1 : ���̵� �������� ����
						//x = 0  : ���̵�� ���������� �н����尡 ��ġ���� ���� ��
						//x = 1  : ���� ����
		
		try {
			
			String orgPass = u_pass;	//������ �Ѿ���� �н�����
			
			String sql = "select u_pass from member02 where u_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs = psmt.executeQuery();
			
			if (rs.next()) {	//���̵� �����ϸ�
				String dbpasswd = rs.getString("u_pass");	//DB���� ������ �н�����.
				
				if(orgPass.equals(dbpasswd)) {
					x = 1;	// ������ �Ѱܿ� �н������ DB���� ������ �н����尡 ��ġ�� �� x : 1
				} else {
					x = 0;		//�н����尡 ��ġ���� ���� ��
				}
				
			}
	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���̵�� �н����� ���� ���� �߽��ϴ�.");
		} finally {
//			instance.close();	//��ü ��� ����. rs, stmt, psmt, con
		}

		return x;
	}
	
	//���̵� �ߺ� üũ(confirmId.jsp) : ���̵� �ߺ��� Ȯ���ϴ� �޼ҵ�
	public int confirmId(String u_id) {
		int x = -1;		//x = -1 �϶� ���� ID�� DB�� �������� ����
						//x = 1 �϶� ���� ID�� DB�� �����Ѵ�.(�ߺ�)
		
		try {
			String sql = "select u_id from member02 where u_id = ?";
			psmt = con.prepareStatement(sql);
			
			System.out.println(sql);
			
			psmt.setString(1, u_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {	//���̵� DB�� �����ϴ� ���
				
				System.out.println(u_id + " �� �����ϴ� ID�Դϴ�.");
				
				x = 1;
			} else {	//���̵� DB�� �������� �ʴ� ���
				System.out.println(u_id + " �� DB�� �������� �ʴ� ID�Դϴ�.");
				x = -1;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ID �ߺ�üũ �� ���ܹ߻�");
		} finally {
//				instance.close();
		}
		return x;
	}


}
