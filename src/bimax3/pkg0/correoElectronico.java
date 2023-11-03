
package bimax3.pkg0;

import java.lang.System.Logger.Level;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;


public class correoElectronico {

    public correoElectronico(String arxml,String nomxml,String arpdf,String nompdf, String correocliente, String correoelectronicoadmin, String contraseñacorreo) throws Exception {
        String ubicacionarchivoxml=arxml;
        String nombrearchivoxml=nomxml; 
        String ubicacionarchivopdf=arpdf;
        String nombrearchivopdf=nompdf; 
        String correoremitente = correoelectronicoadmin;
        String passwordremitente = contraseñacorreo;
        String correoreceptor = correocliente;
        String asunto = "Envio de archivos adjuntos";        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", correoremitente);
        props.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(props);
        //Para enviar archivos adjuntos
        BodyPart archivo = new MimeBodyPart();
        archivo.setText("Reciba un cordial saludo, entrega de se factura electronica");
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource(ubicacionarchivoxml)));
        adjunto.setFileName(nombrearchivoxml);
        BodyPart adjunto1 = new MimeBodyPart();
        adjunto1.setDataHandler(new DataHandler(new FileDataSource(ubicacionarchivopdf)));
        adjunto1.setFileName(nombrearchivopdf);
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(archivo);
        m.addBodyPart(adjunto);
        m.addBodyPart(adjunto1);
        MimeMessage men = new MimeMessage(sesion); 
        try {
            men.setFrom(new InternetAddress(correoremitente));
            men.addRecipient(Message.RecipientType.TO, new InternetAddress(correoreceptor));
            men.setSubject(asunto);
            men.setContent(m);
            Transport t = sesion.getTransport("smtp");
            t.connect(correoremitente,passwordremitente);
            t.sendMessage(men, men.getRecipients(Message.RecipientType.TO));
            t.close();
            System.out.println("Se envio correctamente");
            
        } catch (AddressException ex) {
            java.util.logging.Logger.getLogger(correoElectronico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}
