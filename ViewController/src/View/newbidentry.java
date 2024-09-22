package View;


import java.math.BigDecimal;

import java.sql.Timestamp;

import java.time.LocalDateTime;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

public class newbidentry extends LoggedUserHelper{
   
    private Timestamp  time;
    private Integer     bidderid;
    private RichInputText bidderId;
    private RichInputText amount;
    private RichInputText auctionid;

    private BigDecimal aid;
    private BigDecimal amou;
    private BigDecimal id;
    public newbidentry() {
    }
    
    
   public void popupfetch(PopupFetchEvent popupFetchEvent) {
      
        
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding op = bindings.getOperationBinding("CreateInsert");
        op.execute();
            
        // Add event code here...
    }

    public void popupcancel(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding op = bindings.getOperationBinding("Rollback");
        
        op.execute();
    }

    public String OKentrybid(){
       //  Add event code here...
       
       
       
        BindingContext bctx = BindingContext.getCurrent();
                    DCBindingContainer bindings = (DCBindingContainer) bctx.getCurrentBindingsEntry();
                    DCDataControl dataControl = bindings.getDataControl();
                    ApplicationModule am = (ApplicationModule)dataControl.getDataProvider();
                    ViewObject BidVO = am.findViewObject("G4BidVO2");
                    Row newBid = BidVO.createRow();
                    
                    bidderid = getLoggedInUserId();
                    time= Timestamp.valueOf(LocalDateTime.now());
                    id= BigDecimal.valueOf(bidderid);
                    Object value=amount.getValue();
                    amou=(BigDecimal) value;
                    
                    Object val=auctionid.getValue();
                    aid=(BigDecimal)val;
                     newBid.setAttribute("Bidderid",id);
                    newBid.setAttribute("Amount",amou);
                    newBid.setAttribute("Auctionid",aid);
    newBid.setAttribute("Bidtime",time);
                            try {
                                    BidVO.insertRow(newBid);
                                    am.getTransaction().commit();
                                    
                                } catch (Exception er) {
                                    er.printStackTrace();
                                    FacesContext.getCurrentInstance().addMessage(null,
                                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Creds not added!", null));
    }
    return null;
}

    /*public void OKentrybid(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
        BindingContext bctx = BindingContext.getCurrent();
                    DCBindingContainer bindings = (DCBindingContainer) bctx.getCurrentBindingsEntry();
                    DCDataControl dataControl = bindings.getDataControl();
                    ApplicationModule am = (ApplicationModule)dataControl.getDataProvider();
                    ViewObject BidVO = am.findViewObject("G4BidVO2");
                    Row newBid = BidVO.createRow();

                    bidderid = getLoggedInUserId();
                    time= Timestamp.valueOf(LocalDateTime.now());
                    bidderId1 = BigDecimal.valueOf(bidderid);
                     newBid.setAttribute("Bidderid",bidderId1);
                    newBid.setAttribute("Amount",amount);
                    newBid.setAttribute("Auctionid",auctionId);
        newBid.setAttribute("Bidtime",time);
                            try {
                                    BidVO.insertRow(newBid);
                                    am.getTransaction().commit();

                                } catch (Exception er) {
                                    er.printStackTrace();
                                    FacesContext.getCurrentInstance().addMessage(null,
                                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Creds not added!", null));
        }

    }*/
    public void setBidderId(RichInputText bidderId) {
        this.bidderId = bidderId;
    }

    public RichInputText getBidderId() {
        return bidderId;
    }

    public void setAmount(RichInputText amount) {
        this.amount = amount;
    }

    public RichInputText getAmount() {
        return amount;
    }

    public void setAuctionid(RichInputText auctionid) {
        this.auctionid = auctionid;
    }

    public RichInputText getAuctionid() {
        return auctionid;
    }
}
