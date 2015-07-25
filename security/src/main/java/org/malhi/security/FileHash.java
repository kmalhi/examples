package org.malhi.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;

public class FileHash {
	public static String hash(String filePath) throws NoSuchAlgorithmException,
			IOException {
		String hash = null;
		byte[] digest = null;
		try(DigestInputStream dis = new DigestInputStream(new FileInputStream(
				filePath), MessageDigest.getInstance("SHA-1"))){
		// Read the stream
		while (dis.read() != -1)
			;
		digest = dis.getMessageDigest().digest();
		}
		try (Formatter formatter = new Formatter()) {
			for (final byte b : digest) {
				formatter.format("%02x", b);
			}

			hash = formatter.toString();
		}
		return hash;
	}
	public static String hashWithGuava(String filePath) throws IOException{
		return Files.hash(new File(filePath), Hashing.sha1()).toString();
	}
}
