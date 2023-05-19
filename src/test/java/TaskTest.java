import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testForMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertTrue(meeting.matches("приложения"));//совпадение слова в topic
        Assertions.assertFalse(meeting.matches("услуги"));//отсутствующее слово
        Assertions.assertTrue(meeting.matches("НетоБанк"));//совпадение слова в project
        Assertions.assertFalse(meeting.matches("Нетобанк"));//регистр буквы
        Assertions.assertFalse(meeting.matches("версия"));//другое окончание слова
        Assertions.assertFalse(meeting.matches("NetoBank"));//латиница
        Assertions.assertFalse(meeting.matches("вторник"));//проверка слова в start
        }

    @Test
    public void testForEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(5555, subtasks);

        Epic epicEmpty = new Epic(5, new String[]{});

        Assertions.assertTrue(epic.matches("Молоко"));//поиск слова
        Assertions.assertFalse(epic.matches("молоко"));//регистр слова
        Assertions.assertFalse(epic.matches("milk"));//латиница
        Assertions.assertFalse(epicEmpty.matches("Хлеб"));//пустой массив
    }

    @Test
    public void testForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(
                5,
                "Позвонить родителям"
        );

        Assertions.assertTrue(simpleTask.matches("Позвонить"));//поиск слова
        Assertions.assertFalse(simpleTask.matches("молоко"));//отсутсвующее слово
        Assertions.assertFalse(simpleTask.matches("5"));//цифры
    }

}
