package activities.calendar;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class EventItemScreen {
    public Button deleteButton = new Button(By.id("com.xiaomi.calendar:id/img_delete"));
    public Button closeButton = new Button(By.id("com.xiaomi.calendar:id/img_close"));
}
