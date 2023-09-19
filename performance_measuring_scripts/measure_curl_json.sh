#!/bin/bash

nrOfBooks=$1

echo "Measuring performance..."
echo "Result mode: JSON"
echo "Nr of books: $nrOfBooks"


curl -s -w "@curl-format" -d "{\"query\":\"query x { allBooksAsJSON(nrOfBooks: $nrOfBooks) }\"}" -v http://localhost:8080/graphql -H "Content-Type: application/json" -o ./json_output 2> /dev/null
