package activities.calendar;

import control.Button;
import control.CardItem;
import control.Label;
import org.openqa.selenium.By;

public class CalendarMainScreen {
    public Button addButton = new Button(By.id("com.xiaomi.calendar:id/new_event"));

    public Label getEventTittle(String event){
        Label eventTitle = new Label((By.xpath("//android.widget.TextView[@resource-id=\"com.xiaomi.calendar:id/primary\" and @text='" + event + "']")));
        return eventTitle;
    }

    public CardItem getEventItem(String eventTitle){
        CardItem eventItem = new CardItem(By.xpath("//android.widget.TextView[@resource-id=\"com.xiaomi.calendar:id/primary\" and @text='" + eventTitle + "']/parent::android.view.ViewGroup"));
        return eventItem;
    }
}
