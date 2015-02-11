package service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author KB
 *
 */
public class PanierService {

	public PanierService(){
		
	}
	
	/**
	 * 
	 * @param poRequest
	 * @param filesURL
	 */
	public void DownloadImages(HttpServletResponse poResponse, String cheminDl, ArrayList<String> listeURLImages){
		//Traitement de la fonction
		try{
		    ZipOutputStream zos = new ZipOutputStream(poResponse.getOutputStream()); 
		    zipDir(cheminDl + "/", zos, listeURLImages); 
		    zos.close(); 
		} 
		catch(Exception e){ 
		    e.printStackTrace();
		}
	}
	
	/**
	 * Creation du fichier zip
	 * @param dir2zip
	 * @param zos
	 * @param filesURL
	 */
	public ZipOutputStream zipDir(String dir2zip, ZipOutputStream zos, ArrayList<String> listeURLImages){
		//Déclaration des variables
		File zipDir = new File(dir2zip); 
        File f;
        //Initialisation des variables
        byte[] readBuffer = new byte[1024]; 
        int bytesIn = 0;
        //Traitement de la fonction
	    try{  
	        for(int i=0; i<listeURLImages.size(); i++){ 
	            f = new File(zipDir, listeURLImages.get(i));
	            FileInputStream fis = new FileInputStream(f);
	         
		        ZipEntry anEntry = new ZipEntry(zipDir.getPath()); 
		        
		        //place the zip entry in the ZipOutputStream object 
		        zos.putNextEntry(anEntry); 
		        
		        //now write the content of the file to the ZipOutputStream 
		        while((bytesIn = fis.read(readBuffer)) != -1){ 
		            zos.write(readBuffer, 0, bytesIn); 
		        } 
		        //close the Stream 
		        fis.close();
	        }
	    }
	    catch(Exception e) { 
	        e.printStackTrace(); 
	    }
	    //Retour de la fonction
	    return zos;
	}
}
