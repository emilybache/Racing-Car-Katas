import cgi

class UnicodeFileToHtmlTextConverter(object):

    def __init__(self, full_filename_with_path):
        self.full_filename_with_path = full_filename_with_path

    def convertToHtml(self):
        f = open(self.full_filename_with_path, "r")
        html = ""
        for line in f:
            line = line.rstrip()
            html += cgi.escape(line, quote=True)
            html += "<br />"

        return html
