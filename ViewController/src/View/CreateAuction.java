package View;

import java.io.IOException;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;

import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;

import view.MyADFUtil;
@ManagedBean
@SessionScoped
public class CreateAuction extends LoggedUserHelper{
    public CreateAuction() {
        
    }

    

    public String create(){
        BindingContext bctx = BindingContext.getCurrent();
        DCBindingContainer bindings = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        OperationBinding operationbinding = bindings.getOperationBinding("Commit");
        
        FacesContext con = FacesContext.getCurrentInstance();
        
        System.out.println("Entered" );
        MyADFUtil.setAttributeInIterator("G4AuctionVO1Iterator", "Creatorid", getLoggedInUserId());
            
       BigDecimal price = (BigDecimal)MyADFUtil.getAttributeFromIterator("G4AuctionVO1Iterator","Startprice");
        MyADFUtil.setAttributeInIterator("G4AuctionVO1Iterator", "Currentprice", price);
        
        
                   
                          
        try {
                 Object result = operationbinding.execute();
                       if (!operationbinding.getErrors().isEmpty()) {
                           return null;
                       }
                 con.getExternalContext().redirect("/ViewController/faces/Home");
            MyADFUtil.showSuccessfulMessage("Auction Created Successfully");
             } catch (IOException e) {
                 System.out.println(e);
             }
                    
           return null;    
    }
}
