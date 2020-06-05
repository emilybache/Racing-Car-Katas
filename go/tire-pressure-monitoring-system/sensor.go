package tpms

import (
	"fmt"
	"math/rand"
)

type sensor struct {
	offset         func() int
	samplePressure func() int
}

func (s sensor) popNextPressurePsiValue() int {
	return s.offset() + s.samplePressure()
}

func NewSensor() Sensor {
	return &sensor{
		offset: func() int {
			return 16
		},
		samplePressure: func() int {
			s := rand.NewSource(42)
			r := rand.New(s)
			pressureTelemetryValue := 6 * r.Intn(1) * r.Intn(1)
			fmt.Println(pressureTelemetryValue)
			return pressureTelemetryValue
		},
	}
}
