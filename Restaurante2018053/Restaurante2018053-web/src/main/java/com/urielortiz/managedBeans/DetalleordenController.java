package com.urielortiz.managedBeans;

import com.urielortiz.Entities.Detalleorden;
import com.urielortiz.managedBeans.util.JsfUtil;
import com.urielortiz.managedBeans.util.JsfUtil.PersistAction;
import com.urielortiz.sessionbeans.DetalleordenFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("detalleordenController")
@SessionScoped
public class DetalleordenController implements Serializable {

    @EJB
    private DetalleordenFacadeLocal ejbFacade;
    private List<Detalleorden> items = null;
    private Detalleorden selected;

    public DetalleordenController() {
    }

    public Detalleorden getSelected() {
        return selected;
    }

    public void setSelected(Detalleorden selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getDetalleordenPK().setIdorden(selected.getOrden().getIdorden());
    }

    protected void initializeEmbeddableKey() {
        selected.setDetalleordenPK(new com.urielortiz.Entities.DetalleordenPK());
    }

    private DetalleordenFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Detalleorden prepareCreate() {
        selected = new Detalleorden();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DetalleordenCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DetalleordenUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DetalleordenDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Detalleorden> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Detalleorden getDetalleorden(com.urielortiz.Entities.DetalleordenPK id) {
        return getFacade().find(id);
    }

    public List<Detalleorden> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Detalleorden> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Detalleorden.class)
    public static class DetalleordenControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetalleordenController controller = (DetalleordenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detalleordenController");
            return controller.getDetalleorden(getKey(value));
        }

        com.urielortiz.Entities.DetalleordenPK getKey(String value) {
            com.urielortiz.Entities.DetalleordenPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.urielortiz.Entities.DetalleordenPK();
            key.setIdorden(Integer.parseInt(values[0]));
            key.setIddetalleorden(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.urielortiz.Entities.DetalleordenPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdorden());
            sb.append(SEPARATOR);
            sb.append(value.getIddetalleorden());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Detalleorden) {
                Detalleorden o = (Detalleorden) object;
                return getStringKey(o.getDetalleordenPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Detalleorden.class.getName()});
                return null;
            }
        }

    }

}
