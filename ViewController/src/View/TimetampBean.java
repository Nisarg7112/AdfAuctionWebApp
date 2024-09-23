package View;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@ViewScoped
public class TimetampBean {
    private Timestamp currentTimestamp;
    private Timestamp startTime;
    private Timestamp minimumEndTimestamp;

    public TimetampBean() {
        // Initialize the current timestamp to now
        currentTimestamp = new Timestamp(System.currentTimeMillis());
    }

    // Getter for current timestamp to restrict past start times
    public Timestamp getCurrentTimestamp() {
        return currentTimestamp;
    }

    // Getter for minimum end timestamp, calculated to be 1 day after start time
    public Timestamp getMinimumEndTimestamp() {
        if (startTime != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(startTime.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Add 1 day
            minimumEndTimestamp = new Timestamp(calendar.getTimeInMillis());
        }
        return minimumEndTimestamp;
    }

    // Method to handle changes in Start Time
    public void onStartTimeChange(ValueChangeEvent event) {
        this.startTime = (Timestamp) event.getNewValue();
        // Update the minimum end time based on the new start time
        getMinimumEndTimestamp();

        // Trigger UI refresh to apply the new constraints
        FacesContext.getCurrentInstance().renderResponse();
    }
}
