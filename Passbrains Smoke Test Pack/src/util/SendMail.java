package util;

 

//set CLASSPATH=%CLASSPATH%;activation.jar;mail.jar

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;

 

public class SendMail

{
    public static void main(String[] args)

    {
    	//TestUtil.zip("C:\\rep");
		//TestUtil.zip("C:\\Report");
    	try {
			Zip.zipDir("C:\\Report",System.getProperty("user.dir")+"\\Report.zip" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
                String[] to={"abhinav.sejpal@pass.ch"};

                String[] cc={};
                String[] bcc={};

                //This is for google

                SendMail.sendMail("rahul7751@gmail.com",
                		            "heera123",
                		            "smtp.gmail.com",
                		            "465",
                		            "true",
                		            "true",
                		            true,
                		           "javax.net.ssl.SSLSocketFactory",
                		            "false",
                		            to,
                		            cc,
                		            bcc,
                		            "Automation Test Report",
                		            "Please find the reports attached.\n\n Cheers\nAutoMAN",
                		        	System.getProperty("user.dir")+"\\Report.zip",
                		        	"Report.zip");
           

    }

 

        public  static boolean sendMail(String userName,
        		String passWord,
        		String host,
        		String port,
        		String starttls,
        		String auth,
        		boolean debug,
        		String socketFactoryClass,
        		String fallback,
        		String[] to,
        		String[] cc,
        		String[] bcc,
        		String subject,
        		String text,
        		String attachmentPath,
        		String attachmentName){


                Properties props = new Properties();

                //Properties props=System.getProperties();

        props.put("mail.smtp.user", userName);

        props.put("mail.smtp.host", host);

                if(!"".equals(port))

        props.put("mail.smtp.port", port);

                if(!"".equals(starttls))

        props.put("mail.smtp.starttls.enable",starttls);

        props.put("mail.smtp.auth", auth);
       // props.put("mail.smtps.auth", "true");


                if(debug){

                props.put("mail.smtp.debug", "true");

                }else{

                props.put("mail.smtp.debug", "false");         

                }

                if(!"".equals(port))

        props.put("mail.smtp.socketFactory.port", port);

               if(!"".equals(socketFactoryClass))

        props.put("mail.smtp.socketFactory.class",socketFactoryClass);

                if(!"".equals(fallback))

        props.put("mail.smtp.socketFactory.fallback", fallback);

 

        try

        {

                        Session session = Session.getDefaultInstance(props, null);

            session.setDebug(debug);

            MimeMessage msg = new MimeMessage(session);

            msg.setText(text);

            msg.setSubject(subject);
            //attachment start
            // create the message part 
           
            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = 
              new FileDataSource(attachmentPath);
            messageBodyPart.setDataHandler(
              new DataHandler(source));
            messageBodyPart.setFileName(attachmentName);
            multipart.addBodyPart(messageBodyPart);
            
            // attachment ends

            // Put parts in message
            msg.setContent(multipart);
            msg.setFrom(new InternetAddress(userName));

                        for(int i=0;i<to.length;i++){

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));

                        }

                        for(int i=0;i<cc.length;i++){

            msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));

                        }

                        for(int i=0;i<bcc.length;i++){

            msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));

                        }

            msg.saveChanges();

                        Transport transport = session.getTransport("smtp");

                        transport.connect(host, userName, passWord);

                        transport.sendMessage(msg, msg.getAllRecipients());

                        transport.close();

                        return true;

        }

        catch (Exception mex)

        {

            mex.printStackTrace();

                        return false;

        }

        }

 

}