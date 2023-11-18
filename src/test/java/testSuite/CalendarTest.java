package testSuite;

import activities.calendar.AddEventScreen;
import activities.calendar.CalendarMainScreen;
import activities.calendar.ConfimationScreen;
import activities.calendar.EventItemScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Random;

public class CalendarTest {
    CalendarMainScreen calendaMainScreen = new CalendarMainScreen();
    AddEventScreen addEventScreen = new AddEventScreen();
    EventItemScreen eventItemScreen = new EventItemScreen();
    ConfimationScreen confimationScreen = new ConfimationScreen();


    @Test
    public void createEventTest(){
        String expectedEventTitle = generateEventTitle();
        calendaMainScreen.addButton.click();
        addEventScreen.eventTitle.setText(expectedEventTitle);
        addEventScreen.repitAllDayCheckbox.click();
        addEventScreen.saveButton.click();

        Assertions.assertTrue(calendaMainScreen.getEventTittle(expectedEventTitle).isControlDisplayed(), "ERROR>>> El evento no fue creado");
    }

    @Test
    public void deleteEventTest(){
        String eventTitle = generateEventTitle();
        calendaMainScreen.addButton.click();
        addEventScreen.eventTitle.setText(eventTitle);
        addEventScreen.repitAllDayCheckbox.click();
        addEventScreen.saveButton.click();

        calendaMainScreen.getEventItem(eventTitle).click();
        eventItemScreen.deleteButton.click();
        confimationScreen.acceptButton.click();
        if (eventItemScreen.closeButton.isControlDisplayed()){
            eventItemScreen.closeButton.click();
        }

        Assertions.assertFalse(calendaMainScreen.getEventTittle(eventTitle).isControlDisplayed(), "ERROR>>> El evento no fue eleminado");

    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeSession();
    }

    private String generateEventTitle(){
        Random rand = new Random();
        int eventNumber = rand.nextInt(1000);
        String eventTitle = "Evento de prueba mobile " + eventNumber;

        return eventTitle;
    }

}
