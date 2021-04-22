package tests;

import utils.DBUtils;
import models.Student;
import org.testng.annotations.Test;
import utils.DBUtils;

public class HibernateTest {
    @Test
    public void connectHibernate() {
        DBUtils.getAll();
    }

}
