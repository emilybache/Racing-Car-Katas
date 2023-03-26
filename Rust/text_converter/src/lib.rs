// src/lib.rs
use std::fs::File;
use std::io::{self, BufRead, BufReader, Seek, SeekFrom};
use std::path::Path;

pub struct HtmlPagesConverter {
    filename: String,
    breaks: Vec<u64>,
}

impl HtmlPagesConverter {
    pub fn new(filename: &str) -> io::Result<Self> {
        let mut breaks = vec![0];
        let file = File::open(filename)?;
        let reader = BufReader::new(file);

        let mut cumulative_char_count = 0;
        for line in reader.lines() {
            let line = line?;
            cumulative_char_count += line.len() + 1;
            if line.contains("PAGE_BREAK") {
                breaks.push(cumulative_char_count as u64);
            }
        }

        Ok(Self {
            filename: filename.to_string(),
            breaks,
        })
    }

    pub fn get_html_page(&self, page: usize) -> io::Result<String> {
        let file = File::open(&self.filename)?;
        let mut reader = BufReader::new(file);
        reader.seek(SeekFrom::Start(self.breaks[page]))?;
        let mut html_page = String::new();

        for line in reader.lines() {
            let line = line?;
            if line.contains("PAGE_BREAK") {
                break;
            }
            html_page.push_str(&escape_html(&line));
            html_page.push_str("<br />");
        }

        Ok(html_page)
    }

    pub fn get_filename(&self) -> &str {
        &self.filename
    }
}

pub struct HtmlTextConverter {
    full_filename_with_path: String,
}

impl HtmlTextConverter {
    pub fn new(full_filename_with_path: &str) -> Self {
        Self {
            full_filename_with_path: full_filename_with_path.to_string(),
        }
    }

    pub fn convert_to_html(&self) -> io::Result<String> {
        let file = File::open(&self.full_filename_with_path)?;
        let reader = BufReader::new(file);
        let mut html = String::new();

        for line in reader.lines() {
            let line = line?;
            html.push_str(&escape_html(&line));
            html.push_str("<br />");
        }

        Ok(html)
    }

    pub fn get_filename(&self) -> &str {
        &self.full_filename_with_path
    }
}

fn escape_html(input: &str) -> String {
    input
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;")
        .replace("'", "&#39;")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_html_pages_converter() {
        let converter = HtmlPagesConverter::new("foo.txt").unwrap();
        assert_eq!("foo.txt", converter.get_filename());
    }

    #[test]
    fn test_html_text_converter() {
        let converter = HtmlTextConverter::new("foo.txt");
        assert_eq!("foo.txt", converter.get_filename());
    }
}
