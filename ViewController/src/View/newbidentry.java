package View;


import java.math.BigDecimal;

import java.sql.Timestamp;

import java.time.LocalDateTime;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import view.MyADFUtil;

@ManagedBean
@SessionScoped
public class newbidentry extends LoggedUserHelper{
    private RichPopup myPopup;
    
    private Timestamp  time;
    private Integer     bidderid;
    private BigDecimal id;
    private int amount;

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

    public void OKentrybid(){
       //  Add event code here...
       
       
       
        BindingContext bctx = BindingContext.getCurrent();
                    DCBindingContainer bindings = (DCBindingContainer) bctx.getCurrentBindingsEntry();
                    DCDataControl dataControl = bindings.getDataControl();
                    ApplicationModule am = (ApplicationModule)dataControl.getDataProvider();
                    
        ViewObject AuctionVo=am.findViewObject("G4AuctionVO2_1");
        Row auction=AuctionVo.first();
        BigDecimal auctionid = (BigDecimal) auction.getAttribute("Auctionid");
        
                    ViewObject BidVO = am.findViewObject("G4BidVO2");
                    Row newBid = BidVO.createRow();
                    
                    bidderid = getLoggedInUserId();
                    time= Timestamp.valueOf(LocalDateTime.now());
                    id= BigDecimal.valueOf(bidderid);
                    

                    
                    newBid.setAttribute("Bidderid",id);
                    newBid.setAttribute("Amount",amount);
                    newBid.setAttribute("Auctionid",auctionid);
                    newBid.setAttribute("Bidtime",time);
                    auction.setAttribute("Currentprice",amount);
                    
                            try {
                                    AuctionVo.setCurrentRow(auction);
                                    BidVO.insertRow(newBid);
                                    am.getTransaction().commit();
                                    MyADFUtil.showSuccessfulMessage("Bid has been recorded");
                                    
                                } catch (Exception er) {
                                    er.printStackTrace();
                                    FacesContext.getCurrentInstance().addMessage(null,
                                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Creds not added!", null));
        }
        
        RichPopup popup  = getMyPopup();
        popup.hide();
        
    }

    public void setMyPopup(RichPopup myPopup) {
        this.myPopup = myPopup;
    }

    public RichPopup getMyPopup() {
        return myPopup;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setBidderid(Integer bidderid) {
        this.bidderid = bidderid;
    }

    public Integer getBidderid() {
        return bidderid;
    }

}
