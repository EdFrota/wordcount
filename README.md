# Word Count Service

## Task description

Create an HTTP service which downloads a text file from another HTTP server (URL to be specified in the request)
and calculates the *word frequency* in that text.

The service should only process text files, i. e. HTTP responses with the Content-Type `text/plain`.

For example, if the service receives a request pointing to the URL `https://gist.githubusercontent.com/joschi/3a75e759327bb83ad35f89b4639d16a3/raw/efbc10e0b31f0b539b9ca25154a0ab87b438f00c/lorem_ipsum.txt`,
it should return a word count analysis such as:

```json
{
  "url": "https://gist.githubusercontent.com/joschi/3a75e759327bb83ad35f89b4639d16a3/raw/efbc10e0b31f0b539b9ca25154a0ab87b438f00c/lorem_ipsum.txt",
  "frequencies": {
    "sit": 5,
    "amet": 5,
    "mi": 4,
    "ultricies": 3,
    "nam": 3,
    "maximus": 3,
    "ligula": 3,
    "justo": 3,
    "facilisis": 3,
    "condimentum": 3,
    "vivamus": 2,
    "vitae": 2,
    "tincidunt": 2,
    "tellus": 2,
    "semper": 2,
    "quam": 2,
    "nunc": 2,
    "nisl": 2,
    "mauris": 2,
    "malesuada": 2,
    "lectus": 2,
    "interdum": 2,
    "id": 2,
    "gravida": 2,
    "enim": 2,
    "cras": 2,
    "aliquam": 2,
    "vestibulum": 1,
    "ut": 1,
    "urna": 1,
    "turpis": 1,
    "tempor": 1,
    "sem": 1,
    "sapien": 1,
    "rutrum": 1,
    "quisque": 1,
    "quis": 1,
    "purus": 1,
    "pretium": 1,
    "posuere": 1,
    "porta": 1,
    "placerat": 1,
    "pellentesque": 1,
    "ornare": 1,
    "nulla": 1,
    "nisi": 1,
    "neque": 1,
    "nec": 1,
    "mollis": 1,
    "mattis": 1,
    "lorem": 1,
    "laoreet": 1,
    "lacus": 1,
    "ipsum": 1,
    "fusce": 1,
    "finibus": 1,
    "feugiat": 1,
    "fermentum": 1,
    "felis": 1,
    "facilisi": 1,
    "ex": 1,
    "eu": 1,
    "et": 1,
    "est": 1,
    "eros": 1,
    "elit": 1,
    "elementum": 1,
    "eleifend": 1,
    "egestas": 1,
    "donec": 1,
    "dolor": 1,
    "convallis": 1,
    "consequat": 1,
    "consectetur": 1,
    "commodo": 1,
    "blandit": 1,
    "bibendum": 1,
    "augue": 1,
    "at": 1,
    "arcu": 1,
    "ante": 1,
    "adipiscing": 1,
    "accumsan": 1,
    "ac": 1,
    "a": 1
  }
}
```
# wordcount
