package Controller;
import java.io.*;
public class GestionArchivo {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
    public GestionArchivo (){
        
    }
    
    //Metodo para abrir un archivo de texto
    public String AbrirTexto(File archivo){
        String contenido = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            
            while((ascci = entrada.read())!= -1){
                char caracter = (char) ascci;
                contenido += caracter;
            }
        } catch (Exception e) {
        }
        return contenido;
    }
    
    //Metodo para guardar un archivo de texto
    public String GuardarArchivo(File archivo, String contenido){
        String respuesta = null;
        
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Se guardo con exito el archivo";
        } catch (Exception e) {
        }
        
        return respuesta;
    }
    
    //Metodo para abrir una imagen
    public byte[] AbrirImagen(File archivo){
        byte[] byteImg = new byte[1024*100];
        
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(byteImg);
        } catch (Exception e) {
        }
        return byteImg;
    }
    
    //Metodo para guardar imagen
    public String GuardarImagen(File archivo, byte[] bytesImg){
        String respuesta = null;
        
        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesImg);
            respuesta = "La imagen se guardo con exito";
        } catch (Exception e) {
        }
        
        return respuesta;
    }
}
