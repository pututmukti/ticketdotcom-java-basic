package com.webapps.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.webapps.dao.MahasiswaDAO;
import com.webapps.dto.MahasiswaDTO;
import com.webapps.services.MahasiswaServices;

@SuppressWarnings("deprecation")
@Service
public class MahasiswaServicesImpl implements MahasiswaServices {
	
	
	private MahasiswaDAO mahasiswaDAO;
	

	@Override
	public List<MahasiswaDTO> getAllMahasiswa() {
		MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
		List<MahasiswaDTO> mahasiswaList  = mahasiswaDAO.getAll();
		return mahasiswaList;
	}

	@Override
	public void save(MahasiswaDTO mahasiswa) {
		// TODO Auto-generated method stub
		MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
		try {
			mahasiswaDAO.saveFile(mahasiswa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MahasiswaDTO> findByMahasiswaId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
