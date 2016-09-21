import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brianofrim on 2016-09-17.
 */
public class Habit {
    private Calendar dateCreated;
    private String title;
    private boolean[] daysOfTheWeek = {false,false,false,false,false,false,false};
    //private Integer timesCompleted;


    private List<Long> habbitCompletions; // list of completion dates in millis since Jan 1 1970

    public Habit(){
        this.dateCreated = new GregorianCalendar();
        this.habbitCompletions= new ArrayList<Long>();
    }

    public Habit(String newTitle){
        this.title = newTitle;
        this.dateCreated = new GregorianCalendar();
        this.dateCreated.set(Calendar.HOUR,0);
        this.dateCreated.set(Calendar.MINUTE,0);
        this.dateCreated.set(Calendar.SECOND,0);
        this.dateCreated.set(Calendar.MILLISECOND,0);
        this.habbitCompletions= new ArrayList<Long>();
    }

    public Habit(String newTitle, boolean[] daysOfWeek){
        this.title = newTitle;
        this.dateCreated = new GregorianCalendar();
        this.dateCreated.set(Calendar.HOUR,0);
        this.dateCreated.set(Calendar.MINUTE,0);
        this.dateCreated.set(Calendar.SECOND,0);
        this.dateCreated.set(Calendar.MILLISECOND,0);
        this.habbitCompletions= new ArrayList<Long>();
        this.daysOfTheWeek = daysOfWeek;
    }

    public Calendar getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Calendar dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean[] getDaysOfTheWeek(){
        return this.daysOfTheWeek;
    }

    public boolean getDayOfTheWeek(int dayIndex){
        return this.daysOfTheWeek[dayIndex];
    }

    public void setDayOfWeek(int dayIndex, boolean value){
        this.daysOfTheWeek[dayIndex] = value;
    }

    public List<Long> getHabbitCompletions() {
        return habbitCompletions;
    }

    public void addHabitCompletion(Long completion){
        this.habbitCompletions.add(completion);
    }

    public void removeHabitCompletion(Long completionTime){ // competionTime is in millis since Jan 1 1970
        for(Iterator<Long> i = this.habbitCompletions.iterator(); i.hasNext();){
            Long item = i.next();
            if(item.equals(completionTime)){
                i.remove();
            }
        }
    }

    // get a list of all the days the habit is supposed to be completed on
    private List<Long> getHabitDays(){
        List<Long> returnArr = new ArrayList<Long>();

        Calendar now = new GregorianCalendar();
        now.set(Calendar.HOUR,0);
        now.set(Calendar.MINUTE,0);
        now.set(Calendar.SECOND,0);
        now.set(Calendar.MILLISECOND,0);
        Calendar currDate = new GregorianCalendar(this.dateCreated.get(Calendar.YEAR),this.dateCreated.get(Calendar.MONTH),
                this.dateCreated.get(Calendar.DAY_OF_MONTH),0,0,0);

        //get
        while(currDate.getTimeInMillis() < now.getTimeInMillis()){
            if(this.daysOfTheWeek[currDate.get(Calendar.DAY_OF_WEEK) -1 ]){
                returnArr.add(currDate.getTimeInMillis());
            }
            currDate.set(Calendar.DAY_OF_YEAR,currDate.get(Calendar.DAY_OF_YEAR) + 1);
        }
        return returnArr;
    }

    // check each day since
    public Integer getTimesCompleted(){
        List<Long> habitDays = this.getHabitDays();
        habitDays.retainAll(this.getHabbitCompletions()); //the number of days where the habit was completed
        return habitDays.size();

    }

    public Integer getTimesNotCompleted(){
        return this.habbitCompletions.size() - this.getTimesCompleted();
    }

}
