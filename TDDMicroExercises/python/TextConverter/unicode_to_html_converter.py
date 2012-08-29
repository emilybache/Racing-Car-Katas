import cgi

class UnicodeFileToHtmlTextConverter(object):

    def __init__(self, fullFilenameWithPath):
        self.fullFilenameWithPath = fullFilenameWithPath

    def convertToHtml(self):
	    f = open(self.fullFilenameWithPath, "r")
	    html = ""
	    for line in f:
	        html += cgi.escape(line)
	        html += "<br />"
	            
	    return html
