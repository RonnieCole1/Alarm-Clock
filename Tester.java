import java.util.ArrayList;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public Tester()
    {
    
    }

    /**
     * Tests if the alarm clock sounds at the right time.
     */
    public boolean testAlarm()
    {
        AlarmClock c1 = new AlarmClock();
        c1.setTime(15,03);
        c1.setAlarm(3,05,false);
        c1.turnAlarmOn();
        boolean result;
        c1.timeTick();
        if( c1.getTime().equals(c1.getAlarmTime())) {
            result = false;
        } else {
            c1.timeTick();
            if (c1.getTime().equals(c1.getAlarmTime())) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
    
    /**
     * Tests if the alarm clock sounds at the right time when considering the jump to a
     * new hour.
     */
    public boolean testNoAlarm()
    {
        AlarmClock c1 = new AlarmClock();
        c1.setTime(6,59);
        c1.setAlarm(8,05,true);
        c1.turnAlarmOn();
        boolean result;
        c1.timeTick();
        if(c1.getTime().equals(c1.getAlarmTime())) {
            result = false;
        } else {
            c1.timeTick();
            if (c1.equals(c1.getAlarmTime())) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }
    
    /**
     * Tests durations 1, 2, and 3 and checks if they return the right alarm sound.
     */
    public boolean testDuration()
    {
        AlarmClock c1 = new AlarmClock();
        boolean result1;
        boolean result2;
        c1.setSound("buzz");
        c1.setDuration(1);
        if(c1.getSound().equals("buzz")) {
            result1 = true;
        } else {
            result1 = false;
        }
        c1.setDuration(2);
        if(c1.getSound().equals("buzz buzz")) {
            result2 = true;
        } else {
            result2 = false;
        }
        if(result1 == true && result2 == true) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Tests if snooze properly pushes alarm time foward 4 minutes.
     */
    public boolean testSnooze()
    {
        AlarmClock c1 = new AlarmClock();
        c1.turnAlarmOn();
        c1.setTime(3,05);
        c1.setAlarm(3,05,true);
        c1.snooze();
        c1.timeTick();
        c1.timeTick();
        c1.timeTick();
        c1.timeTick();       
        if(c1.getTime().equals(c1.getAlarmTime())) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Runs all tests and returns a value representative of the tests that ran
     * successfully.
     */
    public int runAllTests()
    {
        ArrayList<String> AllTests = new ArrayList<String>();
        if(testAlarm() == true) {
            AllTests.add("Result1");
        }
        if(testNoAlarm() == true) {
            AllTests.add("Result1");
        }
        if(testDuration() == true) {
            AllTests.add("Result1");
        }
        if(testSnooze() == true) {
            AllTests.add("Result1");
        }
        return AllTests.size();
    }
}