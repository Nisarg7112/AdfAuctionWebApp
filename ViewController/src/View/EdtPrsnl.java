package View;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;


import java.util.Base64;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;


@ManagedBean
@ViewScoped
public class EdtPrsnl {
    public EdtPrsnl() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public String getImageArray() {
        
        DCBindingContainer lBindingContainer =
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding lBinding = lBindingContainer.findIteratorBinding("UserInfo1Iterator");
        Row newRow = lBinding.getCurrentRow();
        System.out.println("newrow:imgarr:" + newRow);
        // System.out.println("sd" + newRow.getAttribute("Profilepicture"));
        
        String imageArray = "";
        BlobDomain attribute = (BlobDomain) newRow.getAttribute("Profilepicture");
        if (attribute == null) {
            System.out.println("edt:att:null");
            return imageArray;
        }
        try {
            byte[] bytesEncoded = Base64.getEncoder().encode(attribute.getBytes(1L,(int)attribute.getLength()));
            // byte[]   bytesEncoded = Base64.getEncoder().encode(attribute.getBytes());
            
            imageArray= new String(bytesEncoded); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return imageArray;
    }
    
    public void uploadFileValueChangeEvent(ValueChangeEvent valueChangeEvent)
    {
        // The event give access to an Uploade dFile which contains data about the file and its content
        UploadedFile file = (UploadedFile) valueChangeEvent.getNewValue();
        // Get the original file name
        String fileName = file.getFilename();
        // get the current roew from the ImagesView2Iterator via the binding
        System.out.println("fileName: " + fileName);
        DCBindingContainer lBindingContainer =
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding lBinding = lBindingContainer.findIteratorBinding("UserInfo1Iterator");
        Row newRow = lBinding.getCurrentRow();
        // set the file name
        newRow.setAttribute("Profilepicture", createBlobDomain(file));
    }
    
    public static BlobDomain createBlobDomain(UploadedFile file)
    {
        // init the internal variables
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
     
        try
        {
            // Get the input stream representing the data from the client
            in = file.getInputStream();
            // create the BlobDomain datatype to store the data in the db
            blobDomain = new BlobDomain();
            // get the outputStream for hte BlobDomain
            out = blobDomain.getBinaryOutputStream();
            // copy the input stream into the output stream
            /*
             * IOUtils is a class from the Apache Commons IO Package (http://www.apache.org/)
             * Here version 2.0.1 is used
             * please download it directly from http://projects.apache.org/projects/commons_io.html
             */
            // IOUtils.copy(in, out);
            byte[] buffer = new byte[4096]; // You can adjust the buffer size
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        catch (IOException e)
        {
            System.out.println("edt:ioe");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.out.println("edt:sqle");
            e.fillInStackTrace();
        }
     
        // return the filled BlobDomain
        return blobDomain;
    } 

    public String b1_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
}
