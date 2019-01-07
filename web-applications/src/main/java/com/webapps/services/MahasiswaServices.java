package com.webapps.services;

import java.util.List;

import com.webapps.dto.MahasiswaDTO;


public interface MahasiswaServices {
	
	public List<MahasiswaDTO> getAllMahasiswa();
	
	public void save(MahasiswaDTO mahasiswa);
	
	public List<MahasiswaDTO> findByMahasiswaId(int id);

}
