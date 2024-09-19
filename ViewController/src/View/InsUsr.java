package View;

import java.io.IOException;

import javax.faces.application.FacesMessage;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class InsUsr {
    private String passwordCopy = "";
    
    public String getPasswordCopy() {
        return passwordCopy;
    }
    
    public void setPasswordCopy(String passwordCopy) {
        this.passwordCopy = passwordCopy; 
    }
    
    public InsUsr() {
        super();
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String commitAction() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        
        FacesContext con = FacesContext.getCurrentInstance();
        UIViewRoot root = con.getViewRoot();
        //RichInputText inputText = (RichInputText)root.findComponent("it3");
        //System.out.println("dam:" + inputText);
        //System.out.println("dam:" + inputText.getValue());
        
        System.out.println("bdam - " + bindings.get("Password"));

        String password = bindings.get("Password").toString();
                
        System.out.println("dam:" + password + " " + passwordCopy);
        
        if (!passwordCopy.equals(password)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Passwords not matched", "");
            con.addMessage("", message);
            return null;
        }
        
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        try {
            con.getExternalContext().redirect("/ViewController/faces/login");
        } catch (IOException e) {
            System.out.println(e);
        }
        return "login";
    }
}
