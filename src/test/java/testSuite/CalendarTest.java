package testSuite;

import activities.calendar.AddEventScreen;
import activities.calendar.CalendarMainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class CalendarTest {
    CalendarMainScreen calendaMainScreen = new CalendarMainScreen();
    AddEventScreen addEventScreen = new AddEventScreen();


    @Test
    public void createEventTest(){
        String eventTitle = "Evento de prueba mobile";
        calendaMainScreen.addButton.click();
        addEventScreen.eventTitle.setText(eventTitle);
        addEventScreen.repitAllDayCheckbox.click();
        addEventScreen.saveButton.click();

        Assertions.assertTrue(calendaMainScreen.getEventTittle(eventTitle).isControlDisplayed(), "ERROR>>> El evento no fue creado");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeSession();
    }

}
