import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brianofrim on 2016-09-20.
 */
public class HabitList {
    private List<Habit> activeHabits;

    HabitList(){
        activeHabits = new ArrayList<Habit>();
    }

    public List<Habit> getHabits(){
        return this.activeHabits;
    }


    private boolean habitExists(String newHabitName){
        for(Iterator<Habit> h = this.activeHabits.iterator(); h.hasNext();){
            Habit habit = h.next();
            if(habit.getTitle().equals(newHabitName)){
                return true;
            }
        }
        return false;
    }

    public void addHabit(String newHabit, boolean [] daysOfWeek){
        // only add unique names
        if(!this.habitExists(newHabit)){
            this.activeHabits.add(new Habit(newHabit, daysOfWeek));
        }else {
            //Error
        }

    }


    public void removeHabit(String habitName){
        for(Iterator<Habit> h = this.activeHabits.iterator(); h.hasNext();){
            Habit habit = h.next();
            if(habit.getTitle().equals(habitName)){
                h.remove();
            }
        }
    }
}
