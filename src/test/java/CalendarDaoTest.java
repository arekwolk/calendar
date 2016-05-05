import service.SQLiteCalendarDaoImpl;

public class CalendarDaoTest {

    private static final String FIRST_KEY = "Maj 2016 Czw 19";
    private static final String FIRST_VALUE = "przykladowa notateczka 1";
    private static final String SECOND_KEY = "Maj 2016 Pt 27";
    private static final String SECOND_VALUE = "przykladowa notateczka 2";
    private static final String THIRD_KEY = "Maj 2016 Pt 6";
    private static final String THIRD_VALUE = "przykladowa notateczka 3";

    private static final String FIRST_UPDATE = "zmieniona notateczka 1";
    private static final String SECOND_UPDATE = "zmieniona notateczka 2";
    private static final String THIRD_UPDATE = "zmieniona notateczka 3";

    public static void main(String[] args) {
        createReadTest();
        updateTest();
        deleteTest();
    }

    private static void createReadTest() {
        SQLiteCalendarDaoImpl dao = new SQLiteCalendarDaoImpl();
        dao.create(FIRST_KEY, FIRST_VALUE);
        dao.create(SECOND_KEY, SECOND_VALUE);
        dao.create(THIRD_KEY, THIRD_VALUE);

        String firstResult = dao.read(FIRST_KEY);

        if (!firstResult.equals(FIRST_VALUE)) {
            throw new AssertionError();
        }

        String secondResult = dao.read(SECOND_KEY);
        assert secondResult.equals(SECOND_VALUE);

        String thirdResult = dao.read(THIRD_KEY);
        assert thirdResult.equals(THIRD_VALUE);

        System.out.println("TEST READ PASSED");
    }

    private static void updateTest() {
        SQLiteCalendarDaoImpl dao = new SQLiteCalendarDaoImpl();
        dao.create(FIRST_KEY, FIRST_VALUE);
        dao.create(SECOND_KEY, SECOND_VALUE);
        dao.create(THIRD_KEY, THIRD_VALUE);
        
        dao.update(FIRST_KEY, FIRST_UPDATE);
        dao.update(SECOND_KEY, SECOND_UPDATE);
        dao.update(THIRD_KEY, THIRD_UPDATE);

        String firstResult = dao.read(FIRST_KEY);
        assert firstResult.equals(FIRST_UPDATE);

        String secondResult = dao.read(SECOND_KEY);
        assert secondResult.equals(SECOND_UPDATE);

        String thirdResult = dao.read(THIRD_KEY);
        assert thirdResult.equals(THIRD_UPDATE);

        System.out.println("TEST UPDATE PASSED");
    }

    private static void deleteTest() {
        SQLiteCalendarDaoImpl dao = new SQLiteCalendarDaoImpl();
        dao.create(FIRST_KEY, FIRST_VALUE);
        dao.create(SECOND_KEY, SECOND_VALUE);
        dao.create(THIRD_KEY, THIRD_VALUE);

        dao.delete(FIRST_KEY);
        dao.delete(SECOND_KEY);
        dao.delete(THIRD_KEY);

        String firstResult = dao.read(FIRST_KEY);
        assert !firstResult.equals(FIRST_VALUE);

        String secondResult = dao.read(SECOND_KEY);
        assert !secondResult.equals(SECOND_VALUE);

        String thirdResult = dao.read(THIRD_KEY);
        assert !thirdResult.equals(THIRD_VALUE);

        System.out.println("TEST DELETE PASSED");
    }
}
