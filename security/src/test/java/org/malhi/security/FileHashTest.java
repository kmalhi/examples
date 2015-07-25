package org.malhi.security;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Stopwatch;

public class FileHashTest {
	private static String path = null;
	private static Stopwatch stopwatch = null;
	@BeforeClass
	public static void setup(){
		URL resource = FileHashTest.class.getClassLoader().getResource("test.txt");
		 path = resource.getPath();
	}
	@Test
	public void testHash() {
		stopwatch = Stopwatch.createStarted();
		try {
			String hash = FileHash.hash(path);
			assertEquals("6e24eb592cdfbe83c74943562737b62cdfc6b980", hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopwatch.stop();
		long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		System.out.println("time: "+elapsed);
	}
	
	@Test
	public void testHashWithGuava(){
		stopwatch = Stopwatch.createStarted();
		try {
			String hash = FileHash.hashWithGuava(path);
			assertEquals("6e24eb592cdfbe83c74943562737b62cdfc6b980", hash);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopwatch.stop();
		long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		System.out.println("time: "+elapsed);
	}

}
