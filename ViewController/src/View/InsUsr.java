package View;

import java.io.IOException;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class InsUsr {
    public InsUsr() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String commitAction() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        FacesContext con = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Added", "");
        con.addMessage("", message);
        try {
            con.getExternalContext().redirect("/ViewController/faces/login");
        } catch (IOException e) {
            System.out.println(e);
        }
        return "login";
    }
}
