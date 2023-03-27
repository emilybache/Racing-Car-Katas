# Text Converter
This is an implementation of a Text Converter in Rust. The project provides functionality to convert text files into HTML format and handles pagination with page breaks.

## Prerequisites
* Rust: Make sure you have Rust and Cargo installed. If not, follow the instructions [here](https://www.rust-lang.org/tools/install)

## Build
To build the project, navigate to the project directory and run the following command:

```sh
cargo build
```

## Run Tests
To run the test suite, execute the following command in the project directory:

```sh
cargo test
```

## Documentation
To generate documentation for the project, run the following command:

```sh
cargo doc --open
```

This will create and open the documentation in your default web browser.

## Usage
To use the Text Converter in your Rust project, add it as a dependency in your Cargo.toml file:

```toml
[dependencies]
text_converter = { path = "path/to/text_converter" }
```

Then, you can use the HtmlPagesConverter and HtmlTextConverter structs in your Rust code:

```rust
use text_converter::{HtmlPagesConverter, HtmlTextConverter};

fn main() {
    let pages_converter = HtmlPagesConverter::new("path/to/your/text_file.txt").unwrap();
    let page_content = pages_converter.get_html_page(0).unwrap();
    println!("{}", page_content);

    let text_converter = HtmlTextConverter::new("path/to/your/text_file.txt");
    let html_content = text_converter.convert_to_html().unwrap();
    println!("{}", html_content);
}
```

Remember to replace "path/to/text_converter" and "path/to/your/text_file.txt" with the actual paths to the text_converter project directory and the input text file, respectively.
