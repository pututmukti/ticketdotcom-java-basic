package com.webapps.dto;

import java.io.Serializable;

public class MahasiswaDTO implements Serializable {
	
	private int id;
	private String nim;
	private String namaMahasiswa;
	private int nilaiKehadiran;
	private int nilaiUts;
	private int nilaiUas;
	private int nilaiAkhir;
	private char grade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNamaMahasiswa() {
		return namaMahasiswa;
	}
	public void setNamaMahasiswa(String namaMahasiswa) {
		this.namaMahasiswa = namaMahasiswa;
	}
	public int getNilaiKehadiran() {
		return nilaiKehadiran;
	}
	public void setNilaiKehadiran(int nilaiKehadiran) {
		this.nilaiKehadiran = nilaiKehadiran;
	}
	public int getNilaiUts() {
		return nilaiUts;
	}
	public void setNilaiUts(int nilaiUts) {
		this.nilaiUts = nilaiUts;
	}
	public int getNilaiUas() {
		return nilaiUas;
	}
	public void setNilaiUas(int nilaiUas) {
		this.nilaiUas = nilaiUas;
	}
	public int getNilaiAkhir() {
		return nilaiAkhir;
	}
	public void setNilaiAkhir(int nilaiAkhir) {
		this.nilaiAkhir = nilaiAkhir;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	

}
