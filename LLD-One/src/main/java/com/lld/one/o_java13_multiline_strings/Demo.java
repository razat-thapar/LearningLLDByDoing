package com.lld.one.o_java13_multiline_strings;

public class Demo {
    public static void main(String[] args) {
        String htmlPage =
                """
                <!DOCTYPE html>
                <html>
                    <head>
                        <meta charset="UTF-8">
                        <title>About</title>
                    </head>
                    <body>
                        <h1>About</h1>
                        <h2>lorem ipsum</h2>
                        <p>This page is stored as a multiline strings.</p>
                    </body>
                </html>
                """;
        System.out.println(htmlPage);
    }
}
