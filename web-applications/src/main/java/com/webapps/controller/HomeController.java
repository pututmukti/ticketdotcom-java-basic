package com.webapps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapps.dto.MahasiswaDTO;
import com.webapps.services.MahasiswaServices;

@Controller
public class HomeController {
	
	@Autowired
	private MahasiswaServices mahasiswaServicesImpl;
	
	  @RequestMapping("/")
	  public String home() {
//		  MahasiswaDTO mahasiswa = new MahasiswaDTO();
//		  mahasiswa.setId(1);
//  		mahasiswa.setNamaMahasiswa("PUTUT MUKTI WIBOWO");
//  		mahasiswa.setNilaiAkhir(80);
//  		mahasiswa.setNilaiKehadiran(80);
//  		mahasiswa.setNilaiUas(80);
//  		mahasiswa.setNilaiUts(80);
// 		mahasiswa.setGrade('A');
//  		mahasiswaServicesImpl.save(mahasiswa);
	      return "home";
	  }
	  
	  @RequestMapping("/mahasiswaList")
	  public String getMahasiswaList(Model model) {
		  
		  List<MahasiswaDTO> mahasisList =  mahasiswaServicesImpl.getAllMahasiswa();
		  int jumlahMahasiswa = 0;
		  int jumlahMahasiswaLulus = 0;
		  int jumlahMahasiswaTidakLulus = 0;
		  
		  for(MahasiswaDTO mahasiswa : mahasisList) {
			  jumlahMahasiswa++;
			  if(mahasiswa.getGrade()=='D' || mahasiswa.getGrade()=='E' ) {
				  jumlahMahasiswaTidakLulus++;
			  }else {
				  jumlahMahasiswaLulus++;
			  }
			  
		  }
		  
		  model.addAttribute("mahasisList", mahasisList);
		  model.addAttribute("jumlahMahasiswa", jumlahMahasiswa);
		  model.addAttribute("jumlahMahasiswaLulus", jumlahMahasiswaLulus);
		  model.addAttribute("jumlahMahasiswaTidakLulus", jumlahMahasiswaTidakLulus);

		  return "mahasiswa";
	  }
	  
	  @RequestMapping("/mahasiswaAdd")
	  public String mahasiswaAddForm(Model model){
		  MahasiswaDTO mahasiswa = new MahasiswaDTO();
		  model.addAttribute("mahasiswa", mahasiswa);

	
		  return "addMahasiswa";
		  
	  }
	  
	  @RequestMapping(value = "/addMahasiswa", method = RequestMethod.POST)
	    public String addProductPost(@ModelAttribute("mahasiswa") MahasiswaDTO mahasiswa) {
		    int nilaiAkhir = (int) ((mahasiswa.getNilaiKehadiran() * 0.2) + (mahasiswa.getNilaiUts() * 0.4) 
		    					+ (mahasiswa.getNilaiUas() * 0.4));
		    char grade = ' ';
		    if(nilaiAkhir <= 45) {
		    		grade = 'E';
		    }else if(nilaiAkhir > 45 && nilaiAkhir <= 60 ) {
		    		grade = 'D';
		    }else if(nilaiAkhir > 60 && nilaiAkhir  <= 75 ) {
	    			grade = 'C';
		    }else if(nilaiAkhir > 75 &&  nilaiAkhir <= 84) {
	    			grade = 'B';
		    }else if(nilaiAkhir > 84 &&  nilaiAkhir <= 100) {
    				grade = 'A';
		    }
		    mahasiswa.setNilaiAkhir(nilaiAkhir);
		    mahasiswa.setGrade(grade);
		    mahasiswaServicesImpl.save(mahasiswa);
	        return "redirect:/mahasiswaList";
	    }

}

