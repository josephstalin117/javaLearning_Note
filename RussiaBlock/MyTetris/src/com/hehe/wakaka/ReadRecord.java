package com.hehe.wakaka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadRecord {
	public TetrisGameRecords readRecordsFromFile(File recordFile) {
		TetrisGameRecords records = new TetrisGameRecords();
		FileInputStream fileInput = null;
		ObjectInputStream objectInput = null;

		if (!recordFile.exists()) {
			return records;
		}

		try {
			fileInput = new FileInputStream(recordFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			objectInput = new ObjectInputStream(fileInput);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Object o = null;
		try {
			o = objectInput.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			objectInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		records = (TetrisGameRecords) o;
		records.sortRecords();
		return records;
	}
}
