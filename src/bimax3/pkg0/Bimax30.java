 
package bimax3.pkg0;

import InterfazGrafica.IniciarSesion;
import InterfazGrafica.InterfazRegistrarUsuAdmin;
import InterfazGrafica.MenuPrincipal;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;


public class Bimax30 {
   
    public static void main(String[] args) throws MessagingException, FileNotFoundException, Exception  {
        usuarios usu =new usuarios(1,"","","");
        usu.consultarc();
        if(usu.i==0){
        InterfazRegistrarUsuAdmin iusuad=new InterfazRegistrarUsuAdmin();
        iusuad.setVisible(true);
        }else{
        IniciarSesion inises =new IniciarSesion();
        inises.setVisible(true);
        }
        
        
    } 
}
