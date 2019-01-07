package com.webapps.dao;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.apache.taglibs.standard.extra.spath.Path;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.webapps.dto.MahasiswaDTO;


public class MahasiswaDAO {
    private EntityManager entityManager;
    
    public List<MahasiswaDTO> getAll(){
    		
    		String fileName = "src/main/webapp/WEB-INF/sourcefile/mahasiswaFiles.txt";
    		List<MahasiswaDTO> mahasiswaList  = new ArrayList();
    		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
			if(inputStream != null) {
				mahasiswaList = (List<MahasiswaDTO>) inputStream.readObject();
			}else {
				MahasiswaDTO mahasiswa = new MahasiswaDTO();
				mahasiswa.setId(1);
		    		mahasiswa.setNamaMahasiswa("");
		    		mahasiswa.setNilaiAkhir(0);
		    		mahasiswa.setNilaiKehadiran(0);
		    		mahasiswa.setNilaiUas(0);
		    		mahasiswa.setNilaiUts(0);
		    		mahasiswa.setGrade(' ');
		    		mahasiswaList.add(mahasiswa);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mahasiswaList;
    }
    
    public void saveFile(MahasiswaDTO mahasiswa) throws ClassNotFoundException {
    		
    		
        List<MahasiswaDTO> mahasiswaList = new ArrayList<MahasiswaDTO>();

    		
    		String fileName = "src/main/webapp/WEB-INF/sourcefile/mahasiswaFiles.txt";
    		
    		try {
				//ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName,true));
				//outputStream.writeObject(mahasiswa);
				//outputStream.close();
    			   boolean fileNull = true;
    			   
    			   FileReader file = new FileReader(fileName);
    			   BufferedReader reader = new BufferedReader(file);
    			   String text = "";
    			   String line = reader.readLine();
    			   while(line != null) {
    				   fileNull = false;
    				   break;
    			   }
    			       				
	    			if(fileNull) {
	    				mahasiswa.setId(1);
	    				mahasiswaList.add(mahasiswa);
	    				ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
	    			    outputStream.writeObject(mahasiswaList);
	    				outputStream.close();
	    			}else {
		    			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
		    			mahasiswaList = (List<MahasiswaDTO>) inputStream.readObject();
		    			MahasiswaDTO mahasiswaValueLast = mahasiswaList.get(mahasiswaList.size() - 1);
		    			mahasiswa.setId(mahasiswaValueLast.getId() + 1);
		    			mahasiswaList.add(mahasiswa);
		    			
		    			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
				    outputStream.writeObject(mahasiswaList);
					outputStream.close();
	    			}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    		
    	
    }


}
