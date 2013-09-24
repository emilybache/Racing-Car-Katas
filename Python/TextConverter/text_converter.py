"""This code is the first exercise to try."""

import html as html_converter

class UnicodeFileToHtmlTextConverter(object):

    def __init__(self, full_filename_with_path):
        self.full_filename_with_path = full_filename_with_path

    def convert_to_html(self):
        f = open(self.full_filename_with_path, "r")
        html = ""
        for line in f:
            line = line.rstrip()
            html += html_converter.escape(line, quote=True)
            html += "<br />"

        return html