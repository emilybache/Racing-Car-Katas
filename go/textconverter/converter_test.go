package textconverter

import "testing"

func TestConverter(t *testing.T) {

	t.Run("Do something", func(t *testing.T) {
		c := Converter{}
		_, err := c.ConvertToHTML("/some-filename.txt")
		if err != nil {
			t.Fatal(err)
		}
	})
}
