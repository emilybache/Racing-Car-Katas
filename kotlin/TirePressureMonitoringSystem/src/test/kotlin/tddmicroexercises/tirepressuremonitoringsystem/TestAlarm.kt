package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*

class TestAlarm {

    @Test
    fun foo() {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }
}
