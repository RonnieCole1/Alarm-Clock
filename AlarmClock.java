
/**
 * Alarmclock can be turned on and off and can be set at a certain time.
 * When it is on, it will sound an alarm at the set time. There is a snooze
 * button which resets the alarm for 4 minutes.
 *
 * @author Ronnie Cole
 * @2/10/2020
 */
public class AlarmClock
{
    private ClockDisplay clock; // the basic clock
    private boolean alarmOn; // indicates if alarm is on
    private ClockDisplay alarm; // alarm (12-hour clock)
    private String sound; // sound alarm makes
    private int duration; // indicates how many times sound should
                          // be repeated per alarm (must be 1 or 2)

    /**
     * Sets our clock to 00:00 and is a 12 hour clock by default. Alarm's sound is
     * "buzz" and has a duration of 1.
     */
    public AlarmClock()
    {
        clock = new ClockDisplay();
        alarm = new ClockDisplay();
        sound = "buzz";
        duration = 1;
    }
    
    /**
     * Initialize clock to hour:minute time with alarm off and its set to 24 hour clock. 
     * Alarm sound is "beep" with duration 1.
     */
    public AlarmClock( int hour, int minute)
    {
        clock = new ClockDisplay();
        alarm = new ClockDisplay();
        alarmOn = false;
        clock.setTime(hour,minute);
        sound = "beep";
        duration = 1;
    }
    
    /**
     * Turns alarm off.
     */
    public void turnAlarmOff()
    {
        alarmOn = false;
    }
    
    /**
     * Turns alarm on.
     */
    public void turnAlarmOn()
    {
        alarmOn = true;
    }
    
    /**
     * Checks if alarm is on.
     */
    public boolean alarmIsOn()
    {
        if( alarmOn = true) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns time on 24 hour clock.
     */
    public String getTime()
    {
        return clock.getTime();
    }
    
    /**
     * Returns the time the alarm is set to on the 24 hour clock.
     */
    public String getAlarmTime()
    {
        return alarm.getTime();
    }
    
    /**
     * Returns the sound of the alarm.
     */
    public String getSound()
    {
        if(duration == 1) {
            return sound;
        } else {
            return sound + " " + sound;
        }
    }
    
    /**
     * Sets sound to newSound if string is not an empty string
     */
    public void setSound(String newSound)
    {
        if(newSound.equals("")) {
            sound = sound;
        } else {
            sound = newSound;
        }
    }
    
    /**
     * Sets the duration of the alarm to 1 or 2 and returns an error
     * for durations greater than 2.
     */
    public void setDuration (int d)
    {
        if(d == 1) {
            duration = 1;
        } else if(d == 2) {
            duration = 2;
        } else {
            duration = duration;
            System.out.println("Error, duration can only be set to 1 or 2");
        }
    }
    
    /**
     * Sets the alarm to a 24 hour clock.
     */
    public void setAlarm(int hour, int minute, boolean am)
    {
        if (hour >=1 && hour <=11 && am == true){
                alarm.setTime(hour,minute);
        }
        else if (hour == 12 && am == true) {
                alarm.setTime(hour,minute);
        }
        else if (hour >=1 && hour <=11 && am == false){
                alarm.setTime(hour+12,minute);
        }
        else {
                alarm.setTime(hour-12,minute);
        }
    }
    
    /**
     * Sets the time of the clock.
     */
    public void setTime(int hour, int minute)
    {
        if(0 <= hour && hour <= 24 && 0 <= minute && minute <= 59) {
            clock.setTime(hour,minute);
        } else {
            System.out.println("Error: Hours or minutes are negative or greater than limit.");  
        }        
    }
    
    /**
     * Moves the clock foward 1 minute. If we reach the time of the alarm, the alarm is sounded.
     */
    public String timeTick()
    {
        clock.timeTick();
        if( alarmOn == true && clock.getTime().equals(alarm.getTime())) {
            return getSound();
        } else {
            return "";
        }
    }
    
    /**
     * Checks if alarm has sounded. If it did, it moves the alarm foward 4 minutes.
     */
    public void snooze()
    {
        String alarmBeforeSnooze = alarm.getTime();
        int timesSnoozed = 0;
        if( alarmOn == true && clock.getTime().equals(alarm.getTime())) {
            alarm.timeTick();
            alarm.timeTick();
            alarm.timeTick();
            alarm.timeTick();
            timesSnoozed = timesSnoozed +1;
            if(timesSnoozed <= 1) {
                alarm.equals(alarmBeforeSnooze);
            }
        }
    }
}
