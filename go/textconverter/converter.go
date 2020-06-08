package textconverter

import (
	"bufio"
	"os"
	"strings"
)

const (
	lt  = "<"
	gt  = ">"
	amp = "&"
	nl  = "\n"
)

// Converter handles the conversion of unicode text to other formats
type Converter struct {
	convertedLine []string
	result        []string
}

//ConvertToHTML converts unitoce text to HTML friendly text
func (c Converter) ConvertToHTML(fileName string) ([]string, error) {
	f, err := os.Open(fileName)
	if err != nil {
		return c.result, err
	}
	defer f.Close()

	scanner := bufio.NewScanner(f)

	for scanner.Scan() {
		c.basicHTMLEncode(scanner.Text())
	}

	if err := scanner.Err(); err != nil {
		return c.result, err
	}
	return c.result, nil
}

func (c *Converter) basicHTMLEncode(s string) {

	for _, ch := range s {
		switch string(ch) {
		case lt:
			c.convertedLine = append(c.convertedLine, "&lt;")
		case gt:
			c.convertedLine = append(c.convertedLine, "&gt;")
		case amp:
			c.convertedLine = append(c.convertedLine, "&amp;")
		case nl:
			c.addNewLine()
		default:
			c.convertedLine = append(c.convertedLine, string(ch))
		}
	}
	c.addNewLine()
}

func (c *Converter) addNewLine() {

	c.result = append(c.result, strings.Join(c.convertedLine[:], ""))
	c.result = append(c.result, "<br />")

	c.convertedLine = c.convertedLine[:0]
}
