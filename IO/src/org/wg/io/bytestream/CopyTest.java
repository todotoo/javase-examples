package org.wg.io.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class CopyTest {

//	千万不要用，效率几乎没有！
	// 基本字节流一次读写一个字节
	@Test
	public void copy_4() throws IOException {
		FileInputStream fis = new FileInputStream("c:\\0.mp3");		
		FileOutputStream fos = new FileOutputStream("c:\\4.mp3");
		
		int ch = 0;
		
		while((ch =fis.read())!=-1){
			fos.write(ch);
		}
		
		fos.close();
		fis.close();
	}

	//不建议。 
	@Test
	public void copy_3() throws IOException {
		FileInputStream fis = new FileInputStream("c:\\0.mp3");		
		FileOutputStream fos = new FileOutputStream("c:\\3.mp3");
		
		byte[] buf = new byte[fis.available()];
		fis.read(buf);
		fos.write(buf);
		fos.close();
		fis.close();
	}

	
	// 字节缓冲流一次读写一个字节
	@Test
	public void copy_2() throws IOException {
		
		FileInputStream fis = new FileInputStream("c:\\0.mp3");	
		BufferedInputStream bufis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("c:\\2.mp3");
		BufferedOutputStream bufos = new BufferedOutputStream(fos);
		
		int ch = 0;
		
		while((ch=bufis.read())!=-1){
			bufos.write(ch);
		}
		
		bufos.close();
		bufis.close();
	}

	public static void copy_1() throws IOException {
		
		FileInputStream fis = new FileInputStream("c:\\0.mp3");		
		FileOutputStream fos = new FileOutputStream("c:\\1.mp3");
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		fos.close();
		fis.close();
	}
	
	// 字节缓冲流一次读写一个字节数组
	private static void method5() throws IOException {
		FileInputStream fis = new FileInputStream("c:\\0.mp3");	
		BufferedInputStream bufis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("c:\\2.mp3");
		BufferedOutputStream bufos = new BufferedOutputStream(fos);

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = bufis.read(bys)) != -1) {
			bufos.write(bys, 0, len);
		}

		bufis.close();
		bufis.close();
	}
}
