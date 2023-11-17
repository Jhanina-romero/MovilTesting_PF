package activities.calendar;

import control.Button;
import control.CheckBox;
import control.TextBox;
import org.openqa.selenium.By;

public class AddEventScreen {
    public TextBox eventTitle = new TextBox(By.id("com.xiaomi.calendar:id/title"));
    public CheckBox repitAllDayCheckbox = new CheckBox(By.id("com.xiaomi.calendar:id/all_day_row"));
    public Button saveButton = new Button(By.id("com.xiaomi.calendar:id/action_done"));
}
