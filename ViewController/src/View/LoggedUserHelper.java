package View;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class LoggedUserHelper {
    public LoggedUserHelper() {
        super();
    }
    
    public String getUsername() {
        ADFContext adfCtx = ADFContext.getCurrent(); 
        SecurityContext secCntx = adfCtx.getSecurityContext();
        if (!secCntx.isAuthenticated()) {
            System.out.println("lh:no authenticated");
            return null;
        }
        return secCntx.getUserName();
    }
    
    public Integer getLoggedInUserId() {
        String username = this.getUsername();
        if (username == null) {
            System.out.println("lh:no authenticated");
            return -1;
        }
        
        System.out.println("username: " + username);
        
        try {
            
           BindingContext bctx = BindingContext.getCurrent();
           DCBindingContainer bindings = (DCBindingContainer) bctx.getCurrentBindingsEntry();
           System.out.println("lh:bindings:" + bindings);
           DCDataControl dataControl = bindings.getDataControl();
           ApplicationModule am = (ApplicationModule)dataControl.getDataProvider();
           
           
           ViewObject usersVO = am.findViewObject("G4UsersVO1");
           
                   
           usersVO.setWhereClause("USERNAME = :username");
           usersVO.defineNamedWhereClauseParam("username", null, null);
           usersVO.setNamedWhereClauseParam("username", username);
           usersVO.executeQuery();

           if (usersVO.getEstimatedRowCount() == 1) {
               Row adminRow = usersVO.first();
               int userId = ((BigDecimal) adminRow.getAttribute("Userid")).intValue();
               System.out.println(userId);
               return userId;
           }
           
           
       } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error While getting user info", null));
           System.out.println(e);
           e.printStackTrace();
       }
       return -1;
    }
}
