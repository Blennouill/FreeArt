
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*int workshopid = Integer.parseInt(request.getParameter("currentworkshopid"));

    javax.servlet.ServletContext context = getServletConfig().getServletContext();
    String path = context.getRealPath("finaldebrief"); --> WHAT IS THE FUCK ? */

    try 
    { 
        /*response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment;filename=qqchose.zip"); --> WHAT IS THE FUCK AUSSI ??? */

        ZipOutputStream zos = new 
               ZipOutputStream(response.getOutputStream()); 

        zipDir(path + "/", zos); 

        zos.close(); 
    } 
    catch(Exception e) 
    { 
        e.printStackTrace();
    } 

}

public void zipDir(String dir2zip, ZipOutputStream zos, ArrayList<String> filesURL) 
{
    try 
    { 
        //Crée le fichier (au chemin spécifié) qui contiendra les images et sera par la suite zippé
        File zipDir = new File(dir2zip); 

        byte[] readBuffer = new byte[1024]; 
        int bytesIn = 0; 
        
        //Boucle parcourant la liste des URL des images et les ajoutant au fichier qui sera zippé
        for(int i=0; i<filesURL.length; i++) 
        { 

            //Crée un nouveau fichier avec comme paramètre du constructeur le dossier dans lequel  il sera mit, et le lien de l'image sur le serveur 
            File f = new File(zipDir, filesURL[i]); 

            if(f.isDirectory()) 
            { 
                //Si le fichier est un dossier, on appelle cette fonction zipDir  à nouveau --> récursivité
                String filePath = f.getPath();
                zipDir(filePath, zos);
                continue; 
            }

        }
        
        //On crée donc un FileInputStream
        FileInputStream fis = new FileInputStream(f); 
        // On crée une nouvelle entrée zip 
        ZipEntry anEntry = new ZipEntry(zipDir.getPath()); 
        
        //place the zip entry in the ZipOutputStream object 
        zos.putNextEntry(anEntry); 
        
        //now write the content of the file to the ZipOutputStream 
        while((bytesIn = fis.read(readBuffer)) != -1) 
        { 
            zos.write(readBuffer, 0, bytesIn); 
        } 
        //close the Stream 
        fis.close(); 
    } 

    catch(Exception e) 
    { 
        e.printStackTrace(); 
    } 
}