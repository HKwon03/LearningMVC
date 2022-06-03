package logon;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//�⺻ ����


public class Base64Test {

	public static void main(String[] args) {
		base64();		//���θ޼ҵ忡�� �ڽ��� Ŭ������ �ٸ� �޼ҵ� ȣ��(static �޼ҵ�)

	}
	
	public static void base64() {
		
		String text = "1234";		//���ڵ��� �����͸� ������ ���
									// ���ڵ� : ��ȣȭ
		//���ڵ� �� �ؽ�Ʈ�� byte �迭�� ����.
		byte[] targetByte = text.getBytes();
		
		
		///// ���ڵ�
		Encoder encoder = Base64.getEncoder();
			//�޼ҵ带 ����ؼ� Encoder ��ü ����.
		byte[] encodedBytes = encoder.encode(targetByte);
		String encoderTxt = new String(encodedBytes);	//��ȣȭ�� �����͸� String �������� ����  
		
		System.out.println("============���ڵ�(��ȣȭ)=============");
		System.out.println("���ڵ� �� ������ : " + text);
		System.out.println("���ڵ� �� ������ : " + encoderTxt);
		
		System.out.println("============���ڵ�(��ȣȭ)==============");
		
		/////���ڵ�
		Decoder decoder = Base64.getDecoder();	//Decoder ��ü ����
		byte[] decodedBytes = decoder.decode(encodedBytes);
		byte[] decodedBytes2 = decoder.decode(encoderTxt);	//��ȣȭ�� String ��ȣȭ
		
		String decoderTxt = new String (decodedBytes);
		String decoderTxt2 = new String (decodedBytes2);
		
		
		System.out.println("��ȣȭ�� ������ : " + decoderTxt);
		System.out.println("��ȣȭ�� ������2 : " + decoderTxt2);
		
		
		
	}
	

}
