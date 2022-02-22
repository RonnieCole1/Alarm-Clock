
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight). It also can be changed to a 12 hour clock.
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes (Modified by Liz)
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private boolean twelveHourDisplay;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        twelveHourDisplay = false;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     * @param hour initial hour
     * @param minute initial minute
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        twelveHourDisplay = false;
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     * @param hour new hour
     * @param minute new minute
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * @return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Changes to 12-hour clock if currently 24-hour clock and vice versa
     */
    public void toggleDisplay(){
        twelveHourDisplay = !twelveHourDisplay;
        updateDisplay();
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if (!twelveHourDisplay){
            displayString = hours.getDisplayValue() + ":" + 
                            minutes.getDisplayValue();
        } else {
            int hour = hours.getValue();
            
            if (hour >= 1 && hour <= 11){
                displayString = hours.getDisplayValue() + ":" + 
                            minutes.getDisplayValue() + " a.m.";
            }
            else if (hour == 0){
                displayString = "12" + ":" + 
                            minutes.getDisplayValue() + " a.m.";
            }
            else if (hour == 12){
                displayString = "12" + ":" + 
                            minutes.getDisplayValue() + " p.m.";
            }
            else {
                hour = hour - 12;
                if (hour < 10){
                    displayString = "0" + hour + ":" + 
                            minutes.getDisplayValue() + " p.m.";
                } else {
                    displayString = hour + ":" + 
                            minutes.getDisplayValue() + " p.m.";  
                }
            }
        }
    }
}
