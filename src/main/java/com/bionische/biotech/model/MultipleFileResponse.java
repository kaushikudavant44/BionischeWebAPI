package com.bionische.biotech.model;

public class MultipleFileResponse {

	private int index;
	private String fileName;
	
	
	public MultipleFileResponse(int index, String fileName) {
		super();
		this.index = index;
		this.fileName = fileName;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "MultipleFileResponse [index=" + index + ", fileName=" + fileName + "]";
	}
	
	
}
