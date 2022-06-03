package logon;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//기본 제공


public class Base64Test {

	public static void main(String[] args) {
		base64();		//메인메소드에서 자신의 클래스의 다른 메소드 호출(static 메소드)

	}
	
	public static void base64() {
		
		String text = "1234";		//인코딩할 데이터를 변수에 등록
									// 인코딩 : 암호화
		//인코딩 전 텍스트를 byte 배열에 저장.
		byte[] targetByte = text.getBytes();
		
		
		///// 인코딩
		Encoder encoder = Base64.getEncoder();
			//메소드를 사용해서 Encoder 객체 생성.
		byte[] encodedBytes = encoder.encode(targetByte);
		String encoderTxt = new String(encodedBytes);	//암호화된 데이터를 String 형식으로 적용  
		
		System.out.println("============인코딩(암호화)=============");
		System.out.println("인코딩 전 데이터 : " + text);
		System.out.println("인코딩 후 데이터 : " + encoderTxt);
		
		System.out.println("============디코딩(복호화)==============");
		
		/////디코딩
		Decoder decoder = Base64.getDecoder();	//Decoder 객체 생성
		byte[] decodedBytes = decoder.decode(encodedBytes);
		byte[] decodedBytes2 = decoder.decode(encoderTxt);	//암호화된 String 복호화
		
		String decoderTxt = new String (decodedBytes);
		String decoderTxt2 = new String (decodedBytes2);
		
		
		System.out.println("복호화된 데이터 : " + decoderTxt);
		System.out.println("복호화된 데이터2 : " + decoderTxt2);
		
		
		
	}
	

}
