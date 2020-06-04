package tpms

import "testing"

type alarmTest struct {
	it       string
	expected bool
	actual   func() bool
}

func TestAlarm(t *testing.T) {
	t.Run("Do something", func(t *testing.T) {
		a := NewAlarm()
		a.check()
	})
}
