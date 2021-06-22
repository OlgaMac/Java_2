package levelUpBank.Jbdc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DateUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtilsTest {
    @Test
    public void testOfLocalDate_whenInputIsNotNull_thenConvertToJavaUtilDate(){
        //given
        LocalDate testDate = LocalDate.of(2020, 1, 25);
        //when что тестируется
        Date result = DateUtils.ofLocalDate(testDate);

        // then
        Assertions.assertEquals(testDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond()*1000, result.getTime());
    }
    @Test
    public void testOfLocalDate_whenInputIsNotNull_thenReturnNull(){
        //given
        LocalDate testDate = null;
        //when
        Date result = DateUtils.ofLocalDate(testDate);
        //then
        Assertions.assertNull(result);

    }
}
